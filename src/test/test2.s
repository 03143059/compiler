##################################
# Global Declarations
##################################
	.data
var_A:	.word	0:100	# int A[100]
var_length:	.word	1	# int length
var_r:	.word	1	# int r
##################################
# End Global
##################################

	.globl	main
	.text
	j	main	# jump to main program
##################################
# Function: partition
# Params: INT p, INT r, INT s
# Returns: VOID
################################## 
test2:
	.data
	.text
	addi	$sp, $sp, -4		# reserve stack
	sw	$ra, 0($sp)
	# SI NO HAY INSTRUCCIONES ESTO SE PUEDE REMOVERvar_a:	.word	1	# int a

	lw	$ra, 0($sp)
	addi	$sp, $sp, 4		# restore stack
	jr	$ra		# return
################################## 
# End Function partition
################################## 

##################################
# Function: partition
# Params: INT p, INT r
# Returns: INT
################################## 
test2:
	.data
	.text
	addi	$sp, $sp, -4		# reserve stack
	sw	$ra, 0($sp)
	# SI NO HAY INSTRUCCIONES ESTO SE PUEDE REMOVERvar_x:	.word	1	# int x
var_i:	.word	1	# int i
var_j:	.word	1	# int j
var_t:	.word	1	# int t
var_z:	.word	1	# int z
var_a:	.word	1	# int a
sw  $a, $b($c)sw  $a, $b($c)sw  $a, $b($c)	li	$t0, 0		# t = 0
test_for1:
	bgt	$t0, 2, test_next1
	sw	$t0, var_i	# i = t
	
	mul	$t1, $t0, $t0	# t = i*i
	
	lw	$t2, var_i	# load i, se usa t2 porque t0 y t1 ya estan utilizados
	
	sw	$t1, var_c($t2)	# c[i] = t
	
	addi	$t0, $t0, 1		# i++
	j	test_for1
test_next1:
COMMAND  $a, $b, $c
	lw	$ra, 0($sp)
	addi	$sp, $sp, 4		# restore stack
	jr	$ra		# return
################################## 
# End Function partition
################################## 

##################################
# Function: quicksort
# Params: INT p, INT r
# Returns: VOID
################################## 
test2:
	.data
	.text
	addi	$sp, $sp, -4		# reserve stack
	sw	$ra, 0($sp)
	# SI NO HAY INSTRUCCIONES ESTO SE PUEDE REMOVERvar_q:	.word	1	# int q
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

	lw	$ra, 0($sp)
	addi	$sp, $sp, 4		# restore stack
	jr	$ra		# return
################################## 
# End Function quicksort
################################## 

##################################
# Function: main
# Params: 
# Returns: VOID
################################## 
test2:
	.data
	.text
	addi	$sp, $sp, -4		# reserve stack
	sw	$ra, 0($sp)
	# SI NO HAY INSTRUCCIONES ESTO SE PUEDE REMOVERvar_temp:	.word	1	# int temp
var_i:	.word	1	# int i
sw  $a, $b($c)j printfj srandom	li	$t0, 0		# t = 0
test_for1:
	bgt	$t0, 2, test_next1
	sw	$t0, var_i	# i = t
	
	mul	$t1, $t0, $t0	# t = i*i
	
	lw	$t2, var_i	# load i, se usa t2 porque t0 y t1 ya estan utilizados
	
	sw	$t1, var_c($t2)	# c[i] = t
	
	addi	$t0, $t0, 1		# i++
	j	test_for1
test_next1:
j printf	li	$t0, 0		# t = 0
test_for1:
	bgt	$t0, 2, test_next1
	sw	$t0, var_i	# i = t
	
	mul	$t1, $t0, $t0	# t = i*i
	
	lw	$t2, var_i	# load i, se usa t2 porque t0 y t1 ya estan utilizados
	
	sw	$t1, var_c($t2)	# c[i] = t
	
	addi	$t0, $t0, 1		# i++
	j	test_for1
test_next1:
j quicksortj printf	li	$t0, 0		# t = 0
test_for1:
	bgt	$t0, 2, test_next1
	sw	$t0, var_i	# i = t
	
	mul	$t1, $t0, $t0	# t = i*i
	
	lw	$t2, var_i	# load i, se usa t2 porque t0 y t1 ya estan utilizados
	
	sw	$t1, var_c($t2)	# c[i] = t
	
	addi	$t0, $t0, 1		# i++
	j	test_for1
test_next1:

	lw	$ra, 0($sp)
	addi	$sp, $sp, 4		# restore stack
	jr	$ra		# return
################################## 
# End Function main
################################## 


