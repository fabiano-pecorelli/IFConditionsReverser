package utils;

import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtPackage;

public class TestUtils {
    public static CtPackage getAST(String path){
        Launcher launcher = new Launcher();
        launcher.addInputResource(path);
        CtModel oracle = launcher.buildModel();
        return oracle.getRootPackage();
    }

}
