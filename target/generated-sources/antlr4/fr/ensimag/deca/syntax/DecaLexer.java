// Generated from java-escape by ANTLR 4.11.1
package fr.ensimag.deca.syntax;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DecaLexer extends AbstractDecaLexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

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
			null, "'\\r'", "'\\n'", "'\\t'", "'@'", "'asm'", "'instanceof'", "'println'", 
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
		"\u0004\u00008\u01f2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007"+
		"?\u0002@\u0007@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u0120\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005"+
		"\u001a\u0125\b\u001a\n\u001a\f\u001a\u0128\t\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0001"+
		",\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001"+
		"0\u00010\u00010\u00011\u00011\u00011\u00012\u00012\u00013\u00013\u0001"+
		"3\u00053\u0163\b3\n3\f3\u0166\t3\u00033\u0168\b3\u00014\u00044\u016b\b"+
		"4\u000b4\f4\u016c\u00015\u00035\u0170\b5\u00016\u00016\u00016\u00016\u0001"+
		"7\u00017\u00017\u00017\u00018\u00018\u00018\u00018\u00038\u017e\b8\u0001"+
		"8\u00038\u0181\b8\u00019\u00019\u0001:\u0004:\u0186\b:\u000b:\f:\u0187"+
		"\u0001;\u0001;\u0001;\u0001;\u0003;\u018e\b;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0003;\u0197\b;\u0001<\u0001<\u0003<\u019b\b<\u0001"+
		"=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0005>\u01a5\b>\n>"+
		"\f>\u01a8\t>\u0001>\u0001>\u0001?\u0001?\u0001?\u0001?\u0001?\u0005?\u01b1"+
		"\b?\n?\f?\u01b4\t?\u0001?\u0001?\u0001@\u0001@\u0001@\u0001@\u0005@\u01bc"+
		"\b@\n@\f@\u01bf\t@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0005@\u01c7"+
		"\b@\n@\f@\u01ca\t@\u0001@\u0003@\u01cd\b@\u0001@\u0001@\u0001A\u0004A"+
		"\u01d2\bA\u000bA\fA\u01d3\u0001A\u0001A\u0001B\u0001B\u0001B\u0004B\u01db"+
		"\bB\u000bB\fB\u01dc\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001"+
		"C\u0001C\u0001C\u0005C\u01e9\bC\nC\fC\u01ec\tC\u0001C\u0001C\u0001C\u0001"+
		"C\u0001C\u0002\u01bd\u01c8\u0000D\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00003\u00005\u00197\u001a"+
		"9\u001b;\u001c=\u001d?\u001eA\u001fC E!G\"I#K$M%O&Q\'S(U)W*Y+[,]-_.a/"+
		"c0e\u0000g1i2k\u0000m\u0000o\u0000q\u0000s\u0000u\u0000w\u0000y3{\u0000"+
		"}4\u007f5\u00816\u00837\u0085\u0000\u00878\u0001\u0000\n\u0002\u0000A"+
		"Zaz\u0002\u0000$$__\u0002\u0000++--\u0002\u0000EEee\u0002\u0000FFff\u0003"+
		"\u000009AFaf\u0002\u0000PPpp\u0003\u0000\n\n\"\"\\\\\u0002\u0000\n\n\\"+
		"\\\u0002\u0000-.__\u0201\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000"+
		";\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001"+
		"\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000"+
		"\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000"+
		"I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001"+
		"\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000"+
		"\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000"+
		"W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001"+
		"\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000"+
		"\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000"+
		"g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000\u0000\u0000y\u0001"+
		"\u0000\u0000\u0000\u0000}\u0001\u0000\u0000\u0000\u0000\u007f\u0001\u0000"+
		"\u0000\u0000\u0000\u0081\u0001\u0000\u0000\u0000\u0000\u0083\u0001\u0000"+
		"\u0000\u0000\u0000\u0087\u0001\u0000\u0000\u0000\u0001\u0089\u0001\u0000"+
		"\u0000\u0000\u0003\u008c\u0001\u0000\u0000\u0000\u0005\u008f\u0001\u0000"+
		"\u0000\u0000\u0007\u0092\u0001\u0000\u0000\u0000\t\u0094\u0001\u0000\u0000"+
		"\u0000\u000b\u0098\u0001\u0000\u0000\u0000\r\u00a3\u0001\u0000\u0000\u0000"+
		"\u000f\u00ab\u0001\u0000\u0000\u0000\u0011\u00b0\u0001\u0000\u0000\u0000"+
		"\u0013\u00b6\u0001\u0000\u0000\u0000\u0015\u00ba\u0001\u0000\u0000\u0000"+
		"\u0017\u00c3\u0001\u0000\u0000\u0000\u0019\u00c9\u0001\u0000\u0000\u0000"+
		"\u001b\u00d1\u0001\u0000\u0000\u0000\u001d\u00d6\u0001\u0000\u0000\u0000"+
		"\u001f\u00dd\u0001\u0000\u0000\u0000!\u00e2\u0001\u0000\u0000\u0000#\u00ea"+
		"\u0001\u0000\u0000\u0000%\u00f4\u0001\u0000\u0000\u0000\'\u00fa\u0001"+
		"\u0000\u0000\u0000)\u0104\u0001\u0000\u0000\u0000+\u010b\u0001\u0000\u0000"+
		"\u0000-\u010e\u0001\u0000\u0000\u0000/\u0114\u0001\u0000\u0000\u00001"+
		"\u0119\u0001\u0000\u0000\u00003\u011b\u0001\u0000\u0000\u00005\u011f\u0001"+
		"\u0000\u0000\u00007\u0129\u0001\u0000\u0000\u00009\u012b\u0001\u0000\u0000"+
		"\u0000;\u012d\u0001\u0000\u0000\u0000=\u012f\u0001\u0000\u0000\u0000?"+
		"\u0131\u0001\u0000\u0000\u0000A\u0133\u0001\u0000\u0000\u0000C\u0135\u0001"+
		"\u0000\u0000\u0000E\u0137\u0001\u0000\u0000\u0000G\u0139\u0001\u0000\u0000"+
		"\u0000I\u013b\u0001\u0000\u0000\u0000K\u013d\u0001\u0000\u0000\u0000M"+
		"\u013f\u0001\u0000\u0000\u0000O\u0141\u0001\u0000\u0000\u0000Q\u0143\u0001"+
		"\u0000\u0000\u0000S\u0145\u0001\u0000\u0000\u0000U\u0147\u0001\u0000\u0000"+
		"\u0000W\u0149\u0001\u0000\u0000\u0000Y\u014b\u0001\u0000\u0000\u0000["+
		"\u014e\u0001\u0000\u0000\u0000]\u0151\u0001\u0000\u0000\u0000_\u0154\u0001"+
		"\u0000\u0000\u0000a\u0157\u0001\u0000\u0000\u0000c\u015a\u0001\u0000\u0000"+
		"\u0000e\u015d\u0001\u0000\u0000\u0000g\u0167\u0001\u0000\u0000\u0000i"+
		"\u016a\u0001\u0000\u0000\u0000k\u016f\u0001\u0000\u0000\u0000m\u0171\u0001"+
		"\u0000\u0000\u0000o\u0175\u0001\u0000\u0000\u0000q\u017d\u0001\u0000\u0000"+
		"\u0000s\u0182\u0001\u0000\u0000\u0000u\u0185\u0001\u0000\u0000\u0000w"+
		"\u018d\u0001\u0000\u0000\u0000y\u019a\u0001\u0000\u0000\u0000{\u019c\u0001"+
		"\u0000\u0000\u0000}\u019e\u0001\u0000\u0000\u0000\u007f\u01ab\u0001\u0000"+
		"\u0000\u0000\u0081\u01cc\u0001\u0000\u0000\u0000\u0083\u01d1\u0001\u0000"+
		"\u0000\u0000\u0085\u01da\u0001\u0000\u0000\u0000\u0087\u01de\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0005\r\u0000\u0000\u008a\u008b\u0006\u0000\u0000"+
		"\u0000\u008b\u0002\u0001\u0000\u0000\u0000\u008c\u008d\u0005\n\u0000\u0000"+
		"\u008d\u008e\u0006\u0001\u0001\u0000\u008e\u0004\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005\t\u0000\u0000\u0090\u0091\u0006\u0002\u0002\u0000\u0091"+
		"\u0006\u0001\u0000\u0000\u0000\u0092\u0093\u0005@\u0000\u0000\u0093\b"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0005a\u0000\u0000\u0095\u0096\u0005"+
		"s\u0000\u0000\u0096\u0097\u0005m\u0000\u0000\u0097\n\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0005i\u0000\u0000\u0099\u009a\u0005n\u0000\u0000\u009a"+
		"\u009b\u0005s\u0000\u0000\u009b\u009c\u0005t\u0000\u0000\u009c\u009d\u0005"+
		"a\u0000\u0000\u009d\u009e\u0005n\u0000\u0000\u009e\u009f\u0005c\u0000"+
		"\u0000\u009f\u00a0\u0005e\u0000\u0000\u00a0\u00a1\u0005o\u0000\u0000\u00a1"+
		"\u00a2\u0005f\u0000\u0000\u00a2\f\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0005p\u0000\u0000\u00a4\u00a5\u0005r\u0000\u0000\u00a5\u00a6\u0005i"+
		"\u0000\u0000\u00a6\u00a7\u0005n\u0000\u0000\u00a7\u00a8\u0005t\u0000\u0000"+
		"\u00a8\u00a9\u0005l\u0000\u0000\u00a9\u00aa\u0005n\u0000\u0000\u00aa\u000e"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005t\u0000\u0000\u00ac\u00ad\u0005"+
		"r\u0000\u0000\u00ad\u00ae\u0005u\u0000\u0000\u00ae\u00af\u0005e\u0000"+
		"\u0000\u00af\u0010\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005c\u0000\u0000"+
		"\u00b1\u00b2\u0005l\u0000\u0000\u00b2\u00b3\u0005a\u0000\u0000\u00b3\u00b4"+
		"\u0005s\u0000\u0000\u00b4\u00b5\u0005s\u0000\u0000\u00b5\u0012\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0005n\u0000\u0000\u00b7\u00b8\u0005e\u0000\u0000"+
		"\u00b8\u00b9\u0005w\u0000\u0000\u00b9\u0014\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0005p\u0000\u0000\u00bb\u00bc\u0005r\u0000\u0000\u00bc\u00bd\u0005"+
		"i\u0000\u0000\u00bd\u00be\u0005n\u0000\u0000\u00be\u00bf\u0005t\u0000"+
		"\u0000\u00bf\u00c0\u0005l\u0000\u0000\u00c0\u00c1\u0005n\u0000\u0000\u00c1"+
		"\u00c2\u0005x\u0000\u0000\u00c2\u0016\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0005w\u0000\u0000\u00c4\u00c5\u0005h\u0000\u0000\u00c5\u00c6\u0005i"+
		"\u0000\u0000\u00c6\u00c7\u0005l\u0000\u0000\u00c7\u00c8\u0005e\u0000\u0000"+
		"\u00c8\u0018\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005e\u0000\u0000\u00ca"+
		"\u00cb\u0005x\u0000\u0000\u00cb\u00cc\u0005t\u0000\u0000\u00cc\u00cd\u0005"+
		"e\u0000\u0000\u00cd\u00ce\u0005n\u0000\u0000\u00ce\u00cf\u0005d\u0000"+
		"\u0000\u00cf\u00d0\u0005s\u0000\u0000\u00d0\u001a\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0005n\u0000\u0000\u00d2\u00d3\u0005u\u0000\u0000\u00d3\u00d4"+
		"\u0005l\u0000\u0000\u00d4\u00d5\u0005l\u0000\u0000\u00d5\u001c\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0005p\u0000\u0000\u00d7\u00d8\u0005r\u0000\u0000"+
		"\u00d8\u00d9\u0005i\u0000\u0000\u00d9\u00da\u0005n\u0000\u0000\u00da\u00db"+
		"\u0005t\u0000\u0000\u00db\u00dc\u0005x\u0000\u0000\u00dc\u001e\u0001\u0000"+
		"\u0000\u0000\u00dd\u00de\u0005e\u0000\u0000\u00de\u00df\u0005l\u0000\u0000"+
		"\u00df\u00e0\u0005s\u0000\u0000\u00e0\u00e1\u0005e\u0000\u0000\u00e1 "+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005r\u0000\u0000\u00e3\u00e4\u0005"+
		"e\u0000\u0000\u00e4\u00e5\u0005a\u0000\u0000\u00e5\u00e6\u0005d\u0000"+
		"\u0000\u00e6\u00e7\u0005I\u0000\u0000\u00e7\u00e8\u0005n\u0000\u0000\u00e8"+
		"\u00e9\u0005t\u0000\u0000\u00e9\"\u0001\u0000\u0000\u0000\u00ea\u00eb"+
		"\u0005p\u0000\u0000\u00eb\u00ec\u0005r\u0000\u0000\u00ec\u00ed\u0005o"+
		"\u0000\u0000\u00ed\u00ee\u0005t\u0000\u0000\u00ee\u00ef\u0005e\u0000\u0000"+
		"\u00ef\u00f0\u0005c\u0000\u0000\u00f0\u00f1\u0005t\u0000\u0000\u00f1\u00f2"+
		"\u0005e\u0000\u0000\u00f2\u00f3\u0005d\u0000\u0000\u00f3$\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f5\u0005f\u0000\u0000\u00f5\u00f6\u0005a\u0000\u0000"+
		"\u00f6\u00f7\u0005l\u0000\u0000\u00f7\u00f8\u0005s\u0000\u0000\u00f8\u00f9"+
		"\u0005e\u0000\u0000\u00f9&\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005r"+
		"\u0000\u0000\u00fb\u00fc\u0005e\u0000\u0000\u00fc\u00fd\u0005a\u0000\u0000"+
		"\u00fd\u00fe\u0005d\u0000\u0000\u00fe\u00ff\u0005F\u0000\u0000\u00ff\u0100"+
		"\u0005l\u0000\u0000\u0100\u0101\u0005o\u0000\u0000\u0101\u0102\u0005a"+
		"\u0000\u0000\u0102\u0103\u0005t\u0000\u0000\u0103(\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0005r\u0000\u0000\u0105\u0106\u0005e\u0000\u0000\u0106\u0107"+
		"\u0005t\u0000\u0000\u0107\u0108\u0005u\u0000\u0000\u0108\u0109\u0005r"+
		"\u0000\u0000\u0109\u010a\u0005n\u0000\u0000\u010a*\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0005i\u0000\u0000\u010c\u010d\u0005f\u0000\u0000\u010d,"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0005p\u0000\u0000\u010f\u0110\u0005"+
		"r\u0000\u0000\u0110\u0111\u0005i\u0000\u0000\u0111\u0112\u0005n\u0000"+
		"\u0000\u0112\u0113\u0005t\u0000\u0000\u0113.\u0001\u0000\u0000\u0000\u0114"+
		"\u0115\u0005t\u0000\u0000\u0115\u0116\u0005h\u0000\u0000\u0116\u0117\u0005"+
		"i\u0000\u0000\u0117\u0118\u0005s\u0000\u0000\u01180\u0001\u0000\u0000"+
		"\u0000\u0119\u011a\u0007\u0000\u0000\u0000\u011a2\u0001\u0000\u0000\u0000"+
		"\u011b\u011c\u000209\u0000\u011c4\u0001\u0000\u0000\u0000\u011d\u0120"+
		"\u00031\u0018\u0000\u011e\u0120\u0007\u0001\u0000\u0000\u011f\u011d\u0001"+
		"\u0000\u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0126\u0001"+
		"\u0000\u0000\u0000\u0121\u0125\u00031\u0018\u0000\u0122\u0125\u00033\u0019"+
		"\u0000\u0123\u0125\u0007\u0001\u0000\u0000\u0124\u0121\u0001\u0000\u0000"+
		"\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0123\u0001\u0000\u0000"+
		"\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000"+
		"\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u01276\u0001\u0000\u0000\u0000"+
		"\u0128\u0126\u0001\u0000\u0000\u0000\u0129\u012a\u0005>\u0000\u0000\u012a"+
		"8\u0001\u0000\u0000\u0000\u012b\u012c\u0005<\u0000\u0000\u012c:\u0001"+
		"\u0000\u0000\u0000\u012d\u012e\u0005=\u0000\u0000\u012e<\u0001\u0000\u0000"+
		"\u0000\u012f\u0130\u0005+\u0000\u0000\u0130>\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u0005-\u0000\u0000\u0132@\u0001\u0000\u0000\u0000\u0133\u0134\u0005"+
		"*\u0000\u0000\u0134B\u0001\u0000\u0000\u0000\u0135\u0136\u0005/\u0000"+
		"\u0000\u0136D\u0001\u0000\u0000\u0000\u0137\u0138\u0005%\u0000\u0000\u0138"+
		"F\u0001\u0000\u0000\u0000\u0139\u013a\u0005.\u0000\u0000\u013aH\u0001"+
		"\u0000\u0000\u0000\u013b\u013c\u0005,\u0000\u0000\u013cJ\u0001\u0000\u0000"+
		"\u0000\u013d\u013e\u0005(\u0000\u0000\u013eL\u0001\u0000\u0000\u0000\u013f"+
		"\u0140\u0005)\u0000\u0000\u0140N\u0001\u0000\u0000\u0000\u0141\u0142\u0005"+
		"{\u0000\u0000\u0142P\u0001\u0000\u0000\u0000\u0143\u0144\u0005}\u0000"+
		"\u0000\u0144R\u0001\u0000\u0000\u0000\u0145\u0146\u0005!\u0000\u0000\u0146"+
		"T\u0001\u0000\u0000\u0000\u0147\u0148\u0005:\u0000\u0000\u0148V\u0001"+
		"\u0000\u0000\u0000\u0149\u014a\u0005;\u0000\u0000\u014aX\u0001\u0000\u0000"+
		"\u0000\u014b\u014c\u0005=\u0000\u0000\u014c\u014d\u0005=\u0000\u0000\u014d"+
		"Z\u0001\u0000\u0000\u0000\u014e\u014f\u0005!\u0000\u0000\u014f\u0150\u0005"+
		"=\u0000\u0000\u0150\\\u0001\u0000\u0000\u0000\u0151\u0152\u0005>\u0000"+
		"\u0000\u0152\u0153\u0005=\u0000\u0000\u0153^\u0001\u0000\u0000\u0000\u0154"+
		"\u0155\u0005<\u0000\u0000\u0155\u0156\u0005=\u0000\u0000\u0156`\u0001"+
		"\u0000\u0000\u0000\u0157\u0158\u0005&\u0000\u0000\u0158\u0159\u0005&\u0000"+
		"\u0000\u0159b\u0001\u0000\u0000\u0000\u015a\u015b\u0005|\u0000\u0000\u015b"+
		"\u015c\u0005|\u0000\u0000\u015cd\u0001\u0000\u0000\u0000\u015d\u015e\u0002"+
		"19\u0000\u015ef\u0001\u0000\u0000\u0000\u015f\u0168\u00050\u0000\u0000"+
		"\u0160\u0164\u0003e2\u0000\u0161\u0163\u00033\u0019\u0000\u0162\u0161"+
		"\u0001\u0000\u0000\u0000\u0163\u0166\u0001\u0000\u0000\u0000\u0164\u0162"+
		"\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0168"+
		"\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0167\u015f"+
		"\u0001\u0000\u0000\u0000\u0167\u0160\u0001\u0000\u0000\u0000\u0168h\u0001"+
		"\u0000\u0000\u0000\u0169\u016b\u00033\u0019\u0000\u016a\u0169\u0001\u0000"+
		"\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016a\u0001\u0000"+
		"\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016dj\u0001\u0000\u0000"+
		"\u0000\u016e\u0170\u0007\u0002\u0000\u0000\u016f\u016e\u0001\u0000\u0000"+
		"\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170l\u0001\u0000\u0000\u0000"+
		"\u0171\u0172\u0007\u0003\u0000\u0000\u0172\u0173\u0003k5\u0000\u0173\u0174"+
		"\u0003i4\u0000\u0174n\u0001\u0000\u0000\u0000\u0175\u0176\u0003i4\u0000"+
		"\u0176\u0177\u0005.\u0000\u0000\u0177\u0178\u0003i4\u0000\u0178p\u0001"+
		"\u0000\u0000\u0000\u0179\u017e\u0003o7\u0000\u017a\u017b\u0003o7\u0000"+
		"\u017b\u017c\u0003m6\u0000\u017c\u017e\u0001\u0000\u0000\u0000\u017d\u0179"+
		"\u0001\u0000\u0000\u0000\u017d\u017a\u0001\u0000\u0000\u0000\u017e\u0180"+
		"\u0001\u0000\u0000\u0000\u017f\u0181\u0007\u0004\u0000\u0000\u0180\u017f"+
		"\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181r\u0001"+
		"\u0000\u0000\u0000\u0182\u0183\u0007\u0005\u0000\u0000\u0183t\u0001\u0000"+
		"\u0000\u0000\u0184\u0186\u0003s9\u0000\u0185\u0184\u0001\u0000\u0000\u0000"+
		"\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000"+
		"\u0187\u0188\u0001\u0000\u0000\u0000\u0188v\u0001\u0000\u0000\u0000\u0189"+
		"\u018a\u00050\u0000\u0000\u018a\u018e\u0005x\u0000\u0000\u018b\u018c\u0005"+
		"0\u0000\u0000\u018c\u018e\u0005X\u0000\u0000\u018d\u0189\u0001\u0000\u0000"+
		"\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000"+
		"\u0000\u018f\u0190\u0003u:\u0000\u0190\u0191\u0005.\u0000\u0000\u0191"+
		"\u0192\u0003u:\u0000\u0192\u0193\u0007\u0006\u0000\u0000\u0193\u0194\u0003"+
		"k5\u0000\u0194\u0196\u0003i4\u0000\u0195\u0197\u0007\u0004\u0000\u0000"+
		"\u0196\u0195\u0001\u0000\u0000\u0000\u0196\u0197\u0001\u0000\u0000\u0000"+
		"\u0197x\u0001\u0000\u0000\u0000\u0198\u019b\u0003q8\u0000\u0199\u019b"+
		"\u0003w;\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019a\u0199\u0001\u0000"+
		"\u0000\u0000\u019bz\u0001\u0000\u0000\u0000\u019c\u019d\b\u0007\u0000"+
		"\u0000\u019d|\u0001\u0000\u0000\u0000\u019e\u01a6\u0005\"\u0000\u0000"+
		"\u019f\u01a5\u0003{=\u0000\u01a0\u01a1\u0005\\\u0000\u0000\u01a1\u01a5"+
		"\u0005\"\u0000\u0000\u01a2\u01a3\u0005\\\u0000\u0000\u01a3\u01a5\u0005"+
		"\\\u0000\u0000\u01a4\u019f\u0001\u0000\u0000\u0000\u01a4\u01a0\u0001\u0000"+
		"\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a5\u01a8\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000"+
		"\u0000\u0000\u01a7\u01a9\u0001\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000"+
		"\u0000\u0000\u01a9\u01aa\u0005\"\u0000\u0000\u01aa~\u0001\u0000\u0000"+
		"\u0000\u01ab\u01b2\u0005\"\u0000\u0000\u01ac\u01b1\u0003{=\u0000\u01ad"+
		"\u01b1\u0007\b\u0000\u0000\u01ae\u01af\u0005\\\u0000\u0000\u01af\u01b1"+
		"\u0005\\\u0000\u0000\u01b0\u01ac\u0001\u0000\u0000\u0000\u01b0\u01ad\u0001"+
		"\u0000\u0000\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b1\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000\u01b2\u01b3\u0001"+
		"\u0000\u0000\u0000\u01b3\u01b5\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b5\u01b6\u0005\"\u0000\u0000\u01b6\u0080\u0001\u0000"+
		"\u0000\u0000\u01b7\u01b8\u0005/\u0000\u0000\u01b8\u01b9\u0005*\u0000\u0000"+
		"\u01b9\u01bd\u0001\u0000\u0000\u0000\u01ba\u01bc\t\u0000\u0000\u0000\u01bb"+
		"\u01ba\u0001\u0000\u0000\u0000\u01bc\u01bf\u0001\u0000\u0000\u0000\u01bd"+
		"\u01be\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01be"+
		"\u01c0\u0001\u0000\u0000\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01c0"+
		"\u01c1\u0005*\u0000\u0000\u01c1\u01cd\u0005/\u0000\u0000\u01c2\u01c3\u0005"+
		"/\u0000\u0000\u01c3\u01c4\u0005/\u0000\u0000\u01c4\u01c8\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c7\t\u0000\u0000\u0000\u01c6\u01c5\u0001\u0000\u0000\u0000"+
		"\u01c7\u01ca\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000"+
		"\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c9\u01cb\u0001\u0000\u0000\u0000"+
		"\u01ca\u01c8\u0001\u0000\u0000\u0000\u01cb\u01cd\u0005\n\u0000\u0000\u01cc"+
		"\u01b7\u0001\u0000\u0000\u0000\u01cc\u01c2\u0001\u0000\u0000\u0000\u01cd"+
		"\u01ce\u0001\u0000\u0000\u0000\u01ce\u01cf\u0006@\u0003\u0000\u01cf\u0082"+
		"\u0001\u0000\u0000\u0000\u01d0\u01d2\u0005 \u0000\u0000\u01d1\u01d0\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d1\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001"+
		"\u0000\u0000\u0000\u01d5\u01d6\u0006A\u0004\u0000\u01d6\u0084\u0001\u0000"+
		"\u0000\u0000\u01d7\u01db\u00031\u0018\u0000\u01d8\u01db\u00033\u0019\u0000"+
		"\u01d9\u01db\u0007\t\u0000\u0000\u01da\u01d7\u0001\u0000\u0000\u0000\u01da"+
		"\u01d8\u0001\u0000\u0000\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01db"+
		"\u01dc\u0001\u0000\u0000\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dc"+
		"\u01dd\u0001\u0000\u0000\u0000\u01dd\u0086\u0001\u0000\u0000\u0000\u01de"+
		"\u01df\u0005#\u0000\u0000\u01df\u01e0\u0005i\u0000\u0000\u01e0\u01e1\u0005"+
		"n\u0000\u0000\u01e1\u01e2\u0005c\u0000\u0000\u01e2\u01e3\u0005l\u0000"+
		"\u0000\u01e3\u01e4\u0005u\u0000\u0000\u01e4\u01e5\u0005d\u0000\u0000\u01e5"+
		"\u01e6\u0005e\u0000\u0000\u01e6\u01ea\u0001\u0000\u0000\u0000\u01e7\u01e9"+
		"\u0005 \u0000\u0000\u01e8\u01e7\u0001\u0000\u0000\u0000\u01e9\u01ec\u0001"+
		"\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000\u0000\u01ea\u01eb\u0001"+
		"\u0000\u0000\u0000\u01eb\u01ed\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001"+
		"\u0000\u0000\u0000\u01ed\u01ee\u0005\"\u0000\u0000\u01ee\u01ef\u0003\u0085"+
		"B\u0000\u01ef\u01f0\u0005\"\u0000\u0000\u01f0\u01f1\u0006C\u0005\u0000"+
		"\u01f1\u0088\u0001\u0000\u0000\u0000\u0019\u0000\u011f\u0124\u0126\u0164"+
		"\u0167\u016c\u016f\u017d\u0180\u0187\u018d\u0196\u019a\u01a4\u01a6\u01b0"+
		"\u01b2\u01bd\u01c8\u01cc\u01d3\u01da\u01dc\u01ea\u0006\u0001\u0000\u0000"+
		"\u0001\u0001\u0001\u0001\u0002\u0002\u0001@\u0003\u0001A\u0004\u0001C"+
		"\u0005";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}