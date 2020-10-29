// Generated from C:/Users/wesll/Documents/Git/CompiladorLinguagemLang/src/antlr4/parser\lang.g4 by ANTLR 4.8
package antlr4.parser;
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
		IDENTIFIER=1, TYPENAME=2, INTEGER=3, FLOAT=4, LITERAL=5, CHAR=6, BOOLEAN=7, 
		NULL=8, LOWERCASE=9, UPPERCASE=10, PARENTHESIS_OPEN=11, PARENTHESIS_CLOSE=12, 
		BRACKET_OPEN=13, BRACKET_CLOSE=14, KEYS_OPEN=15, KEYS_CLOSE=16, SEMI=17, 
		DOT=18, COMMA=19, EQ=20, LESSTHAN=21, MORETHAN=22, EQEQ=23, NOTEQ=24, 
		PLUS=25, MINUS=26, TIMES=27, SLASH=28, PERCENT=29, EQCEQC=30, NOT=31, 
		DP=32, DPDP=33, WHITESPACE=34, COMMENT=35, MULTILINE_COMMENT=36, DATA=37, 
		IF=38, ELSE=39, ITERATE=40, READ=41, PRINT=42, RETURN=43, NEW=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IDENTIFIER", "TYPENAME", "INTEGER", "FLOAT", "LITERAL", "CHAR", "BOOLEAN", 
			"NULL", "LOWERCASE", "UPPERCASE", "PARENTHESIS_OPEN", "PARENTHESIS_CLOSE", 
			"BRACKET_OPEN", "BRACKET_CLOSE", "KEYS_OPEN", "KEYS_CLOSE", "SEMI", "DOT", 
			"COMMA", "EQ", "LESSTHAN", "MORETHAN", "EQEQ", "NOTEQ", "PLUS", "MINUS", 
			"TIMES", "SLASH", "PERCENT", "EQCEQC", "NOT", "DP", "DPDP", "WHITESPACE", 
			"COMMENT", "MULTILINE_COMMENT", "DATA", "IF", "ELSE", "ITERATE", "READ", 
			"PRINT", "RETURN", "NEW"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "'NULL'", null, null, 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "'.'", "','", "'='", 
			"'<'", "'>'", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", 
			"'!'", "':'", "'::'", null, null, null, "'DATA'", "'IF'", "'ELSE'", "'ITERATE'", 
			"'READ'", "'PRINT'", "'RETURN'", "'NEW'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IDENTIFIER", "TYPENAME", "INTEGER", "FLOAT", "LITERAL", "CHAR", 
			"BOOLEAN", "NULL", "LOWERCASE", "UPPERCASE", "PARENTHESIS_OPEN", "PARENTHESIS_CLOSE", 
			"BRACKET_OPEN", "BRACKET_CLOSE", "KEYS_OPEN", "KEYS_CLOSE", "SEMI", "DOT", 
			"COMMA", "EQ", "LESSTHAN", "MORETHAN", "EQEQ", "NOTEQ", "PLUS", "MINUS", 
			"TIMES", "SLASH", "PERCENT", "EQCEQC", "NOT", "DP", "DPDP", "WHITESPACE", 
			"COMMENT", "MULTILINE_COMMENT", "DATA", "IF", "ELSE", "ITERATE", "READ", 
			"PRINT", "RETURN", "NEW"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0115\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\5\2_\n\2\3\3\3\3\3\3\3\4\6\4e\n\4\r\4\16\4f\3\5"+
		"\7\5j\n\5\f\5\16\5m\13\5\3\5\3\5\6\5q\n\5\r\5\16\5r\3\6\3\6\3\6\5\6x\n"+
		"\6\3\6\3\6\3\7\3\7\5\7~\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0089"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\n\6\n\u0091\n\n\r\n\16\n\u0092\3\13\6\13\u0096"+
		"\n\13\r\13\16\13\u0097\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\6#\u00cd\n#\r#\16#"+
		"\u00ce\3#\3#\3$\3$\3$\3$\5$\u00d7\n$\3$\3$\3$\3$\3%\3%\3%\3%\7%\u00e1"+
		"\n%\f%\16%\u00e4\13%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3"+
		",\3,\3,\3,\3,\3,\3-\3-\3-\3-\3\u00e2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.\3\2\7\4\2\62;aa\3\2\62;\4\2\n\f\17\17\5\2\13\f\17\17\"\"\4\2\f\f\17"+
		"\17\2\u0120\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5`\3\2\2\2\7d\3\2"+
		"\2\2\tk\3\2\2\2\13t\3\2\2\2\r}\3\2\2\2\17\u0088\3\2\2\2\21\u008a\3\2\2"+
		"\2\23\u0090\3\2\2\2\25\u0095\3\2\2\2\27\u0099\3\2\2\2\31\u009b\3\2\2\2"+
		"\33\u009d\3\2\2\2\35\u009f\3\2\2\2\37\u00a1\3\2\2\2!\u00a3\3\2\2\2#\u00a5"+
		"\3\2\2\2%\u00a7\3\2\2\2\'\u00a9\3\2\2\2)\u00ab\3\2\2\2+\u00ad\3\2\2\2"+
		"-\u00af\3\2\2\2/\u00b1\3\2\2\2\61\u00b4\3\2\2\2\63\u00b7\3\2\2\2\65\u00b9"+
		"\3\2\2\2\67\u00bb\3\2\2\29\u00bd\3\2\2\2;\u00bf\3\2\2\2=\u00c1\3\2\2\2"+
		"?\u00c4\3\2\2\2A\u00c6\3\2\2\2C\u00c8\3\2\2\2E\u00cc\3\2\2\2G\u00d2\3"+
		"\2\2\2I\u00dc\3\2\2\2K\u00ea\3\2\2\2M\u00ef\3\2\2\2O\u00f2\3\2\2\2Q\u00f7"+
		"\3\2\2\2S\u00ff\3\2\2\2U\u0104\3\2\2\2W\u010a\3\2\2\2Y\u0111\3\2\2\2["+
		"^\5\23\n\2\\_\5\r\7\2]_\t\2\2\2^\\\3\2\2\2^]\3\2\2\2_\4\3\2\2\2`a\5\25"+
		"\13\2ab\5\23\n\2b\6\3\2\2\2ce\t\3\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg"+
		"\3\2\2\2g\b\3\2\2\2hj\t\3\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2"+
		"ln\3\2\2\2mk\3\2\2\2np\7\60\2\2oq\t\3\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2"+
		"\2rs\3\2\2\2s\n\3\2\2\2tw\7)\2\2ux\5\r\7\2vx\t\4\2\2wu\3\2\2\2wv\3\2\2"+
		"\2xy\3\2\2\2yz\7)\2\2z\f\3\2\2\2{~\5\25\13\2|~\5\23\n\2}{\3\2\2\2}|\3"+
		"\2\2\2~\16\3\2\2\2\177\u0080\7V\2\2\u0080\u0081\7T\2\2\u0081\u0082\7W"+
		"\2\2\u0082\u0089\7G\2\2\u0083\u0084\7H\2\2\u0084\u0085\7C\2\2\u0085\u0086"+
		"\7N\2\2\u0086\u0087\7U\2\2\u0087\u0089\7G\2\2\u0088\177\3\2\2\2\u0088"+
		"\u0083\3\2\2\2\u0089\20\3\2\2\2\u008a\u008b\7P\2\2\u008b\u008c\7W\2\2"+
		"\u008c\u008d\7N\2\2\u008d\u008e\7N\2\2\u008e\22\3\2\2\2\u008f\u0091\4"+
		"c|\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\24\3\2\2\2\u0094\u0096\4C\\\2\u0095\u0094\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\26"+
		"\3\2\2\2\u0099\u009a\7*\2\2\u009a\30\3\2\2\2\u009b\u009c\7+\2\2\u009c"+
		"\32\3\2\2\2\u009d\u009e\7]\2\2\u009e\34\3\2\2\2\u009f\u00a0\7_\2\2\u00a0"+
		"\36\3\2\2\2\u00a1\u00a2\7}\2\2\u00a2 \3\2\2\2\u00a3\u00a4\7\177\2\2\u00a4"+
		"\"\3\2\2\2\u00a5\u00a6\7=\2\2\u00a6$\3\2\2\2\u00a7\u00a8\7\60\2\2\u00a8"+
		"&\3\2\2\2\u00a9\u00aa\7.\2\2\u00aa(\3\2\2\2\u00ab\u00ac\7?\2\2\u00ac*"+
		"\3\2\2\2\u00ad\u00ae\7>\2\2\u00ae,\3\2\2\2\u00af\u00b0\7@\2\2\u00b0.\3"+
		"\2\2\2\u00b1\u00b2\7?\2\2\u00b2\u00b3\7?\2\2\u00b3\60\3\2\2\2\u00b4\u00b5"+
		"\7#\2\2\u00b5\u00b6\7?\2\2\u00b6\62\3\2\2\2\u00b7\u00b8\7-\2\2\u00b8\64"+
		"\3\2\2\2\u00b9\u00ba\7/\2\2\u00ba\66\3\2\2\2\u00bb\u00bc\7,\2\2\u00bc"+
		"8\3\2\2\2\u00bd\u00be\7\61\2\2\u00be:\3\2\2\2\u00bf\u00c0\7\'\2\2\u00c0"+
		"<\3\2\2\2\u00c1\u00c2\7(\2\2\u00c2\u00c3\7(\2\2\u00c3>\3\2\2\2\u00c4\u00c5"+
		"\7#\2\2\u00c5@\3\2\2\2\u00c6\u00c7\7<\2\2\u00c7B\3\2\2\2\u00c8\u00c9\7"+
		"<\2\2\u00c9\u00ca\7<\2\2\u00caD\3\2\2\2\u00cb\u00cd\t\5\2\2\u00cc\u00cb"+
		"\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d1\b#\2\2\u00d1F\3\2\2\2\u00d2\u00d3\7/\2\2\u00d3"+
		"\u00d4\7/\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d7\13\2\2\2\u00d6\u00d5\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\n\6\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00db\b$\2\2\u00dbH\3\2\2\2\u00dc\u00dd\7}\2\2\u00dd"+
		"\u00de\7/\2\2\u00de\u00e2\3\2\2\2\u00df\u00e1\13\2\2\2\u00e0\u00df\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3"+
		"\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\7/\2\2\u00e6\u00e7\7\177"+
		"\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\b%\2\2\u00e9J\3\2\2\2\u00ea\u00eb"+
		"\7F\2\2\u00eb\u00ec\7C\2\2\u00ec\u00ed\7V\2\2\u00ed\u00ee\7C\2\2\u00ee"+
		"L\3\2\2\2\u00ef\u00f0\7K\2\2\u00f0\u00f1\7H\2\2\u00f1N\3\2\2\2\u00f2\u00f3"+
		"\7G\2\2\u00f3\u00f4\7N\2\2\u00f4\u00f5\7U\2\2\u00f5\u00f6\7G\2\2\u00f6"+
		"P\3\2\2\2\u00f7\u00f8\7K\2\2\u00f8\u00f9\7V\2\2\u00f9\u00fa\7G\2\2\u00fa"+
		"\u00fb\7T\2\2\u00fb\u00fc\7C\2\2\u00fc\u00fd\7V\2\2\u00fd\u00fe\7G\2\2"+
		"\u00feR\3\2\2\2\u00ff\u0100\7T\2\2\u0100\u0101\7G\2\2\u0101\u0102\7C\2"+
		"\2\u0102\u0103\7F\2\2\u0103T\3\2\2\2\u0104\u0105\7R\2\2\u0105\u0106\7"+
		"T\2\2\u0106\u0107\7K\2\2\u0107\u0108\7P\2\2\u0108\u0109\7V\2\2\u0109V"+
		"\3\2\2\2\u010a\u010b\7T\2\2\u010b\u010c\7G\2\2\u010c\u010d\7V\2\2\u010d"+
		"\u010e\7W\2\2\u010e\u010f\7T\2\2\u010f\u0110\7P\2\2\u0110X\3\2\2\2\u0111"+
		"\u0112\7P\2\2\u0112\u0113\7G\2\2\u0113\u0114\7Y\2\2\u0114Z\3\2\2\2\17"+
		"\2^fkrw}\u0088\u0092\u0097\u00ce\u00d6\u00e2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}