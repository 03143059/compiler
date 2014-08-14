lexer grammar DecafLexer;

@header
{
	package scanner;
	import java.util.LinkedList;
}

mode STR;

WS  : [ \t\r\n\f]+  -> skip;

// palabras reservadas
CLASS:				'class' ;
PROGRAM:			'Program' ;
VOID:				'void' ;
IF:					'if' ;
ELSE:				'else' ;
FOR:				'for' ;
RETURN:				'return' ;
BREAK:				'break' ;
CONTINUE:			'continue';
CALLOUT:			'callout';

//Indentificadores
INT:				'int' ;
BOOLEAN:			'boolean' ;

//Numeros y letras
FLOTANTES
    :   (('0'..'9')+ '.' ('0'..'9')+)
    ;

//Literales
ESC :   '\\'    ( 'b'
                | 't'
                | 'n'
                | 'f'
                | 'r'
                | '\"'
                | '\''
                | '\\')
    ;

ERR1_LITERAL_CHAR:	('\'' ('\'')+ '\'') ;
ERR2_LITERAL_CHAR:	('\'' ('"')+ '\'') ;
ERR3_LITERAL_CHAR:	('\'' ('\n' | '\r')+) ;
ERR4_LITERAL_CHAR:	('\'' ('\n' | '\r')+ '\'') ;
ERR5_LITERAL_CHAR:	('\'' '\\' ~('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') '\'') ;

/*LITERAL_CHAR: POSIBLE ERROR CUANDO 2 o MAS CARACTERES*/
LITERAL_CHAR:		('\'' (ESC | ~('\"'|'\\')) '\'') ;
/*LITERAL_STRING: POSIBLE ERROR CUANDO 2 o MAS CARACTERES*/
LITERAL_STRING:		('"' (ESC | ~('\"'|'\\'))* '"') ;
LITERAL_BOOL:		('true' | 'false') ;

ERROR_LITERAL_HEXA:	(('0x' | '0X')('0'..'9'|'A'..'F'|'a'..'f')+);
LITERAL_HEXA:		(('0x' | '0X') ~('0'..'9'|'A'..'F'|'a'..'f')+) ;
LITERAL_ENTEROS:	('0'..'9')+ ;

//Variables
VARIABLES:			('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

//Simbolos
COMILLAS:	 	    '\"' ;
COMILLA:			'\'' ;
COMA:				',' ;
PUNTOYCOMA:			';' ;
PUNTO:				'.' ;
COLON:		   		':' ;

LPARENTESIS:		'(' ;
RPARENTESIS:		')' ;
LSQUIGLY:	   		'{' ;
RSQUIGLY:	   		'}' ;
LBRACKET:	   		'[' ;
RBRACKET:	  		']' ;

SUMA:				'+' ;
RESTA:				'-' ;
MULTIPLICACION:		'*' ;
DIVISION:			'/' ;
REMAINDER: 			'%' ;
EQUAL:				'=' ;
PLUS_EQUAL:			'+=' ;
MINUS_EQUAL:		'-=' ;

EQUAL_EQUAL:		'==' ;
NOT_EQUAL:			'!=' ;

COND_AND:			'&&' ;
COND_OR:			'||' ;
COND_XOR:		 	'^' ;
CONDNOT:			'!' ;

REL_MENOR
    :   ('<')
    ;
REL_MAYOR
    :   ('>')
    ;
REL_MENOREQ
    :   ('<=')
    ;
REL_MAYOREQ
    :   ('>=')
    ;

COMMENT
    :   ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> skip
    ;
