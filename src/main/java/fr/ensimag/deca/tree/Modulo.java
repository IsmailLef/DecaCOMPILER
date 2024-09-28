package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.*;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public class Modulo extends AbstractOpArith {

    public Modulo(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    // @Override
    // public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
    //         ClassDefinition currentClass) throws ContextualError {
    //     getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
    //     getRightOperand().verifyExpr(compiler, localEnv, currentClass);
    //     if(!getLeftOperand().getType().equals(getRightOperand().getType())){
    //         throw new UnsupportedOperationException("Les valeurs ne sont pas compatibles");
    //     }
    //     return getLeftOperand().getType();
    // }


    @Override
    protected String getOperatorName() {
        return "%";
    }

    @Override
    public void verifyCondition(DecacCompiler compiler, EnvironmentExp localEnv,
                                ClassDefinition currentClass) throws ContextualError {
        AbstractExpr leftOperand = (AbstractExpr) getLeftOperand();
        AbstractExpr rightOperand = (AbstractExpr) getRightOperand();
        Type type1 = leftOperand.verifyExpr(compiler, localEnv, currentClass);
        Type type2 = rightOperand.verifyExpr(compiler, localEnv, currentClass);
        leftOperand.setType(type1);
        rightOperand.setType(type2);

        if ((leftOperand instanceof UnaryMinus) ||  (rightOperand instanceof UnaryMinus))
            throw new ContextualError("Cannot apply % on negative instances", getLocation());
        // Case abstractoparith negative ..
    }
    @Override
    protected void codeGenComment(DecacCompiler compiler){
        compiler.addComment("Setting the MODULO Operation");
    }
    @Override
    protected GPRegister codeGenRegs(DecacCompiler compiler, GPRegister R_left, GPRegister R_right){
        codeGenComment(compiler);

        compiler.addInstruction(new CMP(0, R_right));
        compiler.addInstruction(new BEQ(compiler.ZeroDivisionError));

        compiler.addInstruction(new REM(R_right, R_left));
        compiler.addInstruction(new BOV(compiler.overFlowError));

        if (R_left == Register.R0) {
        compiler.addInstruction(new LOAD(R_left, R_right));
        compiler.gest.FreeReg(R_left);
        compiler.addComment("END OF Division OPERATION");
        return R_right;
        }

        compiler.gest.FreeReg(R_right);
        compiler.addComment("END OF Division OPERATION");
        return R_left;
    }
}
