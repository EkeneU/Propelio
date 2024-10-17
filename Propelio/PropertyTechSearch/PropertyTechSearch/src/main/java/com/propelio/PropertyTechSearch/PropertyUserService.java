package com.propelio.PropertyTechSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyUserService {
    @Autowired
    private PropertyUserRepository propertyUserRepository;


    public List<PropertyUser> searchusers(String first_name, Integer income_bracket) {
        Specification<PropertyUser> userSpec = PropertyUserSpecifications.hasNameAndIncomeBracket(first_name, income_bracket);
        return propertyUserRepository.findAll(userSpec);
    }
}
