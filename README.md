# C-Compiler-in-java
#Grammar used:

start -> statements

statements -> statement statements
			| epsilon

statement  ->  do statement while ( boolean );
           | break ;
           | continue ;
           | {statements}
           | type var;
           | unary statementprime;
 
statementprime -> ;|= bool;

type -> int | float | char | double

var -> id varprime

varprime -> [boolean] varprime | epsilon

boolean -> join booleanprime

booleanprime -> ||boolean | epsilon

join -> equalrelated joinprime

joinprime -> && join | epsilon

equalrelated -> rel equalityrelatedprime

equalityrelatedprime -> == equality | !=equality | epsilon

rel      -> expression relprime

relprime  -> < expression | <= expression | >= expression | > expression | epsilon

expression     -> term expressionprime

expressionprime -> + expression | - expression | epsilon

term     -> factor termprime

termprime -> * term | / term | epsilon

factor   -> ( boolean ) | number | real | true | false | unar

unary    -> !unary | unaryprime var | var unaryprime

unaryprime-> ++ | -- | epsilon
