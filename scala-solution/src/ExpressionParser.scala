import org.parboiled2._

case class ExpressionParser(input: ParserInput) extends Parser {
  def inputLine: Rule1[Expression] = rule {
    expr ~ EOI
  }
  private def expr: Rule1[Expression] = rule {
    disjunction ~ zeroOrMore("->" ~ expr ~> Imp)
  }
  private def disjunction: Rule1[Expression] = rule {
    conjunction ~ zeroOrMore("|" ~ conjunction ~> Dis)
  }
  private def conjunction: Rule1[Expression] = rule {
    negation ~ zeroOrMore("&" ~ negation ~> Con)
  }
  private def negation: Rule1[Expression] = rule {
    ("!" ~ negation ~> Neg) | variable | parens
  }
  private def variable: Rule1[Var] = rule {
    capture(letters) ~> ((a: String) => Var(a))
  }
  private def letters: Rule0 = rule {
    CharPredicate.UpperAlpha ~ zeroOrMore(CharPredicate.Digit | CharPredicate.UpperAlpha)
  }
  private def parens: Rule1[Expression] = rule {
    "(" ~ expr ~ ")"
  }
}
