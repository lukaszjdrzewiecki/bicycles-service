package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.wheels.RearHub;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rearHub", path = "rearHub")
public interface RearHubRestRepository extends PagingAndSortingRepository<RearHub, Long> {

    List<RearHub> findByName(@Param("discType") String discType);
}

