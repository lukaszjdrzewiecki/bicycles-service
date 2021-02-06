package com.workshop.db.specification;

import com.workshop.db.entity.Frame;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class GenericSpecificationBuilder implements Specification<Frame> {

    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<Frame> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
    }
}
