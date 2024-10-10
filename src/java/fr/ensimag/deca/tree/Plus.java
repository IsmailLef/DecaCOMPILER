package fr.ensimag.deca.tree;


import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.instructions.ADD;
import fr.ensimag.ima.pseudocode.instructions.BOV;

/**
 * @author gl37
 * @date 01/01/2023
 */
public class Plus extends AbstractOpArith {
    public Plus(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "+";
    }
    
    
    @Override
    protected void codeGenComment(DecacCompiler compiler){
        compiler.addComment("Setting the ADD Operation");
    }
    @Override
    protected GPRegister codeGenRegs(DecacCompiler compiler, GPRegister R_left, GPRegister R_right){
        codeGenComment(compiler);
        
        compiler.addInstruction(new ADD(R_left, R_right));
        compiler.addInstruction(new BOV(compiler.overFlowError));
        compiler.gest.FreeReg(R_left);    

        compiler.addComment("END OF ADD OPERATION");
        return R_right;
    }

}
