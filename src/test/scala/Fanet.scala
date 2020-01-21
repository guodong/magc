import Compiler.compile
import frontend.{AssignListInst, AssignMapInst, BitVariable, IR, InInst, ListLiteral, MapLiteral, MapVariable, SetVariable, StringLiteral, StringType, StringVariable, UdfInst, ValofInst}
import network.Topology
import org.scalatest.FunSuite

import scala.io.Source

class Fanet extends FunSuite {
  test("basic test") {
    Topology.fromJson(Source.fromResource("topo.json").mkString)
    val ir = IR
    val external_ingress_ports = SetVariable("ei", StringType)
    val l1 = StringLiteral(ir.genName(), "e1:1")
    val l2 = StringLiteral(ir.genName(), "e2:1")
    val ll = ListLiteral(ir.genName(), List(l1, l2))
    val listAssInst = AssignListInst(null, external_ingress_ports)(ll)
    ir.addInstruction(listAssInst)
    //  external_ingress_ports.value += (frontend.StringVariable("e1:1", "e1:1"), frontend.StringVariable("e2:1", "e2:1"))
    val hostTable = MapVariable("hostTable", StringType, StringType)
    val l3 = StringLiteral(ir.genName(), "1.0.0.1")
    val l4 = StringLiteral(ir.genName(), "1.0.0.2")
    val l5 = StringLiteral(ir.genName(), "e1:1")
    val l6 = StringLiteral(ir.genName(), "e2:1")
    val ml = MapLiteral(ir.genName(), Map(l3 -> l5, l4 -> l6))
    val mapAssInst = AssignMapInst(null, hostTable)(ml)
    ir.addInstruction(mapAssInst)
    val g0 = BitVariable("g0", 1)
    val ingestion = StringVariable("ingestion")
    ir.variables += ingestion
    val inst0 = InInst(null, g0, external_ingress_ports, ingestion)
    var v1 = StringVariable("pkt.hdr.ipv4.dst")
    var v2 = StringVariable("v2")
    var path = StringVariable("path")
    ir.variables += path
    val inst = ValofInst(g0, v2, hostTable, v1)
    val inst1 = UdfInst(g0, List(path), "sp", List(ingestion, v2))

    ir.addInstruction(inst0)
    ir.addInstruction(inst)
    ir.addInstruction(inst1)
    compile()
  }
}

