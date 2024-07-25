package com.codurance.module1.preRequisites.otherTypesOfTest.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GreeterShould {

    @Test
    public void greetWithBuenosDiasInTheMorning() {
        Clock clock = mock(Clock.class);
        when(clock.hour()).thenReturn(8);
        Greeter greeter = new Greeter(clock);

        String greeting = greeter.greetingFor("Pedro");

        assertEquals("Buenos dias Pedro", greeting);
    }

    @Test
    public void greetWithBuenasTardesInTheAfternoon() {
        Clock clock = mock(Clock.class);
        when(clock.hour()).thenReturn(14);
        Greeter greeter = new Greeter(clock);

        String greeting = greeter.greetingFor("Pedro");

        assertEquals("Buenas tardes Pedro", greeting);
    }

    @Test
    public void greetWithBuenasNochesAtNight() {
        Clock clock = mock(Clock.class);
        when(clock.hour()).thenReturn(23);
        Greeter greeter = new Greeter(clock);

        String greeting = greeter.greetingFor("Pedro");

        assertEquals("Buenas noches Pedro", greeting);
    }
}