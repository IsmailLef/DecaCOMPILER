package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.instructions.DEL;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public abstract class AbstractOpBool extends AbstractBinaryExpr {

    public AbstractOpBool(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        
        AbstractExpr exp1 = getLeftOperand();
        AbstractExpr exp2 = getRightOperand();
        Type type1 = exp1.verifyExpr(compiler, localEnv, currentClass);
        Type type2 = exp2.verifyExpr(compiler, localEnv, currentClass);
        String Operator = this.getOperatorName();
        Type retrievedType = compiler.typeBinaryOp(Operator, type1, type2);
        
        if (retrievedType != null) {
            verifyCondition(compiler, localEnv, currentClass);
            setType(retrievedType);
            return retrievedType;
        }
        else
            throw new ContextualError("Cannot apply boolean operation : " + getOperatorName()
                                        + " on types that mismatch - " + type1 + " and " + type2, getLocation());
    }
    protected abstract GPRegister codeGenRegs(DecacCompiler compiler, GPRegister Register1, GPRegister Register2);
    protected abstract void codeGenComment(DecacCompiler compiler);
    
    @Override
    public GPRegister codeGenInst(DecacCompiler compiler){
        GPRegister R_left = null;
        GPRegister R_right = null;
        R_left = getLeftOperand().compute(compiler); 
        R_right = getRightOperand().compute(compiler);
       
        return codeGenRegs(compiler, R_left, R_right);
    }

    @Override
    public GPRegister compute(DecacCompiler compiler) {
        return codeGenInst(compiler);
    }
}
