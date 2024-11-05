package com.propelio.PropelioLandingPage.Service;

import com.propelio.PropelioLandingPage.Entity.BlogPost;
import com.propelio.PropelioLandingPage.Entity.Feature;
import com.propelio.PropelioLandingPage.Repository.BlogPostRepository;
import com.propelio.PropelioLandingPage.Repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentServiceImpl implements FeatureService, BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private FeatureRepository featureRepository;


    @Override
    public Feature saveFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public List<Feature> getAllFeatures(){
        return featureRepository.findAll();
    }

    @Override
    public Feature findFeatureById(int featureId) {
        Optional<Feature> result = featureRepository.findById(featureId);
        Feature feature;
        if (result.isPresent()) {
            feature= result.get();
        }
        else {
            throw new RuntimeException("Id not found" + featureId);
        }
        return feature;
    }

    @Override
    public void deleteFeatureById(int feature_id) {
        featureRepository.deleteById(feature_id);
    }

    @Override
    public BlogPost saveBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost findBlogPostById(int blogPostId) {
        Optional<BlogPost> result = blogPostRepository.findById(blogPostId);
        BlogPost blogPost;
        if (result.isPresent()) {
            blogPost= result.get();
        }
        else {
            throw new RuntimeException("Id not found" + blogPostId);
        }
        return blogPost;
    }

    @Override
    public void deleteBlogPostById(int blogPostId) {
        blogPostRepository.deleteById(blogPostId);
    }

}
