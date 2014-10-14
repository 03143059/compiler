// Generated from parser\DecafParser.g4 by ANTLR 4.3

  package parser;
  import scanner.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DecafParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DecafParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code callout}
	 * labeled alternative in {@link DecafParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallout(@NotNull DecafParser.CalloutContext ctx);

	/**
	 * Visit a parse tree produced by the {@code aritexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritexpr(@NotNull DecafParser.AritexprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code singleid}
	 * labeled alternative in {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleid(@NotNull DecafParser.SingleidContext ctx);

	/**
	 * Visit a parse tree produced by the {@code metcall}
	 * labeled alternative in {@link DecafParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetcall(@NotNull DecafParser.MetcallContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull DecafParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code relexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelexpr(@NotNull DecafParser.RelexprContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull DecafParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by the {@code retstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetstmt(@NotNull DecafParser.RetstmtContext ctx);

	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull DecafParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#method_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_name(@NotNull DecafParser.Method_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#method_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_param(@NotNull DecafParser.Method_paramContext ctx);

	/**
	 * Visit a parse tree produced by the {@code locarray}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocarray(@NotNull DecafParser.LocarrayContext ctx);

	/**
	 * Visit a parse tree produced by the {@code locexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocexpr(@NotNull DecafParser.LocexprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code errordecl}
	 * labeled alternative in {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrordecl(@NotNull DecafParser.ErrordeclContext ctx);

	/**
	 * Visit a parse tree produced by the {@code condexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondexpr(@NotNull DecafParser.CondexprContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull DecafParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by the {@code metstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetstmt(@NotNull DecafParser.MetstmtContext ctx);

	/**
	 * Visit a parse tree produced by the {@code parenexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenexpr(@NotNull DecafParser.ParenexprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code eqexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqexpr(@NotNull DecafParser.EqexprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotexpr(@NotNull DecafParser.NotexprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code metexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetexpr(@NotNull DecafParser.MetexprContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#bad_field_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBad_field_decl(@NotNull DecafParser.Bad_field_declContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ifstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(@NotNull DecafParser.IfstmtContext ctx);

	/**
	 * Visit a parse tree produced by the {@code brkstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrkstmt(@NotNull DecafParser.BrkstmtContext ctx);

	/**
	 * Visit a parse tree produced by the {@code cntstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCntstmt(@NotNull DecafParser.CntstmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull DecafParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#method_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_expr(@NotNull DecafParser.Method_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#callout_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallout_arg(@NotNull DecafParser.Callout_argContext ctx);

	/**
	 * Visit a parse tree produced by the {@code litexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitexpr(@NotNull DecafParser.LitexprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code blkstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlkstmt(@NotNull DecafParser.BlkstmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#method_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_decl(@NotNull DecafParser.Method_declContext ctx);

	/**
	 * Visit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstmt(@NotNull DecafParser.ForstmtContext ctx);

	/**
	 * Visit a parse tree produced by the {@code minexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinexpr(@NotNull DecafParser.MinexprContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(@NotNull DecafParser.Var_declContext ctx);

	/**
	 * Visit a parse tree produced by the {@code locstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocstmt(@NotNull DecafParser.LocstmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#assign_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_op(@NotNull DecafParser.Assign_opContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#field_decls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_decls(@NotNull DecafParser.Field_declsContext ctx);

	/**
	 * Visit a parse tree produced by the {@code locid}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocid(@NotNull DecafParser.LocidContext ctx);
}