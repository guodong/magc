package frontend

object Frontend {
  def apply(code: String): Either[MagellanCompilationError, MagellanAST] = {
    for {
      tokens <- Lexer(code)
      ast <- Parser(tokens)
    } yield ast
  }
}
