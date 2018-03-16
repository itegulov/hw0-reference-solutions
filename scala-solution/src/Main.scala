import java.io.{File, PrintWriter}

import org.parboiled2.ParseError
import utils.FastScanner

import scala.util.{Failure, Success}

object Main {
  def main(args: Array[String]): Unit = {
    val in = FastScanner(new File("input.txt"))
    val out = new PrintWriter("output.txt")
    val line = in.next()
    val parser = ExpressionParser(line)
    parser.inputLine.run() match {
      case Success(expr) =>
        out.println(expr.prefixForm)
      case Failure(e) =>
        sys.error(e.toString)
    }
    in.close()
    out.close()
  }
}
