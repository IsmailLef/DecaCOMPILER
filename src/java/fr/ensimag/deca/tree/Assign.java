package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tree.ConvFloat;
import fr.ensimag.deca.tree.GestionnaireReg;

/**
 * Assignment, i.e. lvalue = expr.
 *
 * @author gl37
 * @date 01/01/2023
 */
public class Assign extends AbstractBinaryExpr {

    @Override
    public AbstractLValue getLeftOperand() {
        // The cast succeeds by construction, as the leftOperand has been set
        // as an AbstractLValue by the constructor.
        return (AbstractLValue)super.getLeftOperand();
    }

    public Assign(AbstractLValue leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {

                
        Type expectedType = getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        AbstractExpr expr = getRightOperand().verifyRValue(compiler, localEnv, currentClass, expectedType);
        
        if (expr.getType().isInt() && expectedType.isFloat()) {
            ConvFloat conv = new ConvFloat(expr);
            setRightOperand(conv);
            conv.verifyRValue(compiler, localEnv, currentClass, expectedType);
            setType(expectedType);
            return expectedType;
        }
        else if (expr.getType().sameType(expectedType)) {
            setType(expectedType);
            return expectedType;
        }
        else
        throw new ContextualError("Cannot make assignment : Types are incompatible. Attempting to convert object from " +
                                expr.getType() + " to " + expectedType, getLocation());
    }


    @Override
    protected String getOperatorName() {
        return "=";
    } 
    @Override
    protected GPRegister codeGenInst(DecacCompiler compiler){
        compiler.addComment("assigning a value to an existant variable");
        DAddr leftRegister = compiler.envExp.get(((Identifier)getLeftOperand()).getName()).getOperand();
        GPRegister R_assign = getRightOperand().compute(compiler);

        compiler.addInstruction(new STORE(R_assign, leftRegister));
        return R_assign;
    }

    @Override
    public GPRegister compute(DecacCompiler compiler) {
        return codeGenInst(compiler);
    }

}
