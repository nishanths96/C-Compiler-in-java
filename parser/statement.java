package parser;

import java.io.IOException;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class statement extends Node{
	public statement() throws IOException{
		Token token = getToken();
		
		if(token.tag == TokenNameConstant.DO){
			token = setToken();
			statement s = new statement();
			if(token.tag == TokenNameConstant.WHILE){
				token = setToken();
				token = getToken();
				if(token.tag == TokenNameConstant.OPENPARAN){
					token = setToken();
					booleanclass b = new booleanclass();
					
				}
			}
			
		}
	}
	public void beginProcedure(){
		Token token = getToken();
		if(token.tag == TokenNameConstant.DO){
			beginProcedure();
			token = getToken();
			if(token.tag == TokenNameConstant.WHILE){
				token = getToken();
				if(token.tag==TokenNameConstant.OPENPARAN){
					booleanclass b = new booleanclass();
					token = getToken();
					if(token.tag == TokenNameConstant.CLOSEPARAN){
						token = getToken();
						if(token.tag == TokenNameConstant.SEMICOLON){
							
						}
					}
				}
				
			}
		}
	}
}
