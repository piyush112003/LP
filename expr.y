%{
#include <stdio.h>
#include <stdlib.h>
%}

%token NUMBER
%left '*' '/'

%%

input: /* empty */
     | input line
     ;

line: expr '\n' { printf("Result: %.2f\n", $1); }
    ;

expr: NUMBER           { $$ = $1; }
    | expr '*' expr   { $$ = $1 * $3; }
    | expr '/' expr   { $$ = $1 / $3; }
    ;

%%

int yyerror(const char *s) {
    printf("Error: %s\n", s);
    return 0;
}

int main() {
    yyparse();
    return 0;
}