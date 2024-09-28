package fr.ensimag.deca;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import fr.ensimag.deca.tools.DecacInternalError;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tree.GestionnaireReg;
import fr.ensimag.deca.tree.LocationException;

/**
 * Main class for the command-line Deca compiler.
 *
 * @author gl37
 * @date 01/01/2023
 */
public class DecacMain {
    private static Logger LOG = Logger.getLogger(DecacMain.class);
    
    public static void main(String[] args) throws DecacInternalError, DecacFatalError, LocationException {
        // example log4j message.
        LOG.info("Decac compiler started");
        boolean error = false;
        final CompilerOptions options = new CompilerOptions();
        try {
            options.parseArgs(args);
        } catch (CLIException e) {
            System.err.println("Error during option parsing:\n"
                    + e.getMessage());
            options.displayUsage();
            System.exit(1);
        }
        if (options.getPrintBanner()) {
            System.out.println(" #####  #        #####  #######\n" +                                                                                        
                               "#     # #       #     # #    #\n"  +                                                                                          
                               "#       #             #     #\n"   +                                                                                         
                               "#  #### #        #####     #\n"    +                                                                                            
                               "#     # #             #   #\n"     +                                                                                             
                               "#     # #       #     #   #\n"     +                                                                                              
                               " #####  #######  #####    #  ");
            System.exit(0);
        }
        if (options.getSourceFiles().isEmpty()) {
            throw new UnsupportedOperationException("decac without argument not yet implemented");
        }
        if (options.getParallel()) {
            // A FAIRE : instancier DecacCompiler pour chaque fichier à
            // compiler, et lancer l'exécution des méthodes compile() de chaque
            // instance en parallèle. Il est conseillé d'utiliser
            // java.util.concurrent de la bibliothèque standard Java.
            int machineCores = java.lang.Runtime.getRuntime().availableProcessors();
            ExecutorService exeParallel = Executors.newFixedThreadPool(machineCores);
            
            
            List<Future<Boolean>> future;
            List<CompilerTask> callList = new ArrayList<CompilerTask>();

            for (File source : options.getSourceFiles()) {
                DecacCompiler compiler = new DecacCompiler(options, source);
                GestionnaireReg gest = new GestionnaireReg(compiler, options.getRegisters());
                compiler.setGest(gest);

                callList.add(new CompilerTask(compiler));
            }

            try {
                future = exeParallel.invokeAll(callList);
                int indexFile = 0;
                for (Future<Boolean> f : future) {
                    if (f.get())
                        throw new DecacFatalError("Could not compile source file : " + options.getSourceFiles().get(indexFile));
    
                    indexFile++;
                }
            } catch (InterruptedException | ExecutionException | DecacFatalError e) {
                e.printStackTrace();
                System.exit(1);
            }
            
            System.exit(0);
        }
        if (options.getDecompile()){
            for (File source : options.getSourceFiles()) {
                DecacCompiler compiler = new DecacCompiler(options, source);
                GestionnaireReg gest = new GestionnaireReg(compiler, options.getRegisters());
                compiler.setGest(gest);
                System.out.println(compiler.decompile());
                System.exit(0);
            }
        }
         else {
                for (File source : options.getSourceFiles()) {
                    DecacCompiler compiler = new DecacCompiler(options, source);
                    GestionnaireReg gest = new GestionnaireReg(compiler, options.getRegisters());
                    compiler.setGest(gest);
                    if (compiler.compile()) {
                        error = true;
                    }
                }
            } 
        System.exit(error ? 1 : 0);
    }
}
