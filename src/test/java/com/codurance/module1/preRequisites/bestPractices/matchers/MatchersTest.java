package com.codurance.module1.preRequisites.bestPractices.matchers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatchersTest {
    @Test
    public void shouldCheckForEquality() {
        int a = 1;
        int b = 1;

        assertTrue(a == b);
    }

    @Test
    public void shouldCheckForANull() {
        String a = null;

        assertEquals(null, a);
    }

    @Test
    public void shouldCheckForAnException() {
        try {
            somethingWillFail();
        } catch (Exception e) {
            assertEquals("Something went wrong :-S", e.getMessage());
        }
    }

    @Test
    public void shouldCheckForACollectionContains() {
        String a = "Test";
        String[] array = {"Test", "Test1", "Test2"};
        List<String> collection = new ArrayList<>(Arrays.asList(array));

        assertTrue(collection.contains(a));
    }

    @Test
    public void shouldCheckForBooleanConditions() {
        assertTrue(isValid());
    }

    @Test
    public void shouldCheckForComplexConditions() {
        String[] array = {"Test", "Test1", "Test2"};
        List<String> collection = new ArrayList<>(Arrays.asList(array));
        assertTrue(collection != null && collection.size() > 0);
    }

    private boolean isValid() {
        return true;
    }

    private void somethingWillFail() throws Exception {
        throw new Exception("Something went wrong :-S");
    }
}
