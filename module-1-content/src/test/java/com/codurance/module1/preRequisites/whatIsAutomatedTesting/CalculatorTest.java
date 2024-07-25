package com.codurance.module1.preRequisites.whatIsAutomatedTesting;

class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int expectedSum = 3;

        int actualSum = calculator.add(1, 3);

        if (actualSum != expectedSum) {
            System.err.println("Expected: " + expectedSum + ", but was: " + actualSum);
            System.exit(1);
        }
    }
}