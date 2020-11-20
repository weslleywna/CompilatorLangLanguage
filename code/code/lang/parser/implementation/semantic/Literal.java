package lang.parser.implementation.semantic;

public class Literal extends SemanticTypes{
    public boolean checkClass(SemanticTypes type) {
        return type instanceof Literal;
    }
}
