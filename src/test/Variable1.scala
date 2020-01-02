package ignored

import scala.collection.mutable.ArrayBuffer

object VType extends Enumeration {
  type VType = Value
  val DEFAULT, LIST, MAP = Value
}

abstract class BaseVariable[A](name: String) {
  val value: A
  override def toString: String = name
}

case class IntVariable(name: String) extends BaseVariable[Int](name)

case class ListVariable(name: String) extends BaseVariable(name)

case class MapVariable(name: String) extends BaseVariable(name) {

}

case class StringVariable(name: String) extends BaseVariable(name)

case class BitVariable(name: String) extends BaseVariable(name)

class Variable(var name: String, var width: Int = 8) {

  import VType._

  var typ: VType = VType.DEFAULT
  var values: ArrayBuffer[Double] = new ArrayBuffer[Double]()

}
