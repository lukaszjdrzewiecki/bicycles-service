package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.drivetrain.BottomBracket;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "bottomBracket", path = "bottomBracket")
public interface BottomBracketRepository extends PagingAndSortingRepository<BottomBracket, Long> {

    List<BottomBracket> findByName(@Param("name") String name);

    boolean existsByProductId (String productId);

    Optional<BottomBracket> findByProductId (String productId);

}

