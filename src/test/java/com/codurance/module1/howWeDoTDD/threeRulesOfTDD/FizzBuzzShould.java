package com.codurance.module1.howWeDoTDD.threeRulesOfTDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzShould {
    @Test
    public void convert1To1() {
        String expected = "1";
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.convert(1);

        assertEquals(expected, actual);
    }
}