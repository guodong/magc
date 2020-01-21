package frontend

import network.Topology
import scalax.collection.Graph
import scalax.collection.GraphEdge.DiEdge

import scala.collection.mutable.ArrayBuffer

class FEGNode(val instruction: Instruction) {
  var state: Map[Variable, Any] = Map[Variable, Any]()
}


object IR {
  val variables: ArrayBuffer[Variable] = new ArrayBuffer[Variable]()
  val instructions: ArrayBuffer[Instruction] = new ArrayBuffer[Instruction]()
  var feg: Graph[FEGNode, DiEdge] = Graph()
  var pm: Map[Map[Variable, Any], Topology.g.Path] = Map.empty
  var name_idx = 0

  def genName(): String = {
    name_idx += 1
    "_v" + name_idx.toString
  }

  def addInstruction(inst: Instruction) {
    instructions.addOne(inst)
  }

  def getVariable(name: String): Option[Variable] = {
    variables.find(v => v.name == name)
  }

  def addVariable(variable: Variable): Unit = {
    variables += variable
  }

  def dump() {
    instructions.foreach(i => {
      println(i)
    })
  }

  def explore(): Unit = {
    val node = new FEGNode(null)
    var valueMap: Map[Variable, Any] = Map.empty
    exploreI(instructions(0), node)
  }

  private def exploreI(i: Instruction, node: FEGNode): Unit = {
    println(node.state)
    //    var state1: scala.collection.mutable.Map[frontend.Variable, Any] = node.state.clone()
    var state: Map[Variable, Any] = Map.empty
    for ((k, v) <- node.state) {
      state += (k -> v)
    }
    i match {
      case ai: AssignListInst =>
        state += (ai.dst -> ai.inputs(0))
        val nnode = new FEGNode(i)
        nnode.state = state
        if (instructions.indexOf(i) + 1 < instructions.length) {
          exploreI(instructions(instructions.indexOf(i) + 1), nnode)
        }
      case ami: AssignMapInst =>
        state += (ami.dst -> ami.inputs(0))
        val nnode = new FEGNode(i)
        nnode.state = state
        if (instructions.indexOf(i) + 1 < instructions.length) {
          exploreI(instructions(instructions.indexOf(i) + 1), nnode)
        }
      case ini: InInst =>
        ini.target match {
          case mv: MapVariable =>
            node.state(mv) match {
              case ml: MapLiteral =>
                for ((k, v) <- ml.value) {
                  ini.pit.ents += (Map(ini.inputs(0) -> k) -> Map(ini.output -> v))
                  val nnode = new FEGNode(i)
                  nnode.state = state
                  if (instructions.indexOf(i) + 1 < instructions.length) {
                    exploreI(instructions(instructions.indexOf(i) + 1), nnode)
                  }
                }
            }
          case sv: SetVariable =>
            node.state(sv) match {
              case sl: ListLiteral =>
                sl.value.foreach(v => {
                  ini.pit.ents += (Map(ini.inputs(0) -> v) -> Map(ini.outputs(0) -> "1"))
                  state += (ini.inputs(0) -> v)
                  val nnode = new FEGNode(i)
                  nnode.state = state
                  if (instructions.indexOf(i) + 1 < instructions.length) {
                    exploreI(instructions(instructions.indexOf(i) + 1), nnode)
                  }
                })
            }
          case _ =>
        }
      case vi: ValofInst =>
        vi.target match {
          case mv: MapVariable =>
            node.state(mv) match {
              case ml: MapLiteral =>
                for ((k, v) <- ml.value) {
                  vi.pit.ents += (Map(vi.inputs(0) -> k) -> Map(vi.output -> v))
                  state += (vi.inputs(0) -> k, vi.output -> v)
                  val nnode = new FEGNode(i)
                  nnode.state = state
                  if (instructions.indexOf(i) + 1 < instructions.length) {
                    exploreI(instructions(instructions.indexOf(i) + 1), nnode)
                  }
                }
            }
        }
      case ui: UdfInst =>
        var inputs = Map[Variable, Any]()
        ui.inputs.foreach(input => inputs += (input -> node.state(input)))
        val path = Topology.shortestPath(node.state(ui.inputs(0)).toString, node.state(ui.inputs(1)).toString)
        ui.pit.ents += (inputs -> Map(ui.outputs(0) -> path))
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

  //  private def exploreInst(i: frontend.Instruction, node: frontend.FEGNode): Unit = {
  //    println(node.state)
  //    if (i.pit.tipe == 1) { // ncm
  //      i match {
  //        case ui: frontend.UdfInst =>
  //          var inputs = Map[frontend.Variable, Any]()
  //          ui.inputs.foreach(input => inputs += (input -> node.state(input)))
  //          val path = Topology.shortestPath(node.state(ui.inputs(0)).toString, node.state(ui.inputs(1)).toString)
  //          ui.pit.ents += (inputs -> Map(ui.outputs(0) -> path))
  //          var pfk = Map(getVariable("ingestion").get -> node.state(getVariable("ingestion").get))
  //          for ((k, v) <- node.state) {
  //            if (k.name.contains("pkt.hdr")) {
  //              pfk += (k -> v)
  //            }
  //          }
  //          pm += pfk -> path.get
  //        case _ =>
  //      }
  //    }
  //    for (e <- i.pit.entries) {
  //      var conflicted = false
  //      breakable {
  //        for (item <- e) {
  //          if (node.state.contains(item._1) && node.state(item._1) != item._2) {
  //            conflicted = true
  //            // TODO: remove state
  //            break
  //          }
  //        }
  //      }
  //      if (!conflicted) {
  //        val nnode = new frontend.FEGNode(i)
  //        for (x <- node.state) {
  //          nnode.state += (x._1 -> x._2)
  //        }
  //        nnode.state ++= e
  //        feg += (node ~> nnode)
  //        if (instructions.indexOf(i) + 1 < instructions.length) {
  //          exploreInst(instructions(instructions.indexOf(i) + 1), nnode)
  //        }
  //      }
  //    }
  //  }

  def dumpFEG(): Unit = {
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
              //              pfs += y.get -> Map[frontend.Variable, Any](feg.nodes)
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
