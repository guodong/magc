trait Value {

}
case class StringValue(string: String) extends Value {

}

case class NumberValue[T](numeric: Numeric[T]) extends Value {

}