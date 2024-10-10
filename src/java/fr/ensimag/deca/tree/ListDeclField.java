package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;

public class ListDeclField extends TreeList<AbstractDeclField> {
    AbstractIdentifier className;
    protected int nbFields;

    /**
     * Have all attributs from className and compiler, got also environmentType and superClass
     * @param compiler
     */
    public void verifyClassFields(DecacCompiler compiler, EnvironmentExp classEnv) throws ContextualError {
        int index = 0;
        for (AbstractDeclField field : getList()) {
            field.verifyDeclField(compiler, className, classEnv, index++);
        }
        int nbAllFields = countAllFields(compiler, className.getClassDefinition());
        className.getClassDefinition().setNumberOfFields(nbAllFields);
    }

    @Override
    public void decompile(IndentPrintStream s) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    /**
     * Count class's field and all superclasses ones.
     * @param compiler
     * @param classDef
     * @return
     */
    public int countAllFields(DecacCompiler compiler, ClassDefinition classDef) {
        return this.nbFields + classDef.getSuperClass().getNumberOfFields();
    }
}
