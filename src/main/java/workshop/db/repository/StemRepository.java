package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.cockpit.Stem;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "stem", path = "stem")
public interface StemRepository extends PagingAndSortingRepository<Stem, Long> {

    List<Stem> findByName(@Param("name") String name);

    boolean existsByProductId(String productId);

    Optional<Stem> findByProductId(String productId);

}
