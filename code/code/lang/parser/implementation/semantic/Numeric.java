package lang.parser.implementation.semantic;

public class Numeric extends SemanticTypes{
    @Override
    public boolean checkClass(SemanticTypes type) {
        return type instanceof Numeric;
    }
}
