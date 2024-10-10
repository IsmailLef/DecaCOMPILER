package fr.ensimag.deca;

import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.EnvironmentType;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.syntax.DecaLexer;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.tools.DecacInternalError;
import fr.ensimag.deca.tools.SymbolTable;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.deca.tree.AbstractProgram;
import fr.ensimag.deca.tree.GestionnaireReg;
import fr.ensimag.deca.tree.LocationException;
import fr.ensimag.ima.pseudocode.AbstractLine;
import fr.ensimag.ima.pseudocode.IMAProgram;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;

import static org.mockito.ArgumentMatchers.nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;

/**
 * Decac compiler instance.
 *
 * This class is to be instantiated once per source file to be compiled. It
 * contains the meta-data used for compiling (source file name, compilation
 * options) and the necessary utilities for compilation (symbol tables, abstract
 * representation of target file, ...).
 *
 * It contains several objects specialized for different tasks. Delegate methods
 * are used to simplify the code of the caller (e.g. call
 * compiler.addInstruction() instead of compiler.getProgram().addInstruction()).
 *
 * @author gl37
 * @date 01/01/2023
 */
public class DecacCompiler {
    private static final Logger LOG = Logger.getLogger(DecacCompiler.class);
    
    /**
     * Portable newline character.
     */
    private static final String nl = System.getProperty("line.separator", "\n");

    public DecacCompiler(CompilerOptions compilerOptions, File source) {
        super();
        this.compilerOptions = compilerOptions;
        this.source = source;
    }

    /**
     * Source file associated with this compiler instance.
     */
    public File getSource() {
        return source;
    }

