package utils;

import parser.ExpressionLexer;
import parser.ExpressionParser;
import expression.Expression;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.File;
import java.io.IOException;

public class ExpressionsParser {

    public static Expression parse(String inPath) throws IOException {
        return readFile(inPath);
    }

    private static Expression readFile(String path) throws IOException {
        try (FastScanner in = new FastScanner(new File(path))) {
            String statement = in.next();
            ANTLRInputStream is = new ANTLRInputStream(statement);
            ExpressionLexer lexer = new ExpressionLexer(is);
            TokenStream ts = new CommonTokenStream(lexer);
            ExpressionParser parser = new ExpressionParser(ts);
            return parser.expression().expr;
        }
    }
}
