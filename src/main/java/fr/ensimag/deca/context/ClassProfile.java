package fr.ensimag.deca.context;


public class ClassProfile {
    private ClassExtension extension;
    private EnvironmentExp environmentExp;
    
    public ClassProfile(ClassExtension extension, EnvironmentExp environmentExp) {
        this.extension = extension;
        this.environmentExp = environmentExp;
    }

    public ClassExtension getExtenstion() {
        return extension;
    }

    public EnvironmentExp getEnvironmentExp() {
        return environmentExp;
    }
}
