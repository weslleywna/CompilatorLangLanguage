package lang.parser.implementation.semantic;

public class Boolean extends SemanticTypes{


    public Boolean() {
        className = "Boolean";
    }

    public boolean checkClass(SemanticTypes type) {
        return type instanceof Boolean;
    }
}
