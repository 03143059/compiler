##################################
# Global Declarations
##################################
	.data
var_a:	.word	1	# int a
var_b:	.word	1	# int b
var_c:	.word	0:3	# int c[3]
var_d:	.word	0:10	# int d[10]
var_e:	.word	1	# int e
var_f:	.word	0:2	# int f[2]

##################################
# End Global
##################################

	.globl	main
	.text
	j	main	# jump to main program


[METHOD]

[GCD]
Method (name: gcd, returns: INT, params: INT a, INT b)

[IF]
Binary operation: ==

[LITERAL]
load immediate literal 0

[ID]
load variable b

[RETURN]

[GROUP]

[ID]

[ID]
load variable a

[RETURN]

[GROUP]

[GCD]

[ID]

[ID]
load variable b

[BINOP]
Binary operation: %

[ID]
load variable b

[ID]
load variable a

[METHOD]

[TEST]
Method (name: test, returns: BOOLEAN)

[INT]

[TERMINAL]

[VAR]
declare variable i

[FOR]
use variable i

[LITERAL]
load immediate literal 0

[LITERAL]
load immediate literal 2

[STORE]
store BinOP on c with op Equal

[ID]

[ID]
load variable i
Binary operation: *

[ID]
load variable i

[ID]
load variable i

[RETURN]

[LITERAL]

[LITERAL]
load immediate literal 1

[METHOD]

[TEST2]
Method (name: test2, returns: VOID)

[RETURN]

[METHOD]

[MAIN]
Method (name: main, returns: INT)

[INT]

[TERMINAL]

[VAR]
declare variable x

[TERMINAL]

[VAR]
declare variable y

[TERMINAL]

[VAR]
declare variable z

[STORE]
store literal on id with op Equal

[ID]
load variable a

[LITERAL]
load immediate literal 100

[STORE]
store literal on id with op Equal

[ID]
load variable b

[LITERAL]
load immediate literal 20

[STORE]
store id on id with op Equal

[ID]
load variable x

[ID]
load variable a

[STORE]
store id on id with op Equal

[ID]
load variable y

[ID]
load variable b

[STORE]
store gcd on id with op Equal

[ID]
load variable z

[ID]

[ID]
load variable x

[ID]

[ID]
load variable y

[PRINTF]

[CALLOUT ARG]

[STRING]
load string %c

[CALLOUT ARG]

[ID]

[ID]
load variable a

[PRINT_INT]

[CALLOUT ARG]

[ID]

[ID]
load variable z

[RETURN]

[LITERAL]

[LITERAL]
load immediate literal 0
