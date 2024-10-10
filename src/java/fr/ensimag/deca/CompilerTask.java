package fr.ensimag.deca;

import java.util.concurrent.Callable;

public class CompilerTask implements Callable<Boolean> {
    private DecacCompiler compiler;

    public CompilerTask(DecacCompiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public Boolean call() {
        return compiler.compile();
    }
}
