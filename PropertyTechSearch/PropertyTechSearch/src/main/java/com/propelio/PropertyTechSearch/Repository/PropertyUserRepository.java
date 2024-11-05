package com.propelio.PropertyTechSearch.Repository;

import com.propelio.PropertyTechSearch.Entity.PropertyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyUserRepository extends JpaRepository<PropertyUser, Integer>, JpaSpecificationExecutor<PropertyUser> {
}
