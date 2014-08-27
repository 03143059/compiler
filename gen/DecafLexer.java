// Generated from C:/Dev/_CC4/cc4/compiler/src/scanner\DecafLexer.g4 by ANTLR 4.4.1-dev

    package scanner;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RESERVED=1, CLASS=2, IF=3, ELSE=4, FOR=5, RETURN=6, BREAK=7, CONTINUE=8, 
		CALLOUT=9, TRUE=10, FALSE=11, INT=12, BOOLEAN=13, VOID=14, LCURLY=15, 
		RCURLY=16, LPAREN=17, RPAREN=18, LSQUARE=19, RSQUARE=20, SL_COMMENT=21, 
		COMMA=22, SEMI=23, PLUS=24, MINUS=25, MUL=26, DIV=27, MOD=28, ASSIGNPLUSEQ=29, 
		ASSIGNMINUSEQ=30, ASSIGNEQ=31, LESS=32, MORE=33, LEQ=34, GEQ=35, CEQ=36, 
		NEQ=37, AND=38, OR=39, NOT=40, ID=41, ALPHA_NUM=42, ALPHA=43, DIGIT=44, 
		HEX_DIGIT=45, INT_LITERAL=46, DECIMAL_LITERAL=47, HEX_LITERAL=48, BOOL_LITERAL=49, 
		CHAR_LITERAL=50, STRING_LITERAL=51, CHAR=52, ESC=53, VALIDCHAR=54, WS=55;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'"
	};
	public static final String[] ruleNames = {
		"RESERVED", "CLASS", "IF", "ELSE", "FOR", "RETURN", "BREAK", "CONTINUE", 
		"CALLOUT", "TRUE", "FALSE", "INT", "BOOLEAN", "VOID", "LCURLY", "RCURLY", 
		"LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "SL_COMMENT", "COMMA", "SEMI", 
		"PLUS", "MINUS", "MUL", "DIV", "MOD", "ASSIGNPLUSEQ", "ASSIGNMINUSEQ", 
		"ASSIGNEQ", "LESS", "MORE", "LEQ", "GEQ", "CEQ", "NEQ", "AND", "OR", "NOT", 
		"ID", "ALPHA_NUM", "ALPHA", "DIGIT", "HEX_DIGIT", "INT_LITERAL", "DECIMAL_LITERAL", 
		"HEX_LITERAL", "BOOL_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "CHAR", 
		"ESC", "VALIDCHAR", "WS"
	};


	public DecafLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DecafLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: RESERVED_action((RuleContext)_localctx, actionIndex); break;
		case 14: LCURLY_action((RuleContext)_localctx, actionIndex); break;
		case 15: RCURLY_action((RuleContext)_localctx, actionIndex); break;
		case 16: LPAREN_action((RuleContext)_localctx, actionIndex); break;
		case 17: RPAREN_action((RuleContext)_localctx, actionIndex); break;
		case 18: LSQUARE_action((RuleContext)_localctx, actionIndex); break;
		case 19: RSQUARE_action((RuleContext)_localctx, actionIndex); break;
		case 20: SL_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		case 21: COMMA_action((RuleContext)_localctx, actionIndex); break;
		case 22: SEMI_action((RuleContext)_localctx, actionIndex); break;
		case 23: PLUS_action((RuleContext)_localctx, actionIndex); break;
		case 24: MINUS_action((RuleContext)_localctx, actionIndex); break;
		case 25: MUL_action((RuleContext)_localctx, actionIndex); break;
		case 26: DIV_action((RuleContext)_localctx, actionIndex); break;
		case 27: MOD_action((RuleContext)_localctx, actionIndex); break;
		case 28: ASSIGNPLUSEQ_action((RuleContext)_localctx, actionIndex); break;
		case 29: ASSIGNMINUSEQ_action((RuleContext)_localctx, actionIndex); break;
		case 30: ASSIGNEQ_action((RuleContext)_localctx, actionIndex); break;
		case 31: LESS_action((RuleContext)_localctx, actionIndex); break;
		case 32: MORE_action((RuleContext)_localctx, actionIndex); break;
		case 33: LEQ_action((RuleContext)_localctx, actionIndex); break;
		case 34: GEQ_action((RuleContext)_localctx, actionIndex); break;
		case 35: CEQ_action((RuleContext)_localctx, actionIndex); break;
		case 36: NEQ_action((RuleContext)_localctx, actionIndex); break;
		case 37: AND_action((RuleContext)_localctx, actionIndex); break;
		case 38: OR_action((RuleContext)_localctx, actionIndex); break;
		case 39: NOT_action((RuleContext)_localctx, actionIndex); break;
		case 40: ID_action((RuleContext)_localctx, actionIndex); break;
		case 45: INT_LITERAL_action((RuleContext)_localctx, actionIndex); break;
		case 49: CHAR_LITERAL_action((RuleContext)_localctx, actionIndex); break;
		case 50: STRING_LITERAL_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void INT_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 28:  System.out.println("integer literal");  break;
		}
	}
	private void LSQUARE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:  System.out.println("[");  break;
		}
	}
	private void MOD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14:  System.out.println("modulus operation");  break;
		}
	}
	private void LCURLY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  System.out.println("{");  break;
		}
	}
	private void NOT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 26:  System.out.println("!");  break;
		}
	}
	private void MINUS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:  System.out.println("minus sign");  break;
		}
	}
	private void RSQUARE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:  System.out.println("]");  break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 27:  System.out.println("identifier");  break;
		}
	}
	private void AND_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 24:  System.out.println("&&");  break;
		}
	}
	private void SEMI_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:  System.out.println("semicolon");  break;
		}
	}
	private void MUL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:  System.out.println("mul operation");  break;
		}
	}
	private void LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:  System.out.println("(");  break;
		}
	}
	private void ASSIGNMINUSEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16:  System.out.println("-=");  break;
		}
	}
	private void RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:  System.out.println(")");  break;
		}
	}
	private void STRING_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 30:  System.out.println("string literal");  break;
		}
	}
	private void NEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 23:  System.out.println("!=");  break;
		}
	}
	private void RESERVED_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: 
		                    System.out.println("reserved word " + getText().toUpperCase());
		                  break;
		}
	}
	private void CHAR_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 29:  System.out.println("char literal");  break;
		}
	}
	private void MORE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19:  System.out.println(">");  break;
		}
	}
	private void COMMA_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:  System.out.println("comma");  break;
		}
	}
	private void OR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 25:  System.out.println("||");  break;
		}
	}
	private void SL_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:  System.out.println("comment");  break;
		}
	}
	private void RCURLY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:  System.out.println("}");  break;
		}
	}
	private void LESS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18:  System.out.println("<");  break;
		}
	}
	private void ASSIGNPLUSEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15:  System.out.println("+=");  break;
		}
	}
	private void PLUS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:  System.out.println("plus sign");  break;
		}
	}
	private void CEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 22:  System.out.println("==");  break;
		}
	}
	private void GEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 21:  System.out.println(">=");  break;
		}
	}
	private void DIV_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:  System.out.println("div operation");  break;
		}
	}
	private void ASSIGNEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17:  System.out.println("=");  break;
		}
	}
	private void LEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 20:  System.out.println("<=");  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\29\u0182\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2\177\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u00e5\n\26"+
		"\f\26\16\26\u00e8\13\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 "+
		"\3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%"+
		"\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3*\3*\7*\u013a"+
		"\n*\f*\16*\u013d\13*\3*\3*\3+\3+\5+\u0143\n+\3,\3,\3-\3-\3.\3.\5.\u014b"+
		"\n.\3/\3/\3/\3/\5/\u0151\n/\3\60\6\60\u0154\n\60\r\60\16\60\u0155\3\61"+
		"\3\61\3\61\3\61\6\61\u015c\n\61\r\61\16\61\u015d\3\62\3\62\5\62\u0162"+
		"\n\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\7\64\u016b\n\64\f\64\16\64\u016e"+
		"\13\64\3\64\3\64\3\64\3\65\3\65\5\65\u0175\n\65\3\66\3\66\3\66\3\67\3"+
		"\67\38\68\u017d\n8\r8\168\u017e\38\38\2\29\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9\3\2\t\3\2\f\f\5\2C\\aac|"+
		"\3\2\62;\4\2CHch\b\2$$))^^ppttvv\6\2\"#%(*]_\u0080\5\2\13\f\17\17\"\""+
		"\u0198\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\3~\3\2\2\2\5\u0082\3\2\2\2\7\u0088\3\2\2\2\t\u008b"+
		"\3\2\2\2\13\u0090\3\2\2\2\r\u0094\3\2\2\2\17\u009b\3\2\2\2\21\u00a1\3"+
		"\2\2\2\23\u00aa\3\2\2\2\25\u00b2\3\2\2\2\27\u00b7\3\2\2\2\31\u00bd\3\2"+
		"\2\2\33\u00c1\3\2\2\2\35\u00c9\3\2\2\2\37\u00ce\3\2\2\2!\u00d1\3\2\2\2"+
		"#\u00d4\3\2\2\2%\u00d7\3\2\2\2\'\u00da\3\2\2\2)\u00dd\3\2\2\2+\u00e0\3"+
		"\2\2\2-\u00ee\3\2\2\2/\u00f1\3\2\2\2\61\u00f4\3\2\2\2\63\u00f7\3\2\2\2"+
		"\65\u00fa\3\2\2\2\67\u00fd\3\2\2\29\u0100\3\2\2\2;\u0103\3\2\2\2=\u0108"+
		"\3\2\2\2?\u010d\3\2\2\2A\u0110\3\2\2\2C\u0113\3\2\2\2E\u0116\3\2\2\2G"+
		"\u011b\3\2\2\2I\u0120\3\2\2\2K\u0125\3\2\2\2M\u012a\3\2\2\2O\u012f\3\2"+
		"\2\2Q\u0134\3\2\2\2S\u0137\3\2\2\2U\u0142\3\2\2\2W\u0144\3\2\2\2Y\u0146"+
		"\3\2\2\2[\u014a\3\2\2\2]\u0150\3\2\2\2_\u0153\3\2\2\2a\u0157\3\2\2\2c"+
		"\u0161\3\2\2\2e\u0163\3\2\2\2g\u0168\3\2\2\2i\u0174\3\2\2\2k\u0176\3\2"+
		"\2\2m\u0179\3\2\2\2o\u017c\3\2\2\2q\177\5\5\3\2r\177\5\7\4\2s\177\5\t"+
		"\5\2t\177\5\13\6\2u\177\5\r\7\2v\177\5\17\b\2w\177\5\21\t\2x\177\5\23"+
		"\n\2y\177\5\25\13\2z\177\5\27\f\2{\177\5\31\r\2|\177\5\33\16\2}\177\5"+
		"\35\17\2~q\3\2\2\2~r\3\2\2\2~s\3\2\2\2~t\3\2\2\2~u\3\2\2\2~v\3\2\2\2~"+
		"w\3\2\2\2~x\3\2\2\2~y\3\2\2\2~z\3\2\2\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080\u0081\b\2\2\2\u0081\4\3\2\2\2\u0082\u0083\7e"+
		"\2\2\u0083\u0084\7n\2\2\u0084\u0085\7c\2\2\u0085\u0086\7u\2\2\u0086\u0087"+
		"\7u\2\2\u0087\6\3\2\2\2\u0088\u0089\7k\2\2\u0089\u008a\7h\2\2\u008a\b"+
		"\3\2\2\2\u008b\u008c\7g\2\2\u008c\u008d\7n\2\2\u008d\u008e\7u\2\2\u008e"+
		"\u008f\7g\2\2\u008f\n\3\2\2\2\u0090\u0091\7h\2\2\u0091\u0092\7q\2\2\u0092"+
		"\u0093\7t\2\2\u0093\f\3\2\2\2\u0094\u0095\7t\2\2\u0095\u0096\7g\2\2\u0096"+
		"\u0097\7v\2\2\u0097\u0098\7w\2\2\u0098\u0099\7t\2\2\u0099\u009a\7p\2\2"+
		"\u009a\16\3\2\2\2\u009b\u009c\7d\2\2\u009c\u009d\7t\2\2\u009d\u009e\7"+
		"g\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7m\2\2\u00a0\20\3\2\2\2\u00a1\u00a2"+
		"\7e\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7p\2\2\u00a4\u00a5\7v\2\2\u00a5"+
		"\u00a6\7k\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8\7w\2\2\u00a8\u00a9\7g\2\2"+
		"\u00a9\22\3\2\2\2\u00aa\u00ab\7e\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7"+
		"n\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7w\2\2\u00b0\u00b1"+
		"\7v\2\2\u00b1\24\3\2\2\2\u00b2\u00b3\7v\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5"+
		"\7w\2\2\u00b5\u00b6\7g\2\2\u00b6\26\3\2\2\2\u00b7\u00b8\7h\2\2\u00b8\u00b9"+
		"\7c\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7g\2\2\u00bc"+
		"\30\3\2\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7v\2\2\u00c0"+
		"\32\3\2\2\2\u00c1\u00c2\7d\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7q\2\2\u00c4"+
		"\u00c5\7n\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7p\2\2"+
		"\u00c8\34\3\2\2\2\u00c9\u00ca\7x\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7"+
		"k\2\2\u00cc\u00cd\7f\2\2\u00cd\36\3\2\2\2\u00ce\u00cf\7}\2\2\u00cf\u00d0"+
		"\b\20\3\2\u00d0 \3\2\2\2\u00d1\u00d2\7\177\2\2\u00d2\u00d3\b\21\4\2\u00d3"+
		"\"\3\2\2\2\u00d4\u00d5\7*\2\2\u00d5\u00d6\b\22\5\2\u00d6$\3\2\2\2\u00d7"+
		"\u00d8\7+\2\2\u00d8\u00d9\b\23\6\2\u00d9&\3\2\2\2\u00da\u00db\7]\2\2\u00db"+
		"\u00dc\b\24\7\2\u00dc(\3\2\2\2\u00dd\u00de\7_\2\2\u00de\u00df\b\25\b\2"+
		"\u00df*\3\2\2\2\u00e0\u00e1\7\61\2\2\u00e1\u00e2\7\61\2\2\u00e2\u00e6"+
		"\3\2\2\2\u00e3\u00e5\n\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e9\u00ea\7\f\2\2\u00ea\u00eb\b\26\t\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ed\b\26\n\2\u00ed,\3\2\2\2\u00ee\u00ef\7.\2\2\u00ef\u00f0\b\27\13"+
		"\2\u00f0.\3\2\2\2\u00f1\u00f2\7=\2\2\u00f2\u00f3\b\30\f\2\u00f3\60\3\2"+
		"\2\2\u00f4\u00f5\7-\2\2\u00f5\u00f6\b\31\r\2\u00f6\62\3\2\2\2\u00f7\u00f8"+
		"\7/\2\2\u00f8\u00f9\b\32\16\2\u00f9\64\3\2\2\2\u00fa\u00fb\7,\2\2\u00fb"+
		"\u00fc\b\33\17\2\u00fc\66\3\2\2\2\u00fd\u00fe\7\61\2\2\u00fe\u00ff\b\34"+
		"\20\2\u00ff8\3\2\2\2\u0100\u0101\7\'\2\2\u0101\u0102\b\35\21\2\u0102:"+
		"\3\2\2\2\u0103\u0104\7-\2\2\u0104\u0105\7?\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0107\b\36\22\2\u0107<\3\2\2\2\u0108\u0109\7/\2\2\u0109\u010a\7?\2\2"+
		"\u010a\u010b\3\2\2\2\u010b\u010c\b\37\23\2\u010c>\3\2\2\2\u010d\u010e"+
		"\7?\2\2\u010e\u010f\b \24\2\u010f@\3\2\2\2\u0110\u0111\7>\2\2\u0111\u0112"+
		"\b!\25\2\u0112B\3\2\2\2\u0113\u0114\7@\2\2\u0114\u0115\b\"\26\2\u0115"+
		"D\3\2\2\2\u0116\u0117\7>\2\2\u0117\u0118\7?\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u011a\b#\27\2\u011aF\3\2\2\2\u011b\u011c\7@\2\2\u011c\u011d\7?\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011f\b$\30\2\u011fH\3\2\2\2\u0120\u0121\7?\2\2\u0121"+
		"\u0122\7?\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b%\31\2\u0124J\3\2\2\2\u0125"+
		"\u0126\7#\2\2\u0126\u0127\7?\2\2\u0127\u0128\3\2\2\2\u0128\u0129\b&\32"+
		"\2\u0129L\3\2\2\2\u012a\u012b\7(\2\2\u012b\u012c\7(\2\2\u012c\u012d\3"+
		"\2\2\2\u012d\u012e\b\'\33\2\u012eN\3\2\2\2\u012f\u0130\7~\2\2\u0130\u0131"+
		"\7~\2\2\u0131\u0132\3\2\2\2\u0132\u0133\b(\34\2\u0133P\3\2\2\2\u0134\u0135"+
		"\7#\2\2\u0135\u0136\b)\35\2\u0136R\3\2\2\2\u0137\u013b\5W,\2\u0138\u013a"+
		"\5U+\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\b*"+
		"\36\2\u013fT\3\2\2\2\u0140\u0143\5W,\2\u0141\u0143\5Y-\2\u0142\u0140\3"+
		"\2\2\2\u0142\u0141\3\2\2\2\u0143V\3\2\2\2\u0144\u0145\t\3\2\2\u0145X\3"+
		"\2\2\2\u0146\u0147\t\4\2\2\u0147Z\3\2\2\2\u0148\u014b\5Y-\2\u0149\u014b"+
		"\t\5\2\2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b\\\3\2\2\2\u014c"+
		"\u0151\5_\60\2\u014d\u014e\5a\61\2\u014e\u014f\b/\37\2\u014f\u0151\3\2"+
		"\2\2\u0150\u014c\3\2\2\2\u0150\u014d\3\2\2\2\u0151^\3\2\2\2\u0152\u0154"+
		"\5Y-\2\u0153\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0153\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156`\3\2\2\2\u0157\u0158\7\62\2\2\u0158\u0159\7z\2\2"+
		"\u0159\u015b\3\2\2\2\u015a\u015c\5[.\2\u015b\u015a\3\2\2\2\u015c\u015d"+
		"\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015eb\3\2\2\2\u015f"+
		"\u0162\5\25\13\2\u0160\u0162\5\27\f\2\u0161\u015f\3\2\2\2\u0161\u0160"+
		"\3\2\2\2\u0162d\3\2\2\2\u0163\u0164\7)\2\2\u0164\u0165\5i\65\2\u0165\u0166"+
		"\7)\2\2\u0166\u0167\b\63 \2\u0167f\3\2\2\2\u0168\u016c\7$\2\2\u0169\u016b"+
		"\5i\65\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7$"+
		"\2\2\u0170\u0171\b\64!\2\u0171h\3\2\2\2\u0172\u0175\5k\66\2\u0173\u0175"+
		"\5m\67\2\u0174\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u0175j\3\2\2\2\u0176"+
		"\u0177\7^\2\2\u0177\u0178\t\6\2\2\u0178l\3\2\2\2\u0179\u017a\t\7\2\2\u017a"+
		"n\3\2\2\2\u017b\u017d\t\b\2\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2\2\2"+
		"\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181"+
		"\b8\n\2\u0181p\3\2\2\2\17\2~\u00e6\u013b\u0142\u014a\u0150\u0155\u015d"+
		"\u0161\u016c\u0174\u017e\"\3\2\2\3\20\3\3\21\4\3\22\5\3\23\6\3\24\7\3"+
		"\25\b\3\26\t\b\2\2\3\27\n\3\30\13\3\31\f\3\32\r\3\33\16\3\34\17\3\35\20"+
		"\3\36\21\3\37\22\3 \23\3!\24\3\"\25\3#\26\3$\27\3%\30\3&\31\3\'\32\3("+
		"\33\3)\34\3*\35\3/\36\3\63\37\3\64 ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}