package com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.assertJ;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {
    @Test
    public void badAssertionExample() {
        String actual = "example";
        String expected = "example";


        // don't do this
        assertThat(actual.equals(expected));
        assertThat(actual.equals(expected)).isTrue();

        // do this
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void containsExample() {
        List<String> examples = List.of("example1", "example2", "example3");

        assertThat(examples).contains("example1");
        assertThat(examples).containsExactly("example1", "example2", "example3");
        assertThat("example1").isIn(examples);
    }

    @Test
    public void isEqualExample() {
        Product television = new Product("Television", 400.0);
        Product televisionCopy = new Product("Television", 400.0);

//        assertThat(television).isEqualTo(televisionCopy);
        assertThat(television).usingRecursiveComparison().isEqualTo(televisionCopy);
    }

    class Product {
        private String name;
        private double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

}
