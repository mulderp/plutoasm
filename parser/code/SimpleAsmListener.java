// Generated from SimpleAsm.g4 by ANTLR 4.5

    package antlrparser;

    // PARSER_VERSION = "0.2";

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleAsmParser}.
 */
public interface SimpleAsmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleAsmParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(SimpleAsmParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleAsmParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(SimpleAsmParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleAsmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SimpleAsmParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleAsmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SimpleAsmParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleAsmParser#segmentStmt}.
	 * @param ctx the parse tree
	 */
	void enterSegmentStmt(SimpleAsmParser.SegmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleAsmParser#segmentStmt}.
	 * @param ctx the parse tree
	 */
	void exitSegmentStmt(SimpleAsmParser.SegmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleAsmParser#dataDecl}.
	 * @param ctx the parse tree
	 */
	void enterDataDecl(SimpleAsmParser.DataDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleAsmParser#dataDecl}.
	 * @param ctx the parse tree
	 */
	void exitDataDecl(SimpleAsmParser.DataDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleAsmParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(SimpleAsmParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleAsmParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(SimpleAsmParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleAsmParser#numberList}.
	 * @param ctx the parse tree
	 */
	void enterNumberList(SimpleAsmParser.NumberListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleAsmParser#numberList}.
	 * @param ctx the parse tree
	 */
	void exitNumberList(SimpleAsmParser.NumberListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleAsmParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SimpleAsmParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleAsmParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SimpleAsmParser.ValueContext ctx);
}