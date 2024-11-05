package com.propelio.PropelioLandingPage.Controller;

import com.propelio.PropelioLandingPage.Entity.BlogPost;
import com.propelio.PropelioLandingPage.Entity.Feature;
import com.propelio.PropelioLandingPage.Service.ContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propelio/api/content")
public class ContentController {
    public static final String GET_MAPPING_FEATURE= "/features";
    public static final String GET_MAPPING_BLOGS="/blogs";
    public static final String POST_MAPPING_FEATURE="/feature";
    public static final String POST_MAPPING_BLOGS= "/blogpost";
    public static final String PUT_MAPPING_FEATURE="/u/feature";
    public static final String PUT_MAPPING_BLOGS="/u/blogpost";
    public static final String DELETE_MAPPING_FEATURE="/i/feature";
    public static final String DELETE_MAPPING_BLOGS="/i/blogpost";
    @Autowired
    private ContentServiceImpl service;

    @GetMapping(GET_MAPPING_FEATURE)
    public List<Feature> getFeature() {
        return service.getAllFeatures();
    }

    @GetMapping(GET_MAPPING_BLOGS)
    public List<BlogPost> getBlogPosts () {
        return service.getAllBlogPosts();
    }

    @PostMapping(POST_MAPPING_FEATURE)
    public Feature addFeature(@RequestBody Feature feature) {
        feature.setId(0);
        return service.saveFeature(feature);
    }
    @PostMapping(POST_MAPPING_BLOGS)
    public BlogPost addBlogPost(@RequestBody BlogPost blogPost) {
        blogPost.setId(0);
        return service.saveBlogPost(blogPost);
    }
    @PutMapping(PUT_MAPPING_FEATURE)
    public Feature updateFeature(@RequestBody Feature feature) {
        return service.saveFeature(feature);
    }
    @PutMapping(PUT_MAPPING_BLOGS)
    public BlogPost updateBlogPost(@RequestBody BlogPost blogPost) {
        return service.saveBlogPost(blogPost);
    }
    @DeleteMapping(DELETE_MAPPING_FEATURE)
    public String deleteFeature(@PathVariable int featureId) {
        Feature tempFeature = service.findFeatureById(featureId);
        if (tempFeature==null) {
            throw new RuntimeException("ID not on the database" + featureId);
        }
        else {
            service.deleteFeatureById(featureId);
            return "Feature with ID" + featureId + " has been deleted";
        }
    }

    @DeleteMapping(DELETE_MAPPING_BLOGS)
    public String deleteBlogPost(@PathVariable int blogPostId) {
        BlogPost tempBlogPost = service.findBlogPostById(blogPostId);
        if (tempBlogPost==null) {
            throw new RuntimeException("ID not on the database" + blogPostId);
        }
        else {
            service.deleteFeatureById(blogPostId);
            return "Blog post with ID" + blogPostId + " has been deleted";
        }
    }

}
