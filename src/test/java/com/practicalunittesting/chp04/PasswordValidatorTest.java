package com.practicalunittesting.chp04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by EAnton on 25/06/2014.
 */
public class PasswordValidatorTest {

    public static final String PASSWORD_WITH_NOT_ENOUGHT_CHARS = "1";

    private PasswordValidator passwordValidator;

    @Before
    public void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateShouldThrowExceptionWithPasswordNull() {
        passwordValidator.validate(null);
    }

    @Test
    public void testValidateShouldBeFalseIfPasswordDontHaveMinimalCharacters() {
        boolean result = passwordValidator.validate(PASSWORD_WITH_NOT_ENOUGHT_CHARS);

        assertFalse("Debería devolver falso por no cumplir el minimo de caracteres", result);
    }
    
    @Test
    public void testValidateShouldBeFalseIfPasswordIsGreaterThanMaximalCharacters() {
        boolean result = passwordValidator.validate("123456789876");

        assertFalse("Debería devolver falso por no cumplir el máximo de caracteres", result);
    }

    // TODO etc etc...
}
