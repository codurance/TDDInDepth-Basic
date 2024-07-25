package com.codurance.module1.preRequisites.bestPractices.lifeCycle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BlogServiceTest {
    @Test
    public void shouldAllowEditorToAddABlogPost() {
        BlogRepository blogRepository = new InMemoryBlogRepository();
        BlogService blogService = new BlogService(
            blogRepository
        );
        BlogPost blogPost = new BlogPost("Hello World!!", "Some content.");

        blogService.add(blogPost);

        assertEquals(
            blogPost,
            blogRepository.get("Hello World!!")
        );
    }

    @Test
    public void shouldAllowEditorToModifyABlogPost() {
        List<BlogPost> blogPosts = new ArrayList<>();
        blogPosts.add(new BlogPost("Hello World!!", "Some content."));
        BlogRepository blogRepository = new InMemoryBlogRepository(blogPosts);
        BlogService blogService = new BlogService(blogRepository);

        blogService.updateContent("Hello World!!", "Modified Content.");

        BlogPost modifiedBlogPost = blogRepository.get("Hello World!!");
        assertEquals(
            "Modified Content.",
            modifiedBlogPost.content()
        );
    }

    @Test
    public void shouldAllowEditorToDeleteABlogPost() {
        List<BlogPost> blogPosts = new ArrayList<>();
        blogPosts.add(new BlogPost("Hello World!!", "Some content."));
        BlogRepository blogRepository = new InMemoryBlogRepository(blogPosts);
        BlogService blogService = new BlogService(blogRepository);

        blogService.delete("Hello World!!");

        assertNull(
            blogRepository.get("Hello World!!")
        );
    }
}
