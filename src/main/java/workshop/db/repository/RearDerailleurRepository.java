package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import workshop.db.entity.drivetrain.RearDerailleur;

import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "rearDerailleur", path = "rearDerailleur")
public interface RearDerailleurRepository extends PagingAndSortingRepository<RearDerailleur, Long> {

    boolean existsByProductId (String productId);

    Optional<RearDerailleur> findByProductId (String productId);

}
