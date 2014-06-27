package com.practicalunittesting.chp04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EAnton on 27/06/2014.
 */
public class Booker {
    private List<Integer> bookHour = new ArrayList<>();

    public boolean book(int hourToBook) {
        if (isInvalidHour(hourToBook)) {
            throw new IllegalArgumentException("Hora erronea!");
        }

        return doBook(hourToBook);
    }

    public List<Integer> getAllBooks() {
        return bookHour;
    }

    private boolean isInvalidHour(int hourToBook) {
        return hourToBook < 0 || hourToBook > 23;
    }

    private boolean doBook(int hourToBook) {
        boolean booked = false;
        if (!bookHour.contains(hourToBook)) {
            bookHour.add(hourToBook);
            booked = true;
        }
        return booked;
    }
}
