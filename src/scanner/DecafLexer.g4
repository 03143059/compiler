lexer grammar DecafLexer;

@lexer::header {
    package scanner;
}

@members {
    private int count = 0;
    public static boolean LexerDebug = false;
    private static final String TAB = "  ";
    private static void print(String p) { if (LexerDebug) System.out.print(p); }
    private static void println(String p) { if (LexerDebug) System.out.println(p); }
    private static void println() { if (LexerDebug) System.out.println(); }
}

// reserved words
CLASS	    : 'class' { print(getText().toUpperCase() + " "); } ;
IF	        : 'if' { print(getText().toUpperCase() + " "); } ;
ELSE	    : 'else' { print(getText().toUpperCase() + " "); } ;
FOR	        : 'for' { print(getText().toUpperCase() + " "); } ;
RETURN	    : 'return' { print(getText().toUpperCase() + " "); } ;
BREAK	    : 'break' { print(getText().toUpperCase() + " "); } ;
CONTINUE	: 'continue' { print(getText().toUpperCase() + " "); } ;
CALLOUT	    : 'callout' { print(getText().toUpperCase() + " "); } ;
INT	        : 'int' { print(getText().toUpperCase() + " "); } ;
BOOLEAN	    : 'boolean' { print(getText().toUpperCase() + " "); } ;
VOID	    : 'void' { print(getText().toUpperCase() + " "); } ;

PROGRAM     : 'Program' { print(getText() + " "); } ;

LCURLY      : '{'
            {
                print(getText() + " ");
                count++;
            };

RCURLY      : '}'
            {
                print("\b\b");
                print(getText() + " ");
                count--;
            };

LPAREN      : '(' { print(getText() + " "); };
RPAREN      : ')' { print(getText() + " "); };
LSQUARE     : '[' { print(getText() + " "); };
RSQUARE     : ']' { print(getText() + " "); };

SL_COMMENT  : '//' ~[\r\n]* -> skip;

COMMA       : ',' { print(getText() + " "); };
SEMI        : ';' { print(getText() + TAB + " "); };

// Arithmetic operators
PLUS        : '+' { print(getText() + " "); };
MINUS       : '-' { print(getText() + " "); };
MUL         : '*' { print(getText() + " "); };
DIV         : '/' { print(getText() + " "); };
MOD         : '%' { print(getText() + " "); };

// Assignment operators
ASSIGNPLUSEQ    : '+=' { print(getText() + " "); };
ASSIGNMINUSEQ   : '-=' { print(getText() + " "); };
ASSIGNEQ        : '=' { print(getText() + " "); };

// Relation operators
LESS        : '<'  { print(getText() + " "); };
MORE        : '>'  { print(getText() + " "); };
LEQ         : '<=' { print(getText() + " "); };
GEQ         : '>=' { print(getText() + " "); };
CEQ         : '==' { print(getText() + " "); };
NEQ         : '!=' { print(getText() + " "); };
AND         : '&&' { print(getText() + " "); };
OR          : '||' { print(getText() + " "); };
NOT         : '!'  { print(getText() + " "); };

BOOL_LITERAL	: ( TRUE | FALSE ) { print("BOOLEAN "); } ;

TRUE	    : 'true' { print(getText().toUpperCase() + " "); } ;
FALSE	    : 'false' { print(getText().toUpperCase() + " "); } ;

// Identifiers and Literals
ID              : ALPHA ( ALPHA_NUM )* { print("ID "); } ;

INT_LITERAL     : ( DECIMAL_LITERAL | HEX_LITERAL ) { print("ENTERO "); } ;
DECIMAL_LITERAL : ( DIGIT )+ { print("DECIMAL "); } ;
HEX_LITERAL     : '0x' ( HEX_DIGIT )+ { print("HEX "); } ;

STRING_LITERAL  : '"' ( CHAR )*? '"' { print("CADENA "); } ;
CHAR_LITERAL    : STARTCHAR CHAR ENDCHAR ;
STARTCHAR       : '\'' -> more, pushMode(CARACTER);

// Protected tokens
ALPHA_NUM   : ( ALPHA | DIGIT ) ;
ALPHA       : [A-Za-z_] ;
DIGIT       : [0-9] ;
HEX_DIGIT   : [0-9a-fA-F] ;

WS          : [\t ]+ -> skip ;

NL          : [\r]? [\n]
            {
                println();
                for(int i = 0; i<count; i++)
                    print(TAB);
            } -> skip ;

mode CARACTER;
ENDCHAR     : '\'' { print("CHAR "); } -> mode(DEFAULT_MODE) ;
CHAR        : ( ESC | VALIDCHAR ) ;
ESC         :  '\\' [ntr"'\\] ;
VALIDCHAR   : ( '\u0020'..'\u0021'
            | '\u0023'..'\u0026'
            | '\u0028'..'\u005B'
            | '\u005d'..'\u007e' )
            ;
