package lang.parser.implementation.semantic;

import lang.parser.implementation.lang.parser.antlr.langBaseVisitor;
import lang.parser.implementation.lang.parser.antlr.langParser;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.lang.reflect.Array;
import java.util.*;

public class SemanticAnalyser extends langBaseVisitor<Object> {

    private final HashMap<String, Object> functions;
    private final HashMap<String, Object> dataClass;
    private final HashSet<String> variablesNames;

    public SemanticAnalyser() {
        functions = new HashMap<>();
        dataClass = new HashMap<>();
        variablesNames = new HashSet<>();
    }

    @Override
    public SemanticTypes visitProg(langParser.ProgContext ctx) {

        for (langParser.FuncContext ctxFunc : ctx.func()) {
            functions.put(ctxFunc.getChild(0).getText(), ctxFunc);
        }

        if (functions.get("main") != null) {
            return this.visitFunc((langParser.FuncContext) functions.get("main"));
        }

        throw new RuntimeException("no main function");
    }

    @Override
    public SemanticTypes visitData(langParser.DataContext ctx) {
        if (ctx.getChild(0) == ctx.DATA()) {
            DataClass dataClassDefinition = new DataClass();
            if (Objects.nonNull(ctx.decl())) {
                for (langParser.DeclContext ctxDecl : ctx.decl()) {
                    Object result = this.visitDecl(ctxDecl);
                    dataClassDefinition.properties.put(ctxDecl.getChild(0).getText(), (TerminalNodeImpl) result);
                }
            }
            if(dataClass.get(ctx.getChild(1).getText()) != null) {
                throw new RuntimeException("DataClass already defined");
            }
            dataClass.put(ctx.getChild(1).getText(), dataClassDefinition);
        }
        return null;
    }

    @Override
    public SemanticTypes visitDecl(langParser.DeclContext ctx) {
        if (ctx.getChild(0) == ctx.IDENTIFIER()) {
            return this.visitType(ctx.type());
        }
        throw new RuntimeException("unknown identifier: " + ctx.getChild(0).toString());
    }

    @Override
    public SemanticTypes visitFunc(langParser.FuncContext ctx) {
        //TODO: IDENTIFIER PARENTHESIS_OPEN (params)? PARENTHESIS_CLOSE (DP type (COMMA type)*)? KEYS_OPEN (cmd)* KEYS_CLOSE
        for (langParser.CmdContext ctxCmd : ctx.cmd()) {
            if (this.visitCmd(ctxCmd) == null) {
                return null;
            };
        }

        return null;
    }

    @Override
    public List<SemanticTypes> visitParams(langParser.ParamsContext ctx) {

        ArrayList<SemanticTypes> functionParameters = new ArrayList<>();

        for (langParser.TypeContext ctxType : ctx.type()) {
            functionParameters.add(this.visitType(ctxType));
        }

        return functionParameters;
    }

