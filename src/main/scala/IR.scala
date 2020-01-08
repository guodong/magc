import network.Topology
import scalax.collection.Graph
import scalax.collection.GraphEdge.DiEdge
import scalax.collection.GraphPredef._

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

class FEGNode(val instruction: Instruction) {
  var state: Map[Variable, Any] = Map.empty
}


object IR {
  val variables: ArrayBuffer[Variable] = new ArrayBuffer[Variable]()
  val instructions: ArrayBuffer[Instruction] = new ArrayBuffer[Instruction]()
  var feg: Graph[FEGNode, DiEdge] = Graph()
  var pm: Map[Map[Variable, Any], Topology.g.Path] = Map.empty

  def addInstruction(inst: Instruction) {
    instructions.addOne(inst)
  }

  def getVariable(name: String): Option[Variable] = {
    variables.find(v => v.name == name)
  }

  def dump() {
    instructions.foreach(i => {
      println(i)
    })
  }

  def symbolExe(): Unit = {

  }

  def explore(): Unit = {
    val node = new FEGNode(null)
    exploreInst(instructions(0), node)
  }

  private def exploreInst(i: Instruction, node: FEGNode): Unit = {
    println(node.state)
    if (i.pit.tipe == 1) { // ncm
      i match {
        case ui: UdfInst =>
          var inputs = Map[Variable, Any]()
          ui.inputs.foreach(input => inputs += (input -> node.state(input)))
          val path =  Topology.shortestPath(node.state(ui.inputs(0)).toString, node.state(ui.inputs(1)).toString)
          ui.pit.ents += (inputs -> Map(ui.output -> path))
          var pfk = Map(getVariable("ingestion").get -> node.state(getVariable("ingestion").get))
          for ((k, v) <- node.state) {
            if (k.name.contains("pkt.hdr")) {
              pfk += (k -> v)
            }
          }
          pm += pfk -> path.get
        case _ =>
      }
    }
    for (e <- i.pit.entries) {
      var conflicted = false
      breakable {
        for (item <- e) {
          if (node.state.contains(item._1) && node.state(item._1) != item._2) {
            conflicted = true
            // TODO: remove state
            break
          }
        }
      }
      if (!conflicted) {
        val nnode = new FEGNode(i)
        for (x <- node.state) {
          nnode.state += (x._1 -> x._2)
        }
        nnode.state ++= e
        feg += (node ~> nnode)
        if (instructions.indexOf(i) + 1 < instructions.length) {
          exploreInst(instructions(instructions.indexOf(i) + 1), nnode)
        }
      }
    }
  }

  def dumpJson(): Unit = {
    println(feg)
  }

  def toPIT() {
    instructions.foreach(i => i.toPIT())
  }

  def dumpPIT(): Unit = {
    instructions.foreach(i => i.pit.dump())
  }

  def localize(): Unit = {
    var pfs: Map[Topology.g.Path, Map[Variable, Any]] = Map.empty
    for ((i, o) <- instructions.last.pit.ents) {
      var p = getVariable("path")
      p match {
        case x: Some[Variable] => {
          o(x.get) match {
            case y: Some[Topology.g.Path] => {
              val path = y.get
//              pfs += y.get -> Map[Variable, Any](feg.nodes)
            }
          }
        }
      }

    }
    println(pm)
    val u = pm.flatMap(e => e._2.nodes.map(n => (n, e))).groupBy(_._1).view.mapValues(_.values)
    for ((s, v) <- u) {
      println(s, v)
    }
  }
}
