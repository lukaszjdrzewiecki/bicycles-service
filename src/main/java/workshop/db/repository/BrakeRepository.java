package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.brakes.BrakeHydraulic;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "brakeHydraulic", path = "brakeHydraulic")
public interface BrakeRepository extends PagingAndSortingRepository<BrakeHydraulic, Long> {

    boolean existsByProductId (String productId);

    Optional<BrakeHydraulic> findByProductId (String productId);

}
