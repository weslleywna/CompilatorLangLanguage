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
        return super.visitData(ctx);
    }

    @Override
    public Object visitDecl(langParser.DeclContext ctx) {
        return super.visitDecl(ctx);
    }

    @Override
    public Object visitFunc(langParser.FuncContext ctx) {
        return super.visitFunc(ctx);
    }

    @Override
    public Object visitParams(langParser.ParamsContext ctx) {
        return super.visitParams(ctx);
    }

    @Override
    public Object visitType(langParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public Object visitBtype(langParser.BtypeContext ctx) {
        return super.visitBtype(ctx);
    }

    @Override
    public Object visitCmd(langParser.CmdContext ctx) {

        if(ctx.getChild(0) == ctx.lvalue(0)) {
            Object valueLValue = visitLvalue(ctx.lvalue(0));
            Object valueExp = visitExp(ctx.exp(0));

            enviroment.peek().put(valueLValue.toString(), valueExp);
            System.out.println(enviroment.peek());
        }

        return super.visitCmd(ctx);
    }

    @Override
    public Object visitExp(langParser.ExpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return super.visitRexp(ctx.rexp());
        }

        Object left = this.visitExp(ctx.exp(0));
        Object right = this.visitExp(ctx.exp(1));

        return (boolean) left && (boolean) right;
    }

    @Override
    public Object visitRexp(langParser.RexpContext ctx) {
        if (ctx.getChildCount() == 1) {
            return super.visitAexp(ctx.aexp(0));
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
            return super.visitMexp(ctx.mexp());
        }

        Object left = this.visitAexp(ctx.aexp());
        Object right = super.visitMexp(ctx.mexp());

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
            return super.visitSexp(ctx.sexp());
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
        if(ctx.getChild(0) == ctx.INTEGER()) {
            return Integer.parseInt(ctx.getChild(0).toString());
        }
        if(ctx.getChild(0) == ctx.FLOAT()) {
            return Float.parseFloat(ctx.getChild(0).toString());
        }
        return 0;
    }

    @Override
    public Object visitPexp(langParser.PexpContext ctx) {
        return super.visitPexp(ctx);
    }

    @Override
    public Object visitLvalue(langParser.LvalueContext ctx) {

        if(ctx.getChild(0) == ctx.IDENTIFIER()) {
            return ctx.getChild(0);
        }

        return super.visitLvalue(ctx);
    }

    @Override
    public Object visitExps(langParser.ExpsContext ctx) {
        return super.visitExps(ctx);
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
