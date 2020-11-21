package lang.parser.implementation.semantic;

public class Numeric extends SemanticTypes{

    public Numeric() {
        className = "Numeric";
    }

    @Override
    public boolean checkClass(SemanticTypes type) {
        return type instanceof Numeric;
    }
}
