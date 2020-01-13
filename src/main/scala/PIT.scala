import scala.collection.mutable.ArrayBuffer
//import scala.collection.mutable.Map

trait VariableValue[T] {
  val variable: Variable
  var value: T
}

class PIT {
  var tipe = 0 // 0: cm, 1: ncm
  var inputs: ArrayBuffer[Variable] = ArrayBuffer()
  var outputs: ArrayBuffer[Variable] = ArrayBuffer()
  var ents: Map[Map[Variable, Any], Map[Variable, Any]] = Map()


  var entries: ArrayBuffer[Map[Variable, Any]] = ArrayBuffer()

  def dump(): Unit = {
    println((inputs ++ outputs).map(_.name).mkString(" | "))
    ents.map(e => {
      print(inputs.map(i => e._1(i)).mkString(" | "))
      print(" | ")
      print(outputs.map(o => e._2(o)).mkString(" | "))
      println()
    })
  }
}

/**
 * PIT entry value type
 */
class PITV {

}