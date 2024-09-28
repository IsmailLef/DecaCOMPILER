package fr.ensimag.deca;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * User-specified options influencing the compilation.
 *
 * @author gl37
 * @date 01/01/2023
 */
public class CompilerOptions {
    public static final int QUIET = 0;
    public static final int INFO  = 1;
    public static final int DEBUG = 2;
    public static final int TRACE = 3;
    public int getDebug() {
        return debug;
    }

    public boolean getParallel() {
        return parallel;
    }

    public boolean getPrintBanner() {
        return printBanner;
    }
    public boolean getDecompile(){
        return decompile;
    }
    public boolean getVerify(){
        return verify;
    }
    public boolean getNocheck(){
        return noCheck;
    }
    
    public List<File> getSourceFiles() {
        return Collections.unmodifiableList(sourceFiles);
    }

    private int debug = 0;
    private boolean parallel = false;
    private boolean printBanner = false;
    private List<File> sourceFiles = new ArrayList<File>();
    private boolean decompile = false;
    private boolean noCheck = false;
    private boolean verify = false;
    private int registers = 15;
    public int getRegisters(){return registers;}

    
    public void parseArgs(String[] args) throws CLIException {
        if(args.length == 0){
            displayUsage();
        }
        int i = 0;
        while (i < args.length){
            String s = args[i];
            i++;
            switch(s){
                case "-p":
                    decompile = true;break;
                case "-P":
                    parallel = true;break;
                case "-b":
                    printBanner = true;break;
                case "-n":
                    noCheck = true;break;
                case "-v":
                    verify = true;break;
                case "-r":
                    try{
                        registers = Integer.parseInt(args[i]) - 1;
                        i++;
                        break;
                    }
                    catch (NumberFormatException e){
                        System.out.println("You should enter a number between 4 and 16 after the -r option");
                        System.exit(0);
                    }
                    
                default:
                    sourceFiles.add(new File(s));
                    break;
            }
        
        }
        if(verify && decompile){
            System.out.println("You cannot use these two options at once : -p and -v");
            System.exit(0);
        }

        Logger logger = Logger.getRootLogger();
        // map command-line debug option to log4j's level.
        switch (getDebug()) {
        case QUIET: break; // keep default
        case INFO:
            logger.setLevel(Level.INFO); break;
        case DEBUG:
            logger.setLevel(Level.DEBUG); break;
        case TRACE:
            logger.setLevel(Level.TRACE); break;
        default:
            logger.setLevel(Level.ALL); break;
        }
        logger.info("Application-wide trace level set to " + logger.getLevel());

        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (assertsEnabled) {
            logger.info("Java assertions enabled");
        } else {
            logger.info("Java assertions disabled");
        }

    }

    protected void displayUsage() {
        System.out.println("Usage : decac -option <Files>\n" +
        "Options : \n"+
        "    -p : Stop the compiler after building the tree, and prints the output of decompilation\n" +
        "    -b : Display the team banner\n" +
        "    -v : Stop the compiler after verification step\n" +
        "    -r X : Specify the number of registers to use\n" +
        "    -n : No check"
        );
        System.exit(0);
    }
}

