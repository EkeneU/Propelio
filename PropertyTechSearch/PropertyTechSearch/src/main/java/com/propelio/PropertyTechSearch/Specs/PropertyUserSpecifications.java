package com.propelio.PropertyTechSearch.Specs;

import com.propelio.PropertyTechSearch.Entity.PropertyUser;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;

public class PropertyUserSpecifications {

    public static Specification<PropertyUser> hasNameAndIncomeBracket(String first_name, Integer income_bracket) {
        return new Specification<PropertyUser>() {
            @Override
            public Predicate toPredicate(Root<PropertyUser> root, CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
                    Predicate namePredicate = criteriaBuilder.equal(root.get("first_name"), first_name);

                    Predicate incomeBracketPredicate = criteriaBuilder.equal(root.get("income_bracket"), income_bracket);
                    return criteriaBuilder.and(namePredicate, incomeBracketPredicate);
            }
        };
    }
}
