// Generated from Magellan.g4 by ANTLR 4.7.2

    package frontend.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MagellanParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MagellanVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MagellanParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MagellanParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MagellanParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#classDefBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefBlock(MagellanParser.ClassDefBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MagellanParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MagellanParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#pathCtlDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathCtlDef(MagellanParser.PathCtlDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#funcArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncArgs(MagellanParser.FuncArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#funcArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncArg(MagellanParser.FuncArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MagellanParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(MagellanParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MagellanParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MagellanParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#attr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr(MagellanParser.AttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#anonymousFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousFunc(MagellanParser.AnonymousFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#threadDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreadDef(MagellanParser.ThreadDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#threadBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreadBody(MagellanParser.ThreadBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MagellanParser#threadItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreadItem(MagellanParser.ThreadItemContext ctx);
}