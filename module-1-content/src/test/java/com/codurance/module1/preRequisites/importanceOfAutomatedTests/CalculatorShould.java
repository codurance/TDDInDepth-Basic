package com.codurance.module1.preRequisites.importanceOfAutomatedTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorShould {

    @Test
    public void addTwoNumbers() {
        Calculator calculator = new Calculator();
        int expected = 25;

        int actual = calculator.add(11, 14);

        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoNumbers() {
        Calculator calculator = new Calculator();
        int expected = 8;

        int actual = calculator.subtract(12, 4);

        assertEquals(expected, actual);
    }

    @Test
    public void multiplyTwoNumbers() {
        Calculator calculator = new Calculator();
        int expected = 25;

        int actual = calculator.multiply(5, 5);

        assertEquals(expected, actual);
    }

    @Test
    public void divideDivideTwoNumbers() {
        Calculator calculator = new Calculator();
        double expected = 4.0;

        double actual = calculator.divide(12, 3);

        assertEquals(expected, actual);
    }
}