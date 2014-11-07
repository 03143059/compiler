PROGRAM START
BEGIN GLOBAL SECTION
Global Int a
Global Int b
Global Int[3] c
Global Int[10] d
Global Boolean e
Global Boolean[2] f
END GLOBAL SECTION
Method (name: gcd, returns: INT, params: INT a, INT b)
Evaluate boolean expression
load immediate literal 0
load b
Execute binary operation: ==
If result is true
load a
Execute command: return
If result is false
load function parameters
load b
load b
load a
Execute binary operation: %
jump to function: gcd
Execute command: return
Method (name: test, returns: BOOLEAN)
declare variable i
use variable i
load immediate literal 0
load immediate literal 2
load i
load i
Execute binary operation: *
load c
load i
store with op Equal
load immediate literal 1
Execute command: return
Method (name: test2, returns: VOID)
Execute command: return
Method (name: main, returns: INT)
declare variable x
declare variable y
declare variable z
load immediate literal 100
load a
store with op Equal
load immediate literal 20
load b
store with op Equal
load a
load x
store with op Equal
load b
load y
store with op Equal
load function parameters
load x
load y
jump to function: gcd
load z
store with op Equal
load function parameters
load string %c
load a
jump to function: printf
load function parameters
load z
jump to function: print_int
load immediate literal 0
Execute command: return
