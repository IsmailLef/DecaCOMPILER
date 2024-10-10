package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Signature;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import org.apache.log4j.Logger;

public class ListDeclParam extends TreeList<AbstractDeclParam>{
    @Override
    public void decompile(IndentPrintStream s) {
        for(AbstractDeclParam d : this.getList()){
            d.decompile(s);
        }
    }

    /**
     * Implements non-terminal "list_decl_var" of [SyntaxeContextuelle] in pass 3
     * @param compiler contains the "env_types" attribute
     * @param localEnv
     *   its "parentEnvironment" corresponds to "env_exp_sup" attribute
     *   in precondition, its "current" dictionary corresponds to
     *      the "env_exp" attribute
     *   in postcondition, its "current" dictionary corresponds to
     *      the "env_exp_r" attribute
     * @param currentClass
     *          corresponds to "class" attribute (null in the main bloc).
     */
    public Signature verifyListDeclParam(DecacCompiler compiler, EnvironmentExp localEnv,
                                ClassDefinition currentClass) throws ContextualError {
        Signature sig = new Signature();
        for (AbstractDeclParam declVar : getList()) {
            Type type = declVar.verifyDeclParam(compiler, localEnv, currentClass);
            sig.add(type);
        }
        return sig;
    }
    public void codeGenListDeclParam(DecacCompiler compiler, int i) {
        for (AbstractDeclParam param : getList()) {
            param.codeGenDeclParam(compiler, i);
        }
    }
}