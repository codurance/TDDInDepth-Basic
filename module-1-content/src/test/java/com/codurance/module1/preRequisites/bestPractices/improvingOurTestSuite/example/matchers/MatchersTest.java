package com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.example.matchers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.testcontainers.shaded.org.hamcrest.MatcherAssert.assertThat;

public class MatchersTest {
    @Test
    public void shouldCheckForEquality() {
        int a = 1;
        int b = 1;

        // Bad Usage
        assertTrue(a == b);

        // Improved Usage
        assertEquals(a, b);
    }

    @Test
    public void shouldCheckForANull() {
        String a = null;

        // Bad Usage
        assertEquals(null, a);

        // Improved Usage
        assertNull(a);
    }

    @Test
    public void shouldCheckForAnException() {
        // Bad Usage
        try {
            somethingWillFail();
        } catch (Exception e) {
            assertEquals("Something went wrong :-S", e.getMessage());
        }

        // Improved Usage
        assertThrows(Exception.class, () -> somethingWillFail());
    }

    @Test
    public void shouldCheckForBooleanConditions() {
        // Bad Usage
        assertTrue(isValid());

        boolean a = isValid();
        // Improved Usage
        assertNotNull(a);
        assertTrue(a);
    }

    @Test
    public void shouldCheckForComplexConditions() {

        String[] array = {"Test", "Test1", "Test2"};
        List<String> collection = new ArrayList<>(Arrays.asList(array));
        boolean condition = collection != null && collection.size() > 0;

        // Bad Usage
        assertTrue(condition);

        // Improved Usage
        assertNotNull(collection);
        assertSame(3, collection.size());
    }

    @Test
    public void shouldCheckForACollectionContains() {
        String a = "Test";
        String[] array = {"Test", "Test1", "Test2"};
        List<String> collection = new ArrayList<>(Arrays.asList(array));

        // Bad Usage
        assertTrue(collection.contains(a));

        // Improved Usage: We will resolve in the next video with AssertJ
    }

    private boolean isValid() {
        return true;
    }

    private void somethingWillFail() throws Exception {
        throw new Exception("Something went wrong :-S");
    }
}
