
import scala.collection.mutable.ArrayBuffer

sealed trait Instruction {
  val gv: Variable
  var pit: PIT = new PIT

  def toPIT(): Unit

}

case class ValofInst[KT, VT](gv: Variable, output: Variable, left: MapVariable[KT, VT], right: StringVariable) extends Instruction {
  override def toPIT(): Unit = {
    pit.tipe = 0
    pit.inputs += (gv, right)
    pit.outputs += output
    for (x <- left.value) {
      val mp: Map[Variable, Any] = Map[Variable, Any](gv -> "1", right -> x._1, output -> x._2)
      pit.entries.addOne(mp)
      pit.ents += Map(gv -> "1", right -> x._1) -> Map(output -> x._2)
    }
  }

  override def toString: String = s"if ${gv}: ${output} = varof(${left}, ${right})"
}

case class UdfInst(gv: Variable, output: Variable, name: String, inputs: ArrayBuffer[Variable]) extends Instruction {
  override def toPIT(): Unit = {
    pit.tipe = 1
    pit.inputs = inputs
    pit.outputs += output
  }

  override def toString: String = s"if $gv: ${output} = ${name}(${inputs.map(i => i.toString()).mkString(", ")})"
}

case class InInst(gv: Variable, output: Variable, left: Variable, right: Variable) extends Instruction {
  override def toPIT(): Unit = {
    pit.inputs += right
    pit.outputs += output
    left match {
      case v: SetVariable => {
        for (x <- v.value) {
          val mp: Map[Variable, String] = Map[Variable, String](right -> x, output -> "1")
          pit.entries += mp
          pit.ents += (Map(gv -> "1", right -> x) -> Map(output -> "1"))
        }
      }
      case _ =>
    }
  }

  override def toString: String = {
    if (gv == null) {
      s"${output} = in(${left}, ${right})"
    } else {
      s"if $gv: ${output} = in(${left}, ${right})"
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
  val pit: PIT = new PIT

  def toPIT(): Unit = {
    for (input <- inputs) {
      pit.inputs += input
    }
    for (output <- outputs) {
      pit.outputs += output
    }
    if (mapping == VALOF) {
      inputs.head match {
        case MapVariable(name) => {
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