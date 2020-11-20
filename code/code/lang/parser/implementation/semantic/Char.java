package lang.parser.implementation.semantic;

public class Char extends SemanticTypes{
    public boolean checkClass(SemanticTypes type) {
        return type instanceof Char;
    }
}
