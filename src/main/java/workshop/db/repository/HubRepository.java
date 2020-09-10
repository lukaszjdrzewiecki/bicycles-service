package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.wheels.Hub;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "frontHub", path = "frontHub")
public interface HubRepository extends PagingAndSortingRepository<Hub, Long> {

    List<Hub> findByName(@Param("discType") String discType);

    boolean existsByProductId (String productId);

    Optional<Hub> findByProductId (String productId);

}
