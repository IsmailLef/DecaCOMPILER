package fr.ensimag.deca.tree;


import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.*;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public class Or extends AbstractOpBool {

    public Or(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected String getOperatorName() {
        return "||";
    }

    protected static int counter = 0;

    @Override
    public void verifyCondition(DecacCompiler compiler, EnvironmentExp localEnv,
                                ClassDefinition currentClass) throws ContextualError {
        // No verification is needed here. Already done in typeBinaryOp. Check DecacCompiler.java
    }
    @Override
    protected void codeGenComment(DecacCompiler compiler) {
        compiler.addComment("Setting up the OR Op");
    }
    @Override
    protected GPRegister codeGenRegs(DecacCompiler compiler, GPRegister R_left, GPRegister R_right) {
        compiler.addComment("Setting up the OR Op");
        Label vrai_OR = new Label("vrai_OR" + counter);
        Label fin_OR = new Label("fin_OR" + counter);

        compiler.addInstruction(new CMP(1, R_left));
        compiler.addInstruction(new BEQ(vrai_OR));
        compiler.addInstruction(new BOV(compiler.overFlowBool));

        compiler.addInstruction(new CMP(1, R_right));
        compiler.addInstruction(new BEQ(vrai_OR));
        compiler.addInstruction(new BOV(compiler.overFlowBool));

        compiler.addInstruction(new LOAD(0, R_right));
        compiler.addInstruction(new BRA(fin_OR));
        
        compiler.addLabel(vrai_OR);
        compiler.addInstruction(new LOAD(1, R_right));

        compiler.gest.FreeReg(R_left);
        compiler.addLabel(fin_OR);

        counter++;
        compiler.addComment("End of the AND operation");
        return R_right;
    }
}
