%option noyywrap

%{
    #include<stdio.h>
%}

%%

"{"                         {printf("Open_Brace : %s\n",yytext);}
"}"                         {printf("Close_Brace : %s\n",yytext);}
"int"|"float"               {printf("DataType : %s\n",yytext);}
[0-9_]+                     {printf("Number : %s\n",yytext);}
";"                         {printf("Semicolon : %s\n",yytext);}
"*"                         {printf("Multiply : %s\n",yytext);}
"+"                         {printf("addition : %s\n",yytext);}
"("                         {printf("Open Paren : %s\n",yytext);}
")"                         {printf("Close Paren : %s\n",yytext);}
","                         {printf("Comma : %s\n",yytext);}
"="                         {printf("Assignment : %s\n",yytext);}
[a-zA-Z_][a-zA-Z0-9_]*      {printf("Identifier : %s\n",yytext);}

%%

int main(){
    yyin = stdin;
    yylex();
    return 0;
}