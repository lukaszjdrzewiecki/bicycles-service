package com.workshop.db.specification;

import com.workshop.db.entity.Frame;
import com.workshop.enums.PartType;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpecificationUtils {

    public Specification<Frame> prepareSpecification(GenericSpecification spec) {
        List<SearchCriteria> criteria = createSearchCriteria(spec);

        List<Specification<Frame>> specs = criteria.stream().map(GenericSpecificationBuilder::new).collect(Collectors.toList());

        Specification<Frame> specification = specs.get(0);

        Specification<Frame> finalSpec = specs.stream().reduce(specification, (partialString, element) -> partialString.and(element));

        return finalSpec;

    }

    private List<SearchCriteria> createSearchCriteria(GenericSpecification spec) {
        List<SearchCriteria> searchCriteria = new ArrayList<>();
        addIfSet(searchCriteria, "material", spec.getMaterial());
        addIfSet(searchCriteria, "brand", spec.getBrand());
        addIfSet(searchCriteria, "model", spec.getModel());
        addIfSet(searchCriteria, "series", spec.getSeries());
        addIfSet(searchCriteria, "year", spec.getYear());
        addIfSet(searchCriteria, "size", spec.getSize());
        addIfSet(searchCriteria, "wheelSize", spec.getWheelSize());
        addIfSet(searchCriteria, "product", spec.getProduct());
        addIfSet(searchCriteria, "isOfficial", true);
        return searchCriteria;
    }

    private static <T> void addIfSet(final List<SearchCriteria> searchCriteria, String attr, T value) {
        if (isSet(value)) {
            searchCriteria.add(new SearchCriteria().setKey(attr).setValue(value));
        }
    }

    private static <T> boolean isSet(final T value) {
        return value != null;
    }
}
