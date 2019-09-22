package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.Pedals;
import p76.bicycles.db.entity.drivetrain.Chainring;
import p76.bicycles.db.entity.wheels.Disc;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "disc", path = "disc")
public interface DiscRepository extends PagingAndSortingRepository<Disc, Long> {

    List<Disc> findByName(@Param("type") String type);

    boolean existsByProductId (String productId);

    Optional<Disc> findByProductId (String productId);

}