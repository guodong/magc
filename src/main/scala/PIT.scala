import scala.collection.mutable.ArrayBuffer

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
    println((inputs ++ outputs).map(i => i.name).mkString(" | "))
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