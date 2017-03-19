package parser;
import java.io.IOException;
import SymbolTable.Token;
import SymbolTable.TokenNameConstant;
import lexer.LexicalAnalysis;

public class Node {
	public String code;
	public static Token token;
	protected static NewLabel start = null;
	protected static NewLabel end = null;
	
	public Node(){
		code = "";
		token = null;
	}
	public static Token getToken() throws IOException{
		if(token==null)					
			token = LexicalAnalysis.getNextToken();
		return token; 	// return top of stack
	}
	public static void useToken(int tokenNum) throws IOException{
		boolean f = true;
		int checkCount = 0;
		boolean checkFlag = true;
		if(token.tag!=tokenNum){
			while(f){
				if(token.tag==TokenNameConstant.EOF){
					displayError("Error: EOF reached");
					break;
				}
				if(token.tag==tokenNum){
					f = false;
					break;
				}
				token = null;
				token = LexicalAnalysis.getNextToken();
				checkCount+=1;
				if(checkCount>1 && checkFlag){
					checkFlag = false;
					displayError("Error in Line number: "+LexicalAnalysis.lexline);
				}				
			}
		}
		token = null;
	}
	private static void displayError(String string) {
		System.out.println(string);
	}
}
