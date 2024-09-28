package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.*;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.SNE;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.deca.DecacCompiler;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public class Not extends AbstractUnaryExpr {

    public Not(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {

        AbstractExpr expr = getOperand();
        Type type1 = expr.verifyExpr(compiler, localEnv, currentClass);
        String operator = getOperatorName();
        Type retrievedType = compiler.typeUnaryOp(operator, type1);
        if (retrievedType != null){
            expr.verifyExpr(compiler, localEnv, currentClass);
            setType(retrievedType);
            return retrievedType;
        }
        else
            throw new ContextualError("Cannot apply arithmetic unary operation : " + getOperatorName()
                                    + " on types that mismatch - " + expr.getType().toString(), getLocation());
    }
        


    @Override
    protected String getOperatorName() {
        return "!";
    }

    @Override
    public void verifyCondition(DecacCompiler compiler, EnvironmentExp localEnv,
                                ClassDefinition currentClass) throws ContextualError {
        Type type = getOperand().verifyExpr(compiler, localEnv, currentClass);
        if(! type.isBoolean()){
            throw new ContextualError("Values are not compatible", getLocation());
        }
    }

    @Override
    public GPRegister compute(DecacCompiler compiler) {
        compiler.addComment("Setting up not operation");
        GPRegister R_Not = getOperand().compute(compiler);

        compiler.addInstruction(new CMP(1,R_Not));
        compiler.addInstruction(new SNE(R_Not));
        compiler.addInstruction(new BOV(compiler.overFlowCmp));

        return R_Not;
    }

    @Override
    public GPRegister codeGenInst(DecacCompiler compiler ){
        return compute(compiler);
    }
}
