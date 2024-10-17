package com.propelio.PropertyTechSearch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyListingRepository extends JpaRepository<PropertyListing, Integer>, JpaSpecificationExecutor<PropertyListing> {
}
