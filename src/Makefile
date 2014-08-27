make: scanner\DecafLexer.class parser\DecafParser.class Compiler.class ast\Ast.class codegen\Codegen.class irt\Irt.class lib\Debug.class lib\ErrorHandler.class lib\CompilerOptions.class lib\CliManager\CommandLine.class lib\CliManager\CommandLineParser.class lib\CliManager\HelpFormatter.class lib\CliManager\Option.class lib\CliManager\Options.class opt\Algebraic.class opt\ConstantFolding.class parser\CC4Parser.class scanner\Scanner.class semantic\Semantic.class

Compiler.class: Compiler.java
	javac Compiler.java

ast\Ast.class: ast\Ast.java
	javac ast\Ast.java

codegen\Codegen.class: codegen\Codegen.java
	javac codegen\Codegen.java

irt\Irt.class: irt\Irt.java
	javac irt\Irt.java

lib\Debug.class: lib\Debug.java
	javac lib\Debug.java

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

parser\CC4Parser.class: parser\CC4Parser.java
	javac parser\CC4Parser.java

scanner\Scanner.class: scanner\Scanner.java
	javac scanner\Scanner.java
	
semantic\Semantic.class: semantic\Semantic.java
	javac semantic\Semantic.java

scanner\DecafLexer.class: scanner\DecafLexer.java
	javac scanner\DecafLexer.java

scanner\DecafLexer.java: scanner\DecafLexer.g4
	java org.antlr.v4.Tool scanner\DecafLexer.g4

parser\DecafParser.class: parser\DecafParser.java
	javac parser\DecafParser.java

parser\DecafParser.java: parser\DecafParser.g4 scanner\DecafLexer.tokens
	java org.antlr.v4.Tool -lib .\scanner parser\DecafParser.g4

clean:
    @del /q /s *.class  2>nul
	@del /q /s scanner\DecafLexer.java scanner\*.tokens 2>nul
	@del /q /s parser\DecafParser*.java parser\*.tokens 2>nul

