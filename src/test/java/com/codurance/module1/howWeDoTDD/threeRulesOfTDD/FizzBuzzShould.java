package com.codurance.module1.howWeDoTDD.threeRulesOfTDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzShould {

    @Test
    public void Convert1To1() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expectedResult = "1";

        String result = fizzBuzz.convert(1);

        assertEquals(expectedResult, result);
    }

    @Test
    public void Convert2to2() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expectedResult = "2";

        String result = fizzBuzz.convert(2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void Convert3toFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expectedResult = "Fizz";

        String result = fizzBuzz.convert(3);

        assertEquals(expectedResult, result);
    }

    @Test
    public void Convert4To4() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expectedResult = "4";

        String result = fizzBuzz.convert(4);

        assertEquals(expectedResult, result);
    }

    @Test
    public void Convert5ToBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expectedResult = "Buzz";

        String result = fizzBuzz.convert(5);

        assertEquals(expectedResult, result);
    }
}