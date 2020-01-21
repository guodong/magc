package frontend

sealed trait Instruction {
  val gv: Variable
  val inputs: List[Variable]
  val outputs: List[Variable]
  var pit: PIT = new PIT

  def toPIT(): Unit
}

case class ValofInst(gv: Variable, output: Variable, target: CompoundVariable, key: Variable) extends Instruction {
  override def toPIT(): Unit = {
    pit.inputs += key
    pit.outputs += output
  }

  override val inputs: List[Variable] = List(key)
  override val outputs: List[Variable] = List(output)
  override def toString: String = {
    if (gv == null) {
      s"${output} = valof(${target}, ${key})"
    } else {
      s"if $gv: ${output} = valof(${target}, ${key})"
    }
  }
}

//case class ValofInst1[KT, VT](gv: frontend.Variable, output: frontend.Variable, left: frontend.MapVariable[KT, VT], right: frontend.StringVariable) extends frontend.Instruction {
//  override def toPIT(): Unit = {
//    pit.tipe = 0
//    pit.inputs += (gv, right)
//    pit.outputs += output
//    for (x <- left.value) {
//      val mp: Map[frontend.Variable, Any] = Map[frontend.Variable, Any](gv -> "1", right -> x._1, output -> x._2)
//      pit.entries.addOne(mp)
//      pit.ents += Map(gv -> "1", right -> x._1) -> Map(output -> x._2)
//    }
//  }
//
//  override def toString: String = s"if ${gv}: ${output} = varof(${left}, ${right})"
//}

case class UdfInst(gv: Variable, outputs: List[Variable], name: String, inputs: List[Variable]) extends Instruction {
  override def toPIT(): Unit = {
    pit.tipe = 1
    pit.inputs = collection.mutable.ArrayBuffer(inputs: _*)
    pit.outputs = collection.mutable.ArrayBuffer(outputs: _*)
  }

  override def toString: String = s"if $gv: ${outputs.mkString(", ")} = ${name}(${inputs.map(i => i.toString()).mkString(", ")})"
}

case class InInst(gv: Variable, output: Variable, target: CompoundVariable, key: Variable) extends Instruction {
  override def toPIT(): Unit = {
    pit.inputs += key
    pit.outputs += output
  }

  override def toString: String = {
    if (gv == null) {
      s"${output} = in(${target}, ${key})"
    } else {
      s"if $gv: ${output} = in(${target}, ${key})"
    }
  }

  override val inputs: List[Variable] = List(key)
  override val outputs: List[Variable] = List(output)
}

case class AssignListInst(gv: Variable, dst: Variable)(src: ListLiteral) extends Instruction {
  override def toPIT(): Unit = {}

  override val inputs: List[Variable] = List(src)
  override val outputs: List[Variable] = List(dst)

  override def toString: String = {
    if (gv == null) {
      s"${dst} = assign(${src})"
    } else {
      s"if $gv: ${dst} = assign(${src})"
    }
  }
}

case class AssignMapInst(gv: Variable, dst: Variable)(entries: MapLiteral) extends Instruction {
  override def toPIT(): Unit = {}

  override val inputs: List[Variable] = List(entries)
  override val outputs: List[Variable] = List(dst)

  override def toString: String = {
    if (gv == null) {
      s"${dst} = assign(${entries})"
    } else {
      s"if $gv: ${dst} = assign(${entries})"
    }
  }
}



/*
object Mapping extends Enumeration {
  type Mapping = Value
  val PLUS = Value("plus")
  val MINUS = Value("minus")
  val MUL = Value("mul")
  val DIV = Value("div")
  val GT = Value("gt")
  val UDF = Value("udf")
  //  val GT, GTE, LT, LTE = Value
  val IN = Value("in")
  val VALOF: Mapping.Value = Value("valof")

  override def toString(): String = super.toString()
}

class Instruction1(var gv: BaseVariable) {

  import Mapping._

  var inputs: ArrayBuffer[BaseVariable] = new ArrayBuffer[BaseVariable]()
  var outputs: ArrayBuffer[BaseVariable] = new ArrayBuffer[BaseVariable]()
  var mapping: Mapping = Mapping.PLUS
  var udf: String = ""
  val pit: frontend.PIT = new frontend.PIT

  def toPIT(): Unit = {
    for (input <- inputs) {
      pit.inputs += input
    }
    for (output <- outputs) {
      pit.outputs += output
    }
    if (mapping == VALOF) {
      inputs.head match {
        case frontend.MapVariable(name) => {
          println(name)
        }
      }

    }
  }

  override def toString: String = {
    if (gv == null) {
      s"${outputs.map(o => o.toString()).mkString(", ")} = ${
        if (mapping == UDF) {
          udf
        } else {
          mapping
        }
      }(${inputs.map(i => i.toString()).mkString(", ")})"
    } else {
      s"if ${gv.toString()}: ${outputs.map(o => o.toString()).mkString(", ")} = ${
        if (mapping == UDF) {
          udf
        } else {
          mapping
        }
      }(${inputs.map(i => i.toString()).mkString(", ")})"
    }
  }
}
*/