sealed trait Expression {
  def prefixForm: String = this match {
    case Var(name)        => name
    case Imp(left, right) => s"(->,${left.prefixForm},${right.prefixForm})"
    case Dis(left, right) => s"(|,${left.prefixForm},${right.prefixForm})"
    case Con(left, right) => s"(&,${left.prefixForm},${right.prefixForm})"
    case Neg(expression)  => s"(!${expression.prefixForm})"
  }
}

final case class Var(name: String) extends Expression
final case class Imp(left: Expression, right: Expression) extends Expression
final case class Dis(left: Expression, right: Expression) extends Expression
final case class Con(left: Expression, right: Expression) extends Expression
final case class Neg(expression: Expression) extends Expression