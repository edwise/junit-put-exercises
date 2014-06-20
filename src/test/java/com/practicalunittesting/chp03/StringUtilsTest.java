package com.practicalunittesting.chp03;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class StringUtilsTest {

    private static final Object[] getStrings() {
        return new Object[]{
                new Object[]{"xEgnirtSim", "miStringEx"},
                new Object[]{"", ""},
                new Object[]{"a", "a"},
                new Object[]{"ae", "ea"},
                new Object[]{"1a1", "1a1"},
                new Object[]{"d544fdgf85475jtrh", "hrtj57458fgdf445d"}
        };
    }

    @Test
    @Parameters(method = "getStrings")
    public void testReverse(String expected, String toReverse) {
        String result = StringUtils.reverse(toReverse);

        assertEquals("Deben ser iguales", expected, result);
    }

    @Test(expected = NullPointerException.class)
    public void testReverseNullPointerIfStringNull() {
        String result = StringUtils.reverse(null);
    }

}