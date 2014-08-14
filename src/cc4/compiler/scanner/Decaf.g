lexer grammar DecafLexer;

@header {package scanner;}

options 
{
  mangleLiteralPrefix = "TK_";
  language="Java";
}

class DecafLexer extends Lexer;
options 
{
  k=2;
}

// keyword tokens
tokens 
{
  class,
  if,
  else,
  for,
  return,
  break,
  continue,
  callout,
  true,
  false,
  int,
  boolean,
  void
}

LCURLY options { paraphrase = "{"; } : "{";
RCURLY options { paraphrase = "}"; } : "}";
LPAREN options { paraphrase = "("; } : "(";
RPAREN options { paraphrase = ")"; } : ")";
LSQUARE options { paraphrase = "["; } : "[";
RSQUARE options { paraphrase = "]"; } : "]";

WS_ options { paraphrase = "espacio"; } : (' ' | '\t' | '\n' {newline();}) {_ttype = Token.SKIP; };

SL_COMMENT options { paraphrase = "comentario"; } : "//" (~'\n')* '\n' {_ttype = Token.SKIP; newline (); };

STRING options { paraphrase = "literal cadena"; } : '"' (ESC | VALIDCHARS)* '"';
CHAR options { paraphrase = "literal caracter"; } : '\'' (ESC | VALIDCHARS) '\'';
COMMA options { paraphrase = "coma"; } : ',' ;
SEMI options { paraphrase = "punto y coma"; } : ';' ;

// Operadores aritmeticos
PLUS options { paraphrase = "sgno mas"; } : "+" ;
MINUS options { paraphrase = "sgno menos"; } : "-";
MULDIV options { paraphrase = "operacion multiplicacion o division"; } : "*" | "/" ;
MOD options { paraphrase = "operacion modulo"; } : "%" ;

// operadores de asignacion
ASSIGNPLUSEQ : "+=" ;
ASSIGNMINUSEQ : "-=" ;
ASSIGNEQ : '=' ;

// Operadores relacionales
LESS : "<" ;
MORE : ">" ;
LEQ : "<=" ; 
GEQ : ">=" ;
CEQ : "==" ;
NEQ : "!=" ;
AND : "&&" ;
OR : "||" ;
NOT : "!" ;

// Entificadores y literales
ID options { paraphrase = "identificador"; } : (ALPHA)(ALPHA_NUM)* ;
INTLIT options { paraphrase = "literal entero"; } : DECIMAL | HEX ;

// Tokens protegidos
protected ESC :  '\\' ('n'|'"'|'t'|'r'|'\''|'\\') ;
protected VALIDCHARS : ('\u0020'..'\u0021' | '\u0023'..'\u0026' | '\u0028'..'\u005B' | '\u005d'..'\u007e') ;
protected ALPHA : 'a'..'z' | 'A'..'Z' | '_' ;
protected DIGIT : '0'..'9' ;
protected HEX_DIGIT : DIGIT | 'a'..'f' | 'A'..'F' ;
protected ALPHA_NUM : ALPHA | DIGIT ;
protected DECIMAL : (DIGIT)+ ;
protected HEX : "0x"(HEX_DIGIT)+ ;
