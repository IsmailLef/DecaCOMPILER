package fr.ensimag.deca.context;

import fr.ensimag.deca.tools.SymbolTable;
import fr.ensimag.deca.tools.SymbolTable.Symbol;

public class ClassExtension {
    private boolean isObject;
    private Symbol symbol;

    public ClassExtension(boolean isObject, Symbol symbol) {
       this.isObject = isObject;
       this.symbol = symbol;
    }


    /**
     * Returns Extension symbol. Keep in mind that if class is Object class, this method won't be a good call
     * Try out whether isObject is true or false
     * @return Symbol of current class extension
     */
    public Symbol getSymbol() throws IllegalCallerException{
        if (! isObject)
            return symbol;
        else
            throw new IllegalCallerException("Cannot call ClassExtension.java:getSymbol() because this class has no super class.");
    }

    public int getObjectSymbol() {
        return 0;
    }

    public boolean getIsObject() {
        return this.isObject;
    }
}
