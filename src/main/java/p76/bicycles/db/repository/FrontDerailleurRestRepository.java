package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.drivetrain.RearDerailleur;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "frontDerailleur", path = "frontDerailleur")
public interface FrontDerailleurRestRepository extends PagingAndSortingRepository<FrontDerailleur, Long> {

}
