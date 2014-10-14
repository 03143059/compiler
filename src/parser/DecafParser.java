// Generated from parser\DecafParser.g4 by ANTLR 4.3

  package parser;
  import scanner.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALPHA=49, CLASS=1, MINUS=23, RSQUARE=18, HEX_LITERAL=45, ENDCHAR=54, BREAK=6, 
		ELSE=3, ID=42, IF=2, MUL=24, FOR=4, LPAREN=15, TRUE=40, RPAREN=16, ALPHA_NUM=48, 
		STARTCHAR=58, BOOLEAN=10, CEQ=34, BOOL_LITERAL=39, GEQ=33, NOT=38, AND=36, 
		LESS=30, CHAR_LITERAL=47, VOID=11, PROGRAM=12, NL=53, PLUS=22, VALIDCHAR=57, 
		ASSIGNEQ=29, SEMI=21, CHAR=55, INT=9, RETURN=5, ESC=56, INT_LITERAL=43, 
		HEX_DIGIT=51, WS=52, RCURLY=14, COMMA=20, ASSIGNMINUSEQ=28, MOD=26, OR=37, 
		LCURLY=13, DIGIT=50, CALLOUT=8, CONTINUE=7, DIV=25, LSQUARE=17, MORE=31, 
		SL_COMMENT=19, LEQ=32, FALSE=41, STRING_LITERAL=46, NEQ=35, ASSIGNPLUSEQ=27, 
		DECIMAL_LITERAL=44;
	public static final String[] tokenNames = {
		"<INVALID>", "'class'", "'if'", "'else'", "'for'", "'return'", "'break'", 
		"'continue'", "'callout'", "'int'", "'boolean'", "'void'", "'Program'", 
		"'{'", "'}'", "'('", "')'", "'['", "']'", "SL_COMMENT", "','", "';'", 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'+='", "'-='", "'='", "'<'", "'>'", 
		"'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", "'!'", "BOOL_LITERAL", 
		"'true'", "'false'", "ID", "INT_LITERAL", "DECIMAL_LITERAL", "HEX_LITERAL", 
		"STRING_LITERAL", "CHAR_LITERAL", "ALPHA_NUM", "ALPHA", "DIGIT", "HEX_DIGIT", 
		"WS", "NL", "ENDCHAR", "CHAR", "ESC", "VALIDCHAR", "'''"
	};
	public static final int
		RULE_start = 0, RULE_field_decls = 1, RULE_field_decl = 2, RULE_bad_field_decl = 3, 
		RULE_method_decl = 4, RULE_method_param = 5, RULE_block = 6, RULE_var_decl = 7, 
		RULE_type = 8, RULE_statement = 9, RULE_assign_op = 10, RULE_method_call = 11, 
		RULE_callout_arg = 12, RULE_method_name = 13, RULE_location = 14, RULE_method_expr = 15, 
		RULE_expr = 16, RULE_literal = 17;
	public static final String[] ruleNames = {
		"start", "field_decls", "field_decl", "bad_field_decl", "method_decl", 
		"method_param", "block", "var_decl", "type", "statement", "assign_op", 
		"method_call", "callout_arg", "method_name", "location", "method_expr", 
		"expr", "literal"
	};

	@Override
	public String getGrammarFileName() { return "DecafParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DecafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<Field_declsContext> field_decls() {
			return getRuleContexts(Field_declsContext.class);
		}
		public List<Method_declContext> method_decl() {
			return getRuleContexts(Method_declContext.class);
		}
		public Method_declContext method_decl(int i) {
			return getRuleContext(Method_declContext.class,i);
		}
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public Field_declsContext field_decls(int i) {
			return getRuleContext(Field_declsContext.class,i);
		}
		public TerminalNode CLASS() { return getToken(DecafParser.CLASS, 0); }
		public TerminalNode PROGRAM() { return getToken(DecafParser.PROGRAM, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(CLASS);
			setState(37); match(PROGRAM);
			setState(38); match(LCURLY);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(39); field_decls();
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(45); method_decl();
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(51); match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_declsContext extends ParserRuleContext {
		public Field_declContext field_decl(int i) {
			return getRuleContext(Field_declContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(DecafParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Field_declContext> field_decl() {
			return getRuleContexts(Field_declContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Field_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterField_decls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitField_decls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitField_decls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declsContext field_decls() throws RecognitionException {
		Field_declsContext _localctx = new Field_declsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_field_decls);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53); type();
			setState(54); field_decl();
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(55); match(COMMA);
					setState(56); field_decl();
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(62); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_declContext extends ParserRuleContext {
		public Field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decl; }
	 
		public Field_declContext() { }
		public void copyFrom(Field_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayContext extends Field_declContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode RSQUARE() { return getToken(DecafParser.RSQUARE, 0); }
		public TerminalNode LSQUARE() { return getToken(DecafParser.LSQUARE, 0); }
		public TerminalNode INT_LITERAL() { return getToken(DecafParser.INT_LITERAL, 0); }
		public ArrayContext(Field_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrordeclContext extends Field_declContext {
		public Bad_field_declContext bad_field_decl() {
			return getRuleContext(Bad_field_declContext.class,0);
		}
		public ErrordeclContext(Field_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterErrordecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitErrordecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitErrordecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleidContext extends Field_declContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public SingleidContext(Field_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterSingleid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitSingleid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitSingleid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declContext field_decl() throws RecognitionException {
		Field_declContext _localctx = new Field_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_field_decl);
		try {
			setState(70);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new SingleidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64); match(ID);
				}
				break;

			case 2:
				_localctx = new ArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65); match(ID);
				setState(66); match(LSQUARE);
				setState(67); match(INT_LITERAL);
				setState(68); match(RSQUARE);
				}
				break;

			case 3:
				_localctx = new ErrordeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(69); bad_field_decl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bad_field_declContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public Bad_field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bad_field_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBad_field_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBad_field_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitBad_field_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bad_field_declContext bad_field_decl() throws RecognitionException {
		Bad_field_declContext _localctx = new Bad_field_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bad_field_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); location();
			setState(73); assign_op();
			setState(74); expr(0);
			 notifyErrorListeners("invalid assignment '='"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode VOID() { return getToken(DecafParser.VOID, 0); }
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<Method_paramContext> method_param() {
			return getRuleContexts(Method_paramContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Method_paramContext method_param(int i) {
			return getRuleContext(Method_paramContext.class,i);
		}
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMethod_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_method_decl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			switch (_input.LA(1)) {
			case INT:
			case BOOLEAN:
				{
				setState(77); type();
				}
				break;
			case VOID:
				{
				setState(78); match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(81); match(ID);
			setState(82); match(LPAREN);
			setState(91);
			_la = _input.LA(1);
			if (_la==INT || _la==BOOLEAN) {
				{
				setState(83); method_param();
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(84); match(COMMA);
						setState(85); method_param();
						}
						} 
					}
					setState(90);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				}
			}

			setState(93); match(RPAREN);
			setState(94); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_paramContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Method_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMethod_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_paramContext method_param() throws RecognitionException {
		Method_paramContext _localctx = new Method_paramContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); type();
			setState(97); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(LCURLY);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(100); var_decl();
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << CALLOUT) | (1L << LCURLY) | (1L << ID))) != 0)) {
				{
				{
				setState(106); statement();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112); match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DecafParser.ID); }
		public TerminalNode SEMI() { return getToken(DecafParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(DecafParser.ID, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitVar_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_decl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114); type();
			setState(115); match(ID);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(116); match(COMMA);
					setState(117); match(ID);
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(123); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(DecafParser.BOOLEAN, 0); }
		public TerminalNode INT() { return getToken(DecafParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==BOOLEAN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RetstmtContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(DecafParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(DecafParser.SEMI, 0); }
		public RetstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterRetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitRetstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitRetstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForstmtContext extends StatementContext {
		public ExprContext init;
		public ExprContext cond;
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(DecafParser.COMMA, 0); }
		public TerminalNode FOR() { return getToken(DecafParser.FOR, 0); }
		public TerminalNode ASSIGNEQ() { return getToken(DecafParser.ASSIGNEQ, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterForstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitForstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitForstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfstmtContext extends StatementContext {
		public BlockContext ifs;
		public BlockContext els;
		public TerminalNode ELSE() { return getToken(DecafParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(DecafParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public IfstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitIfstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BrkstmtContext extends StatementContext {
		public TerminalNode BREAK() { return getToken(DecafParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(DecafParser.SEMI, 0); }
		public BrkstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBrkstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBrkstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitBrkstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CntstmtContext extends StatementContext {
		public TerminalNode CONTINUE() { return getToken(DecafParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(DecafParser.SEMI, 0); }
		public CntstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterCntstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitCntstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitCntstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocstmtContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(DecafParser.SEMI, 0); }
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public LocstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLocstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLocstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitLocstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MetstmtContext extends StatementContext {
		public TerminalNode SEMI() { return getToken(DecafParser.SEMI, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public MetstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMetstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMetstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlkstmtContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlkstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBlkstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBlkstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitBlkstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			setState(162);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new LocstmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127); location();
				setState(128); assign_op();
				setState(129); expr(0);
				setState(130); match(SEMI);
				}
				break;

			case 2:
				_localctx = new MetstmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(132); method_call();
				setState(133); match(SEMI);
				}
				break;

			case 3:
				_localctx = new IfstmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(135); match(IF);
				setState(136); match(LPAREN);
				setState(137); expr(0);
				setState(138); match(RPAREN);
				setState(139); ((IfstmtContext)_localctx).ifs = block();
				setState(142);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(140); match(ELSE);
					setState(141); ((IfstmtContext)_localctx).els = block();
					}
				}

				}
				break;

			case 4:
				_localctx = new ForstmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(144); match(FOR);
				setState(145); match(ID);
				setState(146); match(ASSIGNEQ);
				setState(147); ((ForstmtContext)_localctx).init = expr(0);
				setState(148); match(COMMA);
				setState(149); ((ForstmtContext)_localctx).cond = expr(0);
				setState(150); block();
				}
				break;

			case 5:
				_localctx = new RetstmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(152); match(RETURN);
				setState(154);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_LITERAL) | (1L << ID) | (1L << INT_LITERAL) | (1L << CHAR_LITERAL))) != 0)) {
					{
					setState(153); expr(0);
					}
				}

				setState(156); match(SEMI);
				}
				break;

			case 6:
				_localctx = new BrkstmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(157); match(BREAK);
				setState(158); match(SEMI);
				}
				break;

			case 7:
				_localctx = new CntstmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(159); match(CONTINUE);
				setState(160); match(SEMI);
				}
				break;

			case 8:
				_localctx = new BlkstmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(161); block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_opContext extends ParserRuleContext {
		public TerminalNode ASSIGNMINUSEQ() { return getToken(DecafParser.ASSIGNMINUSEQ, 0); }
		public TerminalNode ASSIGNEQ() { return getToken(DecafParser.ASSIGNEQ, 0); }
		public TerminalNode ASSIGNPLUSEQ() { return getToken(DecafParser.ASSIGNPLUSEQ, 0); }
		public Assign_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterAssign_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitAssign_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitAssign_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_opContext assign_op() throws RecognitionException {
		Assign_opContext _localctx = new Assign_opContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assign_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGNPLUSEQ) | (1L << ASSIGNMINUSEQ) | (1L << ASSIGNEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_callContext extends ParserRuleContext {
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
	 
		public Method_callContext() { }
		public void copyFrom(Method_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CalloutContext extends Method_callContext {
		public TerminalNode CALLOUT() { return getToken(DecafParser.CALLOUT, 0); }
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode STRING_LITERAL() { return getToken(DecafParser.STRING_LITERAL, 0); }
		public Callout_argContext callout_arg(int i) {
			return getRuleContext(Callout_argContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public List<Callout_argContext> callout_arg() {
			return getRuleContexts(Callout_argContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public CalloutContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterCallout(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitCallout(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitCallout(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MetcallContext extends Method_callContext {
		public Method_exprContext method_expr() {
			return getRuleContext(Method_exprContext.class,0);
		}
		public MetcallContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMetcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMetcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMetcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_method_call);
		try {
			int _alt;
			setState(178);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new MetcallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166); method_expr();
				}
				break;
			case CALLOUT:
				_localctx = new CalloutContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167); match(CALLOUT);
				setState(168); match(LPAREN);
				setState(169); match(STRING_LITERAL);
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(170); match(COMMA);
						setState(171); callout_arg();
						}
						} 
					}
					setState(176);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(177); match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Callout_argContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(DecafParser.STRING_LITERAL, 0); }
		public Callout_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callout_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterCallout_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitCallout_arg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitCallout_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Callout_argContext callout_arg() throws RecognitionException {
		Callout_argContext _localctx = new Callout_argContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_callout_arg);
		try {
			setState(182);
			switch (_input.LA(1)) {
			case LPAREN:
			case MINUS:
			case NOT:
			case BOOL_LITERAL:
			case ID:
			case INT_LITERAL:
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(180); expr(0);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(181); match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMethod_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_nameContext method_name() throws RecognitionException {
		Method_nameContext _localctx = new Method_nameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_method_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocationContext extends ParserRuleContext {
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
	 
		public LocationContext() { }
		public void copyFrom(LocationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LocarrayContext extends LocationContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode RSQUARE() { return getToken(DecafParser.RSQUARE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LSQUARE() { return getToken(DecafParser.LSQUARE, 0); }
		public LocarrayContext(LocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLocarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLocarray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitLocarray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocidContext extends LocationContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public LocidContext(LocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLocid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLocid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitLocid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_location);
		try {
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new LocidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(186); match(ID);
				}
				break;

			case 2:
				_localctx = new LocarrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(187); match(ID);
				setState(188); match(LSQUARE);
				setState(189); expr(0);
				setState(190); match(RSQUARE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public Method_nameContext method_name() {
			return getRuleContext(Method_nameContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Method_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMethod_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_exprContext method_expr() throws RecognitionException {
		Method_exprContext _localctx = new Method_exprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_method_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194); method_name();
			setState(195); match(LPAREN);
			setState(204);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_LITERAL) | (1L << ID) | (1L << INT_LITERAL) | (1L << CHAR_LITERAL))) != 0)) {
				{
				setState(196); expr(0);
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(197); match(COMMA);
						setState(198); expr(0);
						}
						} 
					}
					setState(203);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				}
			}

			setState(206); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqexprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public TerminalNode NEQ() { return getToken(DecafParser.NEQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CEQ() { return getToken(DecafParser.CEQ, 0); }
		public EqexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterEqexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitEqexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitEqexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotexprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(DecafParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterNotexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitNotexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitNotexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MetexprContext extends ExprContext {
		public Method_exprContext method_expr() {
			return getRuleContext(Method_exprContext.class,0);
		}
		public MetexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMetexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMetexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMetexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(DecafParser.MINUS, 0); }
		public MinexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMinexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMinexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMinexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AritexprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(DecafParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(DecafParser.MINUS, 0); }
		public TerminalNode MOD() { return getToken(DecafParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(DecafParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(DecafParser.MUL, 0); }
		public AritexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterAritexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitAritexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitAritexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocexprContext extends ExprContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LocexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLocexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLocexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitLocexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondexprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(DecafParser.AND, 0); }
		public TerminalNode OR() { return getToken(DecafParser.OR, 0); }
		public CondexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterCondexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitCondexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitCondexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitexprContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LitexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLitexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLitexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitLitexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public ParenexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterParenexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitParenexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitParenexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelexprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public TerminalNode LESS() { return getToken(DecafParser.LESS, 0); }
		public TerminalNode GEQ() { return getToken(DecafParser.GEQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LEQ() { return getToken(DecafParser.LEQ, 0); }
		public TerminalNode MORE() { return getToken(DecafParser.MORE, 0); }
		public RelexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterRelexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitRelexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitRelexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new MinexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(209); match(MINUS);
				setState(210); expr(7);
				}
				break;

			case 2:
				{
				_localctx = new NotexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211); match(NOT);
				setState(212); expr(6);
				}
				break;

			case 3:
				{
				_localctx = new LocexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213); location();
				}
				break;

			case 4:
				{
				_localctx = new MetexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214); method_expr();
				}
				break;

			case 5:
				{
				_localctx = new LitexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215); literal();
				}
				break;

			case 6:
				{
				_localctx = new ParenexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); match(LPAREN);
				setState(217); expr(0);
				setState(218); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(234);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new AritexprContext(new ExprContext(_parentctx, _parentState));
						((AritexprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(223);
						((AritexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((AritexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(224); ((AritexprContext)_localctx).right = expr(6);
						}
						break;

					case 2:
						{
						_localctx = new RelexprContext(new ExprContext(_parentctx, _parentState));
						((RelexprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(226);
						((RelexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << MORE) | (1L << LEQ) | (1L << GEQ))) != 0)) ) {
							((RelexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(227); ((RelexprContext)_localctx).right = expr(5);
						}
						break;

					case 3:
						{
						_localctx = new EqexprContext(new ExprContext(_parentctx, _parentState));
						((EqexprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(228);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(229);
						((EqexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==CEQ || _la==NEQ) ) {
							((EqexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(230); ((EqexprContext)_localctx).right = expr(4);
						}
						break;

					case 4:
						{
						_localctx = new CondexprContext(new ExprContext(_parentctx, _parentState));
						((CondexprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(232);
						((CondexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((CondexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(233); ((CondexprContext)_localctx).right = expr(3);
						}
						break;
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(DecafParser.BOOL_LITERAL, 0); }
		public TerminalNode INT_LITERAL() { return getToken(DecafParser.INT_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(DecafParser.CHAR_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << CHAR_LITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 5);

		case 1: return precpred(_ctx, 4);

		case 2: return precpred(_ctx, 3);

		case 3: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u00f4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\7\2\61\n\2\f\2"+
		"\16\2\64\13\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3<\n\3\f\3\16\3?\13\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6R\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\5\6^\n\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\7\bh\n\b\f\b\16\bk\13\b\3\b\7\bn\n\b\f\b\16\bq\13\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u0091\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u009d\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a5\n\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\7\r\u00af\n\r\f\r\16\r\u00b2\13\r\3\r\5\r\u00b5\n"+
		"\r\3\16\3\16\5\16\u00b9\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u00c3\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u00ca\n\21\f\21\16\21\u00cd"+
		"\13\21\5\21\u00cf\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\5\22\u00df\n\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00ed\n\22\f\22\16\22\u00f0\13\22"+
		"\3\23\3\23\3\23\n,\62=Ziz\u00b0\u00cb\3\"\24\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$\2\t\3\2\13\f\3\2\35\37\3\2\30\34\3\2 #\3\2$%\3\2&\'\5"+
		"\2))--\61\61\u0104\2&\3\2\2\2\4\67\3\2\2\2\6H\3\2\2\2\bJ\3\2\2\2\nQ\3"+
		"\2\2\2\fb\3\2\2\2\16e\3\2\2\2\20t\3\2\2\2\22\177\3\2\2\2\24\u00a4\3\2"+
		"\2\2\26\u00a6\3\2\2\2\30\u00b4\3\2\2\2\32\u00b8\3\2\2\2\34\u00ba\3\2\2"+
		"\2\36\u00c2\3\2\2\2 \u00c4\3\2\2\2\"\u00de\3\2\2\2$\u00f1\3\2\2\2&\'\7"+
		"\3\2\2\'(\7\16\2\2(,\7\17\2\2)+\5\4\3\2*)\3\2\2\2+.\3\2\2\2,-\3\2\2\2"+
		",*\3\2\2\2-\62\3\2\2\2.,\3\2\2\2/\61\5\n\6\2\60/\3\2\2\2\61\64\3\2\2\2"+
		"\62\63\3\2\2\2\62\60\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7\20\2"+
		"\2\66\3\3\2\2\2\678\5\22\n\28=\5\6\4\29:\7\26\2\2:<\5\6\4\2;9\3\2\2\2"+
		"<?\3\2\2\2=>\3\2\2\2=;\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\27\2\2A\5\3\2\2"+
		"\2BI\7,\2\2CD\7,\2\2DE\7\23\2\2EF\7-\2\2FI\7\24\2\2GI\5\b\5\2HB\3\2\2"+
		"\2HC\3\2\2\2HG\3\2\2\2I\7\3\2\2\2JK\5\36\20\2KL\5\26\f\2LM\5\"\22\2MN"+
		"\b\5\1\2N\t\3\2\2\2OR\5\22\n\2PR\7\r\2\2QO\3\2\2\2QP\3\2\2\2RS\3\2\2\2"+
		"ST\7,\2\2T]\7\21\2\2UZ\5\f\7\2VW\7\26\2\2WY\5\f\7\2XV\3\2\2\2Y\\\3\2\2"+
		"\2Z[\3\2\2\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2]U\3\2\2\2]^\3\2\2\2^_\3\2"+
		"\2\2_`\7\22\2\2`a\5\16\b\2a\13\3\2\2\2bc\5\22\n\2cd\7,\2\2d\r\3\2\2\2"+
		"ei\7\17\2\2fh\5\20\t\2gf\3\2\2\2hk\3\2\2\2ij\3\2\2\2ig\3\2\2\2jo\3\2\2"+
		"\2ki\3\2\2\2ln\5\24\13\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2"+
		"\2\2qo\3\2\2\2rs\7\20\2\2s\17\3\2\2\2tu\5\22\n\2uz\7,\2\2vw\7\26\2\2w"+
		"y\7,\2\2xv\3\2\2\2y|\3\2\2\2z{\3\2\2\2zx\3\2\2\2{}\3\2\2\2|z\3\2\2\2}"+
		"~\7\27\2\2~\21\3\2\2\2\177\u0080\t\2\2\2\u0080\23\3\2\2\2\u0081\u0082"+
		"\5\36\20\2\u0082\u0083\5\26\f\2\u0083\u0084\5\"\22\2\u0084\u0085\7\27"+
		"\2\2\u0085\u00a5\3\2\2\2\u0086\u0087\5\30\r\2\u0087\u0088\7\27\2\2\u0088"+
		"\u00a5\3\2\2\2\u0089\u008a\7\4\2\2\u008a\u008b\7\21\2\2\u008b\u008c\5"+
		"\"\22\2\u008c\u008d\7\22\2\2\u008d\u0090\5\16\b\2\u008e\u008f\7\5\2\2"+
		"\u008f\u0091\5\16\b\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u00a5"+
		"\3\2\2\2\u0092\u0093\7\6\2\2\u0093\u0094\7,\2\2\u0094\u0095\7\37\2\2\u0095"+
		"\u0096\5\"\22\2\u0096\u0097\7\26\2\2\u0097\u0098\5\"\22\2\u0098\u0099"+
		"\5\16\b\2\u0099\u00a5\3\2\2\2\u009a\u009c\7\7\2\2\u009b\u009d\5\"\22\2"+
		"\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a5"+
		"\7\27\2\2\u009f\u00a0\7\b\2\2\u00a0\u00a5\7\27\2\2\u00a1\u00a2\7\t\2\2"+
		"\u00a2\u00a5\7\27\2\2\u00a3\u00a5\5\16\b\2\u00a4\u0081\3\2\2\2\u00a4\u0086"+
		"\3\2\2\2\u00a4\u0089\3\2\2\2\u00a4\u0092\3\2\2\2\u00a4\u009a\3\2\2\2\u00a4"+
		"\u009f\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\25\3\2\2"+
		"\2\u00a6\u00a7\t\3\2\2\u00a7\27\3\2\2\2\u00a8\u00b5\5 \21\2\u00a9\u00aa"+
		"\7\n\2\2\u00aa\u00ab\7\21\2\2\u00ab\u00b0\7\60\2\2\u00ac\u00ad\7\26\2"+
		"\2\u00ad\u00af\5\32\16\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b3\u00b5\7\22\2\2\u00b4\u00a8\3\2\2\2\u00b4\u00a9\3\2\2\2\u00b5"+
		"\31\3\2\2\2\u00b6\u00b9\5\"\22\2\u00b7\u00b9\7\60\2\2\u00b8\u00b6\3\2"+
		"\2\2\u00b8\u00b7\3\2\2\2\u00b9\33\3\2\2\2\u00ba\u00bb\7,\2\2\u00bb\35"+
		"\3\2\2\2\u00bc\u00c3\7,\2\2\u00bd\u00be\7,\2\2\u00be\u00bf\7\23\2\2\u00bf"+
		"\u00c0\5\"\22\2\u00c0\u00c1\7\24\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00bc\3"+
		"\2\2\2\u00c2\u00bd\3\2\2\2\u00c3\37\3\2\2\2\u00c4\u00c5\5\34\17\2\u00c5"+
		"\u00ce\7\21\2\2\u00c6\u00cb\5\"\22\2\u00c7\u00c8\7\26\2\2\u00c8\u00ca"+
		"\5\"\22\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00cc\3\2\2\2"+
		"\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00c6"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\7\22\2\2"+
		"\u00d1!\3\2\2\2\u00d2\u00d3\b\22\1\2\u00d3\u00d4\7\31\2\2\u00d4\u00df"+
		"\5\"\22\t\u00d5\u00d6\7(\2\2\u00d6\u00df\5\"\22\b\u00d7\u00df\5\36\20"+
		"\2\u00d8\u00df\5 \21\2\u00d9\u00df\5$\23\2\u00da\u00db\7\21\2\2\u00db"+
		"\u00dc\5\"\22\2\u00dc\u00dd\7\22\2\2\u00dd\u00df\3\2\2\2\u00de\u00d2\3"+
		"\2\2\2\u00de\u00d5\3\2\2\2\u00de\u00d7\3\2\2\2\u00de\u00d8\3\2\2\2\u00de"+
		"\u00d9\3\2\2\2\u00de\u00da\3\2\2\2\u00df\u00ee\3\2\2\2\u00e0\u00e1\f\7"+
		"\2\2\u00e1\u00e2\t\4\2\2\u00e2\u00ed\5\"\22\b\u00e3\u00e4\f\6\2\2\u00e4"+
		"\u00e5\t\5\2\2\u00e5\u00ed\5\"\22\7\u00e6\u00e7\f\5\2\2\u00e7\u00e8\t"+
		"\6\2\2\u00e8\u00ed\5\"\22\6\u00e9\u00ea\f\4\2\2\u00ea\u00eb\t\7\2\2\u00eb"+
		"\u00ed\5\"\22\5\u00ec\u00e0\3\2\2\2\u00ec\u00e3\3\2\2\2\u00ec\u00e6\3"+
		"\2\2\2\u00ec\u00e9\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef#\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\t\b\2\2"+
		"\u00f2%\3\2\2\2\30,\62=HQZ]ioz\u0090\u009c\u00a4\u00b0\u00b4\u00b8\u00c2"+
		"\u00cb\u00ce\u00de\u00ec\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}