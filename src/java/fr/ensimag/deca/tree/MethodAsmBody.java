package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.GPRegister;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;

import java.io.PrintStream;

public class MethodAsmBody extends AbstractMethodBody{
    private static final Logger LOG = Logger.getLogger(MethodAsmBody.class);

    private String code;
    public MethodAsmBody(String code) {
        Validate.notNull(code);
        this.code = code;
    }

    @Override
    protected void verifyMethodBody(DecacCompiler compiler) throws ContextualError {
        LOG.debug("verify MethodAsmBody: start");

        LOG.debug("verify MethodAsmBody: end");
    }

    @Override
    protected GPRegister codeGenMethodBody(DecacCompiler compiler) {
        throw new UnsupportedOperationException("Not yed implemented");
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.println("asm( "+code+" )");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
    }
}