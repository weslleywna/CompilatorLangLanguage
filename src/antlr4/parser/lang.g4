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
BOOLEAN: 'true' | 'false';
NULL: 'null';
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
LESSTHAN: '<';
MORETHAN: '>';
EQEQ: '==';
NOTEQ: '!=';
PLUS: '+';
MINUS: '-';
TIMES: '*';
SLASH: '/';
PERCENT: '%';
EQCEQC: '&&';
NOT: '!';
DP: ':';
DPDP: '::';
IDENTIFIER: LOWERCASE (CHAR | '_' | [0-9]);
TYPENAME: UPPERCASE LOWERCASE;
INTEGER: [0-9]+;
FLOAT: [0-9]* '.' [0-9]+;
LITERAL: '\'' (CHAR | [\n] | [\t] | [\b] | [\r]) '\'';
CHAR: UPPERCASE | LOWERCASE;
LOWERCASE: 'a'..'z'+;
UPPERCASE: 'A'..'Z'+;
WHITESPACE: [ \t\r\n]+ -> skip;
COMMENT: '--' .? ~[\r\n] -> skip;
MULTILINE_COMMENT: '{-' .*? '-}' -> skip;

prog : (data)* (func)*;
data : DATA IDENTIFIER KEYS_OPEN (decl)* KEYS_CLOSE;
decl : IDENTIFIER DPDP type SEMI;
func : IDENTIFIER PARENTHESIS_OPEN (params)? PARENTHESIS_CLOSE (DP type (COMMA type)*)? KEYS_OPEN (cmd)* KEYS_CLOSE;
params : IDENTIFIER DPDP type (COMMA IDENTIFIER DPDP type)*;
type : type BRACKET_OPEN BRACKET_CLOSE | btype;
btype : INTEGER | CHAR | BOOLEAN | FLOAT | IDENTIFIER;
cmd : KEYS_OPEN (cmd)* KEYS_CLOSE | IF PARENTHESIS_OPEN exp PARENTHESIS_CLOSE cmd
                    | IF PARENTHESIS_OPEN exp PARENTHESIS_CLOSE cmd ELSE cmd
                    | ITERATE PARENTHESIS_OPEN exp PARENTHESIS_CLOSE cmd
                    | READ lvalue SEMI
                    | PRINT exp SEMI
                    | RETURN exp (COMMA exp)* SEMI
                    | lvalue EQ exp SEMI
                    | IDENTIFIER PARENTHESIS_OPEN (exps)? PARENTHESIS_CLOSE (LESSTHAN lvalue (COMMA lvalue)* MORETHAN)? SEMI;
exp : exp EQCEQC exp | rexp;
rexp : aexp LESSTHAN aexp | rexp EQEQ aexp | rexp NOTEQ aexp | aexp;
aexp : aexp PLUS mexp | aexp MINUS mexp | mexp;
mexp : mexp TIMES sexp | mexp SLASH sexp | mexp PERCENT sexp | sexp;
sexp : NOT sexp | MINUS sexp | BOOLEAN | NULL | INTEGER | FLOAT | CHAR | pexp;
pexp : lvalue | PARENTHESIS_OPEN exp PARENTHESIS_CLOSE | NEW type (BRACKET_OPEN sexp BRACKET_CLOSE)? | IDENTIFIER PARENTHESIS_OPEN (exps)? PARENTHESIS_CLOSE BRACKET_OPEN exp BRACKET_CLOSE;
lvalue : IDENTIFIER | lvalue BRACKET_OPEN exp BRACKET_CLOSE | lvalue DOT IDENTIFIER;
exps : exp (COMMA exp)*;
