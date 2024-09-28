package fr.ensimag.deca.tree;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.SortedSet;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;

public class ListDeclMethod extends TreeList<AbstractDeclMethod> {
    AbstractIdentifier className;

    
    public ListDeclMethod(AbstractIdentifier className) {
        this.className = className;
    }


    /**
     * Have all attributs from className and compiler, got also environmentType and superClass
     * @param compiler
     */
    public void verifyClassMethods(DecacCompiler compiler, EnvironmentExp classEnv) throws ContextualError {
        ClassDefinition superDef = className.getClassDefinition().getSuperClass();

        int index = superDef.getNumberOfMethods() + 1;
        for (AbstractDeclMethod method : getList()) {
            method.verifyDeclMethod(compiler, className, classEnv, index);
            index++;
        }
    }

    @Override
    public void decompile(IndentPrintStream s) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
