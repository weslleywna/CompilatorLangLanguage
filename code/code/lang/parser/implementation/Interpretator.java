package lang.parser.implementation;

import lang.parser.implementation.lang.parser.antlr.langBaseVisitor;
import lang.parser.implementation.lang.parser.antlr.langParser;

import java.util.HashMap;
import java.util.Stack;

public class Interpretator extends langBaseVisitor<Object> {

    private final Stack<HashMap<String, Object>> enviroment;
    private final HashMap<String, Object> functions;
    private final Stack<Object> operands;

    public Interpretator() {
        enviroment = new Stack<HashMap<String, Object>>();
        enviroment.push(new HashMap<String, Object>());
        functions = new HashMap<String, Object>();
        operands = new Stack<Object>();
    }

    @Override
    public Object visitProg(langParser.ProgContext ctx) {
        return super.visitProg(ctx);
    }

    @Override
    public Object visitData(langParser.DataContext ctx) {
        //TODO: DATA TYPENAME KEYS_OPEN (decl)* KEYS_CLOSE

        return super.visitData(ctx);
    }

    @Override
    public Object visitDecl(langParser.DeclContext ctx) {
        //TODO: IDENTIFIER DPDP type SEMI

        return super.visitDecl(ctx);
    }

    @Override
    public Object visitFunc(langParser.FuncContext ctx) {
        //TODO: IDENTIFIER PARENTHESIS_OPEN (params)? PARENTHESIS_CLOSE (DP type (COMMA type)*)? KEYS_OPEN (cmd)* KEYS_CLOSE

        return super.visitFunc(ctx);
    }

    @Override
    public Object visitParams(langParser.ParamsContext ctx) {
        //TODO: IDENTIFIER DPDP type (COMMA IDENTIFIER DPDP type)*

        return super.visitParams(ctx);
    }

    @Override
    public Object visitType(langParser.TypeContext ctx) {
        //TODO: type BRACKET_OPEN BRACKET_CLOSE
        if (ctx.getChildCount() == 1) {
            return this.visitBtype(ctx.btype());
        }

        throw new RuntimeException("unknown operator: " + ctx.getChild(0).toString());
    }

