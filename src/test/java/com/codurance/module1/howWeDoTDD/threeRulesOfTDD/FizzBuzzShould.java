package com.codurance.module1.howWeDoTDD.threeRulesOfTDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzShould {
    @Test
    public void convert1To1() {
        String expected = "1";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(1);

        assertEquals(expected, actual);
    }

    @Test
    public void convert2To2() {
        String expected = "2";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(2);

        assertEquals(expected, actual);
    }

    @Test
    public void convert3ToFizz() {
        String expected = "Fizz";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(3);

        assertEquals(expected, actual);
    }

    @Test
    public void convert6ToFizz() {
        String expected = "Fizz";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(6);

        assertEquals(expected, actual);
    }

    @Test
    public void convert9ToFizz() {
        String expected = "Fizz";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(9);

        assertEquals(expected, actual);
    }

    @Test
    public void convert5ToBuzz() {
        String expected = "Buzz";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(5);

        assertEquals(expected, actual);
    }

    @Test
    public void convert10ToBuzz() {
        String expected = "Buzz";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(10);

        assertEquals(expected, actual);
    }

    @Test
    public void convert20ToBuzz() {
        String expected = "Buzz";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(20);

        assertEquals(expected, actual);
    }

    @Test
    public void convert15ToFizzBuzz() {
        String expected = "FizzBuzz";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(15);

        assertEquals(expected, actual);
    }

    @Test
    public void convert30ToFizzBuzz() {
        String expected = "FizzBuzz";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(30);

        assertEquals(expected, actual);
    }

    @Test
    public void convert45ToFizzBuzz() {
        String expected = "FizzBuzz";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(45);

        assertEquals(expected, actual);
    }
}