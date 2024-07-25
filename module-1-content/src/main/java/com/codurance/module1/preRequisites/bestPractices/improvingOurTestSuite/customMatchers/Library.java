package com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.customMatchers;

import com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure.CannotLoanBookException;
import com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure.CannotReturnBookException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Library {
    private final Map<UUID, Book> books = new HashMap<>();

    public Library() {
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void loanBook(UUID id) throws CannotLoanBookException {
        Book book = getBook(id);
        canLoan(book);
        LoanedBook loanedBook = book.loanBook();
        books.put(book.getId(), loanedBook);
    }

    public void returnBook(UUID id) throws CannotReturnBookException {
        Book book = getBook(id);
        canReturn(book);
        Book returnedBook = book.returnBook();
        books.put(book.getId(), returnedBook);

    }

    private void canLoan(Book book) throws CannotLoanBookException {
        if (book.isOnLoan()) {
            throw new CannotLoanBookException();
        }

    }

    private void canReturn(Book book) throws CannotReturnBookException {
        if (!book.isOnLoan()) {
            throw new CannotReturnBookException();
        }
        ;
    }

    public boolean isBookAvailable(UUID id) {
        Book book = getBook(id);

        if (book == null) {
            return false;
        }

        return !book.isOnLoan();
    }

    public Book getBook(UUID id) {
        return books.getOrDefault(id, null);
    }
}
