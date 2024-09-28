package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class MethodCall extends AbstractExpr{
    private AbstractExpr object;
    private AbstractIdentifier methodName;

    private ListExpr params = new ListExpr();

    public AbstractExpr getObject() {
        return object;
    }

    public AbstractIdentifier getMethodName() {
        return methodName;
    }

    public ListExpr getParams() {
        return params;
    }

    protected void setObject(AbstractExpr object) {
        this.object = object;
    }

    protected void setMethodName(AbstractIdentifier methodName) {
        Validate.notNull(methodName);
        this.methodName = methodName;
    }

    protected void setParams(ListExpr params){
        Validate.notNull(params);
        for(AbstractExpr e : params.getList()){
            this.params.add(e);
        }
    }
    public MethodCall(AbstractExpr object, AbstractIdentifier methodName, ListExpr params){
        Validate.notNull(methodName);
        Validate.notNull(params);
        this.object = object;
        this.methodName = methodName;
        for(AbstractExpr e : params.getList()){
            this.params.add(e);
        }
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {

        //A FAIRE
        return compiler.environmentType.INT;
    }
    @Override
    public void decompile(IndentPrintStream s){
        if(object!=null){getObject().decompile(s);s.print(".");}
        getMethodName().decompile(s);
        s.print("(");
        getParams().decompile(s);
        s.print(")");
    }

    protected String getOperatorName(){
        return "";
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        if(object!=null)object.iter(f);
        methodName.iter(f);
        params.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        if(object!=null)object.prettyPrint(s, prefix, false);
        methodName.prettyPrint(s, prefix, false);
        params.prettyPrint(s, prefix, true);
    }
}
