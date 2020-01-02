import scala.collection.mutable.ArrayBuffer

sealed trait Variable {
  def name: String
  override def toString: String = name
}

case class MapVariable[KT, VT](name: String) extends Variable {
  var value: Map[KT, VT] = Map[KT, VT]()
}

case class SetVariable(name: String) extends Variable {
  var value: ArrayBuffer[String] = ArrayBuffer[String]()
}

case class StringVariable( var name: String) extends Variable {
  var value = ""
}

case class IntVariable( var name: String) extends Variable