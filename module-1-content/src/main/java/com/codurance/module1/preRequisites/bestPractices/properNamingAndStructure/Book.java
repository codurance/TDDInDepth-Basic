package com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure;

import java.util.Objects;
import java.util.UUID;

public class Book {

    public final UUID id;
    final String title;
    final String author;
    public boolean isOnLoan = false;

    public Book(UUID id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;

    }

    public LoanedBook loanBook() {
        return new LoanedBook(id, title, author);
    }

    public Book returnBook() {
        return new Book(id, title, author);
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
