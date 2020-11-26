// Generated from C:/Users/wesll/Documents/Git/CompiladorLinguagemLang/code/code/lang/parser/antlr\lang.g4 by ANTLR 4.8
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
		PRINT=1, DATA=2, IF=3, ELSE=4, ITERATE=5, READ=6, RETURN=7, NEW=8, PLUS=9, 
		MINUS=10, TIMES=11, SLASH=12, PERCENT=13, LESSTHAN=14, MORETHAN=15, EQEQ=16, 
		NOTEQ=17, EQCEQC=18, NOT=19, PARENTHESIS_OPEN=20, PARENTHESIS_CLOSE=21, 
		BRACKET_OPEN=22, BRACKET_CLOSE=23, KEYS_OPEN=24, KEYS_CLOSE=25, SEMI=26, 
		DOT=27, COMMA=28, EQ=29, DP=30, DPDP=31, COMMENT=32, MULTILINE_COMMENT=33, 
		WHITESPACE=34, TYPENAME=35, BOOLEAN=36, NULL=37, IDENTIFIER=38, INTEGER=39, 
		FLOAT=40, LITERAL=41, CHAR=42, LOWERCASE=43, UPPERCASE=44, UNICODE=45;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PRINT", "DATA", "IF", "ELSE", "ITERATE", "READ", "RETURN", "NEW", "PLUS", 
			"MINUS", "TIMES", "SLASH", "PERCENT", "LESSTHAN", "MORETHAN", "EQEQ", 
			"NOTEQ", "EQCEQC", "NOT", "PARENTHESIS_OPEN", "PARENTHESIS_CLOSE", "BRACKET_OPEN", 
			"BRACKET_CLOSE", "KEYS_OPEN", "KEYS_CLOSE", "SEMI", "DOT", "COMMA", "EQ", 
			"DP", "DPDP", "COMMENT", "MULTILINE_COMMENT", "WHITESPACE", "TYPENAME", 
			"BOOLEAN", "NULL", "IDENTIFIER", "INTEGER", "FLOAT", "LITERAL", "CHAR", 
			"LOWERCASE", "UPPERCASE", "UNICODE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'data'", "'if'", "'else'", "'iterate'", "'read'", "'return'", 
			"'new'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'>'", "'=='", "'!='", 
			"'&&'", "'!'", "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "'.'", 
			"','", "'='", "':'", "'::'", null, null, null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PRINT", "DATA", "IF", "ELSE", "ITERATE", "READ", "RETURN", "NEW", 
			"PLUS", "MINUS", "TIMES", "SLASH", "PERCENT", "LESSTHAN", "MORETHAN", 
			"EQEQ", "NOTEQ", "EQCEQC", "NOT", "PARENTHESIS_OPEN", "PARENTHESIS_CLOSE", 
			"BRACKET_OPEN", "BRACKET_CLOSE", "KEYS_OPEN", "KEYS_CLOSE", "SEMI", "DOT", 
			"COMMA", "EQ", "DP", "DPDP", "COMMENT", "MULTILINE_COMMENT", "WHITESPACE", 
			"TYPENAME", "BOOLEAN", "NULL", "IDENTIFIER", "INTEGER", "FLOAT", "LITERAL", 
			"CHAR", "LOWERCASE", "UPPERCASE", "UNICODE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0131\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		" \3 \3 \3!\3!\3!\3!\7!\u00bf\n!\f!\16!\u00c2\13!\3!\7!\u00c5\n!\f!\16"+
		"!\u00c8\13!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00d0\n\"\f\"\16\"\u00d3\13\"\3"+
		"\"\3\"\3\"\3\"\3\"\3#\6#\u00db\n#\r#\16#\u00dc\3#\3#\3$\3$\7$\u00e3\n"+
		"$\f$\16$\u00e6\13$\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u00f1\n%\3&\3&\3&\3&"+
		"\3&\3\'\3\'\3\'\7\'\u00fb\n\'\f\'\16\'\u00fe\13\'\3(\6(\u0101\n(\r(\16"+
		"(\u0102\3)\7)\u0106\n)\f)\16)\u0109\13)\3)\3)\6)\u010d\n)\r)\16)\u010e"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u011e\n*\3*\3*\3+\3+\5+\u0124"+
		"\n+\3,\6,\u0127\n,\r,\16,\u0128\3-\6-\u012c\n-\r-\16-\u012d\3.\3.\4\u00c0"+
		"\u00d1\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/\3\2\6\4\2\f\f\17\17\5\2"+
		"\13\f\17\17\"\"\4\2\62;aa\3\2\62;\2\u0144\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\3]\3\2\2\2\5c\3\2\2\2\7h\3\2\2\2\tk\3\2\2\2\13p\3\2\2"+
		"\2\rx\3\2\2\2\17}\3\2\2\2\21\u0084\3\2\2\2\23\u0088\3\2\2\2\25\u008a\3"+
		"\2\2\2\27\u008c\3\2\2\2\31\u008e\3\2\2\2\33\u0090\3\2\2\2\35\u0092\3\2"+
		"\2\2\37\u0094\3\2\2\2!\u0096\3\2\2\2#\u0099\3\2\2\2%\u009c\3\2\2\2\'\u009f"+
		"\3\2\2\2)\u00a1\3\2\2\2+\u00a3\3\2\2\2-\u00a5\3\2\2\2/\u00a7\3\2\2\2\61"+
		"\u00a9\3\2\2\2\63\u00ab\3\2\2\2\65\u00ad\3\2\2\2\67\u00af\3\2\2\29\u00b1"+
		"\3\2\2\2;\u00b3\3\2\2\2=\u00b5\3\2\2\2?\u00b7\3\2\2\2A\u00ba\3\2\2\2C"+
		"\u00cb\3\2\2\2E\u00da\3\2\2\2G\u00e0\3\2\2\2I\u00f0\3\2\2\2K\u00f2\3\2"+
		"\2\2M\u00f7\3\2\2\2O\u0100\3\2\2\2Q\u0107\3\2\2\2S\u0110\3\2\2\2U\u0123"+
		"\3\2\2\2W\u0126\3\2\2\2Y\u012b\3\2\2\2[\u012f\3\2\2\2]^\7r\2\2^_\7t\2"+
		"\2_`\7k\2\2`a\7p\2\2ab\7v\2\2b\4\3\2\2\2cd\7f\2\2de\7c\2\2ef\7v\2\2fg"+
		"\7c\2\2g\6\3\2\2\2hi\7k\2\2ij\7h\2\2j\b\3\2\2\2kl\7g\2\2lm\7n\2\2mn\7"+
		"u\2\2no\7g\2\2o\n\3\2\2\2pq\7k\2\2qr\7v\2\2rs\7g\2\2st\7t\2\2tu\7c\2\2"+
		"uv\7v\2\2vw\7g\2\2w\f\3\2\2\2xy\7t\2\2yz\7g\2\2z{\7c\2\2{|\7f\2\2|\16"+
		"\3\2\2\2}~\7t\2\2~\177\7g\2\2\177\u0080\7v\2\2\u0080\u0081\7w\2\2\u0081"+
		"\u0082\7t\2\2\u0082\u0083\7p\2\2\u0083\20\3\2\2\2\u0084\u0085\7p\2\2\u0085"+
		"\u0086\7g\2\2\u0086\u0087\7y\2\2\u0087\22\3\2\2\2\u0088\u0089\7-\2\2\u0089"+
		"\24\3\2\2\2\u008a\u008b\7/\2\2\u008b\26\3\2\2\2\u008c\u008d\7,\2\2\u008d"+
		"\30\3\2\2\2\u008e\u008f\7\61\2\2\u008f\32\3\2\2\2\u0090\u0091\7\'\2\2"+
		"\u0091\34\3\2\2\2\u0092\u0093\7>\2\2\u0093\36\3\2\2\2\u0094\u0095\7@\2"+
		"\2\u0095 \3\2\2\2\u0096\u0097\7?\2\2\u0097\u0098\7?\2\2\u0098\"\3\2\2"+
		"\2\u0099\u009a\7#\2\2\u009a\u009b\7?\2\2\u009b$\3\2\2\2\u009c\u009d\7"+
		"(\2\2\u009d\u009e\7(\2\2\u009e&\3\2\2\2\u009f\u00a0\7#\2\2\u00a0(\3\2"+
		"\2\2\u00a1\u00a2\7*\2\2\u00a2*\3\2\2\2\u00a3\u00a4\7+\2\2\u00a4,\3\2\2"+
		"\2\u00a5\u00a6\7]\2\2\u00a6.\3\2\2\2\u00a7\u00a8\7_\2\2\u00a8\60\3\2\2"+
		"\2\u00a9\u00aa\7}\2\2\u00aa\62\3\2\2\2\u00ab\u00ac\7\177\2\2\u00ac\64"+
		"\3\2\2\2\u00ad\u00ae\7=\2\2\u00ae\66\3\2\2\2\u00af\u00b0\7\60\2\2\u00b0"+
		"8\3\2\2\2\u00b1\u00b2\7.\2\2\u00b2:\3\2\2\2\u00b3\u00b4\7?\2\2\u00b4<"+
		"\3\2\2\2\u00b5\u00b6\7<\2\2\u00b6>\3\2\2\2\u00b7\u00b8\7<\2\2\u00b8\u00b9"+
		"\7<\2\2\u00b9@\3\2\2\2\u00ba\u00bb\7/\2\2\u00bb\u00bc\7/\2\2\u00bc\u00c0"+
		"\3\2\2\2\u00bd\u00bf\13\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2"+
		"\u00c0\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c6\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c3\u00c5\n\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c9\u00ca\b!\2\2\u00caB\3\2\2\2\u00cb\u00cc\7}\2\2\u00cc\u00cd"+
		"\7/\2\2\u00cd\u00d1\3\2\2\2\u00ce\u00d0\13\2\2\2\u00cf\u00ce\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d4\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7/\2\2\u00d5\u00d6\7\177\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d8\b\"\2\2\u00d8D\3\2\2\2\u00d9\u00db\t\3\2\2"+
		"\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\b#\2\2\u00dfF\3\2\2\2\u00e0\u00e4"+
		"\5Y-\2\u00e1\u00e3\5W,\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5H\3\2\2\2\u00e6\u00e4\3\2\2\2"+
		"\u00e7\u00e8\7v\2\2\u00e8\u00e9\7t\2\2\u00e9\u00ea\7w\2\2\u00ea\u00f1"+
		"\7g\2\2\u00eb\u00ec\7h\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7n\2\2\u00ee"+
		"\u00ef\7u\2\2\u00ef\u00f1\7g\2\2\u00f0\u00e7\3\2\2\2\u00f0\u00eb\3\2\2"+
		"\2\u00f1J\3\2\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7w\2\2\u00f4\u00f5\7"+
		"n\2\2\u00f5\u00f6\7n\2\2\u00f6L\3\2\2\2\u00f7\u00fc\5W,\2\u00f8\u00fb"+
		"\5U+\2\u00f9\u00fb\t\4\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb"+
		"\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fdN\3\2\2\2"+
		"\u00fe\u00fc\3\2\2\2\u00ff\u0101\t\5\2\2\u0100\u00ff\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103P\3\2\2\2\u0104"+
		"\u0106\t\5\2\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010c\7\60\2\2\u010b\u010d\t\5\2\2\u010c\u010b\3\2\2\2\u010d\u010e\3"+
		"\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010fR\3\2\2\2\u0110\u011d"+
		"\7)\2\2\u0111\u011e\5U+\2\u0112\u0113\7^\2\2\u0113\u011e\7p\2\2\u0114"+
		"\u0115\7^\2\2\u0115\u011e\7v\2\2\u0116\u0117\7^\2\2\u0117\u011e\7d\2\2"+
		"\u0118\u0119\7^\2\2\u0119\u011e\7t\2\2\u011a\u011b\7^\2\2\u011b\u011e"+
		"\7^\2\2\u011c\u011e\5[.\2\u011d\u0111\3\2\2\2\u011d\u0112\3\2\2\2\u011d"+
		"\u0114\3\2\2\2\u011d\u0116\3\2\2\2\u011d\u0118\3\2\2\2\u011d\u011a\3\2"+
		"\2\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\7)\2\2\u0120"+
		"T\3\2\2\2\u0121\u0124\5Y-\2\u0122\u0124\5W,\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0122\3\2\2\2\u0124V\3\2\2\2\u0125\u0127\4c|\2\u0126\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129X\3\2\2\2"+
		"\u012a\u012c\4C\\\2\u012b\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012b"+
		"\3\2\2\2\u012d\u012e\3\2\2\2\u012eZ\3\2\2\2\u012f\u0130\4\2\u0101\2\u0130"+
		"\\\3\2\2\2\22\2\u00c0\u00c6\u00d1\u00dc\u00e4\u00f0\u00fa\u00fc\u0102"+
		"\u0107\u010e\u011d\u0123\u0128\u012d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}