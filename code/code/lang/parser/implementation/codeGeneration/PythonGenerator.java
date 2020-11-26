package lang.parser.implementation.codeGeneration;

import lang.parser.implementation.lang.parser.antlr.langBaseVisitor;
import lang.parser.implementation.lang.parser.antlr.langParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PythonGenerator extends langBaseVisitor<Object> {
    private STGroup pythonTemplate;
    private static int tabs = 0;

    public PythonGenerator() {
        this.pythonTemplate = new STGroupFile("C:\\Users\\wesll\\Documents\\Git\\CompiladorLinguagemLang\\code\\code\\lang\\parser\\implementation\\codeGeneration\\python.stg");
    }

    @Override
    public Object visitProg(langParser.ProgContext ctx) {
        ST prog = pythonTemplate.getInstanceOf("prog");

        for (langParser.FuncContext funcCtx: ctx.func()) {
            ST func = pythonTemplate.getInstanceOf("func");
            func.add("name", funcCtx.IDENTIFIER().toString());
            if(funcCtx.params() != null){
                langParser.ParamsContext paramsCtx = funcCtx.params();
                for (TerminalNode identifier: paramsCtx.IDENTIFIER()) {
                    func.add("params", identifier.getText());
                }
            }
            for (langParser.CmdContext cmdCtx: funcCtx.cmd()) {
                func.add("cmds", this.visitCmd(cmdCtx));
            }
            prog.add("funcs", func);
        }

        for (langParser.DataContext dataCtx: ctx.data()) {
            ST data = pythonTemplate.getInstanceOf("data");
            data.add("name", dataCtx.TYPENAME().toString());
            for (langParser.DeclContext declContext: dataCtx.decl()) {
                data.add("attributes", this.visitDecl(declContext,false));
                data.add("decl", this.visitDecl(declContext, true));
            }
            prog.add("data", data);
        }

        PrintStream ps = null;
        try {
            ps = new PrintStream("teste" + Math.random() + ".py");
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

    public Object visitDecl(langParser.DeclContext ctx, boolean declaration) {
        return declaration ? ctx.IDENTIFIER().toString() : "self." + ctx.IDENTIFIER().toString() + " = " + ctx.IDENTIFIER().toString();
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
            String cmdLine = ctx.PRINT().toString() + " (" + this.visitExp(ctx.exp(0)) + ", end=\"\")";
            return cmdLine;
        }

        //READ
        if(ctx.getChild(0) == ctx.READ()){
            return this.visitLvalue(ctx.lvalue(0)) + " = input()";
        }

        //IF E IF ELSE
        if(ctx.getChild(0) == ctx.IF()){
            if(ctx.getChild(ctx.getChildCount() - 2) == ctx.ELSE()){
                tabs++;
                String cmdLine = "if " + this.visitExp(ctx.exp(0)) + ":\n"+ getTabs() + this.visitCmd(ctx.cmd(0));
                tabs--;
                cmdLine += "\n" + getTabs();
                tabs++;
                cmdLine += "else:\n" + getTabs() + this.visitCmd(ctx.cmd(1));
                tabs--;
                return cmdLine;
            } else {
                tabs++;
                String cmdLine = "if " + this.visitExp(ctx.exp(0)) + ":\n" + getTabs() + this.visitCmd(ctx.cmd(0));
                tabs--;
                return cmdLine;
            }
        }

        //ITERATE
        if(ctx.getChild(0) == ctx.ITERATE()){
            tabs++;
            String cmdLine = "for iterate in range(" + this.visitExp(ctx.exp(0)) + "):\n" + getTabs() + this.visitCmd(ctx.cmd(0));
            tabs--;
            return cmdLine;
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
            tabs++;
            StringBuilder cmdLine = new StringBuilder();
            cmdLine.append("\t");
            for (langParser.CmdContext cmdCtx: ctx.cmd()) {
                cmdLine.append(this.visitCmd(cmdCtx)).append("\n" + getTabs());
            }
            tabs--;
            return cmdLine.toString();
        }

        return super.visitCmd(ctx);
    }

    @Override
    public Object visitExp(langParser.ExpContext ctx) {
        if(ctx == null){
            return "";
        }
        if(ctx.getChild(1) != null && ctx.getChild(1) == ctx.EQCEQC()){
            return this.visitExp(ctx.exp(0)) + " and " + this.visitExp(ctx.exp(1));
        }

        return this.visitRexp(ctx.rexp());
    }

    @Override
    public Object visitRexp(langParser.RexpContext ctx) {
        if(ctx == null){
            return "";
        }
        if(ctx.getChildCount() == 1) {
            return this.visitAexp(ctx.aexp(0));
        }
        return ctx.getText();
    }

    @Override
    public Object visitAexp(langParser.AexpContext ctx) {
        if(ctx == null){
            return "";
        }
        if(ctx.getChildCount() == 1) {
            return this.visitMexp(ctx.mexp());
        }
        return ctx.getText();
    }

    @Override
    public Object visitMexp(langParser.MexpContext ctx) {
        if(ctx == null){
            return "";
        }
        if(ctx.getChildCount() == 1) {
            return this.visitSexp(ctx.sexp());
        }
        return ctx.getText();
    }

    @Override
    public Object visitSexp(langParser.SexpContext ctx) {
        if(ctx == null){
            return "";
        }
        if(ctx.getChild(0) == ctx.pexp()) {
            return this.visitPexp(ctx.pexp());
        }
        return ctx.getText();
    }

    @Override
    public Object visitPexp(langParser.PexpContext ctx) {
        if(ctx == null){
            return "";
        }
        if(ctx.getChild(0) == ctx.NEW()){
            if(ctx.getChild(2) != null){
                return "[None] * " + this.visitExp(ctx.exp());
            } else{
                return "type('copy', " + this.visitType(ctx.type()) + ".__bases__, dict(" + this.visitType(ctx.type()) + ".__dict__))";
            }

        }
        if(ctx.getChild(0) == ctx.IDENTIFIER()){
            if(ctx.getChild(2) != null){
                if(this.visitExp(ctx.exp()).toString().equals("0")) {
                    return ctx.IDENTIFIER() + "(" + this.visitExps(ctx.exps()) + ")";
                }
            }
        }
        if(ctx.getChild(0) == ctx.lvalue()){
            return this.visitLvalue(ctx.lvalue());
        }

        return ctx.getText();
    }

    @Override
    public Object visitLvalue(langParser.LvalueContext ctx) {
        if(ctx.getChild(0) == ctx.IDENTIFIER()) {
            return ctx.getChild(0).toString();
        }

        return ctx.getText();
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

    private String getTabs() {
        String tabsStr = "";
        for(int i = 0; i< tabs; i++){
            tabsStr += "\t";
        }
        return tabsStr;
    }
}
