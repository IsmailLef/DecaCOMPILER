package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.GPRegister;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * @author gl37
 * @date 01/01/2023
 */
public class Initialization extends AbstractInitialization {

    public AbstractExpr getExpression() {
        return expression;
    }

    private AbstractExpr expression;

    public void setExpression(AbstractExpr expression) {
        Validate.notNull(expression);
        this.expression = expression;
    }

    public Initialization(AbstractExpr expression) {
        Validate.notNull(expression);
        this.expression = expression;
    }

    @Override
    protected void verifyInitialization(DecacCompiler compiler, Type t,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        
        if (t.isVoid()) 
            throw new ContextualError("Cannot initialize with void type", getLocation());

        
        expression.verifyRValue(compiler, localEnv, currentClass, t);

        if (expression.getType().isInt() && t.isFloat()) {
            ConvFloat conv = new ConvFloat(expression);
            setExpression(conv);
            conv.setType(compiler.environmentType.FLOAT);
        }
        expression.setType(t);

    }


    @Override
    public void decompile(IndentPrintStream s) {
        s.print("= ");
        getExpression().decompile(s);
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        expression.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        expression.prettyPrint(s, prefix, true);
    }

    @Override
    public GPRegister compute(DecacCompiler compiler) {
        return getExpression().compute(compiler);
    }
}
