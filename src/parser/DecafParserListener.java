// Generated from parser\DecafParser.g4 by ANTLR 4.3

  package parser;
  import scanner.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DecafParser}.
 */
public interface DecafParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code callout}
	 * labeled alternative in {@link DecafParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterCallout(@NotNull DecafParser.CalloutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callout}
	 * labeled alternative in {@link DecafParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitCallout(@NotNull DecafParser.CalloutContext ctx);

	/**
	 * Enter a parse tree produced by the {@code aritexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAritexpr(@NotNull DecafParser.AritexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aritexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAritexpr(@NotNull DecafParser.AritexprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code singleid}
	 * labeled alternative in {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void enterSingleid(@NotNull DecafParser.SingleidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleid}
	 * labeled alternative in {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void exitSingleid(@NotNull DecafParser.SingleidContext ctx);

	/**
	 * Enter a parse tree produced by the {@code metcall}
	 * labeled alternative in {@link DecafParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterMetcall(@NotNull DecafParser.MetcallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code metcall}
	 * labeled alternative in {@link DecafParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitMetcall(@NotNull DecafParser.MetcallContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull DecafParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull DecafParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code relexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelexpr(@NotNull DecafParser.RelexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelexpr(@NotNull DecafParser.RelexprContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull DecafParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull DecafParser.LiteralContext ctx);

	/**
	 * Enter a parse tree produced by the {@code retstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRetstmt(@NotNull DecafParser.RetstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code retstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRetstmt(@NotNull DecafParser.RetstmtContext ctx);

	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull DecafParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull DecafParser.ArrayContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#method_name}.
	 * @param ctx the parse tree
	 */
	void enterMethod_name(@NotNull DecafParser.Method_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_name}.
	 * @param ctx the parse tree
	 */
	void exitMethod_name(@NotNull DecafParser.Method_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#method_param}.
	 * @param ctx the parse tree
	 */
	void enterMethod_param(@NotNull DecafParser.Method_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_param}.
	 * @param ctx the parse tree
	 */
	void exitMethod_param(@NotNull DecafParser.Method_paramContext ctx);

	/**
	 * Enter a parse tree produced by the {@code locarray}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocarray(@NotNull DecafParser.LocarrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code locarray}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocarray(@NotNull DecafParser.LocarrayContext ctx);

	/**
	 * Enter a parse tree produced by the {@code locexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLocexpr(@NotNull DecafParser.LocexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code locexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLocexpr(@NotNull DecafParser.LocexprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code errordecl}
	 * labeled alternative in {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void enterErrordecl(@NotNull DecafParser.ErrordeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code errordecl}
	 * labeled alternative in {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void exitErrordecl(@NotNull DecafParser.ErrordeclContext ctx);

	/**
	 * Enter a parse tree produced by the {@code condexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCondexpr(@NotNull DecafParser.CondexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCondexpr(@NotNull DecafParser.CondexprContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull DecafParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull DecafParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by the {@code metstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterMetstmt(@NotNull DecafParser.MetstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code metstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitMetstmt(@NotNull DecafParser.MetstmtContext ctx);

	/**
	 * Enter a parse tree produced by the {@code parenexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenexpr(@NotNull DecafParser.ParenexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenexpr(@NotNull DecafParser.ParenexprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code eqexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqexpr(@NotNull DecafParser.EqexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqexpr(@NotNull DecafParser.EqexprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotexpr(@NotNull DecafParser.NotexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotexpr(@NotNull DecafParser.NotexprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code metexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMetexpr(@NotNull DecafParser.MetexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code metexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMetexpr(@NotNull DecafParser.MetexprContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#bad_field_decl}.
	 * @param ctx the parse tree
	 */
	void enterBad_field_decl(@NotNull DecafParser.Bad_field_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#bad_field_decl}.
	 * @param ctx the parse tree
	 */
	void exitBad_field_decl(@NotNull DecafParser.Bad_field_declContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ifstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(@NotNull DecafParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(@NotNull DecafParser.IfstmtContext ctx);

	/**
	 * Enter a parse tree produced by the {@code brkstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBrkstmt(@NotNull DecafParser.BrkstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code brkstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBrkstmt(@NotNull DecafParser.BrkstmtContext ctx);

	/**
	 * Enter a parse tree produced by the {@code cntstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCntstmt(@NotNull DecafParser.CntstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cntstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCntstmt(@NotNull DecafParser.CntstmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull DecafParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull DecafParser.StartContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#callout_arg}.
	 * @param ctx the parse tree
	 */
	void enterCallout_arg(@NotNull DecafParser.Callout_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#callout_arg}.
	 * @param ctx the parse tree
	 */
	void exitCallout_arg(@NotNull DecafParser.Callout_argContext ctx);

	/**
	 * Enter a parse tree produced by the {@code litexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLitexpr(@NotNull DecafParser.LitexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code litexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLitexpr(@NotNull DecafParser.LitexprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code blkstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlkstmt(@NotNull DecafParser.BlkstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blkstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlkstmt(@NotNull DecafParser.BlkstmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void enterMethod_decl(@NotNull DecafParser.Method_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void exitMethod_decl(@NotNull DecafParser.Method_declContext ctx);

	/**
	 * Enter a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForstmt(@NotNull DecafParser.ForstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForstmt(@NotNull DecafParser.ForstmtContext ctx);

	/**
	 * Enter a parse tree produced by the {@code minexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinexpr(@NotNull DecafParser.MinexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minexpr}
	 * labeled alternative in {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinexpr(@NotNull DecafParser.MinexprContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(@NotNull DecafParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(@NotNull DecafParser.Var_declContext ctx);

	/**
	 * Enter a parse tree produced by the {@code locstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLocstmt(@NotNull DecafParser.LocstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code locstmt}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLocstmt(@NotNull DecafParser.LocstmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void enterAssign_op(@NotNull DecafParser.Assign_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void exitAssign_op(@NotNull DecafParser.Assign_opContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#field_decls}.
	 * @param ctx the parse tree
	 */
	void enterField_decls(@NotNull DecafParser.Field_declsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#field_decls}.
	 * @param ctx the parse tree
	 */
	void exitField_decls(@NotNull DecafParser.Field_declsContext ctx);

	/**
	 * Enter a parse tree produced by the {@code locid}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocid(@NotNull DecafParser.LocidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code locid}
	 * labeled alternative in {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocid(@NotNull DecafParser.LocidContext ctx);
}