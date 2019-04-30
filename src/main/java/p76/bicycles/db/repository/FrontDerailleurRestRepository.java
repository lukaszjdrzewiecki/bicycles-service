package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.drivetrain.RearDerailleur;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "frontDerailleur", path = "frontDerailleur")
public interface FrontDerailleurRestRepository extends PagingAndSortingRepository<FrontDerailleur, Long> {

    List<FrontDerailleur> findByCage(@Param("cage") String cage);
}