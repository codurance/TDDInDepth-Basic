package com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BadNamingExampleTest {
    @Test
    public void throwsErrorWhenCallingLoanBookWithLoanedBook() {
        UUID id = UUID.randomUUID();
        Book book = new LoanedBook(id, "Clean Code", "Robert C. Martin");
        InMemoryBookRepository repository = new InMemoryBookRepository(List.of(book));
        Library library = new Library(repository);

        assertThrows(CannotLoanBookException.class, () -> library.loanBook(id));
    }

}