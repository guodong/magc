package frontend

import scala.util.parsing.input.Positional

sealed trait Token extends Positional

case class IDENTIFIER(str: String) extends Token

case class LITERAL(str: String) extends Token

case class EQUALS() extends Token

case class COMMA() extends Token

case class COLON() extends Token

case class EXIT() extends Token

case class TYPEDEF() extends Token

case class EXTERN() extends Token

case class STRING() extends Token

case class CLASS() extends Token

case class INT() extends Token

case class SET() extends Token

case class MAP() extends Token

case class LParen() extends Token

case class RParen() extends Token

case class LBracket() extends Token

case class RBracket() extends Token

case class LBrace() extends Token

case class RBrace() extends Token

case class ASSIGN() extends Token

case class DOT() extends Token

