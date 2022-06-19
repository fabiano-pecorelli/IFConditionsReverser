package processors;

import org.junit.BeforeClass;
import org.junit.Test;
import spoon.Launcher;
import spoon.reflect.declaration.CtPackage;
import utils.TestUtils;

import static org.junit.Assert.assertEquals;

public class UnaryExpressionTest {

    private static String[] args;
    private static Launcher launcher;

    private static String oraclePath, outputPath;

    @BeforeClass
    public static void setUp(){

        oraclePath = "src/test/resources/unary/oracle/";
        outputPath = "target/spooned/unary/";
         args = new String[]{
                "-i", "src/test/resources/unary/input/",
                "-p", "processors.ReverseIfConditionsProcessor",
                "-o", outputPath
        };
        launcher = new Launcher();
        launcher.setArgs(args);
        launcher.run();
    }

    @Test
    public void testNOT() throws Exception {
        String className = "NOT.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }

    @Test
    public void testVAR() throws Exception {
        String className = "VAR.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }

}