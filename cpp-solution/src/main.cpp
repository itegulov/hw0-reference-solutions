#include <iostream>
#include "expression.h"
#include "parser/expression.tab.h"
#include "parser/expression.lexer.h"
using namespace std;

extern expression* result;

void yyerror(const char *error) {
    cerr << error;
}

int yywrap() {
    return 1;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    string expression;
    cin >> expression;
    yy_scan_string(expression.c_str());
    yyparse();
    std::cout << result->prefix_form() << std::endl;
    return 0;
}
