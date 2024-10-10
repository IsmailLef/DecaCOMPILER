package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class AttributeCall extends AbstractExpr{
    private AbstractExpr object;
    private AbstractIdentifier attributeName;


    public AbstractExpr getObject() {
        return object;
    }

    public AbstractIdentifier getAttributeName() {
        return attributeName;
    }


    protected void setObject(AbstractExpr object) {
        Validate.notNull(object);
        this.object = object;
    }

    protected void setAttributeName(AbstractIdentifier attributeName) {
        Validate.notNull(attributeName);
        this.attributeName = attributeName;
    }

    public AttributeCall(AbstractExpr object, AbstractIdentifier attributeName){
        Validate.notNull(object);
        Validate.notNull(attributeName);
        this.object = object;
        this.attributeName = attributeName;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {

        //A FAIRE
        return compiler.environmentType.INT;
    }
    @Override
    public void decompile(IndentPrintStream s){
        getObject().decompile(s);
        s.print(".");
        getAttributeName().decompile(s);
    }

    protected String getOperatorName(){
        return "";
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        object.iter(f);
        attributeName.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        object.prettyPrint(s, prefix, false);
        attributeName.prettyPrint(s, prefix, true);
    }
}
