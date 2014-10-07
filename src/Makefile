make: scanner\DecafLexer.class parser\DecafParser.class Compiler.class ast\Ast.class codegen\Codegen.class irt\Irt.class lib\Debug.class lib\ErrorHandler.class lib\CompilerOptions.class lib\SymbolTable.class lib\CliManager\CommandLine.class lib\CliManager\CommandLineParser.class lib\CliManager\HelpFormatter.class lib\CliManager\Option.class lib\CliManager\Options.class opt\Algebraic.class opt\ConstantFolding.class parser\CC4Parser.class scanner\Scanner.class semantic\Semantic.class

Compiler.class: Compiler.java
	javac Compiler.java

ast\Ast.class: ast\Ast.java ast\AstVisitor.java ast\Node.java ast\NodeList.java ast\BinOp.java ast\BlockNode.java ast\BoolLiteral.java ast\CalloutNode.java ast\CharLiteral.java ast\FieldNode.java ast\IntFieldNode.java ast\BooleanFieldNode.java ast\ForNode.java ast\IfNode.java ast\IntLiteral.java ast\LocArrayNode.java ast\LocationNode.java ast\MethodCallNode.java ast\MethodNode.java ast\BooleanMethodNode.java ast\IntMethodNode.java ast\VoidMethodNode.java ast\MethodParamNode.java ast\BooleanMethodParamNode.java ast\IntMethodParamNode.java ast\ParenNode.java ast\PrefixNode.java ast\ProgramNode.java ast\StringLiteral.java ast\VarNode.java ast\IntVarNode.java ast\BooleanVarNode.java
	javac ast\*.java

codegen\Codegen.class: codegen\Codegen.java
	javac codegen\Codegen.java

irt\Irt.class: irt\Irt.java
	javac irt\Irt.java

lib\Debug.class: lib\Debug.java
	javac lib\Debug.java

lib\SymbolTable.class: lib\SymbolTable.java lib\Symbol.java
	javac lib\Symbol*.java

lib\ErrorHandler.class: lib\ErrorHandler.java
	javac lib\ErrorHandler.java

lib\CompilerOptions.class: lib\CompilerOptions.java
	javac lib\CompilerOptions.java

lib\CliManager\CommandLine.class: lib\CliManager\CommandLine.java
	javac lib\CliManager\CommandLine.java

lib\CliManager\CommandLineParser.class: lib\CliManager\CommandLineParser.java
	javac lib\CliManager\CommandLineParser.java

lib\CliManager\HelpFormatter.class: lib\CliManager\HelpFormatter.java
	javac lib\CliManager\HelpFormatter.java

lib\CliManager\Option.class: lib\CliManager\Option.java
	javac lib\CliManager\Option.java

lib\CliManager\Options.class: lib\CliManager\Options.java
	javac lib\CliManager\Options.java

opt\Algebraic.class: opt\Algebraic.java
	javac opt\Algebraic.java

opt\ConstantFolding.class: opt\ConstantFolding.java
	javac opt\ConstantFolding.java

parser\CC4Parser.class: parser\CC4Parser.java parser\MyErrorStrategy.java
	javac parser\CC4Parser.java parser\MyErrorStrategy.java

scanner\Scanner.class: scanner\Scanner.java scanner\DescriptiveErrorListener.java
	javac scanner\Scanner.java scanner\DescriptiveErrorListener.java
	
semantic\Semantic.class: semantic\Semantic.java semantic\SemNode.java semantic\SemNodeList.java semantic\SemCheckVisitor.java
	javac semantic\*.java

scanner\DecafLexer.class: scanner\DecafLexer.java
	javac scanner\DecafLexer.java

scanner\DecafLexer.java: scanner\DecafLexer.g4
	java org.antlr.v4.Tool scanner\DecafLexer.g4

parser\DecafParser.class: parser\DecafParser.java
	javac parser\DecafParser*.java

parser\DecafParser.java: parser\DecafParser.g4 scanner\DecafLexer.tokens
	java org.antlr.v4.Tool -visitor -lib .\scanner parser\DecafParser.g4

clean:
    @del /q /s *.class  2>nul
	@del /q /s scanner\DecafLexer.java scanner\*.tokens 2>nul
	@del /q /s parser\DecafParser*.java parser\*.tokens 2>nul
