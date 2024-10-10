package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.GPRegister;

public abstract class AbstractDeclField extends Tree {

    /**
     * Need className and environments in order to store fiels into class definition
     * @param compiler
     * @param className
     */
    public abstract void verifyDeclField(DecacCompiler compiler, AbstractIdentifier name, EnvironmentExp classEnv, int index) throws ContextualError;

    protected abstract void codeGenDeclField(DecacCompiler compiler, int index);
}
