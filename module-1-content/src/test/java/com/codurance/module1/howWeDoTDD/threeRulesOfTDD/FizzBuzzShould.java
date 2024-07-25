package com.codurance.module1.howWeDoTDD.threeRulesOfTDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzShould {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @ParameterizedTest(name = "Convert {0} to \"{1}\"")
    @CsvSource({
        "1, 1",
        "2, 2",
        "4, 4",
        "7, 7",
    })
    public void convertNumberToString(String expected, int number) {
        String actual = fizzBuzz.convert(number);

        assertEquals(expected, actual);
    }

    @Test
    public void convert3ToFizz() {
        String expected = "Fizz";

        String actual = fizzBuzz.convert(3);

        assertEquals(expected, actual);
    }

    @Test
    public void convert6ToFizz() {
        String expected = "Fizz";

        String actual = fizzBuzz.convert(6);

        assertEquals(expected, actual);
    }

    @Test
    public void convert9ToFizz() {
        String expected = "Fizz";

        String actual = fizzBuzz.convert(9);

        assertEquals(expected, actual);
    }

    @Test
    public void convert5ToBuzz() {
        String expected = "Buzz";

        String actual = fizzBuzz.convert(5);

        assertEquals(expected, actual);
    }

    @Test
    public void convert10ToBuzz() {
        String expected = "Buzz";

        String actual = fizzBuzz.convert(10);

        assertEquals(expected, actual);
    }

    @Test
    public void convert20ToBuzz() {
        String expected = "Buzz";

        String actual = fizzBuzz.convert(20);

        assertEquals(expected, actual);
    }

    @Test
    public void convert15ToFizzBuzz() {
        String expected = "FizzBuzz";

        String actual = fizzBuzz.convert(15);

        assertEquals(expected, actual);
    }

    @Test
    public void convert30ToFizzBuzz() {
        String expected = "FizzBuzz";

        String actual = fizzBuzz.convert(30);

        assertEquals(expected, actual);
    }

    @Test
    public void convert45ToFizzBuzz() {
        String expected = "FizzBuzz";

        String actual = fizzBuzz.convert(45);

        assertEquals(expected, actual);
    }
}