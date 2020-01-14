import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.scalatest.flatspec.AnyFlatSpec
import frontend.parser.{HelloBaseVisitor, HelloLexer, HelloParser}

class X

class ArithmeticVisitorApp extends HelloBaseVisitor[X] {

  override def visitR(ctx: HelloParser.RContext): X = {
    println(ctx.ID())
    new X
  }
}

class ParseClass extends AnyFlatSpec{
//  it should("success") in {
//    val src = Source.fromResource("basic/class.mag").mkString
//    println(src)
//    val ast = Frontend.apply(src)
//    println(ast)
//  }
  it should("suc") in {
    val src = "hello abc"
    val cs = CharStreams.fromString(src)
    val lexer      = new HelloLexer(cs)
    val parser = new HelloParser(new CommonTokenStream(lexer))
    val app = new ArithmeticVisitorApp
    app.visit(parser.r())
  }
}
