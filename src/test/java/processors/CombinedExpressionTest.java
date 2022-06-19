package processors;

import org.junit.BeforeClass;
import org.junit.Test;
import spoon.Launcher;
import spoon.reflect.declaration.CtPackage;
import utils.TestUtils;

import static org.junit.Assert.assertEquals;

public class CombinedExpressionTest {

    private static String[] args;
    private static Launcher launcher;

    private static String oraclePath, outputPath;

    @BeforeClass
    public static void setUp(){
        oraclePath = "src/test/resources/combined/oracle/";
        outputPath = "target/spooned/combined/";
         args = new String[]{
                "-i", "src/test/resources/combined/input/",
                "-p", "processors.ReverseIfConditionsProcessor",
                "-o", outputPath
        };
        launcher = new Launcher();
        launcher.setArgs(args);
        launcher.run();
    }

    @Test
    public void testC1() throws Exception {
        String className = "C1.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }

    @Test
    public void testC2() throws Exception {
        String className = "C2.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }

}