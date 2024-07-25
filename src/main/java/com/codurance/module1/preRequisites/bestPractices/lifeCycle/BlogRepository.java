package com.codurance.module1.preRequisites.bestPractices.lifeCycle;

public interface BlogRepository {
    BlogPost get(String title);
    void save(BlogPost blogPost);
    void delete(String title);
}
