package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassExtension;
import fr.ensimag.deca.context.ClassProfile;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.DecacInternalError;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;

import java.io.PrintStream;

import org.apache.commons.lang.Validate;

/**
 * Declaration of a class (<code>class name extends superClass {members}<code>).
 * 
 * @author gl37
 * @date 01/01/2023
 */
public class DeclClass extends AbstractDeclClass {

    private AbstractIdentifier name;
    private AbstractIdentifier superClass;
    private ListDeclField fields;
    private ListDeclMethod methods;


    public DeclClass(AbstractIdentifier name, AbstractIdentifier superClass, ListDeclField fields, ListDeclMethod methods) {
        Validate.notNull(name);
        Validate.notNull(fields);
        this.name = name;
        this.superClass = superClass;
        this.fields = fields;
        this.methods = methods;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("class { ... A FAIRE ... }");
    }

    

    @Override
    protected void verifyClass(DecacCompiler compiler) throws ContextualError {
        // Before adding context to environmentType, program should check if any error occurs in superClass or name.

        String className = name.getName().getName();
        
        if (superClass == null) superClass = compiler.environmentType.Object;
        String superClassName = superClass.getName().getName(); // Always not null because the only one with a null superClass is Object. Can't redefine it.

        Symbol superSymb = compiler.environmentType.getSymbol(superClassName);
        if (superSymb == null) 
            throw new ContextualError("superClass " + superClassName + " of class : " + className + " is not defined", getLocation());
        else if (! compiler.environmentType.defOfType(superSymb).isClass())
            throw new ContextualError("Expected a Class type but got generic Type.", getLocation());

        if (compiler.environmentType.getSymbol(className) == null) {
            ClassDefinition superClassDef = superClass.getClassDefinition();

            ClassExtension ext = new ClassExtension(true, superSymb);
            EnvironmentExp parenEnvironment = superClassDef.getMembers();
            EnvironmentExp classEnvironmentExp = new EnvironmentExp(parenEnvironment);
            // Environment is initialized here but still empty. Fill is in second pass
            ClassProfile profile = new ClassProfile(ext, classEnvironmentExp);
            superClassDef.setProfile(profile);
            // Setting definition's profile since it's a Class
            compiler.environmentType.declareClassType(compiler, name, superClassDef);
            // Adding Class type into environmentType
            if (! name.verifyExpr(compiler, classEnvironmentExp, superClassDef).isString())
                throw new ContextualError("Invalid Class name. Only string are allowed as Class name", getLocation());
            superClass.verifyExpr(compiler, classEnvironmentExp, superClassDef).isClass();
        }
        else
            throw new ContextualError("Class " + className + " is already defined", getLocation());
    }

    @Override
    protected void verifyClassMembers(DecacCompiler compiler)
            throws ContextualError {

        
        if (superClass.getName().getName().equals("Object"))
                throw new ContextualError("Trying to access super class of Object class : super class does not exist.", getLocation());
        else {
            Symbol superSymb = compiler.environmentType.getSymbol(superClass.getName().getName());
            ClassDefinition superDef = (ClassDefinition) compiler.environmentType.defOfType(superSymb);
            EnvironmentExp superEnvExp = superClass.getClassDefinition().getMembers();
            ClassProfile profile = superDef.getProfile();
        
            if (! profile.getEnvironmentExp().equals(superEnvExp)) // Expect super Environment to be set
                throw new DecacInternalError("First pass didn't complete successfully.");
            
            EnvironmentExp currentEnvExp = name.getClassDefinition().getMembers();
   
            
            fields.verifyClassFields(compiler, currentEnvExp); // Nesting is done in both verification of fields and methods
            methods.verifyClassMethods(compiler, currentEnvExp);
        }
    }
    
    @Override
    protected void verifyClassBody(DecacCompiler compiler) throws ContextualError {
        throw new UnsupportedOperationException("not yet implemented");
    }


    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        throw new UnsupportedOperationException("Not yet supported");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        throw new UnsupportedOperationException("Not yet supported");
    }

}
