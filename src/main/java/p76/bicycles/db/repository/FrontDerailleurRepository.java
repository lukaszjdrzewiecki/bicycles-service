package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.Pedals;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.drivetrain.RearDerailleur;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "frontDerailleur", path = "frontDerailleur")
public interface FrontDerailleurRepository extends PagingAndSortingRepository<FrontDerailleur, Long> {

    List<FrontDerailleur> findByCage(@Param("cage") String cage);

    boolean existsByProductId (String productId);

    Optional<FrontDerailleur> findByProductId (String productId);

}