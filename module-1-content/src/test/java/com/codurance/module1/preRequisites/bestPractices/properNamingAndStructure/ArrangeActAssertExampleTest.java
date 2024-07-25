package com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrangeActAssertExampleTest {
    @Test
    public void arrangeActAssert() {
        // arrange
        UUID id = UUID.randomUUID();
        Book book = new Book(id, "Clean Code", "Robert C. Martin");
        InMemoryBookRepository repository = new InMemoryBookRepository(List.of(book));
        Library library = new Library(repository);

        // act
        Book foundBook = library.getBook(id);

        // assert
        assertEquals(id, foundBook.id);
    }

}