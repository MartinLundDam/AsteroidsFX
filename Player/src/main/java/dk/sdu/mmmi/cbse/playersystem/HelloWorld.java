package dk.sdu.mmmi.cbse.playersystem;

import org.splitPackageLayer.SplitPackageProvider.JavaSplitPackageProvider;

public class HelloWorld implements JavaSplitPackageProvider {
    @Override
    public String provide() {
        return "I am an Asteroid";
    }
}