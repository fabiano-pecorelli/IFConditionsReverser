package processors;

import org.junit.BeforeClass;
import org.junit.Test;
import spoon.Launcher;
import spoon.reflect.declaration.CtPackage;
import utils.TestUtils;

import static org.junit.Assert.assertEquals;

public class LogicalExpressionTest {

    private static String[] args;
    private static Launcher launcher;

    private static String oraclePath, outputPath;

    @BeforeClass
    public static void setUp(){
        oraclePath = "src/test/resources/logical/oracle/";
        outputPath = "target/spooned/logical/";
         args = new String[]{
                "-i", "src/test/resources/logical/input/",
                "-p", "processors.ReverseIfConditionsProcessor",
                "-o", outputPath
        };
        launcher = new Launcher();
        launcher.setArgs(args);
        launcher.run();
    }

    @Test
    public void testAND() throws Exception {
        String className = "AND.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }

    @Test
    public void testOR() throws Exception {
        String className = "OR.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }


    @Test
    public void testAND_AND() throws Exception {
        String className = "AND_AND.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }


    @Test
    public void testOR_OR() throws Exception {
        String className = "AND_AND.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }

    @Test
    public void testAND_OR() throws Exception {
        String className = "AND_OR.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }

    @Test
    public void testOR_AND() throws Exception {
        String className = "/" +
                "OR_AND.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }
}