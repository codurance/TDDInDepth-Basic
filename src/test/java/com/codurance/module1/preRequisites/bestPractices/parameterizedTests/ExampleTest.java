package com.codurance.module1.preRequisites.bestPractices.parametrizedTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "level"})
    void testPalindrome(String candidate) {
        assertTrue(isPalindrome(candidate));
    }

    private boolean isPalindrome(String text) {
        return new StringBuilder(text).reverse().toString().equals(text);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "2, 3, 5",
        "3, 5, 8",
        "4, 7, 11"
    })
    void testAddition(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/example_data.csv")
    void testAdditionFromFile(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void testIsEven(int number, boolean expected) {
        assertEquals(expected, isEven(number));
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
            Arguments.of(2, true),
            Arguments.of(3, false),
            Arguments.of(4, true),
            Arguments.of(5, false)
        );
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
