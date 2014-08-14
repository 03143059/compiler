// Generated from C:/Dev/_CC4/cc4/compiler/src/scanner\DecafLexer.g4 by ANTLR 4.4.1-dev

	package scanner;
	import java.util.LinkedList;

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
		WHITESPACE=1, CLASS=2, PROGRAM=3, VOID=4, IF=5, ELSE=6, FOR=7, RETURN=8, 
		BREAK=9, CONTINUE=10, CALLOUT=11, INT=12, BOOLEAN=13, FLOTANTES=14, ESC=15, 
		ERR1_LITERAL_CHAR=16, ERR2_LITERAL_CHAR=17, ERR3_LITERAL_CHAR=18, ERR4_LITERAL_CHAR=19, 
		ERR5_LITERAL_CHAR=20, LITERAL_CHAR=21, LITERAL_STRING=22, LITERAL_BOOL=23, 
		ERROR_LITERAL_HEXA=24, LITERAL_HEXA=25, LITERAL_ENTEROS=26, VARIABLES=27, 
		COMILLAS=28, COMILLA=29, COMA=30, PUNTOYCOMA=31, PUNTO=32, COLON=33, LPARENTESIS=34, 
		RPARENTESIS=35, LSQUIGLY=36, RSQUIGLY=37, LBRACKET=38, RBRACKET=39, SUMA=40, 
		RESTA=41, MULTIPLICACION=42, DIVISION=43, REMAINDER=44, EQUAL=45, PLUS_EQUAL=46, 
		MINUS_EQUAL=47, EQUAL_EQUAL=48, NOT_EQUAL=49, COND_AND=50, COND_OR=51, 
		COND_XOR=52, CONDNOT=53, REL_MENOR=54, REL_MAYOR=55, REL_MENOREQ=56, REL_MAYOREQ=57, 
		COMMENTDD=58, COMMENTAD=59;
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
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'"
	};
	public static final String[] ruleNames = {
		"WHITESPACE", "CLASS", "PROGRAM", "VOID", "IF", "ELSE", "FOR", "RETURN", 
		"BREAK", "CONTINUE", "CALLOUT", "INT", "BOOLEAN", "FLOTANTES", "ESC", 
		"ERR1_LITERAL_CHAR", "ERR2_LITERAL_CHAR", "ERR3_LITERAL_CHAR", "ERR4_LITERAL_CHAR", 
		"ERR5_LITERAL_CHAR", "LITERAL_CHAR", "LITERAL_STRING", "LITERAL_BOOL", 
		"ERROR_LITERAL_HEXA", "LITERAL_HEXA", "LITERAL_ENTEROS", "VARIABLES", 
		"COMILLAS", "COMILLA", "COMA", "PUNTOYCOMA", "PUNTO", "COLON", "LPARENTESIS", 
		"RPARENTESIS", "LSQUIGLY", "RSQUIGLY", "LBRACKET", "RBRACKET", "SUMA", 
		"RESTA", "MULTIPLICACION", "DIVISION", "REMAINDER", "EQUAL", "PLUS_EQUAL", 
		"MINUS_EQUAL", "EQUAL_EQUAL", "NOT_EQUAL", "COND_AND", "COND_OR", "COND_XOR", 
		"CONDNOT", "REL_MENOR", "REL_MAYOR", "REL_MENOREQ", "REL_MAYOREQ", "COMMENTDD", 
		"COMMENTAD"
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
		case 0: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		case 57: COMMENTDD_action((RuleContext)_localctx, actionIndex); break;
		case 58: COMMENTAD_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}
	private void COMMENTAD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip(); break;
		}
	}
	private void COMMENTDD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u0195\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\6"+
		"\2{\n\2\r\2\16\2|\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\6\17\u00cb"+
		"\n\17\r\17\16\17\u00cc\3\17\3\17\6\17\u00d1\n\17\r\17\16\17\u00d2\3\20"+
		"\3\20\3\20\3\21\3\21\6\21\u00da\n\21\r\21\16\21\u00db\3\21\3\21\3\22\3"+
		"\22\6\22\u00e2\n\22\r\22\16\22\u00e3\3\22\3\22\3\23\3\23\6\23\u00ea\n"+
		"\23\r\23\16\23\u00eb\3\24\3\24\6\24\u00f0\n\24\r\24\16\24\u00f1\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\5\26\u00fe\n\26\3\26\3\26"+
		"\3\27\3\27\3\27\7\27\u0105\n\27\f\27\16\27\u0108\13\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0115\n\30\3\31\3\31\3\31"+
		"\3\31\5\31\u011b\n\31\3\31\6\31\u011e\n\31\r\31\16\31\u011f\3\32\3\32"+
		"\3\32\3\32\5\32\u0126\n\32\3\32\6\32\u0129\n\32\r\32\16\32\u012a\3\33"+
		"\6\33\u012e\n\33\r\33\16\33\u012f\3\34\3\34\7\34\u0134\n\34\f\34\16\34"+
		"\u0137\13\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3"+
		"$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/"+
		"\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3:\3;\3"+
		";\3;\3;\7;\u0181\n;\f;\16;\u0184\13;\3;\3;\3<\3<\3<\3<\7<\u018c\n<\f<"+
		"\16<\u018f\13<\3<\3<\3<\3<\3<\2\2=\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=\3\2\t\5\2\13\f\17\17\"\""+
		"\n\2$$))^^ddhhppttvv\4\2\f\f\17\17\4\2$$^^\5\2\62;CHch\5\2C\\aac|\6\2"+
		"\62;C\\aac|\u01a7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\3z\3\2\2\2\5\u0080\3\2\2\2\7\u0086\3\2\2\2\t\u008e\3\2\2\2\13\u0093"+
		"\3\2\2\2\r\u0096\3\2\2\2\17\u009b\3\2\2\2\21\u009f\3\2\2\2\23\u00a6\3"+
		"\2\2\2\25\u00ac\3\2\2\2\27\u00b5\3\2\2\2\31\u00bd\3\2\2\2\33\u00c1\3\2"+
		"\2\2\35\u00ca\3\2\2\2\37\u00d4\3\2\2\2!\u00d7\3\2\2\2#\u00df\3\2\2\2%"+
		"\u00e7\3\2\2\2\'\u00ed\3\2\2\2)\u00f5\3\2\2\2+\u00fa\3\2\2\2-\u0101\3"+
		"\2\2\2/\u0114\3\2\2\2\61\u011a\3\2\2\2\63\u0125\3\2\2\2\65\u012d\3\2\2"+
		"\2\67\u0131\3\2\2\29\u0138\3\2\2\2;\u013a\3\2\2\2=\u013c\3\2\2\2?\u013e"+
		"\3\2\2\2A\u0140\3\2\2\2C\u0142\3\2\2\2E\u0144\3\2\2\2G\u0146\3\2\2\2I"+
		"\u0148\3\2\2\2K\u014a\3\2\2\2M\u014c\3\2\2\2O\u014e\3\2\2\2Q\u0150\3\2"+
		"\2\2S\u0152\3\2\2\2U\u0154\3\2\2\2W\u0156\3\2\2\2Y\u0158\3\2\2\2[\u015a"+
		"\3\2\2\2]\u015c\3\2\2\2_\u015f\3\2\2\2a\u0162\3\2\2\2c\u0165\3\2\2\2e"+
		"\u0168\3\2\2\2g\u016b\3\2\2\2i\u016e\3\2\2\2k\u0170\3\2\2\2m\u0172\3\2"+
		"\2\2o\u0174\3\2\2\2q\u0176\3\2\2\2s\u0179\3\2\2\2u\u017c\3\2\2\2w\u0187"+
		"\3\2\2\2y{\t\2\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~"+
		"\177\b\2\2\2\177\4\3\2\2\2\u0080\u0081\7e\2\2\u0081\u0082\7n\2\2\u0082"+
		"\u0083\7c\2\2\u0083\u0084\7u\2\2\u0084\u0085\7u\2\2\u0085\6\3\2\2\2\u0086"+
		"\u0087\7R\2\2\u0087\u0088\7t\2\2\u0088\u0089\7q\2\2\u0089\u008a\7i\2\2"+
		"\u008a\u008b\7t\2\2\u008b\u008c\7c\2\2\u008c\u008d\7o\2\2\u008d\b\3\2"+
		"\2\2\u008e\u008f\7x\2\2\u008f\u0090\7q\2\2\u0090\u0091\7k\2\2\u0091\u0092"+
		"\7f\2\2\u0092\n\3\2\2\2\u0093\u0094\7k\2\2\u0094\u0095\7h\2\2\u0095\f"+
		"\3\2\2\2\u0096\u0097\7g\2\2\u0097\u0098\7n\2\2\u0098\u0099\7u\2\2\u0099"+
		"\u009a\7g\2\2\u009a\16\3\2\2\2\u009b\u009c\7h\2\2\u009c\u009d\7q\2\2\u009d"+
		"\u009e\7t\2\2\u009e\20\3\2\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1\7g\2\2\u00a1"+
		"\u00a2\7v\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7p\2\2"+
		"\u00a5\22\3\2\2\2\u00a6\u00a7\7d\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7"+
		"g\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7m\2\2\u00ab\24\3\2\2\2\u00ac\u00ad"+
		"\7e\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7v\2\2\u00b0"+
		"\u00b1\7k\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7w\2\2\u00b3\u00b4\7g\2\2"+
		"\u00b4\26\3\2\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7"+
		"n\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7w\2\2\u00bb\u00bc"+
		"\7v\2\2\u00bc\30\3\2\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0"+
		"\7v\2\2\u00c0\32\3\2\2\2\u00c1\u00c2\7d\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4"+
		"\7q\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7c\2\2\u00c7"+
		"\u00c8\7p\2\2\u00c8\34\3\2\2\2\u00c9\u00cb\4\62;\2\u00ca\u00c9\3\2\2\2"+
		"\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00d0\7\60\2\2\u00cf\u00d1\4\62;\2\u00d0\u00cf\3\2\2\2"+
		"\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\36"+
		"\3\2\2\2\u00d4\u00d5\7^\2\2\u00d5\u00d6\t\3\2\2\u00d6 \3\2\2\2\u00d7\u00d9"+
		"\7)\2\2\u00d8\u00da\7)\2\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\7)"+
		"\2\2\u00de\"\3\2\2\2\u00df\u00e1\7)\2\2\u00e0\u00e2\7$\2\2\u00e1\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\7)\2\2\u00e6$\3\2\2\2\u00e7\u00e9\7)\2\2\u00e8"+
		"\u00ea\t\4\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec&\3\2\2\2\u00ed\u00ef\7)\2\2\u00ee\u00f0"+
		"\t\4\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7)\2\2\u00f4(\3\2\2\2\u00f5"+
		"\u00f6\7)\2\2\u00f6\u00f7\7^\2\2\u00f7\u00f8\n\3\2\2\u00f8\u00f9\7)\2"+
		"\2\u00f9*\3\2\2\2\u00fa\u00fd\7)\2\2\u00fb\u00fe\5\37\20\2\u00fc\u00fe"+
		"\n\5\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u0100\7)\2\2\u0100,\3\2\2\2\u0101\u0106\7$\2\2\u0102\u0105\5\37\20\2"+
		"\u0103\u0105\n\5\2\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105\u0108"+
		"\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0109\u010a\7$\2\2\u010a.\3\2\2\2\u010b\u010c\7v\2\2\u010c"+
		"\u010d\7t\2\2\u010d\u010e\7w\2\2\u010e\u0115\7g\2\2\u010f\u0110\7h\2\2"+
		"\u0110\u0111\7c\2\2\u0111\u0112\7n\2\2\u0112\u0113\7u\2\2\u0113\u0115"+
		"\7g\2\2\u0114\u010b\3\2\2\2\u0114\u010f\3\2\2\2\u0115\60\3\2\2\2\u0116"+
		"\u0117\7\62\2\2\u0117\u011b\7z\2\2\u0118\u0119\7\62\2\2\u0119\u011b\7"+
		"Z\2\2\u011a\u0116\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011d\3\2\2\2\u011c"+
		"\u011e\t\6\2\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120\62\3\2\2\2\u0121\u0122\7\62\2\2\u0122\u0126"+
		"\7z\2\2\u0123\u0124\7\62\2\2\u0124\u0126\7Z\2\2\u0125\u0121\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0129\n\6\2\2\u0128\u0127\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\64\3\2\2\2\u012c\u012e\4\62;\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2"+
		"\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\66\3\2\2\2\u0131\u0135"+
		"\t\7\2\2\u0132\u0134\t\b\2\2\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u01368\3\2\2\2\u0137\u0135\3\2\2\2"+
		"\u0138\u0139\7$\2\2\u0139:\3\2\2\2\u013a\u013b\7)\2\2\u013b<\3\2\2\2\u013c"+
		"\u013d\7.\2\2\u013d>\3\2\2\2\u013e\u013f\7=\2\2\u013f@\3\2\2\2\u0140\u0141"+
		"\7\60\2\2\u0141B\3\2\2\2\u0142\u0143\7<\2\2\u0143D\3\2\2\2\u0144\u0145"+
		"\7*\2\2\u0145F\3\2\2\2\u0146\u0147\7+\2\2\u0147H\3\2\2\2\u0148\u0149\7"+
		"}\2\2\u0149J\3\2\2\2\u014a\u014b\7\177\2\2\u014bL\3\2\2\2\u014c\u014d"+
		"\7]\2\2\u014dN\3\2\2\2\u014e\u014f\7_\2\2\u014fP\3\2\2\2\u0150\u0151\7"+
		"-\2\2\u0151R\3\2\2\2\u0152\u0153\7/\2\2\u0153T\3\2\2\2\u0154\u0155\7,"+
		"\2\2\u0155V\3\2\2\2\u0156\u0157\7\61\2\2\u0157X\3\2\2\2\u0158\u0159\7"+
		"\'\2\2\u0159Z\3\2\2\2\u015a\u015b\7?\2\2\u015b\\\3\2\2\2\u015c\u015d\7"+
		"-\2\2\u015d\u015e\7?\2\2\u015e^\3\2\2\2\u015f\u0160\7/\2\2\u0160\u0161"+
		"\7?\2\2\u0161`\3\2\2\2\u0162\u0163\7?\2\2\u0163\u0164\7?\2\2\u0164b\3"+
		"\2\2\2\u0165\u0166\7#\2\2\u0166\u0167\7?\2\2\u0167d\3\2\2\2\u0168\u0169"+
		"\7(\2\2\u0169\u016a\7(\2\2\u016af\3\2\2\2\u016b\u016c\7~\2\2\u016c\u016d"+
		"\7~\2\2\u016dh\3\2\2\2\u016e\u016f\7`\2\2\u016fj\3\2\2\2\u0170\u0171\7"+
		"#\2\2\u0171l\3\2\2\2\u0172\u0173\7>\2\2\u0173n\3\2\2\2\u0174\u0175\7@"+
		"\2\2\u0175p\3\2\2\2\u0176\u0177\7>\2\2\u0177\u0178\7?\2\2\u0178r\3\2\2"+
		"\2\u0179\u017a\7@\2\2\u017a\u017b\7?\2\2\u017bt\3\2\2\2\u017c\u017d\7"+
		"\61\2\2\u017d\u017e\7\61\2\2\u017e\u0182\3\2\2\2\u017f\u0181\n\4\2\2\u0180"+
		"\u017f\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\b;\3\2\u0186"+
		"v\3\2\2\2\u0187\u0188\7\61\2\2\u0188\u0189\7,\2\2\u0189\u018d\3\2\2\2"+
		"\u018a\u018c\13\2\2\2\u018b\u018a\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b"+
		"\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190"+
		"\u0191\7,\2\2\u0191\u0192\7\61\2\2\u0192\u0193\3\2\2\2\u0193\u0194\b<"+
		"\4\2\u0194x\3\2\2\2\26\2|\u00cc\u00d2\u00db\u00e3\u00eb\u00f1\u00fd\u0104"+
		"\u0106\u0114\u011a\u011f\u0125\u012a\u012f\u0135\u0182\u018d\5\3\2\2\3"+
		";\3\3<\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}