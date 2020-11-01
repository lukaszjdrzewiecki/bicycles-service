package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.wheels.Disc;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "disc", path = "disc")
public interface DiscRepository extends PagingAndSortingRepository<Disc, Long> {

    boolean existsByProductId (String productId);

    Optional<Disc> findByProductId (String productId);

}