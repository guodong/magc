import frontend.{ASTVisitor, IR}
import frontend.parser.{MagellanLexer, MagellanParser}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class ParseClass extends AnyFlatSpec {
  //  it should("success") in {
  //    val src = Source.fromResource("basic/class.mag").mkString
  //    println(src)
  //    val ast = Frontend.apply(src)
  //    println(ast)
  //  }
  it should ("suc") in {
    val src = Source.fromResource("basic/class.mag").mkString
    val cs = CharStreams.fromString(src)
    val lexer = new MagellanLexer(cs)
    val parser = new MagellanParser(new CommonTokenStream(lexer))
    val app = new ASTVisitor
    app.visit(parser.program())
    println(IR.variables)
  }
}
