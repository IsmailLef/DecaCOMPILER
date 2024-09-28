package fr.ensimag.deca.tree;


import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.*;

/**
 * Operator "x >= y"
 * 
 * @author gl37
 * @date 01/01/2023
 */
public class GreaterOrEqual extends AbstractOpIneq {

    public GreaterOrEqual(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return ">=";
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
    protected void codeGenComment(DecacCompiler compiler) {
        compiler.addComment("Setting up the GreaterThanOrEqual Op");
    }

    @Override
    protected GPRegister codeGenRegs(DecacCompiler compiler, GPRegister register1, GPRegister register2){
        compiler.addInstruction(new CMP(register2, register1));
        compiler.addInstruction(new SGE(register2));
        compiler.addInstruction(new BOV(compiler.overFlowCmp));
        
        compiler.gest.FreeReg(register1);
        compiler.addComment("Fin GreaterOrEqual");
        return register2;
        
    }


}
