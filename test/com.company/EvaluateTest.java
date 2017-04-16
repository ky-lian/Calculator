package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;

/**
 * Regular tests for evaluate method of SimpleInfixCalculator class.
 */
@RunWith(Parameterized.class)
public class EvaluateTest {


    @Parameterized.Parameter
    public String fInput;

    @Parameterized.Parameter(1)
    public String fExpected;


    @Parameterized.Parameters
    public static String[][] data() {
        return new String[][]{
                {"2+2", "4"},
                {"2+2*2", "6"},
                {"2-2*2*2+1", "-5"},
                {"0.5+0.5", "1"},
                {"0.5+0.5*0.5", "0.75"},
                {"0.5+0.5*0.5/0.5", "1"},
                {"5+10*25 - 70 / 35", "253"},
                {" 1.2* 2.5 + 4.5*2*3 + 3/3 *5", "35"},
                {"2/3", "0.66666667"}
        };
    }

    @Test
    public void readDecimalOperand() throws Exception {
        Assert.assertEquals(new BigDecimal(fExpected), SimpleInfixCalculator.evaluate(fInput));
    }

}