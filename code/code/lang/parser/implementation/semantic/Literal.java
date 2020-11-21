package lang.parser.implementation.semantic;

public class Literal extends SemanticTypes{

    public Literal() {
        className = "Literal";
    }

    public boolean checkClass(SemanticTypes type) {
        return type instanceof Literal;
    }
}
