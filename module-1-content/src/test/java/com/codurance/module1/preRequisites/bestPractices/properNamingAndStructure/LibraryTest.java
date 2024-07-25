package com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class LibraryTest {

    /*
     * Fix the test names, consider using Should/When or Given/When/Then
     * Fix the test structure, consider using Arrange/Act/Assert or Four Phase Test
     * */
    @Test
    public void addBookInsertsABookInLibraryListOfBooksAndInvokesBookRepositorySaveBook() {
        BookRepository libraryRepository = mock(BookRepository.class);
        Library library = new Library(libraryRepository);
        UUID id = UUID.randomUUID();
        Book book = new Book(id, "Animal Farm", "George Orwell");
        library.addBook(book);
        verify(libraryRepository).saveBook(book);
    }

    @Test
    public void lendBookShouldChangeTheIsOnLoanPropertyToTrueOfTheBookAndInvokeBookRepositorySaveBook() throws CannotLoanBookException {
        BookRepository libraryRepository = mock(BookRepository.class);
        UUID id = UUID.randomUUID();
        Book book = new Book(id, "Animal Farm", "George Orwell");
        Library library = new Library(libraryRepository);
        when(libraryRepository.findBookById(id)).thenReturn(book);
        library.loanBook(id);
        Book loanedBook = new LoanedBook(id, "Animal Farm", "George Orwell");
        verify(libraryRepository).saveBook(loanedBook);
    }

    @Test
    public void lendBookShouldThrowErrorIfBookIsAlreadyLoaned() throws CannotLoanBookException {
        BookRepository libraryRepository = mock(BookRepository.class);
        UUID id = UUID.randomUUID();
        Book book = new LoanedBook(id, "Animal Farm", "George Orwell");
        Library library = new Library(libraryRepository);
        when(libraryRepository.findBookById(id)).thenReturn(book);
        assertThrows(CannotLoanBookException.class, () -> library.loanBook(id));
    }

    @Test
    public void returnBookShouldThrowErrorIfBookIsNotLoaned() throws CannotLoanBookException {
        BookRepository libraryRepository = mock(BookRepository.class);
        UUID id = UUID.randomUUID();
        Book book = new Book(id, "Animal Farm", "George Orwell");
        Library library = new Library(libraryRepository);
        when(libraryRepository.findBookById(id)).thenReturn(book);
        assertThrows(CannotReturnBookException.class, () -> library.returnBook(id));
    }

    @Test
    public void returnBookShouldChangeTheIsOnLoanPropertyOfTheBookToFalseAndInvokeBookRepositorySaveBook() throws CannotReturnBookException {
        UUID id = UUID.randomUUID();
        BookRepository libraryRepository = mock(BookRepository.class);
        Book loanedBook = new LoanedBook(id, "Animal Farm", "George Orwell");
        when(libraryRepository.findBookById(id)).thenReturn(loanedBook);
        Library library = new Library(libraryRepository);
        Book book = new Book(id, "Animal Farm", "George Orwell");
        library.returnBook(id);
        verify(libraryRepository).saveBook(book);
    }

}