    @Override
    public SemanticTypes visitType(langParser.TypeContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitBtype(ctx.btype());
        }
        else {
            return this.visitType(ctx.type());
        }
    }

    @Override
    public SemanticTypes visitBtype(langParser.BtypeContext ctx) {

        if(ctx.getChild(0) == ctx.INTEGER()) {
            return new Numeric();
        }

        if(ctx.getChild(0) == ctx.CHAR()) {
            return new Char();
        }

        if(ctx.getChild(0) == ctx.BOOLEAN()) {
            return new Boolean();
        }

        if(ctx.getChild(0) == ctx.FLOAT()) {
            return new Numeric();
        }

        if(ctx.getChild(0) == ctx.TYPENAME()) {
            if(dataClass.get(ctx.getChild(0).toString()) == null) {
                throw new RuntimeException("Type: " + ctx.getChild(0) + " is not defined yet");
            } else {
                return new DataClass(ctx.getChild(0).toString());
            }
        }

        throw new RuntimeException("unknown operator: " + ctx.getChild(0).toString());
    }

    @Override
    public SemanticTypes visitCmd(langParser.CmdContext ctx) {
        if(ctx.getChild(0) == ctx.lvalue(0)) {
            variablesNames.add(ctx.lvalue(0).getText());
            Object valueLValue = visitLvalue(ctx.lvalue(0));
            SemanticTypes valueExp = visitExp(ctx.exp(0));

            System.out.println(valueLValue);
            System.out.println(valueExp);
        }

        if(ctx.getChild(0) == ctx.KEYS_OPEN()){
            for (langParser.CmdContext ctxCmd : ctx.cmd()) {
                return this.visitCmd(ctxCmd);
            }
        }

        if(ctx.getChild(0) == ctx.IF()){
            SemanticTypes expression = this.visitExp(ctx.exp(0));
            if (!expression.checkClass(new Boolean())) {
                throw new RuntimeException("The expression is not a boolean");
            }
            for (langParser.CmdContext ctxCmd : ctx.cmd()) {
                this.visitCmd(ctxCmd);
            }
        }

        if(ctx.getChild(0) == ctx.ITERATE()){
            SemanticTypes expresion = visitExp(ctx.exp(0));

            if (! expresion.checkClass(new Boolean())) {
                throw new RuntimeException("The expression is not a boolean");
            }

            visitCmd(ctx.cmd(0));
        }

        if(ctx.getChild(0) == ctx.READ()){
            Object value = visitLvalue(ctx.lvalue(0));
            if(value instanceof String){
                if (variablesNames.stream().anyMatch(x -> x.equals(value.toString()))) {
                    throw new RuntimeException("Variable is already declared");
                } else {
                    variablesNames.add(value.toString());
                    return null;
                }
            } else{
                throw new RuntimeException("Invalid value to read");
            }
        }
        if(ctx.getChild(0) == ctx.PRINT()){
            visitExp(ctx.exp(0));
        }
        if(ctx.getChild(0) == ctx.RETURN()){
            //TODO: RETURN exp (COMMA exp)* SEMI
        }
        if(ctx.getChild(0) == ctx.lvalue()){
            //TODO: lvalue EQ exp SEMI
        }
        if(ctx.getChild(0) == ctx.IDENTIFIER()){
            //TODO: IDENTIFIER PARENTHESIS_OPEN (exps)? PARENTHESIS_CLOSE (LESSTHAN (DP)? lvalue (COMMA lvalue)* (DP)? MORETHAN)? SEMI;
        }

        return null;
    }

    @Override
    public SemanticTypes visitExp(langParser.ExpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitRexp(ctx.rexp());
        }

        SemanticTypes left = this.visitExp(ctx.exp(0));
        SemanticTypes right = this.visitExp(ctx.exp(1));

        if (!left.checkClass(right)) {
            throw new RuntimeException("different type:");
        }

        return left;
    }

    @Override
    public SemanticTypes visitRexp(langParser.RexpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitAexp(ctx.aexp(0));
        }

        SemanticTypes left = this.visitAexp(ctx.aexp(0));
        SemanticTypes right = ctx.getChild(1).toString().equals("<") ? this.visitAexp(ctx.aexp(1)) : this.visitRexp(ctx.rexp());

        if (!left.checkClass(right)) {
            throw new RuntimeException("different types");
        }

        return new Boolean();
    }

    @Override
    public SemanticTypes visitAexp(langParser.AexpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitMexp(ctx.mexp());
        }

        SemanticTypes left = this.visitAexp(ctx.aexp());
        SemanticTypes right = this.visitMexp(ctx.mexp());

        if (!left.checkClass(new Numeric())){
            throw new RuntimeException("invalid type operator: " + left.toString());
        }

        if (!right.checkClass(new Numeric())){
            throw new RuntimeException("invalid type operator: " + right.toString());
        }

        return left;
    }

    @Override
    public SemanticTypes visitMexp(langParser.MexpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitSexp(ctx.sexp());
        }

        SemanticTypes left = this.visitMexp(ctx.mexp());
        SemanticTypes right = this.visitSexp(ctx.sexp());

        if (!left.checkClass(new Numeric())){
            throw new RuntimeException("invalid type operator: " + left.toString());
        }

        if (!right.checkClass(new Numeric())){
            throw new RuntimeException("invalid type operator: " + right.toString());
        }

        return left;
    }

    @Override
    public SemanticTypes visitSexp(langParser.SexpContext ctx) {
        SemanticTypes type;
        switch (ctx.getChild(0).toString()){
            case "!":
                type = this.visitSexp(ctx.sexp());
                if (!type.checkClass(new Boolean())) {
                    throw new RuntimeException("invalid type");
                }
                return type;
            case "-":
                type = this.visitSexp(ctx.sexp());
                if (!type.checkClass(new Numeric())) {
                    throw new RuntimeException("invalid type");
                }
                return type;
        }

        if(ctx.getChild(0) == ctx.BOOLEAN()) {
            return new Boolean();
        }
        if(ctx.getChild(0) == ctx.NULL()) {
            return null;
        }
        if(ctx.getChild(0) == ctx.INTEGER()) {
            return new Numeric();
        }
        if(ctx.getChild(0) == ctx.FLOAT()) {
            return new Numeric();
        }
        if(ctx.getChild(0) == ctx.CHAR()) {
            return new Char();
        }
        if(ctx.getChild(0) == ctx.LITERAL()) {
            return new Literal();
        }
        if (ctx.pexp() != null) {
            return this.visitPexp(ctx.pexp());
        }

        throw new RuntimeException("unknown operator: " + ctx.getChild(0).toString());
    }

    @Override
    public SemanticTypes visitPexp(langParser.PexpContext ctx) {
        if (ctx.getChildCount() == 1) {

            Object variable = visitLvalue(ctx.lvalue());

            if (!(variable instanceof SemanticTypes)) {
                throw new RuntimeException("variable is not declared: ");
            }

            return (SemanticTypes) variable;

        }
        if (ctx.getChild(0) == ctx.PARENTHESIS_OPEN())
        {
            return this.visitExp(ctx.exp());
        }
        if (ctx.getChild(0) == ctx.NEW())
        {
            SemanticTypes semanticType = visitType(ctx.type());

            if(ctx.BRACKET_OPEN() != null) {
                try {
                    Integer.parseInt(visitExp(ctx.exp()).toString());
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid operator in size of array, must be int");
                }

                return semanticType;
            }
        }
        if (ctx.getChild(0) == ctx.IDENTIFIER())
        {
            //TODO: IDENTIFIER PARENTHESIS_OPEN (exps)? PARENTHESIS_CLOSE BRACKET_OPEN exp BRACKET_CLOSE
        }

        throw new RuntimeException("unknown operator: " + ctx.getChild(0).toString());
    }

    @Override
    public Object visitLvalue(langParser.LvalueContext ctx) {
        if(ctx.getChild(0) == ctx.IDENTIFIER()) {
            Object value = variablesNames.stream().anyMatch(x -> x.equals(ctx.getChild(0).toString()));
            if(variablesNames.stream().anyMatch(x -> x.equals(ctx.getChild(0).toString())))
            return value;
        }
        if (ctx.getChildCount() == 4) {
            Object variable = visitLvalue(ctx.lvalue());

            if (!(variable instanceof SemanticTypes)) {
                throw new RuntimeException("null pointer");
            }

        }
        if (ctx.getChildCount() == 3) {
            Object variable = visitLvalue(ctx.lvalue());
            String propertyName = ctx.IDENTIFIER().getText();

            return dataClass.get(propertyName);
        }

        throw new RuntimeException("unknown operator: " + ctx.getChild(0).toString());
    }

    @Override
    public ArrayList<SemanticTypes> visitExps(langParser.ExpsContext ctx) {

        ArrayList<SemanticTypes> allSemanticTypes = new ArrayList<>();
        if(Objects.nonNull(ctx)){
            for (langParser.ExpContext exp : ctx.exp()){
                allSemanticTypes.add(visitExp(exp));
            }
        }
        return allSemanticTypes;
    }
}