    /**
     * Compilation options (e.g. when to stop compilation, number of registers
     * to use, ...).
     */
    public CompilerOptions getCompilerOptions() {
        return compilerOptions;
    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#add(fr.ensimag.ima.pseudocode.AbstractLine)
     */
    public void add(AbstractLine line) {
        program.add(line);
    }

    /**
     * @see fr.ensimag.ima.pseudocode.IMAProgram#addComment(java.lang.String)
     */
    public void addComment(String comment) {
        program.addComment(comment);
    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#addLabel(fr.ensimag.ima.pseudocode.Label)
     */
    public void addLabel(Label label) {
        program.addLabel(label);
    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#addInstruction(fr.ensimag.ima.pseudocode.Instruction)
     */
    public void addInstruction(Instruction instruction) {
        program.addInstruction(instruction);
    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#addInstruction(fr.ensimag.ima.pseudocode.Instruction,
     * java.lang.String)
     */
    public void addInstruction(Instruction instruction, String comment) {
        program.addInstruction(instruction, comment);
    }
    
    /**
     * @see 
     * fr.ensimag.ima.pseudocode.IMAProgram#display()
     */
    public String displayIMAProgram() {
        return program.display();
    }
    

    private final CompilerOptions compilerOptions;
    private final File source;
    /**
     * The main program. Every instruction generated will eventually end up here.
     */
    private final IMAProgram program = new IMAProgram();
    

    /**
     * Error Handling in generation code
     */
    public Label ZeroDivisionError = new Label("Zero_Division_Error");
    public Label StackOverFlowError = new Label("Stack_Over_Flow_Error");
    public Label overFlowError = new Label("Over_Flow_Error");
    public Label ioError = new Label("io_Error");
    public Label overFlowCmp = new Label("Over_Flow_Cmp");
    public Label overFlowBool = new Label("Over_Flow_Bool");


    /** The global environment for types (and the symbolTable) */
    public final SymbolTable symbolTable = new SymbolTable();
    public final EnvironmentType environmentType = new EnvironmentType(this);
    public EnvironmentExp envExp;
    public GestionnaireReg gest;
    public void setEnvExp(EnvironmentExp envExp){
        this.envExp = envExp;
    }
    public void setGest(GestionnaireReg gest){this.gest = gest;}

    private int pushCounter = 0;
    private int maxStackPush = 0;
    public void setMaxStackPush(){
        if(maxStackPush < pushCounter){
            this.maxStackPush = pushCounter;
        }
    }
    public int getMaxStackPush(){
        return maxStackPush;
    }

    public void resetPushCounter(){pushCounter=0;}
    public void incrementPushCounter(){pushCounter++;}
    public int getPushCounter(){return pushCounter;}
    

    public Symbol createSymbol(String name) {
        return symbolTable.create(name);
    }

    /**
     * Run the compiler (parse source file, generate code)
     *
     * @return true on error
     */
    public boolean compile() {
        String sourceFile = source.getAbsolutePath();
        String destFile = source.getAbsolutePath().substring(0, source.getAbsolutePath().lastIndexOf(".")) + ".ass";
        PrintStream err = System.err;
        PrintStream out = System.out;
        LOG.debug("Compiling file " + sourceFile + " to assembly file " + destFile);
        try {
            return doCompile(sourceFile, destFile, out, err);
        } catch (LocationException e) {
            e.display(err);
            return true;
        } catch (DecacFatalError e) {
            err.println(e.getMessage());
            return true;
        } catch (StackOverflowError e) {
            LOG.debug("stack overflow", e);
            err.println("Stack overflow while compiling file " + sourceFile + ".");
            return true;
        } catch (Exception e) {
            LOG.fatal("Exception raised while compiling file " + sourceFile
                    + ":", e);
            err.println("Internal compiler error while compiling file " + sourceFile + ", sorry.");
            return true;
        } catch (AssertionError e) {
            LOG.fatal("Assertion failed while compiling file " + sourceFile
                    + ":", e);
            err.println("Internal compiler error while compiling file " + sourceFile + ", sorry.");
            return true;
        }
    }
    public String decompile() throws DecacInternalError, DecacFatalError{
        String sourceFile = source.getAbsolutePath();
        AbstractProgram prog = doLexingAndParsing(sourceFile, System.err);
         return prog.decompile();
    }


    /**
     * Internal function that does the job of compiling (i.e. calling lexer,
     * verification and code generation).
     *
     * @param sourceName name of the source (deca) file
     * @param destName name of the destination (assembly) file
     * @param out stream to use for standard output (output of decac -p)
     * @param err stream to use to display compilation errors
     *
     * @return true on error
     */
    private boolean doCompile(String sourceName, String destName,
            PrintStream out, PrintStream err)
            throws DecacFatalError, LocationException {
        AbstractProgram prog = doLexingAndParsing(sourceName, err);

        if (prog == null) {
            LOG.info("Parsing failed");
            return true;
        }
        assert(prog.checkAllLocations());


        prog.verifyProgram(this);
        if (getCompilerOptions().getVerify()) {
            return false;
        }
        assert(prog.checkAllDecorations());

        addComment("start main program");
        prog.codeGenProgram(this);
        addComment("end main program");
        LOG.debug("Generated assembly code:" + nl + program.display());
        LOG.info("Output file assembly file is: " + destName);

        FileOutputStream fstream = null;
        try {
            fstream = new FileOutputStream(destName);
        } catch (FileNotFoundException e) {
            throw new DecacFatalError("Failed to open output file: " + e.getLocalizedMessage());
        }

        LOG.info("Writing assembler file ...");

        program.display(new PrintStream(fstream));
        LOG.info("Compilation of " + sourceName + " successful.");
        return false;
    }

    /**
     * Build and call the lexer and parser to build the primitive abstract
     * syntax tree.
     *
     * @param sourceName Name of the file to parse
     * @param err Stream to send error messages to
     * @return the abstract syntax tree
     * @throws DecacFatalError When an error prevented opening the source file
     * @throws DecacInternalError When an inconsistency was detected in the
     * compiler.
     * @throws LocationException When a compilation error (incorrect program)
     * occurs.
     */
    protected AbstractProgram doLexingAndParsing(String sourceName, PrintStream err)
            throws DecacFatalError, DecacInternalError {
        DecaLexer lex;
        try {
            lex = new DecaLexer(CharStreams.fromFileName(sourceName));
        } catch (IOException ex) {
            throw new DecacFatalError("Failed to open input file: " + ex.getLocalizedMessage());
        }
        lex.setDecacCompiler(this);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        DecaParser parser = new DecaParser(tokens);
        parser.setDecacCompiler(this);
        return parser.parseProgramAndManageErrors(err);
    }





    /****************************************** */
    /* BUILDING OPERATORS FOR CHECKERS */

     /** 
     * This method checks whether Type t1 is extending t2 in the EnvironmentType env
     * @param env
     * @param t1
     * @param t2
     * @return
     */
    public boolean subtype(EnvironmentType env, Type t1, Type t2) {
        if (t2.isClass() && t1.isClassOrNull()) {
            ClassType ct1 = (ClassType) t1;
            ClassType ct2 = (ClassType) t2;
            return ct1.isSubClassOf(this, ct2);
        }
        else if (! t1.isClass() && ! t2.isClass() && t1.sameType(t2) ) // t1 and t2 are both not classes -- checking 
                                                                       // they're the same type
            return true;
        else
            return false;
            
        
    
    }


    /**
     * This method allows verifications to check whether an assignation is contextually correct
     * @param env environmentType
     * @param t1 first Type
     * @param t2 second Type
     * @return boolean
     */
    public boolean assign_compatible(EnvironmentType env, Type t1, Type t2) {
        if ((t1.isFloat() && t2.isInt()) || subtype(env, t1, t2)) {
            return true;
        }
        return false;
    }


    /**
     * This method allows verifications to check whether a cast is contextually correct
     * @param env environmentType
     * @param t1 first Type
     * @param t2 second Type
     * @return
     */
    public boolean cast_compatible(EnvironmentType env, Type type1, Type type2) {
        if ( ! type1.isVoid() && (assign_compatible(env, type1, type2) || assign_compatible(env, type2, type1)))
            return true;
        return false;
    }

    /* Building operators for Arithmetic operations */
    /**
     * Retrieves the output type of the given operation
     * Note : Null is given to AbstractOpArith.java:verifyExpr as an error value return to let it handle ContextualException
     */
    public Type typeBinaryOp(String operator, Type type1, Type type2) {
        
        if (operator == "+" || operator == "-" || operator == "*" || operator == "/") {
            if ((type1.isFloat() || type1.isInt()) 
                && (type2.isFloat() || type2.isInt())) {
                    return typeArithOp(type1, type2);
            }
            else
                return null;
        }
        // First Case operator is plus, minus, mult or divide


        if (operator == "%") {
            if (type1.isInt() && type2.isInt())
                return environmentType.INT;
            else
                return null;
        }
        // Second Case operator is mod


        if ((operator == "==" || operator == "!=")) {
            if ((type1.isFloat() || type1.isInt()) && (type2.isFloat() || type2.isInt())
                    || (type1.isBoolean() && type2.isBoolean())
                    || (type1.isClassOrNull() && type2.isClassOrNull())) {
                
                return environmentType.BOOLEAN;
            }    
            return null;
        }
        // Third Case operator is eq or neq

        if (operator == "<" || operator == ">" || operator == "<=" || operator == ">=") {
            if ((type1.isFloat() || type1.isInt()) 
                && (type2.isFloat() || type2.isInt())) {
                    return environmentType.BOOLEAN;
            }
            else
                return null;
        }
        // Third Case operator is lt, gt, lte, gte


        if (operator == "&&" || operator == "||") {
            if (type1.isBoolean() && type2.isBoolean())
                return environmentType.BOOLEAN;
            else 
                return null;
        }
            
        // Last Case operator and , or

        throw new InternalError("DecacCompiler.java:typeBinaryOp: All conditions do not match");
        // If programm doesn't get in any of those condition there's an internal error
    }


    public Type typeArithOp(Type type1, Type type2) {
        if (type1.isInt() && type2.isInt())
            return environmentType.INT;
        else
            return environmentType.FLOAT;
    }


    public Type typeUnaryOp(String operator, Type type) {
        if (operator == "-" && type.isInt())
            return environmentType.INT;
        else if (operator == "-" && type.isFloat())
            return environmentType.FLOAT;
        else if (operator == "!" && type.isBoolean())
            return environmentType.BOOLEAN;
        else if (operator == null && type.isInt())
            return environmentType.FLOAT;
        else 
            return null;
    }


    public Type typeInstanceOfOp(Type type1, Type type2) {
        if (type1.isClassOrNull() && type2.isClass())
            return environmentType.BOOLEAN;
        else
            return null;
    }

}
