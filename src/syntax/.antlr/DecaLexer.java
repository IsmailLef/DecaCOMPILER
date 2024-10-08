// Generated from /Users/macbookpro/ensimag/GL/Projet_GL/src/main/antlr4/fr/ensimag/deca/syntax/DecaLexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecaLexer extends AbstractDecaLexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CR=1, EOL=2, TAB=3, AT=4, ASM=5, INSTANCEOF=6, PRINTLN=7, TRUE=8, CLASS=9, 
		NEW=10, PRINTLNX=11, WHILE=12, EXTENDS=13, NULL=14, PRINTX=15, ELSE=16, 
		READINT=17, PROTECTED=18, FALSE=19, READFLOAT=20, RETURN=21, IF=22, PRINT=23, 
		THIS=24, IDENT=25, GT=26, LT=27, EQUALS=28, PLUS=29, MINUS=30, TIMES=31, 
		SLASH=32, PERCENT=33, DOT=34, COMMA=35, OPARENT=36, CPARENT=37, OBRACE=38, 
		CBRACE=39, EXCLAM=40, COLON=41, SEMI=42, EQEQ=43, NEQ=44, GEQ=45, LEQ=46, 
		AND=47, OR=48, INT=49, NUM=50, FLOAT=51, STRING=52, MULTI_LINE_STRING=53, 
		COMMENT=54, SPACE=55, INCLUDE=56;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CR", "EOL", "TAB", "AT", "ASM", "INSTANCEOF", "PRINTLN", "TRUE", "CLASS", 
			"NEW", "PRINTLNX", "WHILE", "EXTENDS", "NULL", "PRINTX", "ELSE", "READINT", 
			"PROTECTED", "FALSE", "READFLOAT", "RETURN", "IF", "PRINT", "THIS", "LETTER", 
			"DIGIT", "IDENT", "GT", "LT", "EQUALS", "PLUS", "MINUS", "TIMES", "SLASH", 
			"PERCENT", "DOT", "COMMA", "OPARENT", "CPARENT", "OBRACE", "CBRACE", 
			"EXCLAM", "COLON", "SEMI", "EQEQ", "NEQ", "GEQ", "LEQ", "AND", "OR", 
			"POSITIVE_DIGIT", "INT", "NUM", "SIGN", "EXP", "DEC", "FLOATDEC", "DIGITHEX", 
			"NUMHEX", "FLOATHEX", "FLOAT", "STRING_CAR", "STRING", "MULTI_LINE_STRING", 
			"COMMENT", "SPACE", "FILENAME", "INCLUDE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\r'", "'\n'", "'\t'", "'@'", "'asm'", "'instanceof'", "'println'", 
			"'true'", "'class'", "'new'", "'printlnx'", "'while'", "'extends'", "'null'", 
			"'printx'", "'else'", "'readInt'", "'protected'", "'false'", "'readFloat'", 
			"'return'", "'if'", "'print'", "'this'", null, "'>'", "'<'", "'='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'.'", "','", "'('", "')'", "'{'", "'}'", 
			"'!'", "':'", "';'", "'=='", "'!='", "'>='", "'<='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CR", "EOL", "TAB", "AT", "ASM", "INSTANCEOF", "PRINTLN", "TRUE", 
			"CLASS", "NEW", "PRINTLNX", "WHILE", "EXTENDS", "NULL", "PRINTX", "ELSE", 
			"READINT", "PROTECTED", "FALSE", "READFLOAT", "RETURN", "IF", "PRINT", 
			"THIS", "IDENT", "GT", "LT", "EQUALS", "PLUS", "MINUS", "TIMES", "SLASH", 
			"PERCENT", "DOT", "COMMA", "OPARENT", "CPARENT", "OBRACE", "CBRACE", 
			"EXCLAM", "COLON", "SEMI", "EQEQ", "NEQ", "GEQ", "LEQ", "AND", "OR", 
			"INT", "NUM", "FLOAT", "STRING", "MULTI_LINE_STRING", "COMMENT", "SPACE", 
			"INCLUDE"
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




	public DecaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DecaLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			CR_action((RuleContext)_localctx, actionIndex);
			break;
		case 1:
			EOL_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 64:
			COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 65:
			SPACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 67:
			INCLUDE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void CR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void EOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}
	private void TAB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			skip();
			break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			skip();
			break;
		}
	}
	private void SPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			skip();
			break;
		}
	}
	private void INCLUDE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			doInclude(getText());
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u01f4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\5\34\u0122\n\34\3\34\3\34\3\34"+
		"\7\34\u0127\n\34\f\34\16\34\u012a\13\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\65\7\65\u0165\n\65"+
		"\f\65\16\65\u0168\13\65\5\65\u016a\n\65\3\66\6\66\u016d\n\66\r\66\16\66"+
		"\u016e\3\67\5\67\u0172\n\67\38\38\38\38\39\39\39\39\3:\3:\3:\3:\5:\u0180"+
		"\n:\3:\5:\u0183\n:\3;\3;\3<\6<\u0188\n<\r<\16<\u0189\3=\3=\3=\3=\5=\u0190"+
		"\n=\3=\3=\3=\3=\3=\3=\3=\5=\u0199\n=\3>\3>\5>\u019d\n>\3?\3?\3@\3@\3@"+
		"\3@\3@\3@\7@\u01a7\n@\f@\16@\u01aa\13@\3@\3@\3A\3A\3A\3A\3A\7A\u01b3\n"+
		"A\fA\16A\u01b6\13A\3A\3A\3B\3B\3B\3B\7B\u01be\nB\fB\16B\u01c1\13B\3B\3"+
		"B\3B\3B\3B\3B\7B\u01c9\nB\fB\16B\u01cc\13B\3B\5B\u01cf\nB\3B\3B\3C\6C"+
		"\u01d4\nC\rC\16C\u01d5\3C\3C\3D\3D\3D\6D\u01dd\nD\rD\16D\u01de\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\7E\u01eb\nE\fE\16E\u01ee\13E\3E\3E\3E\3E\3E\4\u01bf"+
		"\u01ca\2F\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\2\67\33"+
		"9\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]._/a\60c\61e\62g\2i\63"+
		"k\64m\2o\2q\2s\2u\2w\2y\2{\65}\2\177\66\u0081\67\u00838\u00859\u0087\2"+
		"\u0089:\3\2\f\4\2C\\c|\4\2&&aa\4\2--//\4\2GGgg\4\2HHhh\5\2\62;CHch\4\2"+
		"RRrr\5\2\f\f$$^^\4\2\f\f^^\4\2/\60aa\2\u0203\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\67\3\2\2"+
		"\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2"+
		"E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3"+
		"\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2"+
		"\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"{\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2"+
		"\2\2\u0089\3\2\2\2\3\u008b\3\2\2\2\5\u008e\3\2\2\2\7\u0091\3\2\2\2\t\u0094"+
		"\3\2\2\2\13\u0096\3\2\2\2\r\u009a\3\2\2\2\17\u00a5\3\2\2\2\21\u00ad\3"+
		"\2\2\2\23\u00b2\3\2\2\2\25\u00b8\3\2\2\2\27\u00bc\3\2\2\2\31\u00c5\3\2"+
		"\2\2\33\u00cb\3\2\2\2\35\u00d3\3\2\2\2\37\u00d8\3\2\2\2!\u00df\3\2\2\2"+
		"#\u00e4\3\2\2\2%\u00ec\3\2\2\2\'\u00f6\3\2\2\2)\u00fc\3\2\2\2+\u0106\3"+
		"\2\2\2-\u010d\3\2\2\2/\u0110\3\2\2\2\61\u0116\3\2\2\2\63\u011b\3\2\2\2"+
		"\65\u011d\3\2\2\2\67\u0121\3\2\2\29\u012b\3\2\2\2;\u012d\3\2\2\2=\u012f"+
		"\3\2\2\2?\u0131\3\2\2\2A\u0133\3\2\2\2C\u0135\3\2\2\2E\u0137\3\2\2\2G"+
		"\u0139\3\2\2\2I\u013b\3\2\2\2K\u013d\3\2\2\2M\u013f\3\2\2\2O\u0141\3\2"+
		"\2\2Q\u0143\3\2\2\2S\u0145\3\2\2\2U\u0147\3\2\2\2W\u0149\3\2\2\2Y\u014b"+
		"\3\2\2\2[\u014d\3\2\2\2]\u0150\3\2\2\2_\u0153\3\2\2\2a\u0156\3\2\2\2c"+
		"\u0159\3\2\2\2e\u015c\3\2\2\2g\u015f\3\2\2\2i\u0169\3\2\2\2k\u016c\3\2"+
		"\2\2m\u0171\3\2\2\2o\u0173\3\2\2\2q\u0177\3\2\2\2s\u017f\3\2\2\2u\u0184"+
		"\3\2\2\2w\u0187\3\2\2\2y\u018f\3\2\2\2{\u019c\3\2\2\2}\u019e\3\2\2\2\177"+
		"\u01a0\3\2\2\2\u0081\u01ad\3\2\2\2\u0083\u01ce\3\2\2\2\u0085\u01d3\3\2"+
		"\2\2\u0087\u01dc\3\2\2\2\u0089\u01e0\3\2\2\2\u008b\u008c\7\17\2\2\u008c"+
		"\u008d\b\2\2\2\u008d\4\3\2\2\2\u008e\u008f\7\f\2\2\u008f\u0090\b\3\3\2"+
		"\u0090\6\3\2\2\2\u0091\u0092\7\13\2\2\u0092\u0093\b\4\4\2\u0093\b\3\2"+
		"\2\2\u0094\u0095\7B\2\2\u0095\n\3\2\2\2\u0096\u0097\7c\2\2\u0097\u0098"+
		"\7u\2\2\u0098\u0099\7o\2\2\u0099\f\3\2\2\2\u009a\u009b\7k\2\2\u009b\u009c"+
		"\7p\2\2\u009c\u009d\7u\2\2\u009d\u009e\7v\2\2\u009e\u009f\7c\2\2\u009f"+
		"\u00a0\7p\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7q\2\2"+
		"\u00a3\u00a4\7h\2\2\u00a4\16\3\2\2\2\u00a5\u00a6\7r\2\2\u00a6\u00a7\7"+
		"t\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab"+
		"\7n\2\2\u00ab\u00ac\7p\2\2\u00ac\20\3\2\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af"+
		"\7t\2\2\u00af\u00b0\7w\2\2\u00b0\u00b1\7g\2\2\u00b1\22\3\2\2\2\u00b2\u00b3"+
		"\7e\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7u\2\2\u00b6"+
		"\u00b7\7u\2\2\u00b7\24\3\2\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7g\2\2\u00ba"+
		"\u00bb\7y\2\2\u00bb\26\3\2\2\2\u00bc\u00bd\7r\2\2\u00bd\u00be\7t\2\2\u00be"+
		"\u00bf\7k\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7n\2\2"+
		"\u00c2\u00c3\7p\2\2\u00c3\u00c4\7z\2\2\u00c4\30\3\2\2\2\u00c5\u00c6\7"+
		"y\2\2\u00c6\u00c7\7j\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca"+
		"\7g\2\2\u00ca\32\3\2\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7z\2\2\u00cd\u00ce"+
		"\7v\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7f\2\2\u00d1"+
		"\u00d2\7u\2\2\u00d2\34\3\2\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7w\2\2\u00d5"+
		"\u00d6\7n\2\2\u00d6\u00d7\7n\2\2\u00d7\36\3\2\2\2\u00d8\u00d9\7r\2\2\u00d9"+
		"\u00da\7t\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7p\2\2\u00dc\u00dd\7v\2\2"+
		"\u00dd\u00de\7z\2\2\u00de \3\2\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7n\2"+
		"\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7g\2\2\u00e3\"\3\2\2\2\u00e4\u00e5\7"+
		"t\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7f\2\2\u00e8\u00e9"+
		"\7K\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb\7v\2\2\u00eb$\3\2\2\2\u00ec\u00ed"+
		"\7r\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0\7v\2\2\u00f0"+
		"\u00f1\7g\2\2\u00f1\u00f2\7e\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7g\2\2"+
		"\u00f4\u00f5\7f\2\2\u00f5&\3\2\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7c\2"+
		"\2\u00f8\u00f9\7n\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7g\2\2\u00fb(\3\2"+
		"\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100"+
		"\7f\2\2\u0100\u0101\7H\2\2\u0101\u0102\7n\2\2\u0102\u0103\7q\2\2\u0103"+
		"\u0104\7c\2\2\u0104\u0105\7v\2\2\u0105*\3\2\2\2\u0106\u0107\7t\2\2\u0107"+
		"\u0108\7g\2\2\u0108\u0109\7v\2\2\u0109\u010a\7w\2\2\u010a\u010b\7t\2\2"+
		"\u010b\u010c\7p\2\2\u010c,\3\2\2\2\u010d\u010e\7k\2\2\u010e\u010f\7h\2"+
		"\2\u010f.\3\2\2\2\u0110\u0111\7r\2\2\u0111\u0112\7t\2\2\u0112\u0113\7"+
		"k\2\2\u0113\u0114\7p\2\2\u0114\u0115\7v\2\2\u0115\60\3\2\2\2\u0116\u0117"+
		"\7v\2\2\u0117\u0118\7j\2\2\u0118\u0119\7k\2\2\u0119\u011a\7u\2\2\u011a"+
		"\62\3\2\2\2\u011b\u011c\t\2\2\2\u011c\64\3\2\2\2\u011d\u011e\4\62;\2\u011e"+
		"\66\3\2\2\2\u011f\u0122\5\63\32\2\u0120\u0122\t\3\2\2\u0121\u011f\3\2"+
		"\2\2\u0121\u0120\3\2\2\2\u0122\u0128\3\2\2\2\u0123\u0127\5\63\32\2\u0124"+
		"\u0127\5\65\33\2\u0125\u0127\t\3\2\2\u0126\u0123\3\2\2\2\u0126\u0124\3"+
		"\2\2\2\u0126\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u01298\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c\7@\2\2\u012c"+
		":\3\2\2\2\u012d\u012e\7>\2\2\u012e<\3\2\2\2\u012f\u0130\7?\2\2\u0130>"+
		"\3\2\2\2\u0131\u0132\7-\2\2\u0132@\3\2\2\2\u0133\u0134\7/\2\2\u0134B\3"+
		"\2\2\2\u0135\u0136\7,\2\2\u0136D\3\2\2\2\u0137\u0138\7\61\2\2\u0138F\3"+
		"\2\2\2\u0139\u013a\7\'\2\2\u013aH\3\2\2\2\u013b\u013c\7\60\2\2\u013cJ"+
		"\3\2\2\2\u013d\u013e\7.\2\2\u013eL\3\2\2\2\u013f\u0140\7*\2\2\u0140N\3"+
		"\2\2\2\u0141\u0142\7+\2\2\u0142P\3\2\2\2\u0143\u0144\7}\2\2\u0144R\3\2"+
		"\2\2\u0145\u0146\7\177\2\2\u0146T\3\2\2\2\u0147\u0148\7#\2\2\u0148V\3"+
		"\2\2\2\u0149\u014a\7<\2\2\u014aX\3\2\2\2\u014b\u014c\7=\2\2\u014cZ\3\2"+
		"\2\2\u014d\u014e\7?\2\2\u014e\u014f\7?\2\2\u014f\\\3\2\2\2\u0150\u0151"+
		"\7#\2\2\u0151\u0152\7?\2\2\u0152^\3\2\2\2\u0153\u0154\7@\2\2\u0154\u0155"+
		"\7?\2\2\u0155`\3\2\2\2\u0156\u0157\7>\2\2\u0157\u0158\7?\2\2\u0158b\3"+
		"\2\2\2\u0159\u015a\7(\2\2\u015a\u015b\7(\2\2\u015bd\3\2\2\2\u015c\u015d"+
		"\7~\2\2\u015d\u015e\7~\2\2\u015ef\3\2\2\2\u015f\u0160\4\63;\2\u0160h\3"+
		"\2\2\2\u0161\u016a\7\62\2\2\u0162\u0166\5g\64\2\u0163\u0165\5\65\33\2"+
		"\u0164\u0163\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167"+
		"\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u0161\3\2\2\2\u0169"+
		"\u0162\3\2\2\2\u016aj\3\2\2\2\u016b\u016d\5\65\33\2\u016c\u016b\3\2\2"+
		"\2\u016d\u016e\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016fl"+
		"\3\2\2\2\u0170\u0172\t\4\2\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"n\3\2\2\2\u0173\u0174\t\5\2\2\u0174\u0175\5m\67\2\u0175\u0176\5k\66\2"+
		"\u0176p\3\2\2\2\u0177\u0178\5k\66\2\u0178\u0179\7\60\2\2\u0179\u017a\5"+
		"k\66\2\u017ar\3\2\2\2\u017b\u0180\5q9\2\u017c\u017d\5q9\2\u017d\u017e"+
		"\5o8\2\u017e\u0180\3\2\2\2\u017f\u017b\3\2\2\2\u017f\u017c\3\2\2\2\u0180"+
		"\u0182\3\2\2\2\u0181\u0183\t\6\2\2\u0182\u0181\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183t\3\2\2\2\u0184\u0185\t\7\2\2\u0185v\3\2\2\2\u0186\u0188\5u"+
		";\2\u0187\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u0187\3\2\2\2\u0189"+
		"\u018a\3\2\2\2\u018ax\3\2\2\2\u018b\u018c\7\62\2\2\u018c\u0190\7z\2\2"+
		"\u018d\u018e\7\62\2\2\u018e\u0190\7Z\2\2\u018f\u018b\3\2\2\2\u018f\u018d"+
		"\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0192\5w<\2\u0192\u0193\7\60\2\2\u0193"+
		"\u0194\5w<\2\u0194\u0195\t\b\2\2\u0195\u0196\5m\67\2\u0196\u0198\5k\66"+
		"\2\u0197\u0199\t\6\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199z"+
		"\3\2\2\2\u019a\u019d\5s:\2\u019b\u019d\5y=\2\u019c\u019a\3\2\2\2\u019c"+
		"\u019b\3\2\2\2\u019d|\3\2\2\2\u019e\u019f\n\t\2\2\u019f~\3\2\2\2\u01a0"+
		"\u01a8\7$\2\2\u01a1\u01a7\5}?\2\u01a2\u01a3\7^\2\2\u01a3\u01a7\7$\2\2"+
		"\u01a4\u01a5\7^\2\2\u01a5\u01a7\7^\2\2\u01a6\u01a1\3\2\2\2\u01a6\u01a2"+
		"\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8"+
		"\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ac\7$"+
		"\2\2\u01ac\u0080\3\2\2\2\u01ad\u01b4\7$\2\2\u01ae\u01b3\5}?\2\u01af\u01b3"+
		"\t\n\2\2\u01b0\u01b1\7^\2\2\u01b1\u01b3\7^\2\2\u01b2\u01ae\3\2\2\2\u01b2"+
		"\u01af\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2"+
		"\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7"+
		"\u01b8\7$\2\2\u01b8\u0082\3\2\2\2\u01b9\u01ba\7\61\2\2\u01ba\u01bb\7,"+
		"\2\2\u01bb\u01bf\3\2\2\2\u01bc\u01be\13\2\2\2\u01bd\u01bc\3\2\2\2\u01be"+
		"\u01c1\3\2\2\2\u01bf\u01c0\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01c2\3\2"+
		"\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c3\7,\2\2\u01c3\u01cf\7\61\2\2\u01c4"+
		"\u01c5\7\61\2\2\u01c5\u01c6\7\61\2\2\u01c6\u01ca\3\2\2\2\u01c7\u01c9\13"+
		"\2\2\2\u01c8\u01c7\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01cb\3\2\2\2\u01ca"+
		"\u01c8\3\2\2\2\u01cb\u01cd\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01cf\7\f"+
		"\2\2\u01ce\u01b9\3\2\2\2\u01ce\u01c4\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01d1\bB\5\2\u01d1\u0084\3\2\2\2\u01d2\u01d4\7\"\2\2\u01d3\u01d2\3\2"+
		"\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6"+
		"\u01d7\3\2\2\2\u01d7\u01d8\bC\6\2\u01d8\u0086\3\2\2\2\u01d9\u01dd\5\63"+
		"\32\2\u01da\u01dd\5\65\33\2\u01db\u01dd\t\13\2\2\u01dc\u01d9\3\2\2\2\u01dc"+
		"\u01da\3\2\2\2\u01dc\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01dc\3\2"+
		"\2\2\u01de\u01df\3\2\2\2\u01df\u0088\3\2\2\2\u01e0\u01e1\7%\2\2\u01e1"+
		"\u01e2\7k\2\2\u01e2\u01e3\7p\2\2\u01e3\u01e4\7e\2\2\u01e4\u01e5\7n\2\2"+
		"\u01e5\u01e6\7w\2\2\u01e6\u01e7\7f\2\2\u01e7\u01e8\7g\2\2\u01e8\u01ec"+
		"\3\2\2\2\u01e9\u01eb\7\"\2\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec"+
		"\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef\3\2\2\2\u01ee\u01ec\3\2"+
		"\2\2\u01ef\u01f0\7$\2\2\u01f0\u01f1\5\u0087D\2\u01f1\u01f2\7$\2\2\u01f2"+
		"\u01f3\bE\7\2\u01f3\u008a\3\2\2\2\33\2\u0121\u0126\u0128\u0166\u0169\u016e"+
		"\u0171\u017f\u0182\u0189\u018f\u0198\u019c\u01a6\u01a8\u01b2\u01b4\u01bf"+
		"\u01ca\u01ce\u01d5\u01dc\u01de\u01ec\b\3\2\2\3\3\3\3\4\4\3B\5\3C\6\3E"+
		"\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}