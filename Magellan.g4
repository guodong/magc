// Magellan grammar

grammar Magellan;

@header {
    package frontend.parser;
}

program
   : (classDef | pathCtlDef | threadDef | stmt)*
   ;

classDef
   : 'class' Id '(' varDef (',' varDef)* ')'
   | 'class' Id '(' varDef (',' varDef)* ')' classDefBlock
   ;

classDefBlock
   : '{' (varDef)* '}'
   ;

varDef
   : Id ':' type
   ;

type
   : Id
   | Id '[' type (',' type)* ']'
   ;

pathCtlDef
   : 'path_control' Id '(' funcArgs ')' block
   ;

funcArgs
   : funcArg (',' funcArg)*
   ;

funcArg
   : ('in' | 'out')? Id ':' type
   ;

block
   : '{' stmt* '}'
   ;

stmt
   : varDef
   | varDef '=' expr
   | expr '=' expr
   | ifStmt
   ;

ifStmt
   : 'if' '(' expr ')' block ('else' ifStmt)* ('else' block)?
   ;

expr
   : attr
   | attr '(' anonymousFunc ')'
   | attr '(' expr (',' expr)* ')'
   | mapExpr
   ;

mapExpr
   : '(' mapItem (',' mapItem)* ')'
   ;

mapItem
   : (IntegerLiteral | StringLiteral) '->' (IntegerLiteral | StringLiteral | '_')
   ;

attr
   : Id ('.' Id)*
   ;

anonymousFunc
   : Id '=>' expr
   ;

threadDef
   : 'threads' '{' threadBody '}'
   ;

threadBody
   : threadItem (',' threadItem)*
   ;

threadItem
   : 'ingestion' '=' StringLiteral '=>' 'program' '=' Id
   ;

// lexer

Id
   : [a-zA-Z_] ([a-zA-Z_] | [0-9])*
   ;

fragment WhiteSpace
   : '\u0020' | '\u0009' | '\u000D' | '\u000A'
   ;

StringLiteral
   : '"' StringElement* '"'
   ;

IntegerLiteral
   : (DecimalNumeral)
   ;

fragment StringElement
   : '\u0020' | '\u0021' | '\u0023' .. '\u007F'
   ;

fragment DecimalNumeral
   : '0' | '1' .. '9' Digit*
   ;

fragment Digit
   : '0' | '1' .. '9'
   ;

WS
   :  WhiteSpace+ -> skip
   ;

COMMENT
   :   '/*' .*? '*/' -> skip
   ;

LINE_COMMENT
   :   '//' (~[\r\n])* -> skip
   ;