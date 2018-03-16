import expression.Expression;
import utils.ExpressionsParser;

import java.io.File;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Expression expression = ExpressionsParser.parse("input.txt");
        try (PrintWriter out = new PrintWriter(new File("output.txt"))) {
            out.println(expression.toTree());
        }
    }
}
