package com.propelio.PropertyTechSearch.Specs;

import com.propelio.PropertyTechSearch.Entity.PropertyListing;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;

public class PropertyListingSpecifications {

    public static Specification<PropertyListing> isPropertyAvailable(Boolean isAvailable, String type, String location){
        return new Specification<PropertyListing>() {
            @Override
            public Predicate toPredicate(@NonNull Root<PropertyListing> root, CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
                Predicate isAvailablePredicate = criteriaBuilder.equal(root.get("is_available"), isAvailable);

                Predicate typePredicate = criteriaBuilder.equal(root.get("property_type"), type);

                Predicate locationPredicate = criteriaBuilder.equal(root.get("location"), location);

                return criteriaBuilder.and(isAvailablePredicate, typePredicate, locationPredicate);
            }
        };
    }
}
