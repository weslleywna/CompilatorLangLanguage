/*
 Vitor Hugo Nascimento Pinto - 201535008
 Weslley Nascimento Araujo - 201535001
*/

// Generated from C:/Users/wesll/Downloads/code/code/lang/parser/antlr\lang.g4 by ANTLR 4.8
package lang.parser.implementation.lang.parser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRINT=1, DATA=2, IF=3, ELSE=4, ITERATE=5, READ=6, RETURN=7, NEW=8, BOOLEAN=9, 
		NULL=10, PARENTHESIS_OPEN=11, PARENTHESIS_CLOSE=12, BRACKET_OPEN=13, BRACKET_CLOSE=14, 
		KEYS_OPEN=15, KEYS_CLOSE=16, SEMI=17, DOT=18, COMMA=19, EQ=20, LESSTHAN=21, 
		MORETHAN=22, EQEQ=23, NOTEQ=24, PLUS=25, MINUS=26, TIMES=27, SLASH=28, 
		PERCENT=29, EQCEQC=30, NOT=31, DP=32, DPDP=33, IDENTIFIER=34, TYPENAME=35, 
		INTEGER=36, FLOAT=37, LITERAL=38, CHAR=39, LOWERCASE=40, UPPERCASE=41, 
		WHITESPACE=42, COMMENT=43, MULTILINE_COMMENT=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PRINT", "DATA", "IF", "ELSE", "ITERATE", "READ", "RETURN", "NEW", "BOOLEAN", 
			"NULL", "PARENTHESIS_OPEN", "PARENTHESIS_CLOSE", "BRACKET_OPEN", "BRACKET_CLOSE", 
			"KEYS_OPEN", "KEYS_CLOSE", "SEMI", "DOT", "COMMA", "EQ", "LESSTHAN", 
			"MORETHAN", "EQEQ", "NOTEQ", "PLUS", "MINUS", "TIMES", "SLASH", "PERCENT", 
			"EQCEQC", "NOT", "DP", "DPDP", "IDENTIFIER", "TYPENAME", "INTEGER", "FLOAT", 
			"LITERAL", "CHAR", "LOWERCASE", "UPPERCASE", "WHITESPACE", "COMMENT", 
			"MULTILINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'data'", "'if'", "'else'", "'iterate'", "'read'", "'return'", 
			"'new'", null, "'null'", "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", 
			"'.'", "','", "'='", "'<'", "'>'", "'=='", "'!='", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'&&'", "'!'", "':'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PRINT", "DATA", "IF", "ELSE", "ITERATE", "READ", "RETURN", "NEW", 
			"BOOLEAN", "NULL", "PARENTHESIS_OPEN", "PARENTHESIS_CLOSE", "BRACKET_OPEN", 
			"BRACKET_CLOSE", "KEYS_OPEN", "KEYS_CLOSE", "SEMI", "DOT", "COMMA", "EQ", 
			"LESSTHAN", "MORETHAN", "EQEQ", "NOTEQ", "PLUS", "MINUS", "TIMES", "SLASH", 
			"PERCENT", "EQCEQC", "NOT", "DP", "DPDP", "IDENTIFIER", "TYPENAME", "INTEGER", 
			"FLOAT", "LITERAL", "CHAR", "LOWERCASE", "UPPERCASE", "WHITESPACE", "COMMENT", 
			"MULTILINE_COMMENT"
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


	public langLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lang.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0121\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u0090\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3"+
		"\"\3#\3#\3#\7#\u00cc\n#\f#\16#\u00cf\13#\3$\3$\3$\3%\6%\u00d5\n%\r%\16"+
		"%\u00d6\3&\7&\u00da\n&\f&\16&\u00dd\13&\3&\3&\6&\u00e1\n&\r&\16&\u00e2"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u00f1\n\'\3\'\3\'"+
		"\3(\3(\5(\u00f7\n(\3)\6)\u00fa\n)\r)\16)\u00fb\3*\6*\u00ff\n*\r*\16*\u0100"+
		"\3+\6+\u0104\n+\r+\16+\u0105\3+\3+\3,\3,\3,\3,\5,\u010e\n,\3,\3,\3,\3"+
		",\3-\3-\3-\3-\7-\u0118\n-\f-\16-\u011b\13-\3-\3-\3-\3-\3-\3\u0119\2.\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.\3\2\6\4\2\62;aa\3\2\62;\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\2\u0131\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5a"+
		"\3\2\2\2\7f\3\2\2\2\ti\3\2\2\2\13n\3\2\2\2\rv\3\2\2\2\17{\3\2\2\2\21\u0082"+
		"\3\2\2\2\23\u008f\3\2\2\2\25\u0091\3\2\2\2\27\u0096\3\2\2\2\31\u0098\3"+
		"\2\2\2\33\u009a\3\2\2\2\35\u009c\3\2\2\2\37\u009e\3\2\2\2!\u00a0\3\2\2"+
		"\2#\u00a2\3\2\2\2%\u00a4\3\2\2\2\'\u00a6\3\2\2\2)\u00a8\3\2\2\2+\u00aa"+
		"\3\2\2\2-\u00ac\3\2\2\2/\u00ae\3\2\2\2\61\u00b1\3\2\2\2\63\u00b4\3\2\2"+
		"\2\65\u00b6\3\2\2\2\67\u00b8\3\2\2\29\u00ba\3\2\2\2;\u00bc\3\2\2\2=\u00be"+
		"\3\2\2\2?\u00c1\3\2\2\2A\u00c3\3\2\2\2C\u00c5\3\2\2\2E\u00c8\3\2\2\2G"+
		"\u00d0\3\2\2\2I\u00d4\3\2\2\2K\u00db\3\2\2\2M\u00e4\3\2\2\2O\u00f6\3\2"+
		"\2\2Q\u00f9\3\2\2\2S\u00fe\3\2\2\2U\u0103\3\2\2\2W\u0109\3\2\2\2Y\u0113"+
		"\3\2\2\2[\\\7r\2\2\\]\7t\2\2]^\7k\2\2^_\7p\2\2_`\7v\2\2`\4\3\2\2\2ab\7"+
		"f\2\2bc\7c\2\2cd\7v\2\2de\7c\2\2e\6\3\2\2\2fg\7k\2\2gh\7h\2\2h\b\3\2\2"+
		"\2ij\7g\2\2jk\7n\2\2kl\7u\2\2lm\7g\2\2m\n\3\2\2\2no\7k\2\2op\7v\2\2pq"+
		"\7g\2\2qr\7t\2\2rs\7c\2\2st\7v\2\2tu\7g\2\2u\f\3\2\2\2vw\7t\2\2wx\7g\2"+
		"\2xy\7c\2\2yz\7f\2\2z\16\3\2\2\2{|\7t\2\2|}\7g\2\2}~\7v\2\2~\177\7w\2"+
		"\2\177\u0080\7t\2\2\u0080\u0081\7p\2\2\u0081\20\3\2\2\2\u0082\u0083\7"+
		"p\2\2\u0083\u0084\7g\2\2\u0084\u0085\7y\2\2\u0085\22\3\2\2\2\u0086\u0087"+
		"\7v\2\2\u0087\u0088\7t\2\2\u0088\u0089\7w\2\2\u0089\u0090\7g\2\2\u008a"+
		"\u008b\7h\2\2\u008b\u008c\7c\2\2\u008c\u008d\7n\2\2\u008d\u008e\7u\2\2"+
		"\u008e\u0090\7g\2\2\u008f\u0086\3\2\2\2\u008f\u008a\3\2\2\2\u0090\24\3"+
		"\2\2\2\u0091\u0092\7p\2\2\u0092\u0093\7w\2\2\u0093\u0094\7n\2\2\u0094"+
		"\u0095\7n\2\2\u0095\26\3\2\2\2\u0096\u0097\7*\2\2\u0097\30\3\2\2\2\u0098"+
		"\u0099\7+\2\2\u0099\32\3\2\2\2\u009a\u009b\7]\2\2\u009b\34\3\2\2\2\u009c"+
		"\u009d\7_\2\2\u009d\36\3\2\2\2\u009e\u009f\7}\2\2\u009f \3\2\2\2\u00a0"+
		"\u00a1\7\177\2\2\u00a1\"\3\2\2\2\u00a2\u00a3\7=\2\2\u00a3$\3\2\2\2\u00a4"+
		"\u00a5\7\60\2\2\u00a5&\3\2\2\2\u00a6\u00a7\7.\2\2\u00a7(\3\2\2\2\u00a8"+
		"\u00a9\7?\2\2\u00a9*\3\2\2\2\u00aa\u00ab\7>\2\2\u00ab,\3\2\2\2\u00ac\u00ad"+
		"\7@\2\2\u00ad.\3\2\2\2\u00ae\u00af\7?\2\2\u00af\u00b0\7?\2\2\u00b0\60"+
		"\3\2\2\2\u00b1\u00b2\7#\2\2\u00b2\u00b3\7?\2\2\u00b3\62\3\2\2\2\u00b4"+
		"\u00b5\7-\2\2\u00b5\64\3\2\2\2\u00b6\u00b7\7/\2\2\u00b7\66\3\2\2\2\u00b8"+
		"\u00b9\7,\2\2\u00b98\3\2\2\2\u00ba\u00bb\7\61\2\2\u00bb:\3\2\2\2\u00bc"+
		"\u00bd\7\'\2\2\u00bd<\3\2\2\2\u00be\u00bf\7(\2\2\u00bf\u00c0\7(\2\2\u00c0"+
		">\3\2\2\2\u00c1\u00c2\7#\2\2\u00c2@\3\2\2\2\u00c3\u00c4\7<\2\2\u00c4B"+
		"\3\2\2\2\u00c5\u00c6\7<\2\2\u00c6\u00c7\7<\2\2\u00c7D\3\2\2\2\u00c8\u00cd"+
		"\5Q)\2\u00c9\u00cc\5O(\2\u00ca\u00cc\t\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ceF\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\5S*\2\u00d1\u00d2"+
		"\5Q)\2\u00d2H\3\2\2\2\u00d3\u00d5\t\3\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7J\3\2\2\2\u00d8"+
		"\u00da\t\3\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00e0\7\60\2\2\u00df\u00e1\t\3\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3"+
		"\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3L\3\2\2\2\u00e4\u00f0"+
		"\7)\2\2\u00e5\u00f1\5O(\2\u00e6\u00e7\7^\2\2\u00e7\u00f1\7p\2\2\u00e8"+
		"\u00e9\7^\2\2\u00e9\u00f1\7v\2\2\u00ea\u00eb\7^\2\2\u00eb\u00f1\7d\2\2"+
		"\u00ec\u00ed\7^\2\2\u00ed\u00f1\7t\2\2\u00ee\u00ef\7^\2\2\u00ef\u00f1"+
		"\7^\2\2\u00f0\u00e5\3\2\2\2\u00f0\u00e6\3\2\2\2\u00f0\u00e8\3\2\2\2\u00f0"+
		"\u00ea\3\2\2\2\u00f0\u00ec\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f3\7)\2\2\u00f3N\3\2\2\2\u00f4\u00f7\5S*\2\u00f5\u00f7\5"+
		"Q)\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7P\3\2\2\2\u00f8\u00fa"+
		"\4c|\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fcR\3\2\2\2\u00fd\u00ff\4C\\\2\u00fe\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101T\3\2\2\2"+
		"\u0102\u0104\t\4\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103"+
		"\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\b+\2\2\u0108"+
		"V\3\2\2\2\u0109\u010a\7/\2\2\u010a\u010b\7/\2\2\u010b\u010d\3\2\2\2\u010c"+
		"\u010e\13\2\2\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3"+
		"\2\2\2\u010f\u0110\n\5\2\2\u0110\u0111\3\2\2\2\u0111\u0112\b,\2\2\u0112"+
		"X\3\2\2\2\u0113\u0114\7}\2\2\u0114\u0115\7/\2\2\u0115\u0119\3\2\2\2\u0116"+
		"\u0118\13\2\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u011a\3"+
		"\2\2\2\u0119\u0117\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c"+
		"\u011d\7/\2\2\u011d\u011e\7\177\2\2\u011e\u011f\3\2\2\2\u011f\u0120\b"+
		"-\2\2\u0120Z\3\2\2\2\20\2\u008f\u00cb\u00cd\u00d6\u00db\u00e2\u00f0\u00f6"+
		"\u00fb\u0100\u0105\u010d\u0119\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}