package com.propelio.PropelioLandingPage.Service;

import com.propelio.PropelioLandingPage.Entity.BlogPost;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BlogPostService {

    BlogPost saveBlogPost(BlogPost feature);

    List<BlogPost> getAllBlogPosts();

    BlogPost findBlogPostById(int theId);

    void deleteBlogPostById(int blogPostId);
}
