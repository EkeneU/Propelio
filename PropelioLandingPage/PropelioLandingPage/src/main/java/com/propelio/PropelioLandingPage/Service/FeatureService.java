package com.propelio.PropelioLandingPage.Service;

import com.propelio.PropelioLandingPage.Entity.Feature;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeatureService {
    Feature saveFeature(Feature feature);

    List<Feature> getAllFeatures();

    Feature findFeatureById(int theId);

    void deleteFeatureById(int feature_id);

}
