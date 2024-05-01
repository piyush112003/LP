%option noyywrap

%{
#include <stdio.h>
%}

%%

"{"                     {printf("open_brace : %s\n",yytext);}
"}"                     {printf("close_brace : %s\n",yytext);}
"int"                   {printf("Datatype : %s\n",yytext);}
[a-zA-Z_][a-zA-Z0-9_]*  {printf("Identifier : %s\n",yytext);}
"="                     {printf("Assignment : %s\n",yytext);}
";"                     {printf("Semoicolon : %s\n",yytext);}
","                     {printf("Comma : %s\n",yytext);}
"-"                     {printf("Substraction : %s\n",yytext);}

%%

int main(){
    yyin = stdin;
    yylex();
    return 0;
}