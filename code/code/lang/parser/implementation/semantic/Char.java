package lang.parser.implementation.semantic;

public class Char extends SemanticTypes{

    public Char() {
        className = "Char";
    }

    public boolean checkClass(SemanticTypes type) {
        return type instanceof Char;
    }
}
