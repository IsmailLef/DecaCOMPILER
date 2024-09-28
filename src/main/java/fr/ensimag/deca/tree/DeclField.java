package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.deca.tree.Visibility;

public class DeclField extends AbstractDeclField{
    private Visibility visibility;
    private AbstractIdentifier type;
    private AbstractIdentifier name;
    private AbstractInitialization initialization;

    public DeclField(AbstractIdentifier type, AbstractIdentifier name, AbstractInitialization initialization, Visibility visibility) {
        this.type = type;
        this.name = name;
        this.initialization = initialization;
        this.visibility = visibility;
    }

  

    public void verifyDeclField(DecacCompiler compiler, AbstractIdentifier className,
                                 EnvironmentExp classEnv, int index) 
                                 throws ContextualError {
        ClassDefinition classDef = className.getClassDefinition();
        Type fieldType = type.verifyType(compiler);

        if (visibility != Visibility.PROTECTED && visibility != Visibility.PUBLIC)
            throw new ContextualError("Field should be either visible or protected. No visibility attribut is given.", getLocation());

        if (fieldType.isVoid())
            throw new ContextualError("Field type cannot be void.", getLocation());
    
        FieldDefinition definition = new FieldDefinition(fieldType, getLocation(), visibility, classDef, index);
        Type nameType = name.verifyExpr(compiler, classEnv, classDef);

        if (! nameType.isString())
            throw new ContextualError("Field cannot be other than string type.", getLocation());
        
        try {
            ClassDefinition superClassDef = classDef.getSuperClass();
            EnvironmentExp superEnv = superClassDef.getProfile().getEnvironmentExp();
            FieldDefinition fieldDef = superEnv.getFieldDefinition(name.getName());
            if (fieldDef == null) {
                throw new ContextualError("Expected Field definition but got other type of definition", getLocation());
            }
            

            Symbol fieldSymbol = name.getName();
            if (! compiler.symbolTable.getMap().containsValue(fieldSymbol)) 
                fieldSymbol = compiler.symbolTable.create(name.getName().getName());
            
            classEnv.declare(fieldSymbol, definition);

        } catch (DoubleDefException dde) {
            System.err.println("DoubleDefException : fieldName " + name.getName().getName() + " already exists.");
            dde.printStackTrace();
            System.exit(1);
        }

        initialization.verifyInitialization(compiler, fieldType, classEnv, classDef);

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
    protected void codeGenDeclField(DecacCompiler compiler, int index) {
        throw new UnsupportedOperationException("Not yed implemented");
    } 
}
