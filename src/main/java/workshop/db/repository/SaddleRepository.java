package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.seatpost.Saddle;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "saddle", path = "saddle")
public interface SaddleRepository extends PagingAndSortingRepository<Saddle, Long> {

    List<Saddle> findByName(@Param("name") String name);

    boolean existsByProductId (String productId);

    Optional<Saddle> findByProductId (String productId);

}
