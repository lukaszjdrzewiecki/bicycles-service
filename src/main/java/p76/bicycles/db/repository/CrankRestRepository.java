package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import p76.bicycles.db.entity.drivetrain.Crank;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "crank", path = "crank")
public interface CrankRestRepository extends PagingAndSortingRepository<Crank, Long> {
  List<Crank> findByName(@Param("name") String name);
}
