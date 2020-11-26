/*
 Vitor Hugo Nascimento Pinto - 201535008
 Weslley Nascimento Araujo - 201535001
*/

grammar lang;

PRINT: 'print';
DATA: 'data';
IF: 'if';
ELSE: 'else';
ITERATE: 'iterate';
READ: 'read';
RETURN: 'return';
NEW: 'new';

PLUS: '+';
MINUS: '-';
TIMES: '*';
SLASH: '/';
PERCENT: '%';

LESSTHAN: '<';
MORETHAN: '>';
EQEQ: '==';
NOTEQ: '!=';
EQCEQC: '&&';
NOT: '!';

PARENTHESIS_OPEN: '(';
PARENTHESIS_CLOSE: ')';
BRACKET_OPEN: '[';
BRACKET_CLOSE: ']';
KEYS_OPEN: '{';
KEYS_CLOSE: '}';

SEMI: ';';
DOT: '.';
COMMA: ',';
EQ: '=';
DP: ':';
DPDP: '::';

COMMENT: '--' .*? ~[\r\n]* -> skip;
MULTILINE_COMMENT: '{-' .*? '-}' -> skip;
WHITESPACE: [ \t\r\n]+ -> skip;

TYPENAME: UPPERCASE LOWERCASE*;
BOOLEAN: 'true' | 'false';
NULL: 'null';
IDENTIFIER: LOWERCASE (CHAR | '_' | [0-9])*;
INTEGER: [0-9]+;
FLOAT: [0-9]* '.' [0-9]+;
LITERAL: '\'' (CHAR | '\\n' | '\\t' | '\\b' | '\\r' | '\\\\' | UNICODE) '\'';
CHAR: UPPERCASE | LOWERCASE;
LOWERCASE: 'a'..'z'+;
UPPERCASE: 'A'..'Z'+;
UNICODE: '\u0000'..'\u00FF';

prog : (data)* (func)*;
data : DATA TYPENAME KEYS_OPEN (decl)* KEYS_CLOSE;
decl : IDENTIFIER DPDP type SEMI;
func : IDENTIFIER PARENTHESIS_OPEN (params)? PARENTHESIS_CLOSE (DP type (COMMA type)*)? KEYS_OPEN (cmd)* KEYS_CLOSE;
params : IDENTIFIER DPDP type (COMMA IDENTIFIER DPDP type)*;
type : type BRACKET_OPEN BRACKET_CLOSE | btype;
btype : INTEGER | CHAR | BOOLEAN | FLOAT | TYPENAME;
cmd :               KEYS_OPEN (cmd)* KEYS_CLOSE
                    | IF PARENTHESIS_OPEN exp PARENTHESIS_CLOSE cmd
                    | IF PARENTHESIS_OPEN exp PARENTHESIS_CLOSE cmd ELSE cmd
                    | ITERATE PARENTHESIS_OPEN exp PARENTHESIS_CLOSE cmd
                    | READ lvalue SEMI
                    | PRINT exp SEMI
                    | RETURN exp (COMMA exp)* SEMI
                    | lvalue EQ exp SEMI
                    | IDENTIFIER PARENTHESIS_OPEN (exps)? PARENTHESIS_CLOSE (LESSTHAN (DP)? lvalue (COMMA lvalue)* (DP)? MORETHAN)? SEMI;
exp : exp EQCEQC exp | rexp;
rexp : aexp LESSTHAN aexp | rexp EQEQ aexp | rexp NOTEQ aexp | aexp;
aexp : aexp PLUS mexp | aexp MINUS mexp | mexp;
mexp : mexp TIMES sexp | mexp SLASH sexp | mexp PERCENT sexp | sexp;
sexp : NOT sexp | MINUS sexp | BOOLEAN | NULL | INTEGER | FLOAT | CHAR | LITERAL | pexp;
pexp :          lvalue
                | PARENTHESIS_OPEN exp PARENTHESIS_CLOSE
                | NEW type (BRACKET_OPEN (exp)? BRACKET_CLOSE)?
                | IDENTIFIER PARENTHESIS_OPEN (exps)? PARENTHESIS_CLOSE BRACKET_OPEN exp BRACKET_CLOSE;
lvalue :        IDENTIFIER
                | lvalue BRACKET_OPEN exp BRACKET_CLOSE
                | lvalue DOT IDENTIFIER;
exps : exp (COMMA exp)*;
