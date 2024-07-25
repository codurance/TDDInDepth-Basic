package com.codurance.module1.preRequisites.bestPractices.lifeCycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    @BeforeAll
    static void setUpAll() {
        System.out.println("This runs before all tests");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("This runs after all tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("This runs before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("This runs after each test");
    }

    @Test
    void shouldDoSomething() {
        System.out.println("Executing test1");
        assertTrue(true);
    }

    @Test
    void shouldDoAnotherThing() {
        System.out.println("Executing test2");
        assertTrue(true);
    }
}
