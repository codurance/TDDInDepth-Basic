package com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InMemoryBookRepository implements BookRepository {
    private final HashMap<UUID, Book> books = new HashMap<>();

    public InMemoryBookRepository() {
    }

    public InMemoryBookRepository(List<Book> books) {
        for (Book book : books) {
            saveBook(book);
        }
    }

    @Override
    public void saveBook(Book book) {
        books.put(book.id, book);
    }

    @Override
    public Book findBookById(UUID id) {
        return books.getOrDefault(id, books.get(id));
    }

    public void clear() {
        books.clear();
    }
}
