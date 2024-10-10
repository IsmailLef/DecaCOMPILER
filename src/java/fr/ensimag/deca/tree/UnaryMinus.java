package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.*;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.*;
import fr.ensimag.deca.DecacCompiler;

/**
 * @author gl37
 * @date 01/01/2023
 */
public class UnaryMinus extends AbstractUnaryExpr {

    public UnaryMinus(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {

        Type optype = getOperand().verifyExpr(compiler, localEnv, currentClass);
        if (optype.isInt()) isInt = true;
        String operator = getOperatorName();
        Type retrievedType = compiler.typeUnaryOp(operator, optype);
        if (retrievedType != null){
            setType(retrievedType);
            return retrievedType;
        }
        else
            throw new ContextualError("Cannot apply arithmetic unary operation : " + getOperatorName()
                    + " on types that mismatch - " + optype.toString(), getLocation());
    }


    @Override
    protected String getOperatorName() {
        return "-";
    }

    @Override
    public void verifyCondition(DecacCompiler compiler, EnvironmentExp localEnv,
                                ClassDefinition currentClass) throws ContextualError {
        Type type = getOperand().verifyExpr(compiler, localEnv, currentClass);
        if(! type.isBoolean()){
            throw new ContextualError("Values are not compatible", getLocation());
        }
    }
    protected boolean isInt = false;

    @Override
    public GPRegister codeGenInst(DecacCompiler compiler) {
        compiler.addComment("Setting up the UnaryMinus Op");

        GPRegister R_opposite = getOperand().compute(compiler);
        compiler.addInstruction(new OPP(R_opposite, R_opposite));
        if(!compiler.getCompilerOptions().getNocheck()){
            compiler.addInstruction(new BOV(compiler.overFlowError));
        }

        compiler.addComment("Fin UnaryMinus Op");
        return R_opposite;
    }

    @Override
    protected void codeGenPrint(DecacCompiler compiler, Boolean printhex) {
        GPRegister reg = codeGenInst(compiler);
        if(isInt){
            compiler.addInstruction(new LOAD(reg, Register.R1));
            compiler.addInstruction(new WINT());
        }
        else {
            compiler.addInstruction(new LOAD(reg, Register.R1));
            if (! printhex) compiler.addInstruction(new WFLOAT());
            else compiler.addInstruction(new WFLOATX());
        }
    }

    @Override
    protected GPRegister compute(DecacCompiler compiler) {
        return codeGenInst(compiler);
    }
}

