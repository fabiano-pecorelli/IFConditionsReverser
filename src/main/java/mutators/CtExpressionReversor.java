package mutators;

import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.support.reflect.code.CtBinaryOperatorImpl;
import spoon.support.reflect.code.CtUnaryOperatorImpl;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CtExpressionReversor {

    // The following two lists have been declared to find the reverse for each operator. Elements have been ordered to ensure that reverse elements are subsequent in pairs.
    public static final List<BinaryOperatorKind> relationalOperators = Collections.unmodifiableList(Arrays.asList(BinaryOperatorKind.EQ,BinaryOperatorKind.NE,BinaryOperatorKind.GT,BinaryOperatorKind.LE,BinaryOperatorKind.LT,BinaryOperatorKind.GE));
    public static final List<BinaryOperatorKind> logicalOperators = Collections.unmodifiableList(Arrays.asList(BinaryOperatorKind.AND,BinaryOperatorKind.OR));

    /**
     * This recursive method allows to reverse a generic CtExpression.
     *
     * @param exp is a generic expression
     * @return the reverse of the input expression
     */
    public static CtExpression reverseExpression(CtExpression exp){

        // Base case 1: The expression is a literal (e.g., x) or a unary operator (e.g., !x)
        if (!(exp instanceof CtBinaryOperatorImpl)){

            // If the expression is a NOT operator with an operand, the method simply returns the operand
            if (exp instanceof CtUnaryOperator && ((CtUnaryOperator)exp).getKind().equals(UnaryOperatorKind.NOT)){
                return ((CtUnaryOperator)exp).getOperand();
            }

            // If the expression is any other unary operator or a literal, returns a NOT operator having the entire expression as operand
            CtUnaryOperatorImpl op = new CtUnaryOperatorImpl();
            op.setKind(UnaryOperatorKind.NOT);
            op.setOperand(exp);
            return op;
        }

        BinaryOperatorKind operator = ((CtBinaryOperatorImpl) exp).getKind();
        CtExpression leftOperand = ((CtBinaryOperatorImpl) exp).getLeftHandOperand();
        CtExpression rightOperand = ((CtBinaryOperatorImpl) exp).getRightHandOperand();

        // Recursive step: If the expression contains a logical operator, the method is recursively invoked to reverse both left and right operands. Otherwise, if the expression is relational only the operator is reversed (base case 2)
        if (isLogical(operator)) {
            leftOperand = reverseExpression(leftOperand);
            rightOperand = reverseExpression(rightOperand);
        }

        CtBinaryOperatorImpl binaryOp = new CtBinaryOperatorImpl();
        binaryOp.setLeftHandOperand(leftOperand);
        binaryOp.setRightHandOperand(rightOperand);
        binaryOp.setKind(getReverse(operator));

        return binaryOp;
    }

    static boolean isRelational(BinaryOperatorKind kind){
        return relationalOperators.contains(kind);
    }

    static boolean isLogical(BinaryOperatorKind kind){
        return logicalOperators.contains(kind);
    }

    static BinaryOperatorKind getReverse(BinaryOperatorKind kind){
        int index = relationalOperators.indexOf(kind);
        if (index == -1){
            index = logicalOperators.indexOf(kind);
            //
            return (index%2 == 0)? logicalOperators.get(index+1):logicalOperators.get(index-1);
        }
        return (index%2 == 0)? relationalOperators.get(index+1):relationalOperators.get(index-1);
    }
}
