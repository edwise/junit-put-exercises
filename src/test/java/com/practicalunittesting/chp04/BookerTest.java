package com.practicalunittesting.chp04;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by EAnton on 27/06/2014.
 */
@RunWith(JUnitParamsRunner.class)
public class BookerTest {

    private static final int HOUR_2 = 2;
    private static final int HOUR_9 = 9;
    private static final int HOUR_19 = 19;

    private Booker booker;

    @Before
    public void setUp() {
        booker = new Booker();
    }

    @Test
    public void testGetBooksReturnAListOfBooks() {
        List<Integer> books = booker.getAllBooks();

        assertNotNull("Debe devolver una lista no nula de books", books);
    }

    private static Object[] getValuesBooks() {
        return $(
                $(8),
                $(13),
                $(23),
                $(0),
                $(2)
        );
    }


    @Test
    @Parameters(method = "getValuesBooks")
    public void testGetAllBooksReturnAListOfBooksWithItemWhenBookedOne(Integer hourToBook) {
        booker.book(hourToBook);

        List<Integer> books = booker.getAllBooks();

        assertNotNull("Debe devolver una lista no nula de books", books);
        assertEquals("Debe devolver un book en la lista", 1, books.size());
        assertEquals("Debe devolver como item el book hecho", hourToBook, books.get(0));
    }

    @Test
    public void testAddBookWhenRightBookIsAddedThenIsSaved() {
        boolean booked = booker.book(HOUR_2);

        assertTrue("Deberia devolver true por book correcta", booked);
    }

    @Test
    public void testAddBookSeveralTimesThenBooksAreSaved() {
        boolean bookedHour2 = booker.book(HOUR_2);
        boolean bookedHour9 = booker.book(HOUR_9);
        boolean bookedHour19 = booker.book(HOUR_19);

        List<Integer> books = booker.getAllBooks();

        assertTrue("Deberia devolver true por todos los books hechos", bookedHour2 && bookedHour9 && bookedHour19);
        assertEquals("Debe devolver 3 books en la lista", 3, books.size());
        assertTrue(books.contains(HOUR_2));
        assertTrue(books.contains(HOUR_9));
        assertTrue(books.contains(HOUR_19));
    }

    @Test
    public void testAddBookSeveralTimesTheSameBookThenIsNotSaved() {
        booker.book(HOUR_2);
        boolean bookedHour2Again = booker.book(HOUR_2);

        List<Integer> books = booker.getAllBooks();

        assertFalse("Deberia devolver false para el segundo intento", bookedHour2Again);
        assertEquals("Debe devolver 1 book en la lista", 1, books.size());
        assertTrue(books.contains(HOUR_2));
    }


    private static Object[] getValuesBooksInvalid() {
        return $(
                $(-1),
                $(24),
                $(55),
                $(3000),
                $(-12)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getValuesBooksInvalid")
    public void testAddBookInvalidValuesThenThrowsException(Integer invalidBookValue) {
        booker.book(invalidBookValue);
    }
}
