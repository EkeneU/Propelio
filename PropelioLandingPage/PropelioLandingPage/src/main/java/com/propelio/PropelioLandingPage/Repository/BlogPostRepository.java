package com.propelio.PropelioLandingPage.Repository;

import com.propelio.PropelioLandingPage.Entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
}
