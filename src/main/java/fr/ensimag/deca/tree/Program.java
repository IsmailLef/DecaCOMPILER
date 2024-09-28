package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.AbstractLine;
import fr.ensimag.ima.pseudocode.Line;
import fr.ensimag.ima.pseudocode.ImmediateString;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.*;
import java.io.PrintStream;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;

/**
 * Deca complete program (class definition plus main block)
 *
 * @author gl37
 * @date 01/01/2023
 */
public class Program extends AbstractProgram {
    private static final Logger LOG = Logger.getLogger(Program.class);
    
    public Program(ListDeclClass classes, AbstractMain main) {
        Validate.notNull(classes);
        Validate.notNull(main);
        this.classes = classes;
        this.main = main;
    }
    public ListDeclClass getClasses() {
        return classes;
    }
    public AbstractMain getMain() {
        return main;
    }
    private ListDeclClass classes;
    private AbstractMain main;

    @Override
    public void verifyProgram(DecacCompiler compiler) throws ContextualError {
        LOG.debug("verify program: start");
        EnvironmentExp mainEnv = new EnvironmentExp(null);
        compiler.envExp = mainEnv; // To let envExp accessible to all classes of the compiler

        // 1st pass
        classes.verifyListClass(compiler);
        // 2nd pass
        classes.verifyListClassMembers(compiler);
        // 3d pass
        classes.verifyListClassBody(compiler);
        main.verifyMain(compiler);
        // classes.verifyListClass(compiler); Not yet
        // LOG.debug("verify program: end");
    }

    @Override
    public void codeGenProgram(DecacCompiler compiler) {
        // A FAIRE: compléter ce squelette très rudimentaire de code
        compiler.addComment("Main program");
        Line line = new Line(null, null, null);
        compiler.add(line);
        compiler.addInstruction(new BOV(compiler.StackOverFlowError));
        if(main.getSizeDeclVar() != 0){
            compiler.addInstruction(new ADDSP(main.getSizeDeclVar()));
        }
        main.codeGenMain(compiler);
        line.setInstruction(new TSTO(compiler.getMaxStackPush() + main.getSizeDeclVar()));
        line.setComment(compiler.getMaxStackPush()+" temporary and params on stack + "+main.getSizeDeclVar()+
                            " (variables) + " + compiler.getCompilerOptions().getRegisters()+" (registers) ");
        compiler.addInstruction(new HALT());
        compiler.addComment("End Main program");

        compiler.addLabel(compiler.ZeroDivisionError);
        compiler.addInstruction(new WSTR(new ImmediateString("ERROR : Division by zero not allowed.")));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());

        compiler.addLabel(compiler.StackOverFlowError);
        compiler.addInstruction(new WSTR(new ImmediateString("ERROR : StackOverflow.")));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
        
        compiler.addLabel(compiler.overFlowError);
        compiler.addInstruction(new WSTR(new ImmediateString("ERROR : Overflow during arithmetic operation.")));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());

        compiler.addLabel(compiler.ioError);
        compiler.addInstruction(new WSTR(new ImmediateString("ERROR : inpput/output error.")));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());

        compiler.addLabel(compiler.overFlowCmp);
        compiler.addInstruction(new WSTR(new ImmediateString("ERROR :  Overflow during comparing operation.")));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
        
        compiler.addLabel(compiler.overFlowBool);
        compiler.addInstruction(new WSTR(new ImmediateString("ERROR :  Overflow during boolean operation.")));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
    }

    @Override
    public void decompile(IndentPrintStream s) {
        getClasses().decompile(s);
        getMain().decompile(s);
    }
    
    @Override
    protected void iterChildren(TreeFunction f) {
        classes.iter(f);
        main.iter(f);
    }
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        classes.prettyPrint(s, prefix, false);
        main.prettyPrint(s, prefix, true);
    }
}
