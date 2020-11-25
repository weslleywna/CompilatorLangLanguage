package lang.parser.implementation.codeGeneration;

import lang.parser.implementation.lang.parser.antlr.langBaseVisitor;
import lang.parser.implementation.lang.parser.antlr.langParser;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PythonGenerator extends langBaseVisitor<Object> {
    private STGroup pythonTemplate;

    public PythonGenerator() {
        this.pythonTemplate = new STGroupFile("C:\\Users\\wesll\\Documents\\Git\\CompiladorLinguagemLang\\code\\code\\lang\\parser\\implementation\\codeGeneration\\python.stg");
    }

    @Override
    public Object visitProg(langParser.ProgContext ctx) {
        ST prog = pythonTemplate.getInstanceOf("prog");

        for (langParser.FuncContext funcCtx: ctx.func()) {
            ST func = pythonTemplate.getInstanceOf("func");
            func.add("name", funcCtx.IDENTIFIER().toString());
            for (langParser.CmdContext cmdCtx: funcCtx.cmd()) {
                func.add("cmds", this.visitCmd(cmdCtx));
            }
            prog.add("funcs", func);
        }

        for (langParser.DataContext dataCtx: ctx.data()) {
            ST data = pythonTemplate.getInstanceOf("data");
            data.add("name", dataCtx.TYPENAME().toString());
            for (langParser.DeclContext declContext: dataCtx.decl()) {
                data.add("decl", this.visitDecl(declContext));
            }
            prog.add("data", data);
        }

        PrintStream ps = null;
        try {
            ps = new PrintStream( "teste" + ".py");
            ps.println(prog.render());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return super.visitProg(ctx);
    }

    @Override
    public Object visitData(langParser.DataContext ctx) {

        return super.visitData(ctx);
    }

    @Override
    public Object visitDecl(langParser.DeclContext ctx) {
        String decl = ctx.IDENTIFIER().toString() + " = " + this.visitType(ctx.type());

        return decl;
    }

    @Override
    public Object visitFunc(langParser.FuncContext ctx) {
        ST func = pythonTemplate.getInstanceOf("func");
        for (langParser.CmdContext cmdCtx: ctx.cmd()) {
            //func.add("cmds", cmdCtx.IDENTIFIER().toString());
        }

        return super.visitFunc(ctx);
    }

    @Override
    public Object visitParams(langParser.ParamsContext ctx) {
        return super.visitParams(ctx);
    }

    @Override
    public Object visitType(langParser.TypeContext ctx) {
        if (ctx.getChild(0) == ctx.btype()){
            return this.visitBtype(ctx.btype());
        }

        //TODO type BRACKET_OPEN BRACKET_CLOSE
        return super.visitType(ctx);
    }

    @Override
    public Object visitBtype(langParser.BtypeContext ctx) {
        return ctx.getChild(0).toString();
    }

    @Override
    public Object visitCmd(langParser.CmdContext ctx) {
        ST cmd = pythonTemplate.getInstanceOf("func");

        // ATRIBUIÇÃO
        if (ctx.getChild(1) == ctx.EQ()){
            return this.visitLvalue(ctx.lvalue(0)) + " = " + this.visitExp(ctx.exp(0)).toString();
        }

        //PRINT
        if(ctx.getChild(0) == ctx.PRINT()){
            String cmdLine = ctx.PRINT().toString() + " " + this.visitExp(ctx.exp(0));
            return cmdLine;
        }

        //READ
        if(ctx.getChild(0) == ctx.READ()){
            return this.visitLvalue(ctx.lvalue(0)) + " = input()";
        }

        //IF E IF ELSE
        if(ctx.getChild(0) == ctx.IF()){
            if(ctx.getChild(ctx.getChildCount() - 2) == ctx.ELSE()){
                return "if " + this.visitExp(ctx.exp(0)) + ":\n\t" + this.visitCmd(ctx.cmd(0)) + "\nelse:\n\t" + this.visitCmd(ctx.cmd(1));
            } else {
                return "if " + this.visitExp(ctx.exp(0)) + ":\n\t" + this.visitCmd(ctx.cmd(0));
            }
        }

        //ITERATE
        if(ctx.getChild(0) == ctx.ITERATE()){
            return "for iterate in range(" + this.visitExp(ctx.exp(0)) + "):\n\t" + this.visitCmd(ctx.cmd(0));
        }

        //RETURN
        if(ctx.getChild(0) == ctx.RETURN()){
            StringBuilder cmdLine = new StringBuilder("return ");
            for (langParser.ExpContext expCtx: ctx.exp()) {
                cmdLine.append(this.visitExp(expCtx)).append(",");
            }
            return cmdLine.substring(0, cmdLine.length() - 1);
        }

        //IDENTIFIER
        if(ctx.getChild(0) == ctx.IDENTIFIER()){
            String cmdLine = ctx.IDENTIFIER().toString();
            cmdLine += "(" + this.visitExps(ctx.exps()) + ")";
            if (ctx.getChild(4) != null && ctx.getChild(4) == ctx.LESSTHAN()){
                cmdLine = " = " + cmdLine;
                for (langParser.LvalueContext lValueCtx: ctx.lvalue()) {
                    cmdLine = "," + this.visitLvalue(lValueCtx) + cmdLine;
                }
                return cmdLine.substring(1);
            }
            return cmdLine;
        }

        if(ctx.getChild(0) == ctx.KEYS_OPEN()){
            StringBuilder cmdLine = new StringBuilder();
            for (langParser.CmdContext cmdCtx: ctx.cmd()) {
                cmdLine.append(this.visitCmd(cmdCtx)).append("\n\t");
            }
            return cmdLine.toString();
        }

        return super.visitCmd(ctx);
    }

    @Override
    public Object visitExp(langParser.ExpContext ctx) {
        if(ctx.getChild(1) != null && ctx.getChild(1) == ctx.EQCEQC()){
            return this.visitExp(ctx.exp(0)) + " and " + this.visitExp(ctx.exp(1));
        }

        return ctx.getText();
    }

    @Override
    public Object visitRexp(langParser.RexpContext ctx) {
        return super.visitRexp(ctx);
    }

    @Override
    public Object visitAexp(langParser.AexpContext ctx) {
        return super.visitAexp(ctx);
    }

    @Override
    public Object visitMexp(langParser.MexpContext ctx) {
        return super.visitMexp(ctx);
    }

    @Override
    public Object visitSexp(langParser.SexpContext ctx) {
        return super.visitSexp(ctx);
    }

    @Override
    public Object visitPexp(langParser.PexpContext ctx) {
        return super.visitPexp(ctx);
    }

    @Override
    public Object visitLvalue(langParser.LvalueContext ctx) {
        if(ctx.getChild(0) == ctx.IDENTIFIER()) {
            return ctx.getChild(0).toString();
        }

        return super.visitLvalue(ctx);
    }

    @Override
    public Object visitExps(langParser.ExpsContext ctx) {
        if(ctx == null){
            return "";
        }
        StringBuilder cmdLine = new StringBuilder();
        for (langParser.ExpContext expCtx: ctx.exp()) {
            cmdLine.append(this.visitExp(expCtx)).append(",");
        }
        return cmdLine.substring(0, cmdLine.length() - 1);
    }
}
