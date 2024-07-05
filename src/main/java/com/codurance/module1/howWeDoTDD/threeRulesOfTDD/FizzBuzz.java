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
        return number % 5 == 0;
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }
}
