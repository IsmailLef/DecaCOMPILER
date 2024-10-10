package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class Cast extends AbstractExpr{

    private AbstractIdentifier type;
    private AbstractExpr operand;


    public AbstractIdentifier getTypeOp() {
        return type;
    }

    public AbstractExpr getOperand() {
        return operand;
    }

    protected void setTypeOp(AbstractIdentifier type) {
        Validate.notNull(type);
        this.type = type;
    }

    protected void setOperand(AbstractExpr operand) {
        Validate.notNull(operand);
        this.operand = operand;
    }
    public Cast(AbstractIdentifier type, AbstractExpr operand){
        Validate.notNull(operand);
        Validate.notNull(type);
        this.operand = operand;
        this.type = type;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {

        Type retrievedType = type.verifyType(compiler); // Needs to add to environmentType whenever a new class is defined
        type.setType(retrievedType);
        if (retrievedType.isVoid()) // Variable can't be void-type
            throw new ContextualError("The type " + type.getType().toString() + " isn't allowed.", getLocation());
        operand.verifyExpr(compiler, localEnv, currentClass);
        //A FAIRE
        //Il reste à tester si le type du cast est compatible avec le type de operand
        return retrievedType;
    }
    @Override
    public void decompile(IndentPrintStream s) {
        s.print("(");
        getTypeOp().decompile(s);
        s.print(")" + getOperatorName() + "(");
        getOperand().decompile(s);
        s.print(")");
    }

    protected String getOperatorName(){
        return " ";
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        type.iter(f);
        operand.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        operand.prettyPrint(s, prefix, true);
    }
}
