parser grammar DecafParser;

options {
    tokenVocab = DecafLexer;
}

@parser::header{
  package parser;
  import scanner.*;
}

start	        : CLASS PROGRAM LCURLY ( field_decls )*? ( method_decl )*? RCURLY
                ;

field_decls     : type field_decl ( COMMA field_decl )*? SEMI
                ;

field_decl	    : ID                                # singleid
                | ID LSQUARE INT_LITERAL RSQUARE    # array
                | bad_field_decl                    # errordecl
                ;

bad_field_decl  : location assign_op expr { notifyErrorListeners("invalid assignment '='"); };

method_decl	    : ( type | VOID ) ID LPAREN ( method_param ( COMMA method_param )*? )? RPAREN block
                ;

method_param    : type ID
                ;

block	        : LCURLY ( var_decl )*? ( statement )* RCURLY
                ;

var_decl	    : type ID (COMMA ID)*? SEMI
                ;

type            : INT
                | BOOLEAN
                ;

statement	    : location assign_op expr SEMI                          #locstmt
                | method_call SEMI                                      #metstmt
                | IF LPAREN expr RPAREN ifs=block ( ELSE els=block )?   #ifstmt
                | FOR ID ASSIGNEQ init=expr COMMA cond=expr block       #forstmt
                | RETURN ( expr )? SEMI                                 #retstmt
                | BREAK SEMI                                            #brkstmt
                | CONTINUE SEMI                                         #cntstmt
                | block                                                 #blkstmt
                ;

assign_op	    : ASSIGNEQ
                | ASSIGNPLUSEQ
                | ASSIGNMINUSEQ
                ;

method_call	    : method_name LPAREN ( expr ( COMMA expr )*? )? RPAREN          #metcall
                | CALLOUT LPAREN STRING_LITERAL ( COMMA callout_arg )*? RPAREN  #callout
                ;

callout_arg	    : expr
                | STRING_LITERAL
                ;

method_name	    : ID
                ;

location	    : ID                        #locid
                | ID LSQUARE expr RSQUARE   #locarray
                ;

/*
   precedence:
   -
   !
   * / %
   + -
   < <= >= >
   == !=
   &&
   ||
*/

expr	        : location      #locexpr
                | method_call   #metexpr
                | literal       #litexpr
                | MINUS expr    #minexpr
                | NOT expr      #notexpr
                | left=expr op=(MUL|DIV|MOD|PLUS|MINUS) right=expr  #aritexpr
                | left=expr op=(LESS|LEQ|GEQ|MORE) right=expr       #relexpr
                | left=expr op=(CEQ| NEQ) right=expr                #eqexpr
                | left=expr op=(AND| OR) right=expr                 #condexpr
                | LPAREN expr RPAREN    #parenexpr
                ;

literal	        : INT_LITERAL
                | CHAR_LITERAL
                | BOOL_LITERAL
                ;
