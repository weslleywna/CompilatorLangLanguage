/*
 Vitor Hugo Nascimento Pinto - 201535008
 Weslley Nascimento Araujo - 201535001
*/

import antlr4.parser.langLexer;
import antlr4.parser.langParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileReader;
import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) {
        try{
            String source = "C:\\Users\\wesll\\Documents\\Git\\CompiladorLinguagemLang\\src\\sample2.txt";
            CharStream cs = fromFileName(source);
            langLexer lexer = new langLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            langParser parser = new langParser(token);
            ParseTree tree = parser.prog();

            MyVisitor myVisitor = new MyVisitor();
            myVisitor.visit(tree);
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
