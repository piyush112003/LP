%{
#include<stdio.h>
%}

%option noyywrap

%%

"Dread"|"Run"|"arrives"     {printf("VERB : %s\n",yytext);}
"it"                        {printf("PRONOUN : %s\n",yytext);}
"."                         {printf("FULLSTOP : %s\n",yytext);}
"Destiny"                   {printf("Noun : %s\n",yytext);}

%%

int main(){
    yyin = stdin;
    yylex();
    return 0;
}