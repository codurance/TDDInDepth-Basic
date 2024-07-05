package com.codurance.module1.howWeDoTDD.threeRulesOfTDD;

public class FizzBuzz {
    public String convert(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }

        return String.valueOf(number);
    }
}
