package com.propelio.PropertyTechSearch.Repository;

import com.propelio.PropertyTechSearch.Entity.PropertyListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyListingRepository extends JpaRepository<PropertyListing, Integer>, JpaSpecificationExecutor<PropertyListing> {
}
