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
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.WFLOAT;
import fr.ensimag.ima.pseudocode.instructions.WFLOATX;
import fr.ensimag.ima.pseudocode.instructions.WINT;

/**
 * Arithmetic binary operations (+, -, /, ...)
 * 
 * @author gl37
 * @date 01/01/2023
 */
public abstract class AbstractOpArith extends AbstractBinaryExpr {

    public AbstractOpArith(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }



    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        
        AbstractExpr leftOperand = getLeftOperand();
        AbstractExpr rightOperand = getRightOperand();
        Type type1, type2;
        if (leftOperand instanceof ConvFloat)
            type1 = ((ConvFloat) leftOperand).verifyExpr(compiler, localEnv, currentClass);
        else 
            type1 = leftOperand.verifyExpr(compiler, localEnv, currentClass);

        if (rightOperand instanceof ConvFloat)
            type2 = ((ConvFloat) rightOperand).verifyExpr(compiler, localEnv, currentClass);
        else 
            type2 = rightOperand.verifyExpr(compiler, localEnv, currentClass);

        String Operator = getOperatorName();
        Type retrievedType = compiler.typeBinaryOp(Operator, type1, type2);
        
        // if (Operator.equals("/") || Operator.equals("%")) verifyCondition(compiler, localEnv, currentClass);

        if (type1.isFloat() && type2.isInt()) {
            ConvFloat conv = new ConvFloat(rightOperand);
            setRightOperand(conv);
            conv.setType(compiler.environmentType.FLOAT);
            // conv.verifyExpr(compiler, localEnv, currentClass);
        }
        else if (type1.isInt() && type2.isFloat()) {
            ConvFloat conv = new ConvFloat(leftOperand);
            setLeftOperand(conv);
            conv.setType(compiler.environmentType.FLOAT);
            // conv.verifyExpr(compiler, localEnv, currentClass);
        }

        if (retrievedType != null) {
            setType(retrievedType);
            return retrievedType;
        }
        else
            throw new ContextualError("Cannot apply arithmetic operation : " + getOperatorName()
                                        + " on types that mismatch - " + type1 + " and " + type2, getLocation());
    }
    protected abstract GPRegister codeGenRegs(DecacCompiler compiler, GPRegister Register1, GPRegister Register2);
    protected abstract void codeGenComment(DecacCompiler compiler);
    protected boolean isQUO = false;
    protected boolean isInt = false;

    @Override
    protected GPRegister codeGenInst(DecacCompiler compiler){
        codeGenComment(compiler);

        GPRegister R_left = null;
        GPRegister R_right = null;
        AbstractExpr leftOperand = getLeftOperand();
        AbstractExpr rightOperand = getRightOperand();

    
        if (leftOperand instanceof ConvFloat) {
            R_left = ((ConvFloat) leftOperand).codeGenInst(compiler);
            R_right = rightOperand.compute(compiler);
        }        
        else if (rightOperand instanceof ConvFloat) {
            R_left = leftOperand.compute(compiler);
            R_right = ((ConvFloat) rightOperand).codeGenInst(compiler);
        }
        else {
            if (leftOperand.getType(compiler) != null && rightOperand.getType(compiler) != null) {
                if (leftOperand.getType(compiler).isInt() && rightOperand.getType(compiler).isInt()){isQUO = true; isInt = true;}};
                R_left = leftOperand.compute(compiler);
                R_right = rightOperand.compute(compiler);
        }

        if ((compiler.gest.count() == 1 && compiler.gest.stackCounter != 0) || R_left.equals(R_right)) {
            compiler.addInstruction(new POP(Register.R0));
                R_left = Register.R0;
                compiler.gest.stackCounter--;
            }

        return codeGenRegs(compiler, R_left, R_right);
    }

    @Override
    protected void codeGenPrint(DecacCompiler compiler, Boolean printHex) {
        GPRegister reg = codeGenInst(compiler);
        if(isInt){
            compiler.addInstruction(new LOAD(reg, Register.R1));
            compiler.addInstruction(new WINT());
        }
        else {
            compiler.addInstruction(new LOAD(reg, Register.R1));
            if (! printHex) compiler.addInstruction(new WFLOAT());
            else compiler.addInstruction(new WFLOATX());
        }
    }



    @Override
    protected GPRegister compute(DecacCompiler compiler) {
        return codeGenInst(compiler);
    }
}