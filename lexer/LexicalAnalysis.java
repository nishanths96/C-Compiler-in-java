package lexer;
import SymbolTable.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalysis{
	static String source="";
	public static int lexline;
	public static String inpfile;
	public static String i;
	public LexicalAnalysis(String input){
		inpfile = input;
		lexline = 0;
		removeComments(inpfile);
		i = "filename.txt";
		source = readFile(i);
		source = source+"$";
		init();
		// TODO : line count properly..not here but in getNextToken()
	}
	public static void init(){
		Table.installToken(";", new Token(TokenNameConstant.SEMICOLON));

		//reserved words
		Table.installToken("while", new Token(TokenNameConstant.WHILE));
		Table.installToken("printf", new Token(TokenNameConstant.PRINT));
		Table.installToken("scanf", new Token(TokenNameConstant.SCAN));
		Table.installToken("break", new Token(TokenNameConstant.BREAK));
		Table.installToken("continue", new Token(TokenNameConstant.CONTINUE));
		Table.installToken("return", new Token(TokenNameConstant.RETURN));
		Table.installToken("int", new Token(TokenNameConstant.INT));
		Table.installToken("float", new Token(TokenNameConstant.FLOAT));
		Table.installToken("double", new Token(TokenNameConstant.DOUBLE));
		Table.installToken("char", new Token(TokenNameConstant.CHAR));

		//brackets
		Table.installToken("{", new Token(TokenNameConstant.OPENFLOWER));
		Table.installToken("}", new Token(TokenNameConstant.CLOSEFLOWER));
		Table.installToken("(", new Token(TokenNameConstant.OPENPARAN));
		Table.installToken(")", new Token(TokenNameConstant.CLOSEPARAN));
		Table.installToken("[", new Token(TokenNameConstant.OPENSQUARE));
		Table.installToken("]", new Token(TokenNameConstant.CLOSESQUARE));
		
		//operators
		Table.installToken("+", new Token(TokenNameConstant.ADD));
		Table.installToken("+=", new Token(TokenNameConstant.ADDEQUAL));
		Table.installToken("++", new Token(TokenNameConstant.INCREMENT));
		Table.installToken("-", new Token(TokenNameConstant.SUBTRACT));
		Table.installToken("-=", new Token(TokenNameConstant.SUBTRACTEQUAL));
		Table.installToken("--", new Token(TokenNameConstant.DECREMENT));
		Table.installToken("*", new Token(TokenNameConstant.MULTIPLY));
		Table.installToken("*=", new Token(TokenNameConstant.MODULUSEQUAL));
		Table.installToken("/", new Token(TokenNameConstant.DIVIDE));
		Table.installToken("/=", new Token(TokenNameConstant.DIVIDEEQUAL));
		Table.installToken("%", new Token(TokenNameConstant.MODULUS));
		Table.installToken("%=", new Token(TokenNameConstant.MODULUSEQUAL));
		Table.installToken(">", new Token(TokenNameConstant.GT));
		Table.installToken(">=", new Token(TokenNameConstant.GE));
		Table.installToken("<", new Token(TokenNameConstant.LT));
		Table.installToken("<=", new Token(TokenNameConstant.LE));
		Table.installToken("==", new Token(TokenNameConstant.EQ));
		Table.installToken("=", new Token(TokenNameConstant.ASSIGN));
		Table.installToken("!=", new Token(TokenNameConstant.NE));
		Table.installToken("!", new Token(TokenNameConstant.NOT));
		Table.installToken("&&", new Token(TokenNameConstant.AND));
		Table.installToken("||", new Token(TokenNameConstant.OR));
		
		//EOF
		Table.installToken("$", new Token(TokenNameConstant.EOF));
	}
	/*public static void main(String[] args) throws IOException{
		try{
		String inputfile = args[0];
		removeComments(inputfile);
		String i = "filename.txt";
		source = readFile(i);
		int fff = 0;
		while(++fff<100){
			getNextToken();	
		}
		FileWriter fileout = new FileWriter("filename1.txt");
		fileout.write("");
		fileout.append(source);
		fileout.close();
		source = source+"$";	
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}*/
	public static Token getNextToken() throws IOException{
		try{
			String identifier="", singlecharOperators="", number="", operators="", stringLiterals="", chars="", forlinecount="";
			String pattern2 = "[_a-zA-Z][_a-zA-Z0-9]*"; 		// check for identifiers ( including keywords )
			String pattern4 = "[==|!=|>=|<=|+=|-=|*=|/=|%=|++|--]";	// check for operators i.e, ==, !=, >=, <=, +=, -=, *=, /=, %=, ++, --
			String pattern1 = "[<|>|!|+|-|*|/|=|;|%]";			// check for <, >, !, =, +, -, *, /, %, ;
			String pattern3="[+-]?([0-9]*[.])?[0-9]+";			// check all the numbers here..including float and integer
			String pattern5 = "";									// check for string literals ^"[^"\\]*(\\.[^"\\]*)*"$
			String pattern6 = "'[.]'";								// check for character literals
			String pattern7 = "[\n]";
			Pattern r7 = Pattern.compile(pattern7);
			Pattern r2 = Pattern.compile(pattern2);
			Pattern r4 = Pattern.compile(pattern4);
			Pattern r1 = Pattern.compile(pattern1);
			Pattern r3 = Pattern.compile(pattern3);
			Pattern r5 = Pattern.compile(pattern5);				
			Pattern r6 = Pattern.compile(pattern6);
			Matcher m7 = r7.matcher(source);
			Matcher m2 = r2.matcher(source);
			Matcher m4 = r4.matcher(source);
			Matcher m1 = r1.matcher(source);
			Matcher m3 = r3.matcher(source);
			Matcher m5 = r5.matcher(source);
			Matcher m6 = r6.matcher(source);
			String res = "";
			boolean match = false;
			boolean f1=false, f2=false, f3=false, f4=false, f5=false, f6=false, f7 = false;
			if(m7.find()){
				f7 = true;
				forlinecount = m7.group(0);
			}
			if(m2.find()){
				f2 = true;
				identifier = m2.group(0);
			}
			if(m4.find()){
				f4 = true;
				operators = m4.group(0);
			}
			if(m1.find()){
				f1 = true;
				singlecharOperators = m1.group(0);
			}
			if(m3.find()){
				f3 = true;
				number = m3.group(0);
			}
			if(m5.find()){
				f5 = true;
				stringLiterals = m5.group(0);
			}
			if(m6.find()){
				f6 = true;
				chars = m6.group(0);
			}
			
			if(f2||f4||f1||f3||f5||f6||f7){
				while(!match){
					for(int z=0;z<source.length();z++){	
							res=res+source.charAt(z);
							if(res.equals(forlinecount) && f7==true){
								lexline = lexline+1;
							}
							res = res.replaceAll("\\s+","");
							if(res.equals(identifier)&&f2==true){
								//System.out.println("RES: "+res);
								match = true;
								source = source.replaceFirst(identifier,"");
								return Table.installId(res);	
							}
							else if(res.equals(operators)&&f4==true){
								match = true;
								source = source.replaceFirst(operators,"");
								return Table.getToken(operators);
							}
							else if(res.equals(singlecharOperators)&&f1==true){
								//System.out.println("RES: "+res);
								if(res.charAt(0)=='<' && source.charAt(z+1) == '=')
									continue;
								else if(res.charAt(0)=='>' && source.charAt(z+1) == '=')
									continue;
								else if(res.charAt(0)=='!' && source.charAt(z+1) == '=')
									continue;
								else if(res.charAt(0)=='=' && source.charAt(z+1) == '=')
									continue;
								else if(res.charAt(0)=='+' && source.charAt(z+1) == '+')
									continue;
								else if(res.charAt(0)=='-' && source.charAt(z+1) == '-')
									continue;
								else{
									match = true;
									source = source.replaceFirst(singlecharOperators,"");
									return Table.getToken(singlecharOperators);
								}
							}
							else if(res.equals(number)&&f3==true){
								match = true;
								source = source.replaceFirst(number,"");
								if(res.indexOf('.')==-1){
									int tempnum = Integer.parseInt(res);
									return Table.installNum(tempnum);
								}
								else{
									double tempreal = Double.parseDouble(res);
									return Table.installReal(tempreal);
								}
								
							}
							else if(res.equals(stringLiterals)&&f5==true){
								//System.out.println("RES: "+res);
								match = true;
								source = source.replaceFirst(number,"");
								return Table.installStringLiteral(res);
							}
							else if(res.equals(chars)&&f6==true){
								match = true;
								source = source.replaceFirst(number,"");
								return Table.installCharacter(chars);
							}	
					}
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;	
	}
	public static void removeComments(String inputfile){
		String source = readFile(inputfile);    
    	String clearedinput = source.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
    	try(  PrintWriter out = new PrintWriter( "filename.txt" )  ){
    		out.println( clearedinput );
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static String readFile(String fileName){    
       File file = new File(fileName);    
       char[] buffer = null;    
       try{    
          BufferedReader bufferedReader = new BufferedReader( new FileReader(file));    
          buffer = new char[(int)file.length()];    
          int i = 0;    
          int c = bufferedReader.read();    
          while (c != -1) {    
            buffer[i++] = (char)c;    
            c = bufferedReader.read();    
          }
          bufferedReader.close();
    	} 
    catch (IOException e) {    
        e.printStackTrace();    
    }    
    return new String(buffer);    
 	}
}
