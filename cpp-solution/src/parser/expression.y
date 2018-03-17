%{
#include <iostream>
#include <string>
#include "../expression.h"

int yylex(void);
void yyerror(const char *);

expression* result = nullptr;
%}

%union {
    expression* e;
    std::string* name;
}

%token <name> NAME
%token IMP OR AND NEG
%token LEFT RIGHT
%token END

%right IMP
%left OR
%left AND
%left NEG

%type <e> Input Expression

%start Input

%%
Input: Expression { result = $1; }
;

Expression:
     NAME { $$=new variable(*$1); }
| Expression IMP Expression { $$=new implication($1, $3); }
| Expression OR Expression { $$=new disjunction($1, $3); }
| Expression AND Expression { $$=new conjunction($1, $3); }
| NEG Expression { $$=new negation($2); }
| LEFT Expression RIGHT { $$=$2; }
;

%%
