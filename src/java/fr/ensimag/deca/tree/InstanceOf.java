package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class InstanceOf extends AbstractExpr{

    private AbstractExpr operand;
    private AbstractIdentifier type;
    public AbstractExpr getOperand() {
        return operand;
    }

    public AbstractIdentifier getTypeOp() {
        return type;
    }

    protected void setOperand(AbstractExpr operand) {
        Validate.notNull(operand);
        this.operand = operand;
    }

    protected void setTypeOp(AbstractIdentifier type) {
        Validate.notNull(type);
        this.type = type;
    }
    public InstanceOf(AbstractExpr operand, AbstractIdentifier type){
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
        return compiler.environmentType.BOOLEAN;
    }
    @Override
    public void decompile(IndentPrintStream s) {
        s.print("(");
        getOperand().decompile(s);
        s.print(" " + getOperatorName() + " ");
        getTypeOp().decompile(s);
        s.print(")");
    }

    protected String getOperatorName(){
        return "instanceof";
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        operand.iter(f);
        type.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        operand.prettyPrint(s, prefix, false);
        type.prettyPrint(s, prefix, true);
    }
}
