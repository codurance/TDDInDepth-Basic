package com.codurance.module1.preRequisites.bestPractices.lifeCycle;

public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {

        this.blogRepository = blogRepository;
    }

    public void add(BlogPost blogPost) {
        blogRepository.save(blogPost);

    }

    public void updateContent(String title, String newContent) {
        BlogPost blogPost = blogRepository.get(title);
        blogPost.withUpdated(newContent);

        blogRepository.save(blogPost);
    }

    public void delete(String title) {
        blogRepository.delete(title);
    }
}
