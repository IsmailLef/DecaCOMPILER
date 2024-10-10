package fr.ensimag.deca.tree;


import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;


import java.util.ArrayList;

public class GestionnaireReg {

    private DecacCompiler compiler;
    private ArrayList<Boolean> boolRegistres;
    private int MAX_REG;
    public int stackCounter = 0;

    public GestionnaireReg(DecacCompiler compiler, int MAX_REG) throws IllegalArgumentException{
        if (MAX_REG > 15)
            throw new IllegalArgumentException("There is only 15 Registers. You can't be using more");
        
        this.compiler = compiler;
        this.boolRegistres = new ArrayList<Boolean>(MAX_REG);
        this.MAX_REG = MAX_REG;

        boolRegistres.add(0, true);
        boolRegistres.add(1, true);
        for(int i =2; i<=MAX_REG; i++){
            boolRegistres.add(i, false);
        }
    }

    public GPRegister getFreeReg(){
        for (int i = 2; i<=MAX_REG; i++) {
        if (boolRegistres.get(i) == false) {
            boolRegistres.set(i, true);
                return Register.getR(i);
            }
        }

        compiler.addInstruction(new PUSH(Register.getR(MAX_REG)));
        stackCounter++;
        compiler.incrementPushCounter();
        return Register.getR(MAX_REG);
    }

    public void FreeReg(GPRegister regi){
        int index = regi.getNumber();
        boolRegistres.set(index, false);
    }


    public int count() {
        int count = 0;
        for (int i = 2; i<=MAX_REG; i++) {
            if (! boolRegistres.get(i))
                count++;
        }
        return count;
    }

    public void flush() {
        for (int i = 2; i<=MAX_REG; i++)
            boolRegistres.set(i, false);
    }
}
