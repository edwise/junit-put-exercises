package com.practicalunittesting.chp03;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by EAnton on 20/06/2014.
 */
public class HashMapTest {

    private static final String KEY_TEST_1 = "key1";
    private static final String VALUE_TEST_1 = "valor1";
    private static final String VALUE_TEST_2 = "valor2";
    private static final String KEY_TEST_2 = "key2";
    private static final String NULL_KEY = null;

    private Map<String, String> hashMapTest;

    @Before
    public void setUp() {
        hashMapTest = new HashMap<>();
    }

    @Test
    public void testGet() {
        hashMapTest.put(KEY_TEST_1, VALUE_TEST_1);

        assertEquals("Deben ser iguales", VALUE_TEST_1, hashMapTest.get(KEY_TEST_1));
    }

    @Test
    public void testGetAfterSamePut() {
        hashMapTest.put(KEY_TEST_1, VALUE_TEST_1);
        hashMapTest.put(KEY_TEST_1, VALUE_TEST_2);

        assertEquals("Deben ser iguales", VALUE_TEST_2, hashMapTest.get(KEY_TEST_1));
    }

    @Test
    public void testClear() {
        hashMapTest.put(KEY_TEST_1, VALUE_TEST_1);
        hashMapTest.put(KEY_TEST_2, VALUE_TEST_2);

        hashMapTest.clear();

        assertTrue("Debe devolver true", hashMapTest.isEmpty());
    }

    @Test
    public void testUseKeyNullAsKey() {
        hashMapTest.put(NULL_KEY, VALUE_TEST_1);

        assertEquals("Deben ser iguales", VALUE_TEST_1, hashMapTest.get(NULL_KEY));
    }
}
