package fr.ensimag.deca.tree;


import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.deca.tree.GestionnaireReg;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public abstract class AbstractOpExactCmp extends AbstractOpCmp {

    public AbstractOpExactCmp(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    /* IMPORTANT : Register1 is the left register of operation , Register2 is the right one */

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
            if (leftOperand.getType().isInt() && rightOperand.getType().isInt()) {isQUO = true; isInt = true;};
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
    protected GPRegister compute(DecacCompiler compiler) {
       return codeGenInst(compiler);
    }
}
