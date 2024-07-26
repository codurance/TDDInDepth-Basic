package com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.exercise.part1.customMatchers;

import com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.customMatchers.Book;
import com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.customMatchers.Library;
import com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.customMatchers.LoanedBook;
import com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure.CannotLoanBookException;
import com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure.CannotReturnBookException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryShould {

    public static final String ANIMAL_FARM = "Animal Farm";
    public static final String GEORGE_ORWELL = "George Orwell";
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    public void addBookToLibrary() {
        UUID id = UUID.randomUUID();
        Book book = new Book(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(book);

        assertEquals(book, library.getBook(id));
    }

    @Test
    public void loanBook() throws CannotLoanBookException {
        UUID id = UUID.randomUUID();
        Book book = new Book(id, ANIMAL_FARM, GEORGE_ORWELL);
        Book loanedBook = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(book);
        library.loanBook(id);

        assertEquals(loanedBook, library.getBook(id));
    }

    @Test
    public void makeLoanedBookUnavailable() throws CannotLoanBookException {
        UUID id = UUID.randomUUID();
        Book book = new Book(id, ANIMAL_FARM, GEORGE_ORWELL);
        Book loanedBook = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(book);
        library.loanBook(id);
        boolean isBookAvailable = library.isBookAvailable(id);

        assertFalse(isBookAvailable);
    }

    @Test
    public void notAllowLendingALoanedBook() {
        UUID id = UUID.randomUUID();
        Book book = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(book);

        assertThrows(CannotLoanBookException.class, () -> library.loanBook(id));
    }

    @Test
    public void returnBook() throws CannotReturnBookException {
        UUID id = UUID.randomUUID();
        Book loanedBook = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);
        Book returnedBook = new Book(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(loanedBook);
        library.returnBook(id);

        assertEquals(returnedBook, library.getBook(id));
    }

    @Test
    public void notAllowReturningABookThatIsNotLoaned() {
        UUID id = UUID.randomUUID();
        Book book = new Book(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(book);

        assertThrows(CannotReturnBookException.class, () -> library.returnBook(id));
    }

    @Test
    public void makeReturnedBookAvailable() throws CannotReturnBookException {
        UUID id = UUID.randomUUID();
        Book loanedBook = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(loanedBook);
        library.returnBook(id);
        boolean isBookAvailable = library.isBookAvailable(id);

        assertTrue(isBookAvailable);
    }

}