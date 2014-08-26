lexer grammar DecafLexer;

@lexer::header {
    package scanner;
}

  // keyword tokens
RESERVED    :
                (CLASS | IF | ELSE | FOR | RETURN | BREAK | CONTINUE | CALLOUT | TRUE | FALSE | INT | BOOLEAN | VOID ) {
                    System.out.println("reserved word " + getText().toUpperCase());
                 };
CLASS       :   'class';
IF	        :	'if';
ELSE	    :	'else';
FOR	        :	'for';
RETURN	    :	'return';
BREAK	    :	'break';
CONTINUE	:	'continue';
CALLOUT	    :	'callout';
TRUE	    :	'true';
FALSE	    :	'false';
INT	        :	'int';
BOOLEAN	    :	'boolean';
VOID	    :	'void';

LCURLY : '{' { System.out.println("{"); };
RCURLY : '}' { System.out.println("}"); };
LPAREN : '(' { System.out.println("("); };
RPAREN : ')' { System.out.println(")"); };
LSQUARE : '[' { System.out.println("["); };
RSQUARE : ']' { System.out.println("]"); };

SL_COMMENT : '//' (~'\n')* '\n' { System.out.println("comment"); } -> skip;

STRING : '"' (ESC | VALIDCHARS)* '"' { System.out.println("string literal"); };
CHAR : '\'' (ESC | VALIDCHARS) '\'' { System.out.println("char literal"); };
COMMA : ','  { System.out.println("comma"); };
SEMI : ';'  { System.out.println("semicolon"); };

// Arithmetic operators
PLUS : '+'  { System.out.println("plus sign"); };
MINUS : '-' { System.out.println("minus sign"); };
MULDIV : '*' | '/'  { System.out.println("mul or div operation"); };
MOD : '%'  { System.out.println("modulus operation"); };

// Assignment operators
ASSIGNPLUSEQ : '+=' { System.out.println("+="); };
ASSIGNMINUSEQ : '-=' { System.out.println("-="); };
ASSIGNEQ : '=' { System.out.println("="); };

// Relation operators
LESS : '<' { System.out.println("<"); };
MORE : '>' { System.out.println(">"); };
LEQ : '<=' { System.out.println("<="); };
GEQ : '>=' { System.out.println(">="); };
CEQ : '==' { System.out.println("=="); };
NEQ : '!=' { System.out.println("!="); };
AND : '&&' { System.out.println("&&"); };
OR : '||' { System.out.println("||"); };
NOT : '!' { System.out.println("!"); };

// Identifiers and Literals
ID : (ALPHA)(ALPHA_NUM)*  { System.out.println("identifier"); };
INTLIT : DECIMAL | HEX  { System.out.println("integer literal"); };

// Protected tokens
ESC :  '\\' ('n'|'"'|'t'|'r'|'\''|'\\') ;
VALIDCHARS : ('\u0020'..'\u0021' | '\u0023'..'\u0026' | '\u0028'..'\u005B' | '\u005d'..'\u007e') ;
ALPHA : 'a'..'z' | 'A'..'Z' | '_' ;
DIGIT : '0'..'9' ;
HEX_DIGIT : DIGIT | 'a'..'f' | 'A'..'F' ;
ALPHA_NUM : ALPHA | DIGIT ;
DECIMAL : (DIGIT)+ ;
HEX : '0x' (HEX_DIGIT)+ ;

WS  :   [ \t\n\r]+ -> skip ;
