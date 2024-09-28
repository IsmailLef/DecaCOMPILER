package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.RINT;
import fr.ensimag.ima.pseudocode.instructions.WNL;
import fr.ensimag.ima.pseudocode.instructions.WSTR;

import java.io.PrintStream;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public class ReadInt extends AbstractReadExpr {

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
            
        // if (! compiler.assign_compatible(compiler.environmentType, compiler.environmentType.INT, getType())) {
        //     throw new ContextualError("Expected to read Int value but given value is : " + getType().toString(), getLocation());
        // }
        setType(compiler.environmentType.INT);
        return compiler.environmentType.INT;
    }
    @Override
    protected GPRegister codeGenInst(DecacCompiler compiler) {
        compiler.addComment("Setting up the ReadInt");
        GPRegister R1 = Register.getR(1);
        GPRegister storeReg = compiler.gest.getFreeReg();
        // compiler.addInstruction(new WSTR("Input int value : "));
        // compiler.addInstruction(new WNL());
        compiler.addInstruction(new RINT());
        if(!compiler.getCompilerOptions().getNocheck()){
            compiler.addInstruction(new BOV(compiler.ioError));
        }
        compiler.addInstruction(new LOAD(R1, storeReg));
        compiler.addComment("Fin de ReadInt");
        return storeReg;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("readInt()");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        // leaf node => nothing to do
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // leaf node => nothing to do
    }

    @Override
    protected GPRegister compute(DecacCompiler compiler) {
        return codeGenInst(compiler);
    }
}
