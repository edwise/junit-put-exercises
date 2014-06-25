package com.practicalunittesting.chp04;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by EAnton on 25/06/2014.
 */
@RunWith(JUnitParamsRunner.class)
public class RegexTest {

    @Test
    public void testObtainNumbersFromStringShouldReturnEmptyListWhenStringIsEmpty() {
        Regex regex = new Regex();

        List<String> numbers = regex.obtainNumbersFromString("");

        assertNotNull("Esta devolviendo nulo, deberia no serlo", numbers);
        assertEquals("Devuelve un tamaño de array mayor de 0, deberia ser 0", 0, numbers.size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testObtainNumbersFromStringShouldTrownExceptionWhenStringIsNull() {
        Regex regex = new Regex();

        List<String> numbers = regex.obtainNumbersFromString(null);
    }

    private static final Object[] getValuesWithNumbersToTest() {
        return $(
                $("aee543", Arrays.asList("543")),
                $("4567aee543rt", Arrays.asList("4567", "543")),
                $("asa4567aee543rt", Arrays.asList("4567", "543")),
                $("erqwe4567aee543", Arrays.asList("4567", "543")),
                $("4567aee543rt5555555", Arrays.asList("4567", "543", "5555555"))
        );
    }

    @Test
    public void testObtainNumbersFromStringShouldReturnEmptyListWhenStringDontHaveNumbers() {
        Regex regex = new Regex();

        List<String> numbers = regex.obtainNumbersFromString("aee54ghrfo5fea");

        assertNotNull("Esta devolviendo nulo, deberia no serlo", numbers);
        assertEquals("Devuelve un tamaño de array mayor de 0, deberia ser 0", 0, numbers.size());
    }

    @Test
    @Parameters(method = "getValuesWithNumbersToTest")
    public void testObtainNumbersFromStringShouldReturnListWhenStringHaveNumbers(String stringToProcess, List<String> excectedResults) {
        Regex regex = new Regex();

        List<String> numbers = regex.obtainNumbersFromString(stringToProcess);

        assertNotNull("Esta devolviendo nulo, deberia no serlo", numbers);
        assertEquals("Devuelve un tamaño de array distinto de " + excectedResults.size() + ", deberia ser " + excectedResults.size(),
                excectedResults.size(), numbers.size());
        for (int i = 0; i < excectedResults.size(); i++) {
            assertEquals(excectedResults.get(i), numbers.get(i));
        }
    }

}
