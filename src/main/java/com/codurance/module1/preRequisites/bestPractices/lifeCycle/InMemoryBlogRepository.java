package com.codurance.module1.preRequisites.bestPractices.lifeCycle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBlogRepository implements BlogRepository {
    private Map<String, BlogPost> blogPosts = new HashMap<>();

    public InMemoryBlogRepository() {
    }
    public InMemoryBlogRepository(List<BlogPost> blogPosts) {
        for (BlogPost blogPost: blogPosts) {
            this.blogPosts.put(blogPost.title(), blogPost);
        }
    }

    @Override
    public BlogPost get(String title) {
        return blogPosts.get(title);
    }

    @Override
    public void save(BlogPost blogPost) {
        blogPosts.put(blogPost.title(), blogPost);
    }

    @Override
    public void delete(String title) {
        blogPosts.remove(title);
    }
}
