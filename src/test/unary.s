PROGRAM START
BEGIN GLOBAL SECTION
END GLOBAL SECTION
Method (functionName: main, returns: VOID)
declare variable a
declare variable b
load immediate literal 10
Unary operation: -
load a
store with op Equal
load immediate literal 0
Unary operation: !
load b
store with op Equal
use variable a
load immediate literal 1
load immediate literal 3
Evaluate boolean expression
load immediate literal 2
load a
Execute binary operation: ==
If result is true
Execute command: break
If result is false
load immediate literal 1
load b
store with op Equal
Execute command: continue
