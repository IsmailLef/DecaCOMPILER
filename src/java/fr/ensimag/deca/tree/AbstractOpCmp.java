package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public abstract class AbstractOpCmp extends AbstractBinaryExpr {

    public AbstractOpCmp(AbstractExpr leftOperand, AbstractExpr rightOperand) {
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
            setType(retrievedType);
            verifyCondition(compiler, localEnv, currentClass);
            return retrievedType;
        }
        else
            throw new ContextualError("Cannot apply comparison operation : " + getOperatorName()
                                        + " on types that mismatch - " + type1 + " and " + type2, getLocation());
    }


    
}
