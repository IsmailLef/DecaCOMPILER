package fr.ensimag.deca.tree;


import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.BNE;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.BRA;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.deca.tree.GestionnaireReg;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public class And extends AbstractOpBool {

    public And(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected String getOperatorName() {
        return "&&";
    }

    protected static int counter = 0;

    @Override
    public void verifyCondition(DecacCompiler compiler, EnvironmentExp localEnv,
                                ClassDefinition currentClass) throws ContextualError {
        // No verification is needed here. Already done in typeBinaryOp. Check DecacCompiler.java

    }
    @Override
    protected void codeGenComment(DecacCompiler compiler) {
        compiler.addComment("Setting up the AND Op");
    }
    @Override
    protected GPRegister codeGenRegs(DecacCompiler compiler, GPRegister R_left, GPRegister R_right) {
        compiler.addComment("Setting up the AND Operation");
        Label faux_AND = new Label("faux_AND" + counter);
        Label fin_AND = new Label("fin_AND" + counter);
        compiler.addInstruction(new CMP(1, R_left));
        compiler.addInstruction(new BNE(faux_AND));
        compiler.addInstruction(new BOV(compiler.overFlowBool));

        compiler.addInstruction(new CMP(1, R_right));
        compiler.addInstruction(new BNE(faux_AND));
        compiler.addInstruction(new BOV(compiler.overFlowBool));

        compiler.addInstruction(new LOAD(1, R_right));
        compiler.addInstruction(new BRA(fin_AND));

        compiler.addLabel(faux_AND);

        compiler.addInstruction(new LOAD(0, R_right));
        compiler.gest.FreeReg(R_left);
        compiler.addLabel(fin_AND);
        
        counter++;

        compiler.addComment("End of the AND operation");
        return R_right;
    }
}
