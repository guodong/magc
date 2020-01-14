package frontend

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

object Lexer extends RegexParsers {
  override def skipWhitespace = true

  override val whiteSpace: Regex = "[ \t\r\f\n]+".r

  def apply(code: String): Either[MagellanLexerError, List[Token]] = {
    parse(tokens, code) match {
      case NoSuccess(msg, next) => Left(MagellanLexerError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, _) => Right(result)
    }
  }

  def tokens: Parser[List[Token]] = {
    phrase(rep1(positioned(":" ^^ (_ => COLON()))
      | positioned("class" ^^ (_ => CLASS()))
      | positioned("Int" ^^ (_ => INT()))
      | positioned("Set" ^^ (_ => SET()))
      | positioned("Map" ^^ (_ => MAP()))
      | positioned("(" ^^ (_ => LParen()))
      | positioned(")" ^^ (_ => RParen()))
      | positioned("[" ^^ (_ => LBracket()))
      | positioned("]" ^^ (_ => RBracket()))
      | positioned("{" ^^ (_ => LBrace()))
      | positioned("}" ^^ (_ => RBrace()))
      | positioned("=" ^^ (_ => ASSIGN()))
      | positioned("." ^^ (_ => DOT()))
      | positioned("," ^^ (_ => COMMA()))
      | positioned(":" ^^ (_ => COLON()))
      | positioned("==" ^^ (_ => EQUALS()))
      | literal | identifier))
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
}
