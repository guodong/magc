package frontend


trait Variable {
  val name: String
  val ty: Type
  var isGlobal: Boolean = false

  override def toString: String = name
}

trait CompoundVariable extends Variable

trait Literal extends Variable

trait SimpleLiteral extends Literal

case class StringLiteral(name: String, value: String) extends SimpleLiteral {
  override val ty: Type = StringType

  // NOTE: if add "" to string, the udf part need to trim it to get string value
  // override def toString: String = s""""${value}""""
  override def toString: String = value.toString
}

// TODO: float numeric, xe{n} numeric, 0x numeric...
case class NumericLiteral(name: String, value: Int) extends SimpleLiteral {
  override val ty: Type = BitwiseType

  override def toString: String = value.toString
}

/**
 * support simple literal currently, nested literal should be added in future
 *
 * @param name
 * @param value
 */
case class ListLiteral(name: String, value: List[SimpleLiteral]) extends Literal {
  override val ty: Type = ListType

  override def toString: String = s"${this.getClass.getSimpleName}(${value.mkString(", ")})"
}

/**
 * support simple literal currently, nested literal should be added in future
 *
 * @param name
 * @param value
 */
case class MapLiteral(name: String, value: Map[SimpleLiteral, SimpleLiteral]) extends Literal {
  override val ty: Type = MapType

  override def toString: String = value.toString()
}

case class StringVariable(name: String) extends Variable {
  override val ty: Type = StringType
}

case class BitVariable(name: String, width: Int) extends Variable {
  override val ty: Type = BitwiseType
}

case class MapVariable(name: String, kt: Type, vt: Type) extends CompoundVariable {
  override val ty: Type = MapType
}

case class SetVariable(name: String, vt: Type) extends CompoundVariable {
  override val ty: Type = SetType
}

//case class ClassVariable(name: String, attrs: Map[String, Variable]) extends CompoundVariable {
//  override val ty: Type = ClassType
//}