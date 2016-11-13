/** 
 *  grammar for simpleAsm
 */
grammar SimpleAsm;


@header {
    package antlrparser;

    // PARSER_VERSION = "0.2";
}


/** A rule called init that matches comma-separated values between {...}. */
init  :  stmt* ;

stmt : segmentStmt
     | dataDecl
     | arrayInit ;

segmentStmt : TEXTS
      | DATAS ;

dataDecl : label TYPE arrayInit ;

label : ALPHA ':' ;
   

arrayInit : '{' value (',' value)* '}' ;  // must match at least one value

/** A value can be either a nested array/struct or a simple integer (INT) */
value : arrayInit
      | INT
      ;

// parser rules start with lowercase letters, lexer rules with uppercase
INT :   [0-9]+ ;             // Define token INT as one or more digits
ALPHA:  [a-zA-Z]+ ;
TYPE :  '.word' ;
WS  :   [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out

TEXTS : '.text' ;
DATAS : '.data' ;
