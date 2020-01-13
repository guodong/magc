package frontend

sealed trait MagellanCompilationError

case class MagellanLexerError(location: Location, msg: String) extends MagellanCompilationError
case class MagellanParserError(location: Location, msg: String) extends MagellanCompilationError

case class Location(line: Int, column: Int) {
  override def toString = s"$line:$column"
}
