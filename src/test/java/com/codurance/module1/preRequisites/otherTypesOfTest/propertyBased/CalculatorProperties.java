package com.codurance.module1.preRequisites.otherTypesOfTest.propertyBased;

import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorProperties {
    Calculator calculator = new Calculator();

    @Property
    public void addShouldBeCommutative(@ForAll int first, @ForAll int second) {

        int sum = calculator.add(first, second);
        int invertedSum = calculator.add(second, first);

        assertEquals(sum, invertedSum);
    }

    @Property
    public void multiplyShouldBeCommutative(@ForAll int first, @ForAll int second) {

        int multiplication = calculator.multiply(first, second);
        int invertedMultiplication = calculator.multiply(second, first);

        assertEquals(multiplication, invertedMultiplication);
    }

    @Property
    public void subtractionResultShouldBeZeroForSameNumber(@ForAll int number) {
        int subtraction = calculator.subtract(number, number);

        assertEquals(0, subtraction);
    }

    @Property
    void divisionShouldBeOneForSameNumber(@ForAll double number) {
        Assume.that(number > 0);
        double division = calculator.divide(number, number);

        assertEquals(1, division);
    }
}
