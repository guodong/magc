// Generated from Magellan.g4 by ANTLR 4.7.2

    package frontend.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MagellanParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, Id=21, StringLiteral=22, WS=23, COMMENT=24, 
		LINE_COMMENT=25;
	public static final int
		RULE_program = 0, RULE_classDef = 1, RULE_classDefBlock = 2, RULE_varDef = 3, 
		RULE_type = 4, RULE_pathCtlDef = 5, RULE_funcArgs = 6, RULE_funcArg = 7, 
		RULE_block = 8, RULE_stmt = 9, RULE_ifStmt = 10, RULE_expr = 11, RULE_attr = 12, 
		RULE_anonymousFunc = 13, RULE_threadDef = 14, RULE_threadBody = 15, RULE_threadItem = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classDef", "classDefBlock", "varDef", "type", "pathCtlDef", 
			"funcArgs", "funcArg", "block", "stmt", "ifStmt", "expr", "attr", "anonymousFunc", 
			"threadDef", "threadBody", "threadItem"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'('", "','", "')'", "'{'", "'}'", "':'", "'['", "']'", 
			"'path_control'", "'in'", "'out'", "'='", "'if'", "'else'", "'.'", "'=>'", 
			"'threads'", "'ingestion'", "'program'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Id", "StringLiteral", 
			"WS", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Magellan.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MagellanParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public List<PathCtlDefContext> pathCtlDef() {
			return getRuleContexts(PathCtlDefContext.class);
		}
		public PathCtlDefContext pathCtlDef(int i) {
			return getRuleContext(PathCtlDefContext.class,i);
		}
		public List<ThreadDefContext> threadDef() {
			return getRuleContexts(ThreadDefContext.class);
		}
		public ThreadDefContext threadDef(int i) {
			return getRuleContext(ThreadDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__9) | (1L << T__17))) != 0)) {
				{
				setState(37);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(34);
					classDef();
					}
					break;
				case T__9:
					{
					setState(35);
					pathCtlDef();
					}
					break;
				case T__17:
					{
					setState(36);
					threadDef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MagellanParser.Id, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public ClassDefBlockContext classDefBlock() {
			return getRuleContext(ClassDefBlockContext.class,0);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDef);
		int _la;
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(T__0);
				setState(43);
				match(Id);
				setState(44);
				match(T__1);
				setState(45);
				varDef();
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(46);
					match(T__2);
					setState(47);
					varDef();
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(53);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(T__0);
				setState(56);
				match(Id);
				setState(57);
				match(T__1);
				setState(58);
				varDef();
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(59);
					match(T__2);
					setState(60);
					varDef();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66);
				match(T__3);
				setState(67);
				classDefBlock();
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

	public static class ClassDefBlockContext extends ParserRuleContext {
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public ClassDefBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitClassDefBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefBlockContext classDefBlock() throws RecognitionException {
		ClassDefBlockContext _localctx = new ClassDefBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDefBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__4);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Id) {
				{
				{
				setState(72);
				varDef();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(T__5);
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

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MagellanParser.Id, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(Id);
			setState(81);
			match(T__6);
			setState(82);
			type();
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
		public TerminalNode Id() { return getToken(MagellanParser.Id, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(Id);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(Id);
				setState(86);
				match(T__7);
				setState(87);
				type();
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(88);
					match(T__2);
					setState(89);
					type();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(T__8);
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

	public static class PathCtlDefContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MagellanParser.Id, 0); }
		public FuncArgsContext funcArgs() {
			return getRuleContext(FuncArgsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public PathCtlDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathCtlDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitPathCtlDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathCtlDefContext pathCtlDef() throws RecognitionException {
		PathCtlDefContext _localctx = new PathCtlDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pathCtlDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__9);
			setState(100);
			match(Id);
			setState(101);
			match(T__1);
			setState(102);
			funcArgs();
			setState(103);
			match(T__3);
			setState(104);
			block();
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

	public static class FuncArgsContext extends ParserRuleContext {
		public List<FuncArgContext> funcArg() {
			return getRuleContexts(FuncArgContext.class);
		}
		public FuncArgContext funcArg(int i) {
			return getRuleContext(FuncArgContext.class,i);
		}
		public FuncArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitFuncArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgsContext funcArgs() throws RecognitionException {
		FuncArgsContext _localctx = new FuncArgsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			funcArg();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(107);
				match(T__2);
				setState(108);
				funcArg();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class FuncArgContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MagellanParser.Id, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitFuncArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgContext funcArg() throws RecognitionException {
		FuncArgContext _localctx = new FuncArgContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10 || _la==T__11) {
				{
				setState(114);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(117);
			match(Id);
			setState(118);
			match(T__6);
			setState(119);
			type();
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
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__4);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13 || _la==Id) {
				{
				{
				setState(122);
				stmt();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(T__5);
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

	public static class StmtContext extends ParserRuleContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stmt);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				varDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				varDef();
				setState(132);
				match(T__12);
				setState(133);
				expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				expr();
				setState(136);
				match(T__12);
				setState(137);
				expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				ifStmt();
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

	public static class IfStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<IfStmtContext> ifStmt() {
			return getRuleContexts(IfStmtContext.class);
		}
		public IfStmtContext ifStmt(int i) {
			return getRuleContext(IfStmtContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__13);
			setState(143);
			match(T__1);
			setState(144);
			expr();
			setState(145);
			match(T__3);
			setState(146);
			block();
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(147);
					match(T__14);
					setState(148);
					ifStmt();
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(154);
				match(T__14);
				setState(155);
				block();
				}
				break;
			}
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
		public AttrContext attr() {
			return getRuleContext(AttrContext.class,0);
		}
		public AnonymousFuncContext anonymousFunc() {
			return getRuleContext(AnonymousFuncContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				attr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				attr();
				setState(160);
				match(T__1);
				setState(161);
				anonymousFunc();
				setState(162);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				attr();
				setState(165);
				match(T__1);
				setState(166);
				expr();
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(167);
					match(T__2);
					setState(168);
					expr();
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(174);
				match(T__3);
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

	public static class AttrContext extends ParserRuleContext {
		public List<TerminalNode> Id() { return getTokens(MagellanParser.Id); }
		public TerminalNode Id(int i) {
			return getToken(MagellanParser.Id, i);
		}
		public AttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(Id);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(179);
				match(T__15);
				setState(180);
				match(Id);
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class AnonymousFuncContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MagellanParser.Id, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AnonymousFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousFunc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitAnonymousFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnonymousFuncContext anonymousFunc() throws RecognitionException {
		AnonymousFuncContext _localctx = new AnonymousFuncContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_anonymousFunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(Id);
			setState(187);
			match(T__16);
			setState(188);
			expr();
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

	public static class ThreadDefContext extends ParserRuleContext {
		public ThreadBodyContext threadBody() {
			return getRuleContext(ThreadBodyContext.class,0);
		}
		public ThreadDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_threadDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitThreadDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThreadDefContext threadDef() throws RecognitionException {
		ThreadDefContext _localctx = new ThreadDefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_threadDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__17);
			setState(191);
			match(T__4);
			setState(192);
			threadBody();
			setState(193);
			match(T__5);
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

	public static class ThreadBodyContext extends ParserRuleContext {
		public List<ThreadItemContext> threadItem() {
			return getRuleContexts(ThreadItemContext.class);
		}
		public ThreadItemContext threadItem(int i) {
			return getRuleContext(ThreadItemContext.class,i);
		}
		public ThreadBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_threadBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitThreadBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThreadBodyContext threadBody() throws RecognitionException {
		ThreadBodyContext _localctx = new ThreadBodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_threadBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			threadItem();
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(196);
				match(T__2);
				setState(197);
				threadItem();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ThreadItemContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(MagellanParser.StringLiteral, 0); }
		public TerminalNode Id() { return getToken(MagellanParser.Id, 0); }
		public ThreadItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_threadItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagellanVisitor ) return ((MagellanVisitor<? extends T>)visitor).visitThreadItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThreadItemContext threadItem() throws RecognitionException {
		ThreadItemContext _localctx = new ThreadItemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_threadItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__18);
			setState(204);
			match(T__12);
			setState(205);
			match(StringLiteral);
			setState(206);
			match(T__16);
			setState(207);
			match(T__19);
			setState(208);
			match(T__12);
			setState(209);
			match(Id);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00d6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\63\n"+
		"\3\f\3\16\3\66\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3@\n\3\f\3\16\3"+
		"C\13\3\3\3\3\3\3\3\5\3H\n\3\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6]\n\6\f\6\16\6`\13\6\3\6\3\6"+
		"\5\6d\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7\bp\n\b\f\b\16\bs\13"+
		"\b\3\t\5\tv\n\t\3\t\3\t\3\t\3\t\3\n\3\n\7\n~\n\n\f\n\16\n\u0081\13\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008f\n"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0098\n\f\f\f\16\f\u009b\13\f\3\f"+
		"\3\f\5\f\u009f\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ac"+
		"\n\r\f\r\16\r\u00af\13\r\3\r\3\r\5\r\u00b3\n\r\3\16\3\16\3\16\7\16\u00b8"+
		"\n\16\f\16\16\16\u00bb\13\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\7\21\u00c9\n\21\f\21\16\21\u00cc\13\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"\2\3\3\2\r\16\2\u00da\2)\3\2\2\2\4G\3\2\2\2\6I\3\2\2\2\bR"+
		"\3\2\2\2\nc\3\2\2\2\fe\3\2\2\2\16l\3\2\2\2\20u\3\2\2\2\22{\3\2\2\2\24"+
		"\u008e\3\2\2\2\26\u0090\3\2\2\2\30\u00b2\3\2\2\2\32\u00b4\3\2\2\2\34\u00bc"+
		"\3\2\2\2\36\u00c0\3\2\2\2 \u00c5\3\2\2\2\"\u00cd\3\2\2\2$(\5\4\3\2%(\5"+
		"\f\7\2&(\5\36\20\2\'$\3\2\2\2\'%\3\2\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2"+
		"\2)*\3\2\2\2*\3\3\2\2\2+)\3\2\2\2,-\7\3\2\2-.\7\27\2\2./\7\4\2\2/\64\5"+
		"\b\5\2\60\61\7\5\2\2\61\63\5\b\5\2\62\60\3\2\2\2\63\66\3\2\2\2\64\62\3"+
		"\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7\6\2\28H\3\2\2\2"+
		"9:\7\3\2\2:;\7\27\2\2;<\7\4\2\2<A\5\b\5\2=>\7\5\2\2>@\5\b\5\2?=\3\2\2"+
		"\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\6\2\2EF\5\6\4"+
		"\2FH\3\2\2\2G,\3\2\2\2G9\3\2\2\2H\5\3\2\2\2IM\7\7\2\2JL\5\b\5\2KJ\3\2"+
		"\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\b\2\2Q\7\3"+
		"\2\2\2RS\7\27\2\2ST\7\t\2\2TU\5\n\6\2U\t\3\2\2\2Vd\7\27\2\2WX\7\27\2\2"+
		"XY\7\n\2\2Y^\5\n\6\2Z[\7\5\2\2[]\5\n\6\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2"+
		"\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7\13\2\2bd\3\2\2\2cV\3\2\2\2cW\3\2"+
		"\2\2d\13\3\2\2\2ef\7\f\2\2fg\7\27\2\2gh\7\4\2\2hi\5\16\b\2ij\7\6\2\2j"+
		"k\5\22\n\2k\r\3\2\2\2lq\5\20\t\2mn\7\5\2\2np\5\20\t\2om\3\2\2\2ps\3\2"+
		"\2\2qo\3\2\2\2qr\3\2\2\2r\17\3\2\2\2sq\3\2\2\2tv\t\2\2\2ut\3\2\2\2uv\3"+
		"\2\2\2vw\3\2\2\2wx\7\27\2\2xy\7\t\2\2yz\5\n\6\2z\21\3\2\2\2{\177\7\7\2"+
		"\2|~\5\24\13\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2"+
		"\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7\b\2\2\u0083\23\3"+
		"\2\2\2\u0084\u008f\5\b\5\2\u0085\u0086\5\b\5\2\u0086\u0087\7\17\2\2\u0087"+
		"\u0088\5\30\r\2\u0088\u008f\3\2\2\2\u0089\u008a\5\30\r\2\u008a\u008b\7"+
		"\17\2\2\u008b\u008c\5\30\r\2\u008c\u008f\3\2\2\2\u008d\u008f\5\26\f\2"+
		"\u008e\u0084\3\2\2\2\u008e\u0085\3\2\2\2\u008e\u0089\3\2\2\2\u008e\u008d"+
		"\3\2\2\2\u008f\25\3\2\2\2\u0090\u0091\7\20\2\2\u0091\u0092\7\4\2\2\u0092"+
		"\u0093\5\30\r\2\u0093\u0094\7\6\2\2\u0094\u0099\5\22\n\2\u0095\u0096\7"+
		"\21\2\2\u0096\u0098\5\26\f\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009e\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009c\u009d\7\21\2\2\u009d\u009f\5\22\n\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\27\3\2\2\2\u00a0\u00b3\5\32\16\2\u00a1\u00a2\5\32"+
		"\16\2\u00a2\u00a3\7\4\2\2\u00a3\u00a4\5\34\17\2\u00a4\u00a5\7\6\2\2\u00a5"+
		"\u00b3\3\2\2\2\u00a6\u00a7\5\32\16\2\u00a7\u00a8\7\4\2\2\u00a8\u00ad\5"+
		"\30\r\2\u00a9\u00aa\7\5\2\2\u00aa\u00ac\5\30\r\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7\6\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00a0\3\2\2\2\u00b2\u00a1\3\2\2\2\u00b2\u00a6\3\2\2\2\u00b3\31\3\2\2"+
		"\2\u00b4\u00b9\7\27\2\2\u00b5\u00b6\7\22\2\2\u00b6\u00b8\7\27\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\33\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7\27\2\2\u00bd\u00be"+
		"\7\23\2\2\u00be\u00bf\5\30\r\2\u00bf\35\3\2\2\2\u00c0\u00c1\7\24\2\2\u00c1"+
		"\u00c2\7\7\2\2\u00c2\u00c3\5 \21\2\u00c3\u00c4\7\b\2\2\u00c4\37\3\2\2"+
		"\2\u00c5\u00ca\5\"\22\2\u00c6\u00c7\7\5\2\2\u00c7\u00c9\5\"\22\2\u00c8"+
		"\u00c6\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb!\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7\25\2\2\u00ce\u00cf"+
		"\7\17\2\2\u00cf\u00d0\7\30\2\2\u00d0\u00d1\7\23\2\2\u00d1\u00d2\7\26\2"+
		"\2\u00d2\u00d3\7\17\2\2\u00d3\u00d4\7\27\2\2\u00d4#\3\2\2\2\24\')\64A"+
		"GM^cqu\177\u008e\u0099\u009e\u00ad\u00b2\u00b9\u00ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}