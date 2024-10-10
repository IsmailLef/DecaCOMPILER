package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.GPRegister;

public abstract class AbstractDeclMethod extends Tree {

    /**
     * Needs environment and super class in order to verify signature
     * @param compiler
     * @param className
     */
    public abstract void verifyDeclMethod(DecacCompiler compiler, AbstractIdentifier className, EnvironmentExp classEnv, int index) throws ContextualError;

    public abstract void codeDeclMethod(DecacCompiler compiler, int index);
}
