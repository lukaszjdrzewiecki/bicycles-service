package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.drivetrain.Chainring;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "chainring", path = "chainring")
public interface ChainringRepository extends PagingAndSortingRepository<Chainring, Long> {

    List<Chainring> findByName(@Param("type") String type);

    Optional<Chainring> findByProductId (String productId);

}

