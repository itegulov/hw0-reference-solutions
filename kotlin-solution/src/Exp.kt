sealed class Exp {
    data class Var(val name: String) : Exp()
    data class Imp(val left: Exp, val right: Exp) : Exp()
    data class Dis(val left: Exp, val right: Exp) : Exp()
    data class Con(val left: Exp, val right: Exp) : Exp()
    data class Neg(val exp: Exp) : Exp()
}