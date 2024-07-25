package com.codurance.module1.preRequisites.bestPractices.lifeCycle;

public class BlogPost {
    private final String title;
    private String content;

    public BlogPost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String content() {
        return content;
    }

    public String title() {
        return title;
    }

    public void withUpdated(String content) {
        this.content = content;
    }
}
