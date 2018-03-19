import com.github.h0tk3y.betterParse.grammar.parseToEnd
import Exp.*
import java.io.File
import java.io.PrintWriter
import java.util.*

object Main {
    fun prefixForm(exp: Exp): String =
            when (exp) {
                is Var -> exp.name
                is Imp -> "(->," + prefixForm(exp.left) + "," + prefixForm(exp.right) + ")"
                is Dis -> "(|," + prefixForm(exp.left) + "," + prefixForm(exp.right) + ")"
                is Con -> "(&," + prefixForm(exp.left) + "," + prefixForm(exp.right) + ")"
                is Neg -> "(!" + prefixForm(exp.exp) + ")"
            }


    @JvmStatic
    fun main(args: Array<String>) {
        Scanner(File("input.txt")).use { input ->
            PrintWriter(File("output.txt")).use { output ->
                val expStr = input.nextLine()
                val exp = expGrammar.parseToEnd(expStr)
                output.println(prefixForm(exp))
            }
        }
    }
}