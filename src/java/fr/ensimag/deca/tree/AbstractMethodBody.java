package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.ima.pseudocode.GPRegister;

public abstract class AbstractMethodBody extends Tree{
    protected abstract GPRegister codeGenMethodBody(DecacCompiler compiler);

    protected abstract void verifyMethodBody(DecacCompiler compiler) throws ContextualError;
}
