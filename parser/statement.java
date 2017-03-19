package parser;

import java.io.IOException;

import SymbolTable.Token;
import SymbolTable.TokenNameConstant;

public class statement extends Node{
	public statement(NewLabel l) throws IOException{
		beginProcedure();
		this.code="";
	}
	public void beginProcedure() throws IOException{
		Token token = getToken();
		int t = token.tag;
		if(TokenNameConstant.DO==t){
			useToken(TokenNameConstant.DO);
			NewLabel l1 = new NewLabel();
			NewLabel l2 = new NewLabel();
			NewLabel temps,tempe;
			temps = start;
			tempe = end;
			start = l1;
			end = l2;
			statement s1 = new statement(l1);
			useToken(TokenNameConstant.WHILE);
			useToken(TokenNameConstant.OPENPARAN);
			// booleanclass b = new booleanclass();
			useToken(TokenNameConstant.CLOSEPARAN);
			
			this.code+= l1.toString()+s1.code;
			/*this.code += booleanclass.code;		//synthetic attr
			  if(booleanclass.true)		// inherited attr
			  	this.code += "goto"+ l1;
			  else
			   	this.code = "goto"+l2;
			*/	
			this.code+=l2+":\n";
			start = temps;
			end = tempe;
		}
		
	}
}
