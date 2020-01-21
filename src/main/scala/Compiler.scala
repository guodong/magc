import frontend.IR

object Compiler extends App {
//  Topology.fromJson(Source.fromResource("topo.json").mkString)
//  val ir = frontend.IR
//  val external_ingress_ports = frontend.SetVariable("ei", frontend.StringType)
//  val l1 = frontend.StringLiteral(ir.genName(), "e1:1")
//  val l2 = frontend.StringLiteral(ir.genName(), "e2:1")
//  val ll = frontend.ListLiteral(ir.genName(), List(l1, l2))
//  val listAssInst = frontend.AssignListInst(null, external_ingress_ports)(ll)
//  ir.addInstruction(listAssInst)
//  //  external_ingress_ports.value += (frontend.StringVariable("e1:1", "e1:1"), frontend.StringVariable("e2:1", "e2:1"))
//  val hostTable = frontend.MapVariable("hostTable", frontend.StringType, frontend.StringType)
//  val l3 = frontend.StringLiteral(ir.genName(), "1.0.0.1")
//  val l4 = frontend.StringLiteral(ir.genName(), "1.0.0.2")
//  val l5 = frontend.StringLiteral(ir.genName(), "e1:1")
//  val l6 = frontend.StringLiteral(ir.genName(), "e2:1")
//  val ml = frontend.MapLiteral(ir.genName(), Map(l3 -> l5, l4 -> l6))
//  val mapAssInst = frontend.AssignMapInst(null, hostTable)(ml)
//  ir.addInstruction(mapAssInst)
//  val g0 = frontend.BitVariable("g0", 1)
//  val ingestion = frontend.StringVariable("ingestion")
//  ir.variables += ingestion
//  val inst0 = frontend.InInst(null, g0, external_ingress_ports, ingestion)
//  var v1 = frontend.StringVariable("pkt.hdr.ipv4.dst")
//  var v2 = frontend.StringVariable("v2")
//  var path = frontend.StringVariable("path")
//  ir.variables += path
//  val inst = frontend.ValofInst(g0, v2, hostTable, v1)
//  val inst1 = frontend.UdfInst(g0, List(path), "sp", List(ingestion, v2))
//
//  ir.addInstruction(inst0)
//  ir.addInstruction(inst)
//  ir.addInstruction(inst1)
//  compile()


  def compile(): Unit = {
    val ir = IR
    ir.dump()
    ir.toPIT()
    //    ir.dumpPIT()
    ir.explore()
    ir.dumpFEG()
    ir.dumpPIT()
    ir.localize()
    //  val a = BitSetBuilder.fromString("100") // 100101
    //  println(a)
    //  val b = BitSetBuilder.fromInt(21, 6) // 010101  -> 011001100110
    //  println(b)
    //  val x = Codegen.gen()
    //  println(x)
    //  val x = Cheese.foo(1)(b => println(b))
    //  println(x)
  }
}
