package com.practicalunittesting.chp04;

/**
 * Created by EAnton on 25/06/2014.
 */
public class PasswordValidator {

    private static final int NUM_MINIMAL_CHARACTERS = 8;
    private static final int NUM_MAXIMAL_CHARACTERS = 10;

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password nulo!");
        }

        return password.length() >= NUM_MINIMAL_CHARACTERS && password.length() <= NUM_MAXIMAL_CHARACTERS;
    }
}
