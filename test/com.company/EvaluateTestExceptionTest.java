package com.company;

import org.junit.Test;

/**
 * Exceptions tests for evaluate method of SimpleInfixCalculator class.
 */
public class EvaluateTestExceptionTest {


    @Test(expected = IllegalArgumentException.class)
    public void decimalMarkAtTheBeginning() throws Exception {
        SimpleInfixCalculator.evaluate(".234+4");

    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongSymbol() throws Exception {
        SimpleInfixCalculator.evaluate("123+ a.23");
    }

    @Test(expected = IllegalArgumentException.class)
    public void unaryOperator() throws Exception {
        SimpleInfixCalculator.evaluate("5 + - 3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void unaryOperatorAtTheBeginning() throws Exception {
        SimpleInfixCalculator.evaluate("+5 + - 3");
    }


    @Test(expected = IllegalArgumentException.class)
    public void innerWhitespaceInNumber() throws Exception {
        SimpleInfixCalculator.evaluate("1 000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void missingOperandAtTheEnd() throws Exception {
        SimpleInfixCalculator.evaluate("5 +3 +");
    }


    @Test(expected = NullPointerException.class)
    public void nullPointerArgument() throws Exception {
        SimpleInfixCalculator.evaluate(null);
    }


}