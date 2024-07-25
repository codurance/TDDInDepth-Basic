package com.codurance.module1.preRequisites.otherTypesOfTest.mutation;

public class Greeter {
    private final Clock clock;

    public Greeter(Clock clock) {

        this.clock = clock;
    }

    public String greetingFor(String name) {
        int hour = clock.hour();

        if (hour >= 6 && hour < 12) {
            return "Buenos dias " + name;
        }

        if (hour >= 12 && hour < 20) {
            return "Buenas tardes " + name;
        }

        return "Buenas noches " + name;
    }
}
