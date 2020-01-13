package frontend

import scala.util.parsing.combinator.Parsers
import scala.util.parsing.input.{NoPosition, Position, Reader}

object WorkflowParser extends Parsers {
  override type Elem = MagellanToken

  class WorkflowTokenReader(tokens: Seq[MagellanToken]) extends Reader[MagellanToken] {
    override def first: MagellanToken = tokens.head
    override def atEnd: Boolean = tokens.isEmpty
    override def pos: Position = tokens.headOption.map(_.pos).getOrElse(NoPosition)
    override def rest: Reader[MagellanToken] = new WorkflowTokenReader(tokens.tail)
  }


  def apply(tokens: Seq[MagellanToken]): Either[MagellanParserError, MagellanAST] = {
    val reader = new WorkflowTokenReader(tokens)
    program(reader) match {
      case NoSuccess(msg, next) => Left(MagellanParserError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, next) => Right(result)
    }
  }

  def program: Parser[MagellanAST] = positioned {
    phrase(block)
  }

  def block: Parser[MagellanAST] = positioned {
    rep1(statement) ^^ { case stmtList => stmtList reduceRight AndThen }
  }

  def statement: Parser[MagellanAST] = positioned {
    val exit = EXIT() ^^ (_ => Exit)

    exit
  }

  def condition: Parser[Equals] = positioned {
    (identifier ~ EQUALS() ~ literal) ^^ { case IDENTIFIER(id) ~ eq ~ LITERAL(lit) => Equals(id, lit) }
  }

  private def identifier: Parser[IDENTIFIER] = positioned {
    accept("identifier", { case id @ IDENTIFIER(name) => id })
  }

  private def literal: Parser[LITERAL] = positioned {
    accept("string literal", { case lit @ LITERAL(name) => lit })
  }

}
