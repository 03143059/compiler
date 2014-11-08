##################################
# Global Declarations
# Variables: Int a, Int b, Int c[3], Int d[10], Boolean e, Boolean f[2]
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
##################################
# Function: gcd
# Params: INT a, INT b
# Returns: INT
##################################
gcd:
	.data
	.text
	addi	$sp, $sp, -12
	sw	$ra, 0($sp)	# reserve stack
	sw	$a0, 4($sp)
	sw	$a1, 8($sp)
# if stmt
	beqz	$a1, gcd_lbl2	# lleva un lc (label count) por metodo, brinca al lc+2 (true block)
	
gcd_lbl1: # false block

	lw	$t0, 8($sp)	# load param t0 = b
	
	lw	$t1, 4($sp)	# load param t1 = a
	
	div	$t1, $t0	# div a/b y recuperar residuo
	mfhi	$t2		# t2 = a%b
	
	move	$a0, $t0	# param1 = t0
	move	$a1, $t2	# param2 = t2
	jal	gcd		# gcd(t0, t2)	
	move	$t0, $v0	# guardar valor de retorno
	
	move	$v0, $t0	# return stmt
	j	gcd_end	
	
	j	gcd_lbl3	# salir del if
	
gcd_lbl2: # true block
	move	$t0, $a0	# return statement, copy value to return
	
	move	$v0, $t0	# return stmt
	j	gcd_end
	
gcd_lbl3: # end if
gcd_end:
	lw	$ra, 0($sp)	# restore stack
	addi	$sp, $sp, 12
	jr	$ra	# return
##################################
# End Function gcd
##################################

##################################
# Function: test
# Params: 
# Returns: BOOLEAN
##################################
test:
	.data
	.text
	addi	$sp, $sp, -4
	sw	$ra, 0($sp)	# reserve stack
var_i:	.word	1	# int i
	li	$t0, 0		# t = 0
test_for1:
	bgt	$t0, 2, test_next1
	sw	$t0, var_i	# i = t
	
	mul	$t1, $t0, $t0	# t = i*i
	
	lw	$t2, var_i	# load i, se usa t2 porque t0 y t1 ya estan utilizados
	
	sw	$t1, var_c($t2)	# c[i] = t
	
	addi	$t0, $t0, 1		# i++
	j	test_for1
test_next1:
	return	$a, $b, $c
test_end:
	lw	$ra, 0($sp)	# restore stack
	addi	$sp, $sp, 4
	jr	$ra	# return
##################################
# End Function test
##################################

##################################
# Function: test2
# Params: 
# Returns: VOID
##################################
test2:
	.data
	.text
	addi	$sp, $sp, -4
	sw	$ra, 0($sp)	# reserve stack
	return	$a, $b, $c
test2_end:
	lw	$ra, 0($sp)	# restore stack
	addi	$sp, $sp, 4
	jr	$ra	# return
##################################
# End Function test2
##################################

##################################
# Function: main
# Params: 
# Returns: INT
##################################
main:
	.data
	.text
	addi	$sp, $sp, -4
	sw	$ra, 0($sp)	# reserve stack
var_x:	.word	1	# int x
var_y:	.word	1	# int y
var_z:	.word	1	# int z
	sw	$a, $b($c)
	sw	$a, $b($c)
	sw	$a, $b($c)
	sw	$a, $b($c)
	sw	$a, $b($c)
	j	printf
	j	print_int
	return	$a, $b, $c
main_end:
	lw	$ra, 0($sp)	# restore stack
	addi	$sp, $sp, 4
	jr	$ra	# return
##################################
# End Function main
##################################


