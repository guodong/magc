package frontend

import frontend.parser.MagellanBaseVisitor


class ASTVisitor extends MagellanBaseVisitor[Value]{
//  override def visitClassDef(ctx: MagellanParser.ClassDefContext): Value = {
//    val ir = IR
//    var attrs: Map[String, Variable] = Map.empty
//
//    ctx.varDef().forEach(v => attrs += visit(v).name -> visit(v))
//    val variable: ClassVariable = ClassVariable(ctx.Id().getText, attrs)
//    ir.addVariable(variable)
//    variable
//  }

//  override def visitVarDef(ctx: MagellanParser.VarDefContext): Value = {
//    ctx.`type`() match {
//      case "Map" =>
//        val variable = MapVariable(ctx.Id().getText, ctx.`type`().)
//    }
//  }
}
