
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Compiler extends App {
  Topology.fromJson(Source.fromResource("topo.json").mkString)
  val ir = IR
  val external_ingress_ports = SetVariable("ei")
  external_ingress_ports.value += ("e1:1", "e2:1")
  val g0 = IntVariable("g0")
  val ingestion = StringVariable("ingestion")
  ingestion.value = "e1:1"
  val inst0 = InInst(null, g0, external_ingress_ports, ingestion)
  ir.addInstruction(inst0)
  val hostTable = MapVariable[String, String]("hostTable")
  hostTable.value += ("1.0.0.1" -> "e1:1", "1.0.0.2" -> "e2:1")
  var v1 = StringVariable("pkt.hdr.ipv4.dst")
  var v2 = IntVariable("v2")
  var path = IntVariable("path" )
  val inst = ValofInst(g0, v2, hostTable, v1)
  val inst1 = UdfInst(g0, path, "sp", ArrayBuffer[Variable](ingestion, v2))

  ir.addInstruction(inst)
  ir.addInstruction(inst1)
  ir.dump()
  ir.toPIT()
  ir.dumpPIT()
  ir.explore()
  ir.dumpJson()
  ir.dumpPIT()
  val a = BitSetBuilder.fromString("100") // 100101
  println(a)
  val b = BitSetBuilder.fromInt(21, 6) // 010101  -> 011001100110
  println(b)
}

/*
object Compiler extends App {
  val ir = IR

  val hostTable = MapVariable("hostTable")
  hostTable.

  var whiteList = ListVariable("whiteList")
  var hosttable = MapVariable("hostTable")
  var ingestion = StringVariable("ingestion")

  // g0 = in(whitelist, pkt.hdr.ipv4.dst)
  val g0 = IntVariable("g0")
  val v0 = new IntVariable("pkt.hdr.ipv4.dst")
  var inst = new Instruction(null)
  inst.mapping = Mapping.IN
  inst.inputs += (whiteList, v0)
  inst.outputs.addOne(g0)
  ir.addInstruction(inst)

  // if g0: v1 = valof(hostTable, pkt.hdr.ipv4.dst)
  var v1 = new IntVariable("v1")
  var inst1 = new Instruction(g0)
  inst1.mapping = Mapping.VALOF
  inst1.inputs += (hosttable, v0)
  inst1.outputs.addOne(v1)
  ir.addInstruction(inst1)

  // if g0: pkt.path = sp(ingestion, v1)
  var v2 = new ListVariable("pkt.path")
  val inst2 = new Instruction(g0)
  inst2.mapping = Mapping.UDF
  inst2.udf = "sp"
  inst2.inputs += (ingestion, v1)
  inst2.outputs.addOne(v2)
  ir.addInstruction(inst2)

  ir.dump()

  val topo = Topology

}
*/