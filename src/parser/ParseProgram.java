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
	StringBuffer output;
	
	public ParseProgram(String input) {
		this.input = input ;
		output = new StringBuffer();
	}
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public StringBuffer getOutput() {
		return output;
	}

	public void setOutput(StringBuffer output) {
		this.output = output;
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
        
        Vector<String> memoryMap = new Vector<String>();
        
        walker.walk(new TranslateASMSource(memoryMap), tree);

        StringBuffer str = new StringBuffer();
        for (int i = 0; i < memoryMap.size(); i++) {
        	str.append(memoryMap.get(i));
        }
		setOutput(str);
		
	}

}
