/*
 Vitor Hugo Nascimento Pinto - 201535008
 Weslley Nascimento Araujo - 201535001
*/

package lang.parser.implementation;

import lang.ast.SuperNode;
import lang.parser.ParseAdaptor;
import lang.parser.implementation.lang.parser.antlr.langParser;
import lang.parser.implementation.lang.parser.antlr.langLexer;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Parser implements ParseAdaptor {
    @Override
    public SuperNode parseFile(String path) {
        try{
            CharStream cs = fromFileName(path);
            langLexer lexer = new langLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            langParser parser = new langParser(token);
            ParseTree tree = parser.prog();

            if (parser.getNumberOfSyntaxErrors() > 0) {
                return null;
            }

            Interpretator interpretator = new Interpretator();
            interpretator.visit(tree);

            SuperNode node = new Node();
            return node;
        }
        catch (IOException exception){
            exception.printStackTrace();
            return null;
        }
    }
}
