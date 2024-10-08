package fr.ensimag.deca.context;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.deca.tree.Location;
import org.apache.commons.lang.Validate;

/**
 * Type defined by a class.
 *
 * @author gl37
 * @date 01/01/2023
 */
public class ClassType extends Type {
    
    protected ClassDefinition definition;
    
    public ClassDefinition getDefinition() {
        return this.definition;
    }
            
    @Override
    public ClassType asClassType(String errorMessage, Location l) {
        return this;
    }

    @Override
    public boolean isClass() {
        return true;
    }

    @Override
    public boolean isClassOrNull() {
        return true;
    }

    /**
     * Standard creation of a type class.
     */
    public ClassType(Symbol className, Location location, ClassDefinition superClass) {
        super(className);
        this.definition = new ClassDefinition(this, location, superClass);
    }

    /**
     * Creates a type representing a class className.
     * (To be used by subclasses only)
     */
    protected ClassType(Symbol className) {
        super(className);
    }
    

    @Override
    public boolean sameType(Type otherType) {
        if (otherType instanceof ClassType) {
            try {
                ClassType comparablType = otherType.asClassType("Cannot cast into ClassType.", definition.getLocation());
                if (this.equals(comparablType)) 
                    return true;
            } catch (ContextualError ce) {
                ce.printStackTrace();
                System.exit(1);
            }
        }
        return false;
    }

    /**
     * Return true if potentialSuperClass is a superclass of this class.
     */
    public boolean isSubClassOf(DecacCompiler compiler, ClassType potentialSuperClass) {
        if (this.equals(null))
            return true;

        if (this.equals(potentialSuperClass)) 
            return true;
        // Superclass is main class

        ClassType objClassType = compiler.environmentType.OBJECT;
        if (potentialSuperClass.equals(objClassType)) 
            return true;
        // Superclass is actually Object class

        ClassType superClassType = this.definition.getSuperClass().getType();
        if (potentialSuperClass.equals(superClassType) || superClassType.isSubClassOf(compiler, potentialSuperClass))
            return true;
        // Transitivty of subClassing

        return false;        
    }


}
