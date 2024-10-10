package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;

import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.instructions.BRA;

import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.BNE;
import fr.ensimag.ima.pseudocode.instructions.BRA;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Full if/else if/else statement.
 *
 * @author gl37
 * @date 01/01/2023
 */
public class IfThenElse extends AbstractInst {
    
    private final AbstractExpr condition; 
    private final ListInst thenBranch;
    private ListInst elseBranch;
    private static int counter = 0;

    public IfThenElse(AbstractExpr condition, ListInst thenBranch, ListInst elseBranch) {
        Validate.notNull(condition);
        Validate.notNull(thenBranch);
        Validate.notNull(elseBranch);
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }
    
    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass, Type returnType)
            throws ContextualError {
            condition.verifyExpr(compiler, localEnv, currentClass);
            thenBranch.verifyListInst(compiler, localEnv, currentClass, returnType);
            elseBranch.verifyListInst(compiler, localEnv, currentClass, returnType);
    }


    @Override
    protected GPRegister codeGenInst(DecacCompiler compiler) {
        Label ifLabel = new Label("if" + counter);
        Label elseLabel = new Label("else" + counter);
        Label fiLabel = new Label("fi" + counter);
        compiler.addLabel(ifLabel);
        counter++;
        
        GPRegister R_res = condition.compute(compiler);
        compiler.addInstruction(new CMP(1, R_res));
        compiler.addInstruction(new BNE(elseLabel));
        compiler.gest.FreeReg(R_res);

        thenBranch.codeGenListInst(compiler);
        compiler.addInstruction(new BRA(fiLabel));
        compiler.addLabel(elseLabel);
        elseBranch.codeGenListInst(compiler);
        compiler.addLabel(fiLabel);
        return null;
    }


    @Override
    public void decompile(IndentPrintStream s) {
        s.print("if (");
        condition.decompile(s);
        s.println(") {");
        s.indent();
        thenBranch.decompile(s);
        s.unindent();
        s.println("}");
        s.println("else { ");
        s.indent();
        elseBranch.decompile(s);
        s.unindent();
        s.print("}");

    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        condition.iter(f);
        thenBranch.iter(f);
        elseBranch.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        condition.prettyPrint(s, prefix, false);
        thenBranch.prettyPrint(s, prefix, false);
        elseBranch.prettyPrint(s, prefix, true);
    }
}
