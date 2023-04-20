#[macro_use]
mod expression;
mod expression_parser;

use std::io::stdin;

fn main() {
    let mut s = String::new();
    stdin().read_line(&mut s).unwrap();
    let e = expression_parser::parse_expr(&s).unwrap();
    println!("{}", e.to_string())
}
