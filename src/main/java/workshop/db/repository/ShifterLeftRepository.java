package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.drivetrain.shifters.ShifterLeft;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "shifterLeft", path = "shifterLeft")
public interface ShifterLeftRepository extends PagingAndSortingRepository<ShifterLeft, Long> {

    List<ShifterLeft> findByName(@Param("gears") String gears);

    boolean existsByProductId (String productId);

    Optional<ShifterLeft> findByProductId (String productId);

}

