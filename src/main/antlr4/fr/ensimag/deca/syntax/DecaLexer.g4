lexer grammar DecaLexer;

options {
   language=Java;
   // Tell ANTLR to make the generated lexer class extend the
   // the named class, which is where any supporting code and
   // variables will be placed.
   superClass = AbstractDecaLexer;
}

@members {
}

// Deca lexer rules.
 // A FAIRE : Règle bidon qui reconnait tous les caractères.
// A FAIRE : Il faut la supprimer et la remplacer par les vraies règles.
//fragment EOL : '\n';
//mots reservés
CR : '\r'{skip();};
EOL : '\n'{skip();};
TAB : '\t'{skip();};
AT : '@';
ASM : 'asm';
INSTANCEOF : 'instanceof';
PRINTLN : 'println';
TRUE : 'true';
CLASS : 'class';
NEW : 'new';
PRINTLNX : 'printlnx';
WHILE : 'while';
EXTENDS : 'extends';
NULL : 'null';
PRINTX : 'printx';
ELSE : 'else';
READINT : 'readInt';
PROTECTED : 'protected';
FALSE : 'false';
READFLOAT : 'readFloat';
RETURN : 'return';
IF : 'if';
PRINT : 'print';
THIS : 'this';
// Identificateurs
fragment LETTER : 'a' .. 'z' | 'A' .. 'Z';
fragment DIGIT  : '0' .. '9';
IDENT : (LETTER | '$' | '_')(LETTER | DIGIT | '$' | '_')*;
//Symbols spéciaux
GT : '>';
LT : '<';
EQUALS : '=';
PLUS : '+';
MINUS : '-';
TIMES : '*';
SLASH : '/';
PERCENT : '%';
DOT : '.';
COMMA : ',';
OPARENT : '(';
CPARENT : ')';
OBRACE : '{';
CBRACE : '}';
EXCLAM : '!';
COLON : ':';
SEMI : ';';
EQEQ : '==';
NEQ : '!=';
GEQ : '>=';
LEQ : '<=';
AND : '&&';
OR : '||';
// Littéraux entiers
fragment POSITIVE_DIGIT : '1' .. '9';
INT : '0' | POSITIVE_DIGIT DIGIT*;
//Littéraux Flottants
NUM : DIGIT+;
fragment SIGN : ('+' | '-')? ;
fragment EXP : ('E' | 'e') SIGN NUM;
fragment DEC : NUM '.' NUM;
fragment FLOATDEC : (DEC | DEC EXP) ('F' | 'f')?;
fragment DIGITHEX : '0' ..'9' | 'A' .. 'F' | 'a' ..'f';
fragment NUMHEX : DIGITHEX+;
fragment FLOATHEX : ('0x' | '0X') NUMHEX '.' NUMHEX ('P' | 'p') SIGN NUM ('F' | 'f')?;
FLOAT : FLOATDEC | FLOATHEX;
// Chaînes de caractères
fragment STRING_CAR : ~('"' | '\\' | '\n');
STRING : '"' (STRING_CAR | '\\"' | '\\\\')* '"';
MULTI_LINE_STRING : '"' (STRING_CAR | '\n' | '\\' | '\\\\')* '"';
// Commentaires
COMMENT : ('/*' .*? '*/' | '//' .*? '\n') {skip();};
//Séparateurs
SPACE : ' '+{skip();};

fragment FILENAME : (LETTER | DIGIT | '.' | '-' | '_')+;
INCLUDE : '#include' (' ')* '"' FILENAME '"'{doInclude(getText());};

