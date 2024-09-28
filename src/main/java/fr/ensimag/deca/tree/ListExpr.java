package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;

/**
 * List of expressions (eg list of parameters).
 *
 * @author gl37
 * @date 01/01/2023
 */
public class ListExpr extends TreeList<AbstractExpr> {


    @Override
    public void decompile(IndentPrintStream s) {
        if(getList().size() == 1){
            getList().get(0).decompile(s);
        }
        else{
            for(int i = 0; i < getList().size() - 1; i++){
                getList().get(i).decompile(s);
                s.print(", ");
            }
            getList().get(getList().size() - 1).decompile(s);
        }
        
    }
}
