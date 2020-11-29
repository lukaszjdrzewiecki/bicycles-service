package workshop.db.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import workshop.db.entity.Frame;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class FrameSpecification {


    private List<SearchCriteria> list;

    public FrameSpecification() {
        this.list = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }



    public static Specification<Frame> buildFrameSpecification (String query) {
        return new Specification<>() {

            @Override
            public Predicate toPredicate(Root<Frame> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                addIfSet(predicates, root, criteriaBuilder, "brand", query != null ? query :null);

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

    private static <T> void addIfSet(final List<Predicate> predicates, final Root<Frame> root, final CriteriaBuilder criteriaBuilder, String attr, T value) {
        if (isSet(value)) {
            predicates.add(criteriaBuilder.equal(root.get(attr), value));
        }
    }

    private static <T> boolean isSet(final T value) {
        return value != null;
    }
}

