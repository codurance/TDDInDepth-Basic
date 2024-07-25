package com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure;

import java.util.UUID;

public interface BookRepository {
    void saveBook(Book book);

    Book findBookById(UUID id);
}
