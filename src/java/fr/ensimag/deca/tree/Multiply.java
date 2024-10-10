package fr.ensimag.deca.tree;


import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.*;

/**
 * @author gl37
 * @date 01/01/2023
 */
public class Multiply extends AbstractOpArith {
    public Multiply(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "*";
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
        if (type1.isFloat() && type2.isInt()) {
            ConvFloat conv = new ConvFloat(rightOperand);
            setRightOperand(conv);
            conv.verifyExpr(compiler, localEnv, currentClass);
        } else if (type1.isInt() && type2.isFloat()) {
            ConvFloat conv = new ConvFloat(leftOperand);
            setLeftOperand(conv);
            conv.verifyExpr(compiler, localEnv, currentClass);
        }
        else if (! type1.sameType(type2))
            throw new ContextualError("Values are not compatible", getLocation());
    }
    @Override
    protected void codeGenComment(DecacCompiler compiler){
        compiler.addComment("Setting the ADD Operation");
    }
    @Override
    protected GPRegister codeGenRegs(DecacCompiler compiler, GPRegister R_left, GPRegister R_right){
        codeGenComment(compiler);

        compiler.addInstruction(new MUL(R_left, R_right));
        compiler.addInstruction(new BOV(compiler.overFlowError));
        compiler.gest.FreeReg(R_left);    
        

        compiler.addComment("END OF ADD OPERATION");
        return R_right;
    }
}
