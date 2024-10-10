package fr.ensimag.deca.tree;

import com.sun.org.apache.xpath.internal.operations.Bool;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class This extends AbstractExpr{
    private boolean impl;


    public boolean getImpl() {
        return impl;
    }


    protected void setImpl(boolean impl) {
        Validate.notNull(impl);
        this.impl = impl;
    }

    public This(boolean impl){
        Validate.notNull(impl);
        this.impl = impl;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {

        //A FAIRE
        return compiler.environmentType.BOOLEAN;
    }
    @Override
    public void decompile(IndentPrintStream s){
        if(!getImpl()) {
            s.print(getOperatorName());
        }
    }

    protected String getOperatorName(){
        return "this";
    }

    @Override
    protected void iterChildren(TreeFunction f) {
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
    }
}
