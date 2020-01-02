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

  def addInstruction(inst: Instruction) {
    instructions.addOne(inst)
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
        case ui: UdfInst => {
          var inputs = Map[Variable, Any]()
          ui.inputs.foreach(input => inputs += (input -> node.state(input)))
          ui.pit.ents += (inputs -> Map(ui.output -> Topology.shortestPath("e1", "e2")))
        }
        case _ =>
      }
    }
//    feg += node
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

  def toPIT(): Unit = {
    instructions.map(i => i.toPIT)
  }

  def dumpPIT(): Unit = {
    instructions.map(i => i.pit.dump())
  }

}
