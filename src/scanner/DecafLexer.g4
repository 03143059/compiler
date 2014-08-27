lexer grammar DecafLexer;

@lexer::header {
    package scanner;
}

@members {
    private int count = 0;
    private static final String TAB = "  ";
}

// reserved words
RESERVED    :
                (CLASS | IF | ELSE | FOR | RETURN | BREAK | CONTINUE | CALLOUT | TRUE | FALSE | INT | BOOLEAN | VOID ) {
                    System.out.print(getText().toUpperCase() + " ");
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

LCURLY      : '{'
            {
                System.out.print(getText() + " ");
                count++;
            };

RCURLY      : '}'
            {
                System.out.print("\b\b");
                System.out.print(getText() + " ");
                count--;
            };

LPAREN      : '(' { System.out.print(getText() + " "); };
RPAREN      : ')' { System.out.print(getText() + " "); };
LSQUARE     : '[' { System.out.print(getText() + " "); };
RSQUARE     : ']' { System.out.print(getText() + " "); };

SL_COMMENT  : '//' (~'\n')*? NL -> skip;

COMMA       : ',' { System.out.print(getText() + " "); };
SEMI        : ';' { System.out.print(getText() + TAB + " "); };

// Arithmetic operators
PLUS        : '+' { System.out.print(getText() + " "); };
MINUS       : '-' { System.out.print(getText() + " "); };
MUL         : '*' { System.out.print(getText() + " "); };
DIV         : '/' { System.out.print(getText() + " "); };
MOD         : '%' { System.out.print(getText() + " "); };

// Assignment operators
ASSIGNPLUSEQ    : '+=' { System.out.print(getText() + " "); };
ASSIGNMINUSEQ   : '-=' { System.out.print(getText() + " "); };
ASSIGNEQ        : '=' { System.out.print(getText() + " "); };

// Relation operators
LESS        : '<'  { System.out.print(getText() + " "); };
MORE        : '>'  { System.out.print(getText() + " "); };
LEQ         : '<=' { System.out.print(getText() + " "); };
GEQ         : '>=' { System.out.print(getText() + " "); };
CEQ         : '==' { System.out.print(getText() + " "); };
NEQ         : '!=' { System.out.print(getText() + " "); };
AND         : '&&' { System.out.print(getText() + " "); };
OR          : '||' { System.out.print(getText() + " "); };
NOT         : '!'  { System.out.print(getText() + " "); };

// Identifiers and Literals
ID              : ALPHA ( ALPHA_NUM )* { System.out.print("ID "); } ;
INT_LITERAL     : ( DECIMAL_LITERAL | HEX_LITERAL ) { System.out.print("ENTERO "); } ;
DECIMAL_LITERAL : ( DIGIT )+ { System.out.print("DECIMAL "); } ;
HEX_LITERAL     : '0x' ( HEX_DIGIT )+ { System.out.print("HEX "); } ;
BOOL_LITERAL	: ( TRUE | FALSE ) { System.out.print("BOOLEAN "); } ;
CHAR_LITERAL    : '\'' CHAR '\'' { System.out.print("CHAR "); } ;
STRING_LITERAL  : '"' ( CHAR )*? '"' { System.out.print("CADENA "); } ;
CHAR            : ESC | VALIDCHAR ;

// Protected tokens
ALPHA_NUM   : ALPHA | DIGIT ;
ALPHA       : [A-Za-z_] ;
DIGIT       : [0-9] ;
HEX_DIGIT   : DIGIT | [a-fA-F] ;
ESC         :  '\\' [ntr"'\\] ;
VALIDCHAR   : ( '\u0020'..'\u0021'
            | '\u0023'..'\u0026'
            | '\u0028'..'\u005B'
            | '\u005d'..'\u007e' )
            ;

//WS          :   [ \t\n\r]+ -> skip ;
NL          : [\r]? [\n]
            {
                System.out.println();
                for(int i = 0; i<count; i++)
                    System.out.print(TAB);
            } -> skip ;

WS          : [\t ]+ -> skip ;
