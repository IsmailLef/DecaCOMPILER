package fr.ensimag.deca.context;

import java.util.HashMap;
import java.util.Map;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.tools.SymbolTable.Symbol;

/**
 * Dictionary associating identifier's ExpDefinition to their names.
 * 
 * This is actually a linked list of dictionaries: each EnvironmentExp has a
 * pointer to a parentEnvironment, corresponding to superblock (eg superclass).
 * 
 * The dictionary at the head of this list thus corresponds to the "current" 
 * block (eg class).
 * 
 * Searching a definition (through method get) is done in the "current" 
 * dictionary and in the parentEnvironment if it fails. 
 * 
 * Insertion (through method declare) is always done in the "current" dictionary.
 * 
 * @author gl37
 * @date 01/01/2023
 */
public class EnvironmentExp {

    EnvironmentExp parentEnvironment;
    Map<Symbol, Definition> expTokens;
    DecacCompiler compiler;
    
    /**
     * Use this constructor to restore super Environment and in order to empile the new one on it
     * @param parentEnvironment
     *                      The parameter we want to empile on
     */
    public EnvironmentExp(EnvironmentExp parentEnvironment) {
        this.parentEnvironment = parentEnvironment;
        if (parentEnvironment != null) 
            this.expTokens = new HashMap<Symbol, Definition>(parentEnvironment.expTokens);
        else 
            this.expTokens = new HashMap<Symbol, Definition>();
    }
   



    public EnvironmentExp getSuperEnvironmentExp() {
        return this.parentEnvironment;
    }


    public Symbol getSymbol(String name) {
        for (Symbol symb : expTokens.keySet()) {
            if (symb.getName().equals(name))
                return symb;
        }
        return null;
    }

    public static class DoubleDefException extends Exception {
        private static final long serialVersionUID = -2733379901827316441L;
    }

    /**
     * Return the definition of the symbol in the environment, or null if the
     * symbol is undefined.
     */
    public ExpDefinition get(Symbol key) {
        // if (compiler.symbolTable.getMap().containsValue(key))
            return (ExpDefinition) expTokens.get(key);
        // else return null;
    }

    /**
     * Add the definition def associated to the symbol name in the environment.
     * 
     * Adding a symbol which is already defined in the environment,
     * - throws DoubleDefException if the symbol is in the "current" dictionary 
     * - or, hides the previous declaration otherwise.
     * 
     * @param name
     *            Name of the symbol to define
     * @param def
     *            Definition of the symbol
     * @throws DoubleDefException
     *             if the symbol is already defined at the "current" dictionary
     *
     */
    public void declare(Symbol name, Definition def) throws DoubleDefException {
        
        // Symbol exists, Shall define it only if it's not already done
        Symbol symb = getSymbol(name.getName());
        if (symb != null && expTokens.get(symb).getType() == def.getType()) {// If symbol is found with the exact same definition
                                                                             // Typically : int x, x;
            throw new DoubleDefException();
        }
        else // Compute it if exists and different. Typically int x; and then String x;
            expTokens.put(name, def);
    }

    public FieldDefinition getFieldDefinition(Symbol symbol) {
        Definition def = expTokens.get(symbol);
        if (def instanceof FieldDefinition)
            return (FieldDefinition) expTokens.get(symbol);
        return null;
    }

    public MethodDefinition getMethodDefinition(Symbol symbol) {
        Definition def = expTokens.get(symbol);
        if (def instanceof FieldDefinition)
            return (MethodDefinition) expTokens.get(symbol);
        return null;
    }
}
