use std::ops::{BitOr, BitAnd, Not};
use std::string::ToString;

pub enum Expression {
    Implication(Box<Expression>, Box<Expression>),
    Disjunction(Box<Expression>, Box<Expression>),
    Conjunction(Box<Expression>, Box<Expression>),
    Negation(Box<Expression>),
    Variable(String),
}

impl BitOr for Expression {
    type Output = Expression;

    fn bitor(self, other: Expression) -> Expression {
        Expression::Disjunction(Box::new(self), Box::new(other))
    }
}

impl BitAnd for Expression {
    type Output = Expression;

    fn bitand(self, other: Expression) -> Expression {
        Expression::Conjunction(Box::new(self), Box::new(other))
    }
}

impl Not for Expression {
    type Output = Expression;
    fn not(self) -> Expression {
        Expression::Negation(Box::new(self))
    }
}

impl ToString for Expression {
    fn to_string(&self) -> String {
        match self {
            &Expression::Implication(ref a, ref b) => {
                format!("(->,{},{})", &a.to_string(), &b.to_string())
            }
            &Expression::Disjunction(ref a, ref b) => {
                format!("(|,{},{})", &a.to_string(), &b.to_string())
            }
            &Expression::Conjunction(ref a, ref b) => {
                format!("(&,{},{})", &a.to_string(), &b.to_string())
            }
            &Expression::Negation(ref a) => format!("(!{})", &a.to_string()),
            &Expression::Variable(ref s) => s.clone(),
        }
    }
}
