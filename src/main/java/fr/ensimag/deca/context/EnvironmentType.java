package fr.ensimag.deca.context;

import fr.ensimag.deca.DecacCompiler;
import java.util.HashMap;
import java.util.Map;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.deca.tree.AbstractIdentifier;
import fr.ensimag.deca.tree.Identifier;
import fr.ensimag.deca.tree.Location;

// A FAIRE: étendre cette classe pour traiter la partie "avec objet" de Déca
/**
 * Environment containing types. Initially contains predefined identifiers, more
 * classes can be added with declareClass().
 *
 * @author gl37
 * @date 01/01/2023
 */
public class EnvironmentType {
    public EnvironmentType(DecacCompiler compiler) {
        
        envTypes = new HashMap<Symbol, Definition>();
        
        Symbol intSymb = compiler.createSymbol("int");
        INT = new IntType(intSymb);
        envTypes.put(intSymb, new TypeDefinition(INT, Location.BUILTIN));

        Symbol floatSymb = compiler.createSymbol("float");
        FLOAT = new FloatType(floatSymb);
        envTypes.put(floatSymb, new TypeDefinition(FLOAT, Location.BUILTIN));

        Symbol voidSymb = compiler.createSymbol("void");
        VOID = new VoidType(voidSymb);
        envTypes.put(voidSymb, new TypeDefinition(VOID, Location.BUILTIN));

        Symbol booleanSymb = compiler.createSymbol("boolean");
        BOOLEAN = new BooleanType(booleanSymb);
        envTypes.put(booleanSymb, new TypeDefinition(BOOLEAN, Location.BUILTIN));

        Symbol stringSymb = compiler.createSymbol("string");
        STRING = new StringType(stringSymb);
        // not added to envTypes, it's not visible for the user.

        Symbol objectClass = compiler.createSymbol("Object"); // Object class is needed in the initialization
        OBJECT = new ClassType(objectClass);
        ClassDefinition def = new ClassDefinition(OBJECT, Location.BUILTIN, null);
        ClassExtension ext = new ClassExtension(true, null);
        ClassProfile profile = new ClassProfile(ext, null); // Needs change because environmentExp should implement equals() method.
        def.setProfile(profile);
        envTypes.put(objectClass, def);
        Object = new Identifier(objectClass);
        Object.setDefinition(def);
        def.setNumberOfFields(0);
        def.setNumberOfMethods(1);
    }

    
    private final Map<Symbol, Definition> envTypes;

    public Definition defOfType(Symbol s) { // Changed : was retrieving TypeDefinition type at the beginning
        return envTypes.get(s);
    }


    public Symbol getSymbol(String name) {
        for (Symbol symb : envTypes.keySet()) {
        if (symb.getName().equals(name))
                return symb;
        }
        return null;
    }

    /**
     * Declare new class type with the string passed in parameters and add it to the types environment
     * with its definition
     * @param compiler
     * @param name
     * @param superClassDef
     */
    public void declareClassType(DecacCompiler compiler, AbstractIdentifier name, ClassDefinition superClassDef) {
        String nameString = name.getName().getName();
        if (! compiler.symbolTable.getMap().containsKey(nameString)) {
            Symbol symb = compiler.createSymbol(nameString);
        
            if (! envTypes.containsKey(symb)) {
                ClassType type = new ClassType(symb);
                ClassDefinition def =  new ClassDefinition(type, Location.BUILTIN, superClassDef);
                envTypes.put(symb, def);
                name.setDefinition(def);
                // Important to set Definition in the identifier so that it can be accessible whenever we have this identifier
            }
        }
    }



    public final VoidType    VOID;
    public final IntType     INT;
    public final FloatType   FLOAT;
    public final StringType  STRING;
    public final BooleanType BOOLEAN;
    public final ClassType OBJECT;
    public AbstractIdentifier Object;
}
