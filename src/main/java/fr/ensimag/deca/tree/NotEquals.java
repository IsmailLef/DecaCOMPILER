package fr.ensimag.deca.tree;


import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.*;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public class NotEquals extends AbstractOpExactCmp {

    public NotEquals(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "!=";
    }
    @Override
    public void verifyCondition(DecacCompiler compiler, EnvironmentExp localEnv,
                                ClassDefinition currentClass) throws ContextualError {
        getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        getRightOperand().verifyExpr(compiler, localEnv, currentClass);
        if (! getType().isBoolean())
            throw new ContextualError("Expecting boolean return type", getLocation());
        if(!(((getLeftOperand() instanceof Identifier)||(getLeftOperand().getType().isFloat())||(getLeftOperand().getType().isInt()))&&((getRightOperand() instanceof Identifier)||(getRightOperand().getType().isFloat())||(getRightOperand().getType().isInt())))){
            throw new UnsupportedOperationException("Les valeurs ne sont pas comparables");
        }
        if(!((getLeftOperand() instanceof Identifier) && (getRightOperand() instanceof Identifier))) {
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
        }
    }
    
    @Override
    protected void codeGenComment(DecacCompiler compiler) {
        compiler.addComment("Setting up the NotEquals Op");
    }

    @Override
    protected GPRegister codeGenRegs(DecacCompiler compiler, GPRegister register1, GPRegister register2){
        compiler.addInstruction(new CMP(register1, register2));
        compiler.addInstruction(new SNE(register2));
        compiler.addInstruction(new BOV(compiler.overFlowCmp));
        
        compiler.gest.FreeReg(register1);
        compiler.addComment("Fin NotEquals");
        return register2;
    }
}
