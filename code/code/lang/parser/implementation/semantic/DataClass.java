package lang.parser.implementation.semantic;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.util.HashMap;

public class DataClass extends SemanticTypes{

    protected HashMap<String, TerminalNodeImpl> properties = new HashMap<>();

    public DataClass() {

    }

    public DataClass(HashMap<String, TerminalNodeImpl> properties, String name) {
        className = name;
        this.properties = properties;
    }

    public DataClass(String name) {
        className = name;
    }

    @Override
    public boolean checkClass(SemanticTypes type) {
        return false;
    }
}
