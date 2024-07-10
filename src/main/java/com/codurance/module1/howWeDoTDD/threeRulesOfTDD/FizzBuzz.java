package com.codurance.module1.howWeDoTDD.threeRulesOfTDD;

public class FizzBuzz {
    public String convert(int number) {
        if (isFizz(number) && isBuzz(number)) {
            return "FizzBuzz";
        }

        if (isFizz(number)) {
            return "Fizz";
        }

        if (isBuzz(number)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private boolean isBuzz(int number) {
        return isDivisibleBy5(number);
    }

    private static boolean isDivisibleBy5(int number) {
        return isDivisibleBy(number, 5);
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

    private boolean isFizz(int number) {
        return isDivisibleBy3(number);
    }

    private static boolean isDivisibleBy3(int number) {
        return isDivisibleBy(number, 3);
    }
}
