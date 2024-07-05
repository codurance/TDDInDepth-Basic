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
}