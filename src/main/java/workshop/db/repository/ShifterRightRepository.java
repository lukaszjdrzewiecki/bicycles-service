package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.drivetrain.shifters.ShifterRight;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "shifterRight", path = "shifterRight")
public interface ShifterRightRepository extends PagingAndSortingRepository<ShifterRight, Long> {

    boolean existsByProductId (String productId);

    Optional<ShifterRight> findByProductId (String productId);

}

