package com.codurance.module1.preRequisites.importanceOfAutomatedTests;

public class Calculator {

    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public double divide(double first, double second) {
        if (second == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return first / second;
    }
}
