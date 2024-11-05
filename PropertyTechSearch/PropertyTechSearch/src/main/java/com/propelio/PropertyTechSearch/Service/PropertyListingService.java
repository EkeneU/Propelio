package com.propelio.PropertyTechSearch.Service;

import com.propelio.PropertyTechSearch.Entity.PropertyListing;
import com.propelio.PropertyTechSearch.Repository.PropertyListingRepository;
import com.propelio.PropertyTechSearch.Specs.PropertyListingSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyListingService {
    @Autowired
    private PropertyListingRepository repository;

    public List<PropertyListing> searchProperty(String type, String location, Boolean isAvailable) {
        Specification<PropertyListing> propertySpec = PropertyListingSpecifications.isPropertyAvailable(isAvailable, location, type);
        return repository.findAll(propertySpec);

    }

    public PropertyListing findById(int property_id) {
        Optional<PropertyListing> result = repository.findById(property_id);
        PropertyListing listing;
        if (result.isPresent()) {
            listing=result.get();
        }
        else {
            throw new RuntimeException("Property with ID " + property_id + "not found");
        }
        return listing;
    }
    public List<PropertyListing> findAllProperties() {
        return repository.findAll();
    }

    public PropertyListing save(PropertyListing propertyListing) {
        return repository.save(propertyListing);

    }

    public void deleteProperty(int property_id) {
        repository.deleteById(property_id);
    }


}
