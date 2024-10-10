package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.ExpDefinition;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.ImmediateString;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.deca.tree.GestionnaireReg;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * @author gl37
 * @date 01/01/2023
 */
public class DeclVar extends AbstractDeclVar {

    
    final private AbstractIdentifier type;
    final private AbstractIdentifier varName;
    final private AbstractInitialization initialization;

    public DeclVar(AbstractIdentifier type, AbstractIdentifier varName, AbstractInitialization initialization) {
        Validate.notNull(type);
        Validate.notNull(varName);
        Validate.notNull(initialization);
        this.type = type;
        this.varName = varName;
        this.initialization = initialization;
    }

    @Override
    protected void verifyDeclVar(DecacCompiler compiler,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
            
        
            /* Adding new context to @param localEnv
                */

            try {
                Type retrievedType = type.verifyType(compiler); // Needs to add to environmentType whenever a new class is defined
                type.setType(retrievedType);
                if (retrievedType.isVoid()) // Variable can't be void-type
                    throw new ContextualError("Cannot declare variable " + varName.getName().toString() + " with void type.", getLocation());
                if(initialization instanceof Initialization){
                    AbstractExpr expInit = ((Initialization)initialization).getExpression();
                    if ((expInit instanceof IntLiteral) && retrievedType.isFloat()) {
                        ConvFloat conv = new ConvFloat(expInit);
                        ((Initialization)initialization).setExpression(conv);
                        conv.verifyRValue(compiler, localEnv, currentClass, retrievedType);
                        expInit.setType(retrievedType);
                    }
                }
                
                
                Definition def = new VariableDefinition(type.getType(), getLocation());
                localEnv.declare(varName.getName(), (ExpDefinition) def);
                varName.verifyExpr(compiler, localEnv, currentClass);

                EnvironmentExp empileEnvExp = new EnvironmentExp(localEnv);
                initialization.verifyInitialization(compiler, retrievedType, empileEnvExp, currentClass);
            } catch (DoubleDefException dde) {
                dde.printStackTrace();
                System.exit(1);
            } 
        }

    
    @Override
    public void decompile(IndentPrintStream s) {
        type.decompile(s);
        s.print(" ");
        varName.decompile(s);
        s.print(" ");
        initialization.decompile(s);
        s.println(";");
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        type.iter(f);
        varName.iter(f);
        initialization.iter(f);
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        varName.prettyPrint(s, prefix, false);
        initialization.prettyPrint(s, prefix, true);
    }
    @Override
    protected void codeGenDeclVar(DecacCompiler compiler, int i){
        DAddr locationInStack = new RegisterOffset(i, Register.GB);
        compiler.envExp.get(this.varName.getName()).setOperand(locationInStack);
        
        GPRegister R_decl = initialization.compute(compiler);

        compiler.addInstruction(new STORE(R_decl,locationInStack));
        compiler.gest.FreeReg(R_decl);
    }
}