package SymbolTable;

public class TokenNameConstant {
  public static int KEYWORD = 1;
  public static int BRACKET = 2;
  public static int IDENTIFIER = 3;
  public static int OPERATOR = 4;
  public static int INTEGERNUMBER = 5;
  public static int REALNUMBER = 6;
  public static int STRINGLITERAL = 7;
  public static int CHARACTERLITERAL = 8;
  public static int BASICANDARRAYTYPE = 9;
  //KEYWORDS
  public static int WHILE = 101;
  public static int PRINT = 102;
  public static int SCAN = 103;
  public static int BREAK = 104;
  public static int CONTINUE = 105;
  public static int RETURN = 106;
  public static int DO = 107;
  //SEMI-COLON
  public static int SEMICOLON = 108;
  
  //BRACKETS
  public static int OPENFLOWER = 201;
  public static int CLOSEFLOWER = 202;
  public static int OPENPARAN = 203;
  public static int CLOSEPARAN = 204;
  public static int OPENSQUARE = 205;
  public static int CLOSESQUARE = 206;
  
  //OPERATORS
  public static int ADD = 401;
  public static int ADDEQUAL = 402;
  public static int INCREMENT = 403;
  public static int SUBTRACT = 404;
  public static int SUBTRACTEQUAL = 405;
  public static int DECREMENT = 406;
  public static int MULTIPLY = 407;
  public static int MULTIPLYEQUAL = 408;
  public static int DIVIDE = 409;
  public static int DIVIDEEQUAL = 410;
  public static int MODULUS = 411;
  public static int MODULUSEQUAL = 412;
  public static int GT = 413;
  public static int GE = 414;
  public static int LT = 415;
  public static int LE = 416;
  public static int EQ = 417;
  public static int ASSIGN = 418;
  public static int NE = 419;
  public static int NOT = 420;
  public static int AND = 421;
  public static int OR = 422;
  
  //types
  public static final int INT = 501;
  public static final int FLOAT = 502;
  public static final int DOUBLE = 503;
  public static final int CHAR = 504;
  public static final int ARRAYINT = 505;
  public static final int ARRAYFLOAT = 506;
  public static final int ARRAYDOUBLE = 507;
  public static final int ARRAYCHAR = 508;
  
  //EOF
  public static final int EOF = 601;
  public static String getTokenName(int tag){
	  if(tag==WHILE)return "while";
		if(tag==PRINT)return "printf";
		if(tag==SCAN)return "scanf";
		if(tag==BREAK)return "break"; 
		if(tag==CONTINUE)return "continue"; 
		if(tag==RETURN)return "return"; 
		if(tag==INT)return "int"; 
		if(tag==FLOAT)return "float"; 
		if(tag==DOUBLE)return "double"; 
		if(tag==CHAR)return "char"; 
		if(tag==SEMICOLON)return ";";
		//brackets
		if(tag==OPENFLOWER)return "{"; 
		if(tag==CLOSEFLOWER)return "}"; 
		if(tag==OPENPARAN)return "("; 
		if(tag==CLOSEPARAN)return ")"; 
		if(tag==OPENSQUARE)return "["; 
		if(tag==CLOSESQUARE)return "]"; 
		
		//operators
		if(tag==ADD)return "+"; 
		if(tag==ADDEQUAL)return "+="; 
		if(tag==INCREMENT)return "++"; 
		if(tag==SUBTRACT)return "-"; 
		if(tag==SUBTRACTEQUAL)return "-="; 
		if(tag==DECREMENT)return "--"; 
		if(tag==MULTIPLY)return "*"; 
		if(tag==MODULUSEQUAL)return "*="; 
		if(tag==DIVIDE)return "/"; 
		if(tag==DIVIDEEQUAL)return "/="; 
		if(tag==MODULUS)return "%"; 
		if(tag==MODULUSEQUAL)return "%="; 
		if(tag==GT)return ">"; 
		if(tag==GE)return ">="; 
		if(tag==LT)return "<"; 
		if(tag==LE)return "<="; 
		if(tag==EQ)return "=="; 
		if(tag==ASSIGN)return "="; 
		if(tag==NE)return "!="; 
		if(tag==NOT)return "!"; 
		if(tag==AND)return "&&"; 
		if(tag==OR)return "||"; 
		return "";
  }
    
}
