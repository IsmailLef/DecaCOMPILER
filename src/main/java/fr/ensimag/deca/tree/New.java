package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class New extends AbstractExpr{

    private AbstractIdentifier className;


    public AbstractIdentifier getclassName() {
        return className;
    }


    protected void setClassName(AbstractIdentifier className) {
        Validate.notNull(className);
        this.className = className;
    }

    public New(AbstractIdentifier className){
        Validate.notNull(className);
        this.className = className;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {

        //A FAIRE
        return compiler.environmentType.INT;
    }
    @Override
    public void decompile(IndentPrintStream s){
        s.print(getOperatorName() + " ");
        getclassName().decompile(s);
        s.print("()");
    }

    protected String getOperatorName(){
        return "new";
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        className.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        className.prettyPrint(s, prefix, true);
    }
}
