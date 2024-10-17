package com.propelio.PropertyTechSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyListingService {
    @Autowired
    private PropertyListingRepository repository;

    public List<PropertyListing> searchProperty(String type, String location, Boolean isAvailable) {
        Specification<PropertyListing> propertySpec = PropertyListingSpecifications.isPropertyAvailable(isAvailable, location, type);
        return repository.findAll(propertySpec);

    }

}
