parser grammar Lab04Parser;

options {
    tokenVocab = DecafLexer;
}

@parser::header{
  package parser;
}

start : NT_PROGRAM;

NT_PROGRAM	:	RW_CLASS ID '{' NT_FIELD_DECLS* NT_METHOD_DECLS* '}' ;

NT_FIELD_DECLS  : NT_FIELD_DECL (',' NT_FIELD_DECL)* ;

NT_FIELD_DECL	:	NT_TYPE '{' NT_ID | NT_ID '[' NT_INT_LITERAL ']' '}' ;

NT_METHOD_DECL	:	'{' NT_TYPE | RW_VOID '}' NT_ID '(' '[' '{' NT_TYPE NT_ID+ '}' ',' ']' ')' NT_BLOCK ;

NT_BLOCK	:	'{' NT_FIELD_DECL*  NT_STATEMENT* '}' ;

%NT_VAR_DECL	:	NT_TYPE NT_ID+, ;

NT_TYPE	:	RW_INT | RW_BOOLEAN ;

NT_STATEMENT	:	NT_LOCATION NT_ASSIGN_OP NT_EXPR
             | NT_METHOD_CALL
             | RW_IF ( NT_EXPR ) NT_BLOCK [RW_ELSE NT_BLOCK]
             | RW_FOR NT_ID = NT_EXPR , NT_EXPR NT_BLOCK
             | RW_RETURN [NT_EXPR]
             | RW_BREAK
             | RW_CONTINUE ;

NT_ASSIGN_OP	:	'=' | '+=' | '-=' ;

NT_METHOD_CALL	:	NT_METHOD_NAME ( [NT_EXPR+,] )
        |        NT_METHOD_NAME ( [NT_CALLOUT_ARG+,] ) ;

NT_METHOD_NAME	:	NT_ID ;

NT_LOCATION	:	NT_ID
            | NT_ID '[' NT_EXPR ']' ;

NT_EXPR	:	NT_LOCATION
        | NT_METHOD_CALL
        | NT_LITERAL
        | NT_EXPR NT_BIN_OP NT_EXPR
        | '-' NT_EXPR
        | '|' NT_EXPR
        | '(' NT_EXPR ')' ;

NT_CALLOUT_ARG	:	NT_EXPR | NT_STRING_LITERAL ;

NT_BIN_OP	:	NT_ARITH_OP | NT_REL_OP | NT_EQ_OP | NT_COND_OP ;

NT_ARITH_OP	:	'+' | '-' | '*' | '/' | '%' | '<<' | '>>' ;

NT_REL_OP	:	'<' | '>' | '<=' | '>=' ;

NT_EQ_OP  	:	'==' | '!=' ;

NT_COND_OP	:	'&&' | '||' ;

NT_LITERAL	:	NT_INT_LITERAL | NT_CHAR_LITERAL | NT_BOOL_LITERAL ;

NT_ID	:	NT_ALPHA NT_ALPHA_NUM* ;

NT_ALPHA_NUM	:	NT_ALPHA | NT_DIGIT  ;

NT_ALPHA	:	[A-Za-z_] ;

NT_DIGIT	:	[0-9] ;

NT_HEX_DIGIT	:	NT_DIGIT | [A-F] ;

NT_INT_LITERAL	:	NT_DECIMAL_LITERAL | NT_HEX_LITERAL ;

NT_DECIMAL_LITERAL	:	NT_DIGIT NT_DIGIT* ;

NT_HEX_LITERAL	:	'0' [xX] NT_HEX_DIGIT NT_HEX_DIGIT* ;

NT_BOOL_LITERAL	:	RW_TRUE | RW_FALSE ;

NT_CHAR_LITERAL	:	NT_CHAR ;

NT_STRING_LITERAL	:	NT_CHAR* ;

