package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.BNE;
import fr.ensimag.ima.pseudocode.instructions.BRA;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.DAddr;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.ObjectUtils.Null;

/**
 *
 * @author gl37
 * @date 01/01/2023
 */
public class While extends AbstractInst {
    private AbstractExpr condition;
    private ListInst body;

    public AbstractExpr getCondition() {
        return condition;
    }

    public ListInst getBody() {
        return body;
    }

    protected static int counter = 0;

    public While(AbstractExpr condition, ListInst body) {
        Validate.notNull(condition);
        Validate.notNull(body);
        this.condition = condition;
        this.body = body;
    }

    @Override
    protected GPRegister codeGenInst(DecacCompiler compiler) {
        compiler.addComment("Setting up the WHILE instruction");
        Label while_label = new Label("While" + counter);
        Label fin_while = new Label("fin_while" + counter);
        compiler.addLabel(while_label);
        GPRegister R_res = null;
        counter++;
        
        R_res =condition.codeGenInst(compiler);
        compiler.addInstruction(new CMP(1, R_res));
        compiler.addInstruction(new BNE(fin_while));
        compiler.gest.FreeReg(R_res);

        body.codeGenListInst(compiler);
        compiler.addInstruction(new BRA(while_label));
        compiler.addLabel(fin_while);
        compiler.addComment("End of WHILE instruction");

        return null;
    }

    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass, Type returnType)
            throws ContextualError {
            condition.verifyExpr(compiler, localEnv, currentClass);
            body.verifyListInst(compiler, localEnv, currentClass, returnType);
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("while (");
        getCondition().decompile(s);
        s.println(") {");
        s.indent();
        getBody().decompile(s);
        s.unindent();
        s.print("}");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        condition.iter(f);
        body.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        condition.prettyPrint(s, prefix, false);
        body.prettyPrint(s, prefix, true);
    }

}
