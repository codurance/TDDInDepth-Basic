package com.codurance.module1.preRequisites.whatIsTesting;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);

        System.out.println(calculator.add(first, second));
        System.exit(0);
    }
}
