package com.practicalunittesting.chp03;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest {

    private static final Object[] getCelciusToFahrenheitData() {
        return new Object[]{
                new Object[]{0, 32},
                new Object[]{37, 98},
                new Object[]{100, 212}
        };
    }

    private static final Object[] getFahrenheitToCelciusData() {
        return new Object[]{
                new Object[]{32, 0},
                new Object[]{100, 37},
                new Object[]{212, 100}
        };
    }

    @Test
    @Parameters(method = "getCelciusToFahrenheitData")
    public void shouldConvertCelciusToFahrenheit(int celcius, int fahrenheit) {
        assertEquals(fahrenheit, FahrenheitCelciusConverter.toFahrenheit(celcius));
    }

    @Test
    @Parameters(method = "getFahrenheitToCelciusData")
    public void shouldConvertFahrenheitToCelcius(int fahrenheit, int celcius) {
        assertEquals(celcius, FahrenheitCelciusConverter.toCelcius(fahrenheit));
    }
}
