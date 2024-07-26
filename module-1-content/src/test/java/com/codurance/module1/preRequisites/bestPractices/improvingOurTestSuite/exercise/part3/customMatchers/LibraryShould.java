package com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.exercise.part3.customMatchers;

import com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.customMatchers.Book;
import com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.customMatchers.Library;
import com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.customMatchers.LoanedBook;
import com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure.CannotLoanBookException;
import com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure.CannotReturnBookException;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

        LibraryAssert.assertThat(library).hasBook(book);
    }

    @Test
    public void loanBook() throws CannotLoanBookException {
        UUID id = UUID.randomUUID();
        Book book = new Book(id, ANIMAL_FARM, GEORGE_ORWELL);
        Book loanedBook = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(book);
        library.loanBook(id);

        assertThat(library.getBook(id)).isEqualTo(loanedBook);
    }

    @Test
    public void makeLoanedBookUnavailable() throws CannotLoanBookException {
        UUID id = UUID.randomUUID();
        Book book = new Book(id, ANIMAL_FARM, GEORGE_ORWELL);
        Book loanedBook = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(book);
        library.loanBook(id);
        boolean isBookAvailable = library.isBookAvailable(id);

        assertThat(isBookAvailable).isFalse();
    }

    @Test
    public void notAllowLendingALoanedBook() {
        UUID id = UUID.randomUUID();
        Book book = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(book);

        assertThatThrownBy(() -> library.loanBook(id)).isInstanceOf(CannotLoanBookException.class);
    }

    @Test
    public void returnBook() throws CannotReturnBookException {
        UUID id = UUID.randomUUID();
        Book loanedBook = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);
        Book returnedBook = new Book(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(loanedBook);
        library.returnBook(id);

        assertThat(library.getBook(id)).isEqualTo(returnedBook);
    }

    @Test
    public void notAllowReturningABookThatIsNotLoaned() {
        UUID id = UUID.randomUUID();
        Book book = new Book(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(book);

        assertThatThrownBy(() -> library.returnBook(id)).isInstanceOf(CannotReturnBookException.class);
    }

    @Test
    public void makeReturnedBookAvailable() throws CannotReturnBookException {
        UUID id = UUID.randomUUID();
        Book loanedBook = new LoanedBook(id, ANIMAL_FARM, GEORGE_ORWELL);

        library.addBook(loanedBook);
        library.returnBook(id);
        boolean isBookAvailable = library.isBookAvailable(id);

        assertThat(isBookAvailable).isTrue();
    }

}

class LibraryAssert extends AbstractAssert<LibraryAssert, Library> {

    private final Library library;

    public LibraryAssert(Library library) {
        super(library, LibraryAssert.class);
        this.library = library;
    }

    public static LibraryAssert assertThat(Library library) {
        return new LibraryAssert(library);
    }

    public LibraryAssert hasBook(Book book) {
        isNotNull();
        Book foundBook = library.getBook(book.getId());

        if (foundBook == null) {
            failWithMessage("Expected book to be found");
        }

        if (foundBook != book) {
            failWithMessage("Expected book to be equal to");
        }

        return this;
    }
}