    @Override
    public Object visitBtype(langParser.BtypeContext ctx) {

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
    public Object visitCmd(langParser.CmdContext ctx) {
        if(ctx.getChild(0) == ctx.lvalue(0)) {
            Object valueLValue = visitLvalue(ctx.lvalue(0));
            Object valueExp = visitExp(ctx.exp(0));
            enviroment.peek().put(valueLValue.toString(), valueExp);

            System.out.println(enviroment.peek());
        }

        if(ctx.getChild(0) == ctx.KEYS_OPEN()){
            //TODO: KEYS_OPEN (cmd)* KEYS_CLOSE
        }
        if(ctx.getChild(0) == ctx.IF()){
            if(ctx.getChild(ctx.getChildCount() -1) == ctx.ELSE()){
                if(Boolean.valueOf(this.visitExp(ctx.exp(0)).toString())){
                    return this.visitCmd(ctx.cmd(0));
                } else {
                    return this.visitCmd(ctx.cmd(1));
                }
            } else {
                if(Boolean.valueOf(this.visitExp(ctx.exp(0)).toString())){
                    return this.visitCmd(ctx.cmd(0));
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
    public Object visitExp(langParser.ExpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitRexp(ctx.rexp());
        }

        Object left = this.visitExp(ctx.exp(0));
        Object right = this.visitExp(ctx.exp(1));

        return Boolean.valueOf(left.toString()) && Boolean.valueOf(right.toString());
    }

    @Override
    public Object visitRexp(langParser.RexpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitAexp(ctx.aexp(0));
        }

        switch (ctx.getChild(1).toString()) {
            case "<":
                return CalculateLogicValue(this.visitAexp(ctx.aexp(0)), this.visitAexp(ctx.aexp(1)), "<");
            case "==":
                return this.visitRexp(ctx.rexp()) == this.visitAexp(ctx.aexp(0));
            case "!=":
                return this.visitRexp(ctx.rexp()) != this.visitAexp(ctx.aexp(0));
            default:
                throw new RuntimeException("unknown operator: " + ctx.getChild(1).toString());
        }
    }

    @Override
    public Object visitAexp(langParser.AexpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitMexp(ctx.mexp());
        }

        Object left = this.visitAexp(ctx.aexp());
        Object right = this.visitMexp(ctx.mexp());

        switch (ctx.getChild(1).toString()) {
            case "+":
                return CalculateArithmeticValue(left, right, "+");
            case "-":
                return CalculateArithmeticValue(left, right, "-");
            default:
                throw new RuntimeException("unknown operator: " + ctx.getChild(1).toString());
        }
    }

    @Override
    public Object visitMexp(langParser.MexpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitSexp(ctx.sexp());
        }

        Object left = this.visitMexp(ctx.mexp());
        Object right = this.visitSexp(ctx.sexp());

        switch (ctx.getChild(1).toString()) {
            case "*":
                return CalculateArithmeticValue(left, right, "*");
            case "/":
                return CalculateArithmeticValue(left, right, "/");
            case "%":
                return CalculateArithmeticValue(left, right, "%");
            default:
                throw new RuntimeException("unknown operator: " + ctx.getChild(1).toString());
        }
    }

    @Override
    public Object visitSexp(langParser.SexpContext ctx) {
        switch (ctx.getChild(0).toString()){
            case "!":
                return !Boolean.valueOf(this.visitSexp(ctx.sexp()).toString());
            case "-":
                Object sexpResult = this.visitSexp(ctx.sexp());
                if(sexpResult instanceof Integer)
                    return Integer.parseInt(sexpResult.toString());
                else
                    return Float.parseFloat(sexpResult.toString());
        }

        if(ctx.getChild(0) == ctx.BOOLEAN()) {
            return Boolean.valueOf(ctx.getChild(0).toString());
        }
        if(ctx.getChild(0) == ctx.NULL()) {
            return null;
        }
        if(ctx.getChild(0) == ctx.INTEGER()) {
            return Integer.parseInt(ctx.getChild(0).toString());
        }
        if(ctx.getChild(0) == ctx.FLOAT()) {
            return Float.parseFloat(ctx.getChild(0).toString());
        }
        if(ctx.getChild(0) == ctx.CHAR()) {
            return ctx.getChild(0).toString().charAt(1);
        }
        if(ctx.getChild(0) == ctx.LITERAL()) {
            return ctx.getChild(0).toString();
        }
        if (ctx.pexp() != null) {
            return this.visitPexp(ctx.pexp());
        }

        throw new RuntimeException("unknown operator: " + ctx.getChild(0).toString());
    }

    @Override
    public Object visitPexp(langParser.PexpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return this.visitLvalue(ctx.lvalue());
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
            return value == null? ctx.getChild(0) : value;
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
    public Object visitExps(langParser.ExpsContext ctx) {
        if(ctx.getChild(1) == ctx.COMMA()) {
            return this.visitExp(ctx.exp(1));
        }
        return this.visitExp(ctx.exp(0));
    }

    public Object CalculateArithmeticValue(Object exp1, Object exp2, String operator){
        switch (operator){
            case "+":
                if(exp1 instanceof Integer && exp2 instanceof Integer){
                    return Integer.parseInt(exp1.toString()) + Integer.parseInt(exp2.toString());
                }
                else {
                    return Float.parseFloat(exp1.toString()) + Float.parseFloat(exp2.toString());
                }
            case "-":
                if(exp1 instanceof Integer && exp2 instanceof Integer){
                    return Integer.parseInt(exp1.toString()) - Integer.parseInt(exp2.toString());
                }
                else {
                    return Float.parseFloat(exp1.toString()) - Float.parseFloat(exp2.toString());
                }
            case "*":
                return Float.parseFloat(exp1.toString()) * Float.parseFloat(exp2.toString());
            case "/":
                return Float.parseFloat(exp1.toString()) / Float.parseFloat(exp2.toString());
            case "%":
                return Float.parseFloat(exp1.toString()) % Float.parseFloat(exp2.toString());
            default:
                throw new RuntimeException("unknown operator: " + operator);
        }
    }

    public Object CalculateLogicValue(Object exp1, Object exp2, String operator){
        switch (operator){
            case "<":
                return Float.parseFloat(exp1.toString()) < Float.parseFloat(exp2.toString());
            default:
                throw new RuntimeException("unknown operator: " + operator);
        }
    }
}
