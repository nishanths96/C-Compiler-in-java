package parser;
import java.io.IOException;

import SymbolTable.Token;
import lexer.LexicalAnalysis;

public class Node {
	//public static int lexline;
	public String code;
	public static Token token;
	
	public Node(){
		//lexline = LexicalAnalysis.lexline;
		code = "";
		token = null;
	}
	/*public void error(){
		System.out.println("Error at around line number: "+lexline);	//use token tag and tokenameconstant
	}*/
	
	public static Token getToken() throws IOException{
		//if(token==null)
		token = LexicalAnalysis.getNextToken();
		return token; 
	}
	public static Token setToken(){
		token = null;
		return token;
	}
}
