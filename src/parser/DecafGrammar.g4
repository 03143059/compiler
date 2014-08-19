NT_program	:	RW_class ID("Program") '{' NT_field_decl* NT_method_decl* '}'

NT_field_decl	:	NT_type '{' NT_id | NT_id '[' NT_int_literal ']' }+, ;

NT_method_decl	:	{NT_type | RW_void} NT_id ( [{NT_type NT_id+},] ) NT_block

NT_block	:	'\{' NT_field_decl*  NT_statement* '\}'

%NT_var_decl	:	NT_type NT_id+, ;

NT_type	:	RW_int | RW_boolean

NT_statement	:	NT_location NT_assign_op NT_expr ;
             | NT_method_call ;
             | RW_if ( NT_expr ) NT_block [RW_else NT_block]
             | RW_for NT_id = NT_expr , NT_expr NT_block
             | RW_return [NT_expr] ;
             | RW_break ;
             | RW_continue ;

NT_assign_op	:	=
             | +=
	     | -=

NT_method_call	:	NT_method_name ( [NT_expr+,] )
        |        NT_method_name ( [NT_callout_arg+,] )

NT_method_name	:	NT_id

NT_location	:	NT_id
            | NT_id '\[' NT_expr '\']

NT_expr	:	NT_location
        | NT_method_call
        | NT_literal
        | NT_expr NT_bin_op NT_expr
        | - NT_expr
        | | NT_expr
        | ( NT_expr )

NT_callout_arg	:	NT_expr | NT_string_literal

NT_bin_op	:	NT_arith_op | NT_rel_op | NT_eq_op | NT_cond_op

NT_arith_op	:	+ | - | * | / | \% % | << | >>

NT_rel_op	:	< | > | <= | >=

NT_eq_op  	:	== | !=

NT_cond_op	:	\&\& | ||

NT_literal	:	NT_int_literal | NT_char_literal | NT_bool_literal

NT_id	:	NT_alpha NT_alpha_num*

NT_alpha_num	:	NT_alpha | NT_digit

NT_alpha	:	a | b | \ldots{} | z | A | B | \ldots{} | Z | \_

NT_digit	:	0 | 1 | 2 | \ldots | 9

NT_hex_digit	:	NT_digit | a | b | c | d | e | f | A | B | C | D | E | F

NT_int_literal	:	NT_decimal_literal | NT_hex_literal

NT_decimal_literal	:	NT_digit NT_digit*

NT_hex_literal	:	0x NT_hex_digit NT_hex_digit*

NT_bool_literal	:	RW_true | RW_false

NT_char_literal	:	' NT_char '

NT_string_literal	:	" NT_char* "
