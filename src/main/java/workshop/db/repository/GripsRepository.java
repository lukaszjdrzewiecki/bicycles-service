package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.cockpit.Grips;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "grips", path = "grips")
public interface GripsRepository extends PagingAndSortingRepository<Grips, Long> {

    boolean existsByProductId (String productId);

    Optional<Grips> findByProductId (String productId);

}
