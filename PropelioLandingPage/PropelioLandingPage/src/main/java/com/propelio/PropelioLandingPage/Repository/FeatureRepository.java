package com.propelio.PropelioLandingPage.Repository;

import com.propelio.PropelioLandingPage.Entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {
}
