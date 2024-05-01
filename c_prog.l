%option noyywrap

%{
    #include<stdio.h>
%}

%%

"{"                 {printf("Open Brace : %s\n",yytext);}
"}"                 {printf("Close Brace : %s\n",yytext);}
"int"               {printf("Datetype : %s\n",yytext);}
"="                  {printf("Assignment op : %s\n",yytext);}
":"                 {printf("Colon : %s\n",yytext);}
"printf"            {printf("Function : %s\n",yytext);}
[a-zA-Z0-9_][a-zA-Z]* {printf("Identifier : %s\n",yytext);}
[0-9_]+             {printf("Number : %s\n",yytext);}
"("                 {printf("left paren : %s\n",yytext);}
")"                 {printf("right paren : %s\n",yytext);}
","                 {printf("Comma : %s\n",yytext);}
[\t]                ;   //ignore white sapces
.                   ;   // ignore all other chars

%%

int main(){
    yyin = stdin;
    yylex();
    return 0;
}