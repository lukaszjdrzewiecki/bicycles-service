package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.wheels.FrontHub;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "frontHub", path = "frontHub")
public interface FrontHubRestRepository extends PagingAndSortingRepository<FrontHub, Long> {

    List<FrontHub> findByName(@Param("discType") String discType);
}
