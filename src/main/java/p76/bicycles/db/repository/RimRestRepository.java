package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.wheels.Rim;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rim", path = "rim")
public interface RimRestRepository extends PagingAndSortingRepository<Rim, Long> {

    List<Rim> findByName(@Param("material") String material);
}

