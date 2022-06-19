package processors;

import mutators.CtExpressionReversor;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;

public class IfProcessor extends AbstractProcessor<CtIf> {



@Override
public void process(CtIf element) {
        element.setCondition(CtExpressionReversor.reverseExpression(element.getCondition()));
    }

}
