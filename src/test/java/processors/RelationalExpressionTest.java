package processors;

import org.junit.BeforeClass;
import org.junit.Test;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtElement;

import spoon.reflect.declaration.CtPackage;
import spoon.reflect.visitor.Filter;
import utils.TestUtils;

import static org.junit.Assert.assertEquals;

public class RelationalExpressionTest {

    private static String[] args;
    private static Launcher launcher;

    private static String oraclePath, outputPath;

    @BeforeClass
    public static void setUp(){

        oraclePath = "src/test/resources/relationals/oracle/";
        outputPath = "target/spooned/relationals/";
         args = new String[]{
                "-i", "src/test/resources/relationals/input/",
                "-p", "processors.ReverseIfConditionsProcessor",
                "-o", outputPath
        };
        launcher = new Launcher();
        launcher.setArgs(args);
        launcher.run();
    }


    @Test
    public void testEQ() throws Exception {
        String className = "EQ.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }

    @Test
    public void testNE() throws Exception {
        String className = "NE.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }


    @Test
    public void testGT() throws Exception {
        String className = "GT.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }

    @Test
    public void testGE() throws Exception {
        String className = "GE.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }



    @Test
    public void testLT() throws Exception {
        String className = "LT.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }


    @Test
    public void testLE() throws Exception {
        String className = "LE.java";

        CtPackage oracleAST = TestUtils.getAST(oraclePath+className);
        CtPackage outputAST = TestUtils.getAST(outputPath+className);

        assertEquals(oracleAST,outputAST);
    }




}