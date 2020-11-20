package lang.parser.implementation.semantic;

import lang.parser.implementation.lang.parser.antlr.langBaseVisitor;
import lang.parser.implementation.lang.parser.antlr.langParser;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class SemanticAnalyser extends langBaseVisitor<Object> {

    private final Stack<HashMap<String, Object>> enviroment;
    private final HashMap<String, Object> functions;
    private final HashMap<String, Object> dataClass;
    private final Stack<Object> operands;

    private static class DataClassDefinition {
        protected HashMap<String, TerminalNodeImpl> properties = new HashMap<>();
    }

    public SemanticAnalyser() {
        enviroment = new Stack<>();
        enviroment.push(new HashMap<>());
        functions = new HashMap<>();
        dataClass = new HashMap<>();
        operands = new Stack<>();
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
            DataClassDefinition dataClassDefinition = new DataClassDefinition();
            if (Objects.nonNull(ctx.decl())) {
                for (langParser.DeclContext ctxDecl : ctx.decl()) {
                    Object result = this.visitDecl(ctxDecl);
                    dataClassDefinition.properties.put(ctxDecl.getChild(0).getText(), (TerminalNodeImpl) result);
                }
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

        return super.visitFunc(ctx);
    }

    @Override
    public SemanticTypes visitParams(langParser.ParamsContext ctx) {
        //TODO: IDENTIFIER DPDP type (COMMA IDENTIFIER DPDP type)*

        return super.visitParams(ctx);
    }

    @Override
    public SemanticTypes visitType(langParser.TypeContext ctx) {
        //TODO: type BRACKET_OPEN BRACKET_CLOSE
        if (ctx.getChildCount() == 1) {
            return this.visitBtype(ctx.btype());
        }

        throw new RuntimeException("unknown operator: " + ctx.getChild(0).toString());
    }

    @Override
    public SemanticTypes visitBtype(langParser.BtypeContext ctx) {

        if(ctx.getChild(0) == ctx.INTEGER()) {
            return ctx.getChild(0);
        }

        if(ctx.getChild(0) == ctx.CHAR()) {
            return ctx.getChild(0);
        }

        if(ctx.getChild(0) == ctx.BOOLEAN()) {
            return ctx.getChild(0);
        }

        if(ctx.getChild(0) == ctx.FLOAT()) {
            return ctx.getChild(0);
        }

        if(ctx.getChild(0) == ctx.TYPENAME()) {
            return ctx.getChild(0);
        }

        throw new RuntimeException("unknown operator: " + ctx.getChild(0).toString());
    }

    @Override
    public SemanticTypes visitCmd(langParser.CmdContext ctx) {
        if(ctx.getChild(0) == ctx.lvalue(0)) {
            Object valueLValue = visitLvalue(ctx.lvalue(0));
            Object valueExp = visitExp(ctx.exp(0));
            enviroment.peek().put(valueLValue.toString(), valueExp);

            System.out.println(enviroment.peek());
        }

        //TODO : TESTAR ESSE IF AI
        if(ctx.getChild(0) == ctx.KEYS_OPEN()){
            for (langParser.CmdContext ctxCmd : ctx.cmd()) {
                return this.visitCmd(ctxCmd);
            }
        }

        if(ctx.getChild(0) == ctx.IF()){
            if(ctx.getChild(ctx.getChildCount() - 2) == ctx.ELSE()){
                if(Boolean.valueOf(this.visitExp(ctx.exp(0)).toString())){
                    return this.visitCmd(ctx.cmd(0));
                } else {
                    return this.visitCmd(ctx.cmd(1));
                }
            } else {
                if(Boolean.valueOf(this.visitExp(ctx.exp(0)).toString())){
                    return this.visitCmd(ctx.cmd(0));
                } else {
                    return null;
                }
            }
        }
        if(ctx.getChild(0) == ctx.ITERATE()){
            //TODO: ITERATE PARENTHESIS_OPEN exp PARENTHESIS_CLOSE cmd
        }
        if(ctx.getChild(0) == ctx.READ()){
            //TODO: READ lvalue SEMI
        }
        if(ctx.getChild(0) == ctx.PRINT()){
            //TODO: PRINT exp SEMI
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

        return super.visitCmd(ctx);
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

        return left;
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
            return (SemanticTypes)this.visitLvalue(ctx.lvalue());
        }
        if (ctx.getChild(0) == ctx.PARENTHESIS_OPEN())
        {
            return this.visitExp(ctx.exp());
        }
        if (ctx.getChild(0) == ctx.NEW())
        {
            //TODO: NEW type (BRACKET_OPEN (exp)? BRACKET_CLOSE)?
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
            Object value = enviroment.peek().get(ctx.getChild(0).toString());
            return value == null ? ctx.getChild(0) : value;
        }
        if (ctx.getChildCount() == 4) {
            //TODO: lvalue BRACKET_OPEN exp BRACKET_CLOSE
        }
        if (ctx.getChildCount() == 3) {
            //TODO: lvalue DOT IDENTIFIER
        }

        throw new RuntimeException("unknown operator: " + ctx.getChild(0).toString());
    }

    @Override
    public SemanticTypes visitExps(langParser.ExpsContext ctx) {
        if(ctx.getChild(1) == ctx.COMMA()) {
            return this.visitExp(ctx.exp(1));
        }
        return this.visitExp(ctx.exp(0));
    }
}
