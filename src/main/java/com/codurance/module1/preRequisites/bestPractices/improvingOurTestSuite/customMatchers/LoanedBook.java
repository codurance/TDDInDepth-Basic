package com.codurance.module1.preRequisites.bestPractices.improvingOurTestSuite.customMatchers;

import java.util.UUID;

public class LoanedBook extends Book {
    public LoanedBook(UUID id, String title, String author) {
        super(id, title, author);
        this.isOnLoan = true;
    }
}
