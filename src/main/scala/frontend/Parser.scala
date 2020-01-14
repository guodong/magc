package frontend

import scala.util.parsing.combinator.Parsers
import scala.util.parsing.input.{NoPosition, Position, Reader}

object Parser extends Parsers {
  override type Elem = Token

  class TokenReader(tokens: Seq[Token]) extends Reader[Token] {
    override def first: Token = tokens.head
    override def atEnd: Boolean = tokens.isEmpty
    override def pos: Position = tokens.headOption.map(_.pos).getOrElse(NoPosition)
    override def rest: Reader[Token] = new TokenReader(tokens.tail)
  }


  def apply(tokens: Seq[Token]): Either[MagellanParserError, MagellanAST] = {
    val reader = new TokenReader(tokens)
    program(reader) match {
      case NoSuccess(msg, next) => Left(MagellanParserError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, next) => Right(result)
    }
  }

  def program: Parser[MagellanAST] = positioned {
    phrase(statement)
  }

  def block: Parser[MagellanAST] = positioned {
    LBrace() ~ rep1(statement) ~ RBrace() ^^ { case _ ~ stmtList ~ _ => stmtList reduceRight AndThen }
  }

  def statement: Parser[MagellanAST] = positioned {
    val classdef = CLASS() ~ identifier ~ LParen() ~ rep(identifier ~ COLON() ~ INT() ~ COMMA()) ~ identifier ~ COLON() ~ INT() ~ RParen() ~ block ^^ {
      case _ ~ IDENTIFIER(classname) ~ _ ~ inputs ~ IDENTIFIER(lastInput) ~ _ ~ _ ~ _ => ClassDef(classname)
    }
//    val varDef = identifier ~ COLON() ~ (simpleType | simpleType) ^^ {
//      case IDENTIFIER(name) ~ _ ~ _ =>
//    }
    classdef
  }

//  private def varType: Parser[MagellanAST] = positioned {
//    val t = identifier ~ LBracket() ~ rep(simpleType ~ COMMA()) ~ identifier ~ RBracket() ^^ {
//      case IDENTIFIER(name) ~ _ ~ types ~ IDENTIFIER(lname) ~ _ => VarType(name, types.map(_._1.name))
//    }
//  }

//  private def simpleType: Parser[SimpleType] = positioned {
//    accept("simple type", {case tp @ SimpleType(name) => tp})
//  }

  private def identifier: Parser[IDENTIFIER] = positioned {
    accept("identifier", { case id @ IDENTIFIER(name) => id })
  }

  private def literal: Parser[LITERAL] = positioned {
    accept("string literal", { case lit @ LITERAL(name) => lit })
  }

}
