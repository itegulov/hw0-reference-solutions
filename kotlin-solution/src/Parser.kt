import com.github.h0tk3y.betterParse.combinators.*
import com.github.h0tk3y.betterParse.grammar.*
import Exp.*
import com.github.h0tk3y.betterParse.parser.Parser

val expGrammar = object : Grammar<Exp>() {
    val id by token("[A-Z]([A-Z0-9])*")
    val not by token("!")
    val and by token("&")
    val or by token("\\|")
    val ws by token("\\s+", ignore = true)
    val imp by token("->")
    val lpar by token("\\(")
    val rpar by token("\\)")

    val term: Parser<Exp> by
        (id use { Var(text) }) or
        (-not * parser(this::term) map { Neg(it) }) or
        (-lpar * parser(this::rootParser) * -rpar)

    val conChain by leftAssociative(term, and) { l, _, r -> Con(l, r) }
    val disChain by leftAssociative(conChain, or) { l, _, r -> Dis(l, r) }
    override val rootParser by rightAssociative(disChain, imp) { l, _, r -> Imp(l, r) }
}
