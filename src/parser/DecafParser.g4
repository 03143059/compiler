parser grammar DecafParser;

options {
    tokenVocab = DecafLexer;
}

@parser::header{
  package parser;
  import scanner.*;
}


start           : program
                ;

program	        : CLASS ID LCURLY ( field_decls )* ( method_decls )? RCURLY
                ;

field_decls     : type field_decl ( COMMA field_decl )* SEMI
                ;

field_decl	    : ( ID | ID LSQUARE INT_LITERAL RSQUARE )
                ;

method_decls    : method_decl ( COMMA method_decl )*
                ;

method_decl	    : ( type | VOID ) ID LPAREN ( method_params )? RPAREN block
                ;

method_params   : method_param ( COMMA method_param )*
                ;

method_param    : type ID
                ;

block	        : LCURLY ( var_decl )* ( statement )* RCURLY
                ;

var_decl	    : type ID (COMMA ID)* SEMI
                ;

type            : INT
                | BOOLEAN
                ;

statement	    : location assign_op expr SEMI
                | method_call SEMI
                | IF LPAREN expr RPAREN block ( ELSE block )?
                | FOR ID ASSIGNEQ expr COMMA expr block
                | RETURN ( expr )? SEMI
                | BREAK SEMI
                | CONTINUE SEMI
                | block
                ;

assign_op	    : ASSIGNEQ
                | ASSIGNPLUSEQ
                | ASSIGNMINUSEQ
                ;

method_call	    : method_name LPAREN ( exprs )? RPAREN
                | CALLOUT LPAREN STRING_LITERAL ( callout_args )? RPAREN
                ;

method_name	    : ID
                ;

location	    : ID
                | ID LSQUARE expr RSQUARE
                ;

exprs           : expr ( COMMA expr )*
                ;

expr	        : location
                | method_call
                | literal
                | expr bin_op expr
                | MINUS expr
                | NOT expr
                | LPAREN expr RPAREN
                ;

callout_args    : callout_arg ( COMMA callout_arg )*
                ;

callout_arg	    : expr
                | STRING_LITERAL
                ;

bin_op	        : arith_op
                | rel_op
                | eq_op
                | cond_op
                ;

arith_op	    : PLUS
                | MINUS
                | MUL
                | DIV
                | MOD
                ;

rel_op	        : LESS
                | MORE
                | LEQ
                | GEQ
                ;

eq_op  	        : CEQ
                | NEQ
                ;

cond_op	        : AND
                | OR
                ;

literal	        : INT_LITERAL
                | CHAR_LITERAL
                | BOOL_LITERAL
                ;