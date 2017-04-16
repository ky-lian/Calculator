package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.text.StringCharacterIterator;

/**
 * Regular tests for decimalMarkAtTheBeginning method of SimpleInfixCalculator class.
 */
@RunWith(Parameterized.class)
public class ReadDecimalOperandTest {

    @Parameterized.Parameter
    public String fInput;


    @Parameterized.Parameters
    public static String[] data() {
        return new String[]{"   123", "123   ", "024", "12.12", "3", "03.32", "32.30"};
    }

    @Test
    public void readDecimalOperand() throws Exception {
        Assert.assertEquals(new BigDecimal(fInput.trim()), SimpleInfixCalculator.readDecimalOperand(new StringCharacterIterator(fInput)));
    }

}