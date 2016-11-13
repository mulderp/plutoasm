package parser;

import java.util.Vector;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlrparser.SimpleAsmLexer;
import antlrparser.SimpleAsmParser;

public class ParseProgram {
	
	String input;
	String output;
	
	public ParseProgram(String input) {
		this.input = input ;
		output = "";
	}
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String string) {
		this.output = string;
	}

	public void parse() {
		
		
		ANTLRInputStream input = new ANTLRInputStream(getInput());
		
        // create a lexer that feeds off of input CharStream
        SimpleAsmLexer lexer = new SimpleAsmLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        SimpleAsmParser parser = new SimpleAsmParser(tokens);

        ParseTree tree = parser.init(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        
        ParseTreeWalker walker = new ParseTreeWalker();
        
        MemoryMap memoryMap = new MemoryMap();
        
        walker.walk(new TranslateASMSource(memoryMap), tree);


		setOutput(memoryMap.getString());
		
	}

}
