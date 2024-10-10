package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.instructions.FLOAT;

/**
 * Conversion of an int into a float. Used for implicit conversions.
 * 
 * @author gl37
 * @date 01/01/2023
 */
public class ConvFloat extends AbstractUnaryExpr {
    public ConvFloat(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError{

        AbstractExpr operand = getOperand();
        Type type = operand.verifyExpr(compiler, localEnv, currentClass);
        Type retrievedType = compiler.typeUnaryOp(null, type);
        if (retrievedType != null){
            // operand.verifyExpr(compiler, localEnv, currentClass);
            setType(retrievedType);
            return retrievedType;
        }
        else
            throw new InternalError("ConvFloat:verifyExpr: Shouldn't get in code since operand is not Int Type."
                    + " Check AbstractExpr.java:verifyRValue for more details");
    }

    @Override
    protected GPRegister codeGenInst(DecacCompiler compiler) {
        compiler.addComment("Setting up the ConvFloat Op");

        GPRegister reg_ConvFloat = getOperand().compute(compiler);
        compiler.addInstruction(new FLOAT( reg_ConvFloat, reg_ConvFloat));

        compiler.addComment("End of ConvFloat Op");
        return reg_ConvFloat;
    }
    @Override
    protected String getOperatorName() {
        return "/* conv float */";
    }

    @Override
    public GPRegister compute(DecacCompiler compiler) {
        return codeGenInst(compiler);
    }
}
