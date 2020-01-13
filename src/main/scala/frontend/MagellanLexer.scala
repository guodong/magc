package frontend

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

object MagellanLexer extends RegexParsers {
  override def skipWhitespace = true
  override val whiteSpace: Regex = "[ \t\r\f]+".r

  def apply(code: String): Either[MagellanLexerError, List[MagellanToken]] = {
    parse(tokens, code) match {
      case NoSuccess(msg, next) => Left(MagellanLexerError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, next) => Right(result)
    }
  }

  def tokens: Parser[List[MagellanToken]] = {
    phrase(rep1( colon
      | equals | comma | literal | identifier))
  }

  def identifier: Parser[IDENTIFIER] = positioned {
    "[a-zA-Z_][a-zA-Z0-9_]*".r ^^ { str => IDENTIFIER(str) }
  }

  def literal: Parser[LITERAL] = positioned {
    """"[^"]*"""".r ^^ { str =>
      val content = str.substring(1, str.length - 1)
      LITERAL(content)
    }
  }
  def colon         = positioned { ":"             ^^ (_ => COLON()) }
  def equals        = positioned { "=="            ^^ (_ => EQUALS()) }
  def comma         = positioned { ","             ^^ (_ => COMMA()) }
  def exit         = positioned { "exit"             ^^ (_ => EXIT()) }
}
