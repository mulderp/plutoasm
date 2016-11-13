package parser;

import java.util.Vector;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlrparser.SimpleAsmListener;
import antlrparser.SimpleAsmParser.DataDeclContext;
import antlrparser.SimpleAsmParser.InitContext;
import antlrparser.SimpleAsmParser.LabelContext;
import antlrparser.SimpleAsmParser.NumberListContext;
import antlrparser.SimpleAsmParser.SegmentStmtContext;
import antlrparser.SimpleAsmParser.StmtContext;
import antlrparser.SimpleAsmParser.ValueContext;

public class TranslateASMSource implements SimpleAsmListener {

	MemoryMap memoryMap;
	
	public TranslateASMSource(MemoryMap memoryMap) {
		this.memoryMap = memoryMap;
	}
	
	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterInit(InitContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitInit(InitContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterStmt(StmtContext ctx) {

	}

	@Override
	public void exitStmt(StmtContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterSegmentStmt(SegmentStmtContext ctx) {
		memoryMap.setActiveSegment(ctx.getText());

		System.out.println();
	}

	@Override
	public void exitSegmentStmt(SegmentStmtContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterDataDecl(DataDeclContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitDataDecl(DataDeclContext ctx) {

	}

	@Override
	public void enterLabel(LabelContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitLabel(LabelContext ctx) {
	
	}

	@Override
	public void enterNumberList(NumberListContext ctx) {

	}

	@Override
	public void exitNumberList(NumberListContext ctx) {

	}

	@Override
	public void enterValue(ValueContext ctx) {
		System.out.println(ctx.INT().getText());
		memoryMap.add(ctx.INT().getText());
	}

	@Override
	public void exitValue(ValueContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
