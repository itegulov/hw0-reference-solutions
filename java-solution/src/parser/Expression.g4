grammar Expression;

@header {
package parser;
import expression.*;
}

expression returns [Expression expr] : disj=disjunction {$expr = $disj.expr;}
                                     | disj1=disjunction IMPLIES exp1=expression {$expr = new Implication($disj1.expr, $exp1.expr);};

disjunction returns [Expression expr] : conj=conjunction {$expr = $conj.expr;}
                                      | disj1=disjunction OR conj1=conjunction {$expr = new Disjunction($disj1.expr, $conj1.expr);};

conjunction returns [Expression expr] : neg=negation {$expr = $neg.expr;}
                                      | conj1=conjunction AND neg1=negation{$expr = new Conjunction($conj1.expr, $neg1.expr);};

negation returns [Expression expr] : var=variable {$expr = $var.expr;}
                                   | NOT neg=negation {$expr = new Negation($neg.expr);}
                                   | OB exp=expression CB {$expr = $exp.expr;};

variable returns [Expression expr] : VAR {$expr = new Variable($VAR.text);};

IMPLIES : '->';
OR : '|';
AND : '&';
NOT : '!';
OB : '(';
CB : ')';
VAR : [A-Z]([A-Z0-9])*;
