package processors;

import mutators.CtExpressionReverser;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;

public class ReverseIfConditionsProcessor extends AbstractProcessor<CtIf> {



@Override
public void process(CtIf element) {
        element.setCondition(CtExpressionReverser.reverseExpression(element.getCondition()));
    }

}
