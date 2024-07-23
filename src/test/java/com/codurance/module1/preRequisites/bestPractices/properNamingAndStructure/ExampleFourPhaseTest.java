package com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleFourPhaseTest {
    @Test
    public void exampleFourPhaseInline() {
        // set up
        UUID id = UUID.randomUUID();
        Book book = new Book(id, "Clean Code", "Robert C. Martin");
        InMemoryBookRepository repository = new InMemoryBookRepository(List.of(book));
        Library library = new Library(repository);

        // exercise
        Book foundBook = library.getBook(id);

        // verification
        assertEquals(id, foundBook.id);

        // tear down
        repository.clear();
    }

    private UUID id;
    private Book book;
    private InMemoryBookRepository repository;
    private Library library;


    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        book = new Book(id, "Clean Code", "Robert C. Martin");
        repository = new InMemoryBookRepository(List.of(book));
        library = new Library(repository);
    }

    @AfterEach
    void tearDown() {
        repository.clear();
    }

    @Test
    public void exampleFourPhaseImplicit() {
        // exercise
        Book foundBook = library.getBook(id);

        // verification
        assertEquals(id, foundBook.id);
    }
}