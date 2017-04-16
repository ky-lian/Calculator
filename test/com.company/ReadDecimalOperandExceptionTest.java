package com.company;

import org.junit.Test;

import java.text.StringCharacterIterator;

/**
 * Exceptions tests for decimalMarkAtTheBeginning method of SimpleInfixCalculator class.
 */
public class ReadDecimalOperandExceptionTest {


    @Test(expected = NumberFormatException.class)
    public void wrongSymbolAtTheBeginning() throws Exception {
        SimpleInfixCalculator.readDecimalOperand(new StringCharacterIterator("a1.133"));
    }

    @Test(expected = NumberFormatException.class)
    public void decimalMarkAtTheBeginning() throws Exception {
        SimpleInfixCalculator.readDecimalOperand(new StringCharacterIterator(".23"));
    }

    @Test(expected = NumberFormatException.class)
    public void doubleDecimalMarkInNumber() throws Exception {
        SimpleInfixCalculator.readDecimalOperand(new StringCharacterIterator("2.2.23"));
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerArgument() throws Exception {
        SimpleInfixCalculator.readDecimalOperand(null);
    }


}