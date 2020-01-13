package frontend

import scala.util.parsing.input.Positional

sealed trait MagellanToken extends Positional

case class IDENTIFIER(str: String) extends MagellanToken
case class LITERAL(str: String) extends MagellanToken
case class EQUALS() extends MagellanToken
case class COMMA() extends MagellanToken
case class COLON() extends MagellanToken
case class EXIT() extends MagellanToken