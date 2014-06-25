package com.practicalunittesting.chp04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EAnton on 25/06/2014.
 */
public class Regex {

    private static final int NUM_CHARS_NUMBER = 3;

    public List<String> obtainNumbersFromString(String stringWithNumbers) {
        if (stringWithNumbers == null) {
            throw new IllegalArgumentException("Cadena nula!");
        }
        List<String> result = new ArrayList<>();

        if (!stringWithNumbers.isEmpty()) {
            StringBuilder actualNumber = new StringBuilder();
            boolean toInsertInList = false;
            for (int i = 0; i < stringWithNumbers.length(); i++) {
                Character character = stringWithNumbers.charAt(i);
                if (Character.isDigit(character)) {
                    actualNumber.append(character);
                    if (actualNumber.length() >= NUM_CHARS_NUMBER) {
                        toInsertInList = true;
                        if (isLastCharacterInString(stringWithNumbers, i)) {
                            result.add(actualNumber.toString());
                        }
                    }
                }
                else {
                    if (toInsertInList) {
                        result.add(actualNumber.toString());
                    }
                    toInsertInList = false;
                    actualNumber = new StringBuilder();
                }
            }
        }

        return result;
    }

    private boolean isLastCharacterInString(String stringWithNumbers, int numChar) {
        return numChar == stringWithNumbers.length() - 1;
    }
}
