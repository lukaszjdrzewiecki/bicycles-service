package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.Pedals;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterRight;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "shifterRight", path = "shifterRight")
public interface ShifterRightRepository extends PagingAndSortingRepository<ShifterRight, Long> {

    boolean existsByProductId (String productId);

    Optional<ShifterRight> findByProductId (String productId);

}

