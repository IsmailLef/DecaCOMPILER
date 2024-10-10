package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.MethodDefinition;
import fr.ensimag.deca.context.Signature;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;

public class DeclMethod extends AbstractDeclMethod {
    AbstractIdentifier type;
    AbstractIdentifier methodName;
    ListDeclParam param;
    AbstractMethodBody methBody;
    // ADD METHOD BODY

    public DeclMethod(AbstractIdentifier type, AbstractIdentifier methodName, ListDeclParam param, AbstractMethodBody methBody) {
        this.type = type;
        this.methodName = methodName;
        this.param = param;
        this.methBody = methBody;
    }


    public void verifyDeclMethod(DecacCompiler compiler, AbstractIdentifier className,
                                    EnvironmentExp classEnv, int index)
                                    throws ContextualError {

        Type retrievedType = type.verifyType(compiler);
        ClassDefinition classDef = className.getClassDefinition();
        Signature sig = param.verifyListDeclParam(compiler, classEnv, classDef);


        int actualIndex = index; // May be different than index in parameter because it should match the index of the method that it overrides
        
        ClassDefinition superClassDef = classDef.getSuperClass();
        EnvironmentExp superEnv = superClassDef.getProfile().getEnvironmentExp();
        MethodDefinition methodDefInSuper = superEnv.getMethodDefinition(methodName.getName());
        if (methodDefInSuper != null) { // if method is already declared in parent class
            if (! methodDefInSuper.getSignature().equals(sig))
                throw new ContextualError("Overrided methods should have the same signature", getLocation());
            if (! compiler.subtype(compiler.environmentType, retrievedType, methodDefInSuper.getType()))
                throw new ContextualError("Overrided methods must retrieve same Type or Subtypes", getLocation());
            actualIndex = methodDefInSuper.getIndex();
            index--; // Decrement this index because it was not used.
        }

        MethodDefinition methodDef = new MethodDefinition(retrievedType, getLocation(), sig, actualIndex);
        try {
            classEnv.declare(methodName.getName(), methodDef);
        } catch (DoubleDefException dde) {
            System.err.println("DoubleDefException : fieldName " + methodName.getName().getName() + " already exists.");
            dde.printStackTrace();
            System.exit(1);
        }
        
        methodName.verifyExpr(compiler, classEnv, classDef);
        methodName.setType(retrievedType);
    }

    @Override
    public void decompile(IndentPrintStream s) {
        throw new UnsupportedOperationException("Not yed implemented");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        throw new UnsupportedOperationException("Not yed implemented");
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        throw new UnsupportedOperationException("Not yed implemented");
    }

    @Override
    public void codeDeclMethod(DecacCompiler compiler, int index) {
        throw new UnsupportedOperationException("Not yed implemented");
    } 
}
