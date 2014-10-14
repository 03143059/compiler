// Generated from scanner\DecafLexer.g4 by ANTLR 4.3

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
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, IF=2, ELSE=3, FOR=4, RETURN=5, BREAK=6, CONTINUE=7, CALLOUT=8, 
		INT=9, BOOLEAN=10, VOID=11, PROGRAM=12, LCURLY=13, RCURLY=14, LPAREN=15, 
		RPAREN=16, LSQUARE=17, RSQUARE=18, SL_COMMENT=19, COMMA=20, SEMI=21, PLUS=22, 
		MINUS=23, MUL=24, DIV=25, MOD=26, ASSIGNPLUSEQ=27, ASSIGNMINUSEQ=28, ASSIGNEQ=29, 
		LESS=30, MORE=31, LEQ=32, GEQ=33, CEQ=34, NEQ=35, AND=36, OR=37, NOT=38, 
		BOOL_LITERAL=39, TRUE=40, FALSE=41, ID=42, INT_LITERAL=43, DECIMAL_LITERAL=44, 
		HEX_LITERAL=45, STRING_LITERAL=46, CHAR_LITERAL=47, ALPHA_NUM=48, ALPHA=49, 
		DIGIT=50, HEX_DIGIT=51, WS=52, NL=53, ENDCHAR=54, CHAR=55, ESC=56, VALIDCHAR=57, 
		STARTCHAR=58;
	public static final int CARACTER = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "CARACTER"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'"
	};
	public static final String[] ruleNames = {
		"CLASS", "IF", "ELSE", "FOR", "RETURN", "BREAK", "CONTINUE", "CALLOUT", 
		"INT", "BOOLEAN", "VOID", "PROGRAM", "LCURLY", "RCURLY", "LPAREN", "RPAREN", 
		"LSQUARE", "RSQUARE", "SL_COMMENT", "COMMA", "SEMI", "PLUS", "MINUS", 
		"MUL", "DIV", "MOD", "ASSIGNPLUSEQ", "ASSIGNMINUSEQ", "ASSIGNEQ", "LESS", 
		"MORE", "LEQ", "GEQ", "CEQ", "NEQ", "AND", "OR", "NOT", "BOOL_LITERAL", 
		"TRUE", "FALSE", "ID", "INT_LITERAL", "DECIMAL_LITERAL", "HEX_LITERAL", 
		"STRING_LITERAL", "CHAR_LITERAL", "STARTCHAR", "ALPHA_NUM", "ALPHA", "DIGIT", 
		"HEX_DIGIT", "WS", "NL", "ENDCHAR", "CHAR", "ESC", "VALIDCHAR"
	};


	    private int count = 0;
	    public static boolean LexerDebug = false;
	    private static final String TAB = "  ";
	    private static void print(String p) { if (LexerDebug) System.out.print(p); }
	    private static void println(String p) { if (LexerDebug) System.out.println(p); }
	    private static void println() { if (LexerDebug) System.out.println(); }


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
		case 0: CLASS_action((RuleContext)_localctx, actionIndex); break;

		case 1: IF_action((RuleContext)_localctx, actionIndex); break;

		case 2: ELSE_action((RuleContext)_localctx, actionIndex); break;

		case 3: FOR_action((RuleContext)_localctx, actionIndex); break;

		case 4: RETURN_action((RuleContext)_localctx, actionIndex); break;

		case 5: BREAK_action((RuleContext)_localctx, actionIndex); break;

		case 6: CONTINUE_action((RuleContext)_localctx, actionIndex); break;

		case 7: CALLOUT_action((RuleContext)_localctx, actionIndex); break;

		case 8: INT_action((RuleContext)_localctx, actionIndex); break;

		case 9: BOOLEAN_action((RuleContext)_localctx, actionIndex); break;

		case 10: VOID_action((RuleContext)_localctx, actionIndex); break;

		case 11: PROGRAM_action((RuleContext)_localctx, actionIndex); break;

		case 12: LCURLY_action((RuleContext)_localctx, actionIndex); break;

		case 13: RCURLY_action((RuleContext)_localctx, actionIndex); break;

		case 14: LPAREN_action((RuleContext)_localctx, actionIndex); break;

		case 15: RPAREN_action((RuleContext)_localctx, actionIndex); break;

		case 16: LSQUARE_action((RuleContext)_localctx, actionIndex); break;

		case 17: RSQUARE_action((RuleContext)_localctx, actionIndex); break;

		case 19: COMMA_action((RuleContext)_localctx, actionIndex); break;

		case 20: SEMI_action((RuleContext)_localctx, actionIndex); break;

		case 21: PLUS_action((RuleContext)_localctx, actionIndex); break;

		case 22: MINUS_action((RuleContext)_localctx, actionIndex); break;

		case 23: MUL_action((RuleContext)_localctx, actionIndex); break;

		case 24: DIV_action((RuleContext)_localctx, actionIndex); break;

		case 25: MOD_action((RuleContext)_localctx, actionIndex); break;

		case 26: ASSIGNPLUSEQ_action((RuleContext)_localctx, actionIndex); break;

		case 27: ASSIGNMINUSEQ_action((RuleContext)_localctx, actionIndex); break;

		case 28: ASSIGNEQ_action((RuleContext)_localctx, actionIndex); break;

		case 29: LESS_action((RuleContext)_localctx, actionIndex); break;

		case 30: MORE_action((RuleContext)_localctx, actionIndex); break;

		case 31: LEQ_action((RuleContext)_localctx, actionIndex); break;

		case 32: GEQ_action((RuleContext)_localctx, actionIndex); break;

		case 33: CEQ_action((RuleContext)_localctx, actionIndex); break;

		case 34: NEQ_action((RuleContext)_localctx, actionIndex); break;

		case 35: AND_action((RuleContext)_localctx, actionIndex); break;

		case 36: OR_action((RuleContext)_localctx, actionIndex); break;

		case 37: NOT_action((RuleContext)_localctx, actionIndex); break;

		case 38: BOOL_LITERAL_action((RuleContext)_localctx, actionIndex); break;

		case 39: TRUE_action((RuleContext)_localctx, actionIndex); break;

		case 40: FALSE_action((RuleContext)_localctx, actionIndex); break;

		case 41: ID_action((RuleContext)_localctx, actionIndex); break;

		case 42: INT_LITERAL_action((RuleContext)_localctx, actionIndex); break;

		case 43: DECIMAL_LITERAL_action((RuleContext)_localctx, actionIndex); break;

		case 44: HEX_LITERAL_action((RuleContext)_localctx, actionIndex); break;

		case 45: STRING_LITERAL_action((RuleContext)_localctx, actionIndex); break;

		case 53: NL_action((RuleContext)_localctx, actionIndex); break;

		case 54: ENDCHAR_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void ASSIGNEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 27:  print(getText() + " ");  break;
		}
	}
	private void SEMI_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19:  print(getText() + TAB + " ");  break;
		}
	}
	private void CLASS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void INT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void MINUS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 21:  print(getText() + " ");  break;
		}
	}
	private void RETURN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void RSQUARE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17:  print(getText() + " ");  break;
		}
	}
	private void HEX_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 43:  print("HEX ");  break;
		}
	}
	private void ENDCHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 46:  print("CHAR ");  break;
		}
	}
	private void BREAK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void INT_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 41:  print("ENTERO ");  break;
		}
	}
	private void ELSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 40:  print("ID ");  break;
		}
	}
	private void IF_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void RCURLY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: 
		                print("\b\b");
		                print(getText() + " ");
		                count--;
		             break;
		}
	}
	private void COMMA_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18:  print(getText() + " ");  break;
		}
	}
	private void ASSIGNMINUSEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 26:  print(getText() + " ");  break;
		}
	}
	private void MOD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 24:  print(getText() + " ");  break;
		}
	}
	private void OR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 35:  print(getText() + " ");  break;
		}
	}
	private void MUL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 22:  print(getText() + " ");  break;
		}
	}
	private void FOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14:  print(getText() + " ");  break;
		}
	}
	private void LCURLY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: 
		                print(getText() + " ");
		                count++;
		             break;
		}
	}
	private void TRUE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 38:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15:  print(getText() + " ");  break;
		}
	}
	private void BOOLEAN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void CEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 32:  print(getText() + " ");  break;
		}
	}
	private void CALLOUT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void BOOL_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 37:  print("BOOLEAN ");  break;
		}
	}
	private void CONTINUE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void DIV_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 23:  print(getText() + " ");  break;
		}
	}
	private void LSQUARE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16:  print(getText() + " ");  break;
		}
	}
	private void MORE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 29:  print(getText() + " ");  break;
		}
	}
	private void GEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 31:  print(getText() + " ");  break;
		}
	}
	private void NOT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 36:  print(getText() + " ");  break;
		}
	}
	private void AND_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 34:  print(getText() + " ");  break;
		}
	}
	private void LEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 30:  print(getText() + " ");  break;
		}
	}
	private void LESS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 28:  print(getText() + " ");  break;
		}
	}
	private void FALSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 39:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void STRING_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 44:  print("CADENA ");  break;
		}
	}
	private void NEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 33:  print(getText() + " ");  break;
		}
	}
	private void VOID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:  print(getText().toUpperCase() + " ");  break;
		}
	}
	private void ASSIGNPLUSEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 25:  print(getText() + " ");  break;
		}
	}
	private void PROGRAM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:  print(getText() + " ");  break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 45: 
		                println();
		                for(int i = 0; i<count; i++)
		                    print(TAB);
		             break;
		}
	}
	private void PLUS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 20:  print(getText() + " ");  break;
		}
	}
	private void DECIMAL_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 42:  print("DECIMAL ");  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u01ae\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\7\24\u00f0\n\24\f\24\16\24\u00f3\13\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\""+
		"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3"+
		"\'\3\'\3\'\3(\3(\5(\u0142\n(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3+\3+\7+\u0157\n+\f+\16+\u015a\13+\3+\3+\3,\3,\5,\u0160\n,"+
		"\3,\3,\3-\6-\u0165\n-\r-\16-\u0166\3-\3-\3.\3.\3.\3.\6.\u016f\n.\r.\16"+
		".\u0170\3.\3.\3/\3/\7/\u0177\n/\f/\16/\u017a\13/\3/\3/\3/\3\60\3\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\5\62\u018a\n\62\3\63\3\63"+
		"\3\64\3\64\3\65\3\65\3\66\6\66\u0193\n\66\r\66\16\66\u0194\3\66\3\66\3"+
		"\67\5\67\u019a\n\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\59\u01a8"+
		"\n9\3:\3:\3:\3;\3;\3\u0178\2<\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13"+
		"\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62"+
		"\32\64\33\66\348\35:\36<\37> @!B\"D#F$H%J&L\'N(P)R*T+V,X-Z.\\/^\60`\61"+
		"b<d\62f\63h\64j\65l\66n\67p8r9t:v;\4\2\3\13\4\2\f\f\17\17\5\2C\\aac|\3"+
		"\2\62;\5\2\62;CHch\4\2\13\13\"\"\3\2\17\17\3\2\f\f\b\2$$))^^ppttvv\6\2"+
		"\"#%(*]_\u0080\u01b7\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2"+
		"\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3"+
		"\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2"+
		"\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2"+
		".\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2"+
		"\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2"+
		"F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3"+
		"\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2"+
		"\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2"+
		"\2l\3\2\2\2\2n\3\2\2\2\3p\3\2\2\2\3r\3\2\2\2\3t\3\2\2\2\3v\3\2\2\2\4x"+
		"\3\2\2\2\6\u0080\3\2\2\2\b\u0085\3\2\2\2\n\u008c\3\2\2\2\f\u0092\3\2\2"+
		"\2\16\u009b\3\2\2\2\20\u00a3\3\2\2\2\22\u00ae\3\2\2\2\24\u00b8\3\2\2\2"+
		"\26\u00be\3\2\2\2\30\u00c8\3\2\2\2\32\u00cf\3\2\2\2\34\u00d9\3\2\2\2\36"+
		"\u00dc\3\2\2\2 \u00df\3\2\2\2\"\u00e2\3\2\2\2$\u00e5\3\2\2\2&\u00e8\3"+
		"\2\2\2(\u00eb\3\2\2\2*\u00f6\3\2\2\2,\u00f9\3\2\2\2.\u00fc\3\2\2\2\60"+
		"\u00ff\3\2\2\2\62\u0102\3\2\2\2\64\u0105\3\2\2\2\66\u0108\3\2\2\28\u010b"+
		"\3\2\2\2:\u0110\3\2\2\2<\u0115\3\2\2\2>\u0118\3\2\2\2@\u011b\3\2\2\2B"+
		"\u011e\3\2\2\2D\u0123\3\2\2\2F\u0128\3\2\2\2H\u012d\3\2\2\2J\u0132\3\2"+
		"\2\2L\u0137\3\2\2\2N\u013c\3\2\2\2P\u0141\3\2\2\2R\u0145\3\2\2\2T\u014c"+
		"\3\2\2\2V\u0154\3\2\2\2X\u015f\3\2\2\2Z\u0164\3\2\2\2\\\u016a\3\2\2\2"+
		"^\u0174\3\2\2\2`\u017e\3\2\2\2b\u0182\3\2\2\2d\u0189\3\2\2\2f\u018b\3"+
		"\2\2\2h\u018d\3\2\2\2j\u018f\3\2\2\2l\u0192\3\2\2\2n\u0199\3\2\2\2p\u01a0"+
		"\3\2\2\2r\u01a7\3\2\2\2t\u01a9\3\2\2\2v\u01ac\3\2\2\2xy\7e\2\2yz\7n\2"+
		"\2z{\7c\2\2{|\7u\2\2|}\7u\2\2}~\3\2\2\2~\177\b\2\2\2\177\5\3\2\2\2\u0080"+
		"\u0081\7k\2\2\u0081\u0082\7h\2\2\u0082\u0083\3\2\2\2\u0083\u0084\b\3\3"+
		"\2\u0084\7\3\2\2\2\u0085\u0086\7g\2\2\u0086\u0087\7n\2\2\u0087\u0088\7"+
		"u\2\2\u0088\u0089\7g\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\4\4\2\u008b"+
		"\t\3\2\2\2\u008c\u008d\7h\2\2\u008d\u008e\7q\2\2\u008e\u008f\7t\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0091\b\5\5\2\u0091\13\3\2\2\2\u0092\u0093\7t\2\2"+
		"\u0093\u0094\7g\2\2\u0094\u0095\7v\2\2\u0095\u0096\7w\2\2\u0096\u0097"+
		"\7t\2\2\u0097\u0098\7p\2\2\u0098\u0099\3\2\2\2\u0099\u009a\b\6\6\2\u009a"+
		"\r\3\2\2\2\u009b\u009c\7d\2\2\u009c\u009d\7t\2\2\u009d\u009e\7g\2\2\u009e"+
		"\u009f\7c\2\2\u009f\u00a0\7m\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\b\7\7"+
		"\2\u00a2\17\3\2\2\2\u00a3\u00a4\7e\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6"+
		"\7p\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9"+
		"\u00aa\7w\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\b\b\b"+
		"\2\u00ad\21\3\2\2\2\u00ae\u00af\7e\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1"+
		"\7n\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7w\2\2\u00b4"+
		"\u00b5\7v\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\t\t\2\u00b7\23\3\2\2\2"+
		"\u00b8\u00b9\7k\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00bd\b\n\n\2\u00bd\25\3\2\2\2\u00be\u00bf\7d\2\2\u00bf"+
		"\u00c0\7q\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7g\2\2"+
		"\u00c3\u00c4\7c\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7"+
		"\b\13\13\2\u00c7\27\3\2\2\2\u00c8\u00c9\7x\2\2\u00c9\u00ca\7q\2\2\u00ca"+
		"\u00cb\7k\2\2\u00cb\u00cc\7f\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b\f\f"+
		"\2\u00ce\31\3\2\2\2\u00cf\u00d0\7R\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2"+
		"\7q\2\2\u00d2\u00d3\7i\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7c\2\2\u00d5"+
		"\u00d6\7o\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\b\r\r\2\u00d8\33\3\2\2\2"+
		"\u00d9\u00da\7}\2\2\u00da\u00db\b\16\16\2\u00db\35\3\2\2\2\u00dc\u00dd"+
		"\7\177\2\2\u00dd\u00de\b\17\17\2\u00de\37\3\2\2\2\u00df\u00e0\7*\2\2\u00e0"+
		"\u00e1\b\20\20\2\u00e1!\3\2\2\2\u00e2\u00e3\7+\2\2\u00e3\u00e4\b\21\21"+
		"\2\u00e4#\3\2\2\2\u00e5\u00e6\7]\2\2\u00e6\u00e7\b\22\22\2\u00e7%\3\2"+
		"\2\2\u00e8\u00e9\7_\2\2\u00e9\u00ea\b\23\23\2\u00ea\'\3\2\2\2\u00eb\u00ec"+
		"\7\61\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00f1\3\2\2\2\u00ee\u00f0\n\2\2\2"+
		"\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2"+
		"\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\b\24\24\2"+
		"\u00f5)\3\2\2\2\u00f6\u00f7\7.\2\2\u00f7\u00f8\b\25\25\2\u00f8+\3\2\2"+
		"\2\u00f9\u00fa\7=\2\2\u00fa\u00fb\b\26\26\2\u00fb-\3\2\2\2\u00fc\u00fd"+
		"\7-\2\2\u00fd\u00fe\b\27\27\2\u00fe/\3\2\2\2\u00ff\u0100\7/\2\2\u0100"+
		"\u0101\b\30\30\2\u0101\61\3\2\2\2\u0102\u0103\7,\2\2\u0103\u0104\b\31"+
		"\31\2\u0104\63\3\2\2\2\u0105\u0106\7\61\2\2\u0106\u0107\b\32\32\2\u0107"+
		"\65\3\2\2\2\u0108\u0109\7\'\2\2\u0109\u010a\b\33\33\2\u010a\67\3\2\2\2"+
		"\u010b\u010c\7-\2\2\u010c\u010d\7?\2\2\u010d\u010e\3\2\2\2\u010e\u010f"+
		"\b\34\34\2\u010f9\3\2\2\2\u0110\u0111\7/\2\2\u0111\u0112\7?\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0114\b\35\35\2\u0114;\3\2\2\2\u0115\u0116\7?\2\2"+
		"\u0116\u0117\b\36\36\2\u0117=\3\2\2\2\u0118\u0119\7>\2\2\u0119\u011a\b"+
		"\37\37\2\u011a?\3\2\2\2\u011b\u011c\7@\2\2\u011c\u011d\b  \2\u011dA\3"+
		"\2\2\2\u011e\u011f\7>\2\2\u011f\u0120\7?\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0122\b!!\2\u0122C\3\2\2\2\u0123\u0124\7@\2\2\u0124\u0125\7?\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0127\b\"\"\2\u0127E\3\2\2\2\u0128\u0129\7?\2\2\u0129"+
		"\u012a\7?\2\2\u012a\u012b\3\2\2\2\u012b\u012c\b##\2\u012cG\3\2\2\2\u012d"+
		"\u012e\7#\2\2\u012e\u012f\7?\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b$$\2"+
		"\u0131I\3\2\2\2\u0132\u0133\7(\2\2\u0133\u0134\7(\2\2\u0134\u0135\3\2"+
		"\2\2\u0135\u0136\b%%\2\u0136K\3\2\2\2\u0137\u0138\7~\2\2\u0138\u0139\7"+
		"~\2\2\u0139\u013a\3\2\2\2\u013a\u013b\b&&\2\u013bM\3\2\2\2\u013c\u013d"+
		"\7#\2\2\u013d\u013e\b\'\'\2\u013eO\3\2\2\2\u013f\u0142\5R)\2\u0140\u0142"+
		"\5T*\2\u0141\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"\u0144\b((\2\u0144Q\3\2\2\2\u0145\u0146\7v\2\2\u0146\u0147\7t\2\2\u0147"+
		"\u0148\7w\2\2\u0148\u0149\7g\2\2\u0149\u014a\3\2\2\2\u014a\u014b\b))\2"+
		"\u014bS\3\2\2\2\u014c\u014d\7h\2\2\u014d\u014e\7c\2\2\u014e\u014f\7n\2"+
		"\2\u014f\u0150\7u\2\2\u0150\u0151\7g\2\2\u0151\u0152\3\2\2\2\u0152\u0153"+
		"\b**\2\u0153U\3\2\2\2\u0154\u0158\5f\63\2\u0155\u0157\5d\62\2\u0156\u0155"+
		"\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c\b++\2\u015cW\3\2\2\2\u015d"+
		"\u0160\5Z-\2\u015e\u0160\5\\.\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2"+
		"\2\u0160\u0161\3\2\2\2\u0161\u0162\b,,\2\u0162Y\3\2\2\2\u0163\u0165\5"+
		"h\64\2\u0164\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\b--\2\u0169[\3\2\2\2\u016a"+
		"\u016b\7\62\2\2\u016b\u016c\7z\2\2\u016c\u016e\3\2\2\2\u016d\u016f\5j"+
		"\65\2\u016e\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u016e\3\2\2\2\u0170"+
		"\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\b..\2\u0173]\3\2\2\2\u0174"+
		"\u0178\7$\2\2\u0175\u0177\5r9\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2"+
		"\2\u0178\u0179\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0178"+
		"\3\2\2\2\u017b\u017c\7$\2\2\u017c\u017d\b//\2\u017d_\3\2\2\2\u017e\u017f"+
		"\5b\61\2\u017f\u0180\5r9\2\u0180\u0181\5p8\2\u0181a\3\2\2\2\u0182\u0183"+
		"\7)\2\2\u0183\u0184\3\2\2\2\u0184\u0185\b\61\60\2\u0185\u0186\b\61\61"+
		"\2\u0186c\3\2\2\2\u0187\u018a\5f\63\2\u0188\u018a\5h\64\2\u0189\u0187"+
		"\3\2\2\2\u0189\u0188\3\2\2\2\u018ae\3\2\2\2\u018b\u018c\t\3\2\2\u018c"+
		"g\3\2\2\2\u018d\u018e\t\4\2\2\u018ei\3\2\2\2\u018f\u0190\t\5\2\2\u0190"+
		"k\3\2\2\2\u0191\u0193\t\6\2\2\u0192\u0191\3\2\2\2\u0193\u0194\3\2\2\2"+
		"\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197"+
		"\b\66\24\2\u0197m\3\2\2\2\u0198\u019a\t\7\2\2\u0199\u0198\3\2\2\2\u0199"+
		"\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\t\b\2\2\u019c\u019d\b\67"+
		"\62\2\u019d\u019e\3\2\2\2\u019e\u019f\b\67\24\2\u019fo\3\2\2\2\u01a0\u01a1"+
		"\7)\2\2\u01a1\u01a2\b8\63\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\b8\64\2\u01a4"+
		"q\3\2\2\2\u01a5\u01a8\5t:\2\u01a6\u01a8\5v;\2\u01a7\u01a5\3\2\2\2\u01a7"+
		"\u01a6\3\2\2\2\u01a8s\3\2\2\2\u01a9\u01aa\7^\2\2\u01aa\u01ab\t\t\2\2\u01ab"+
		"u\3\2\2\2\u01ac\u01ad\t\n\2\2\u01adw\3\2\2\2\17\2\3\u00f1\u0141\u0158"+
		"\u015f\u0166\u0170\u0178\u0189\u0194\u0199\u01a7\65\3\2\2\3\3\3\3\4\4"+
		"\3\5\5\3\6\6\3\7\7\3\b\b\3\t\t\3\n\n\3\13\13\3\f\f\3\r\r\3\16\16\3\17"+
		"\17\3\20\20\3\21\21\3\22\22\3\23\23\b\2\2\3\25\24\3\26\25\3\27\26\3\30"+
		"\27\3\31\30\3\32\31\3\33\32\3\34\33\3\35\34\3\36\35\3\37\36\3 \37\3! "+
		"\3\"!\3#\"\3$#\3%$\3&%\3\'&\3(\'\3)(\3*)\3+*\3,+\3-,\3.-\3/.\5\2\2\7\3"+
		"\2\3\67/\38\60\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}