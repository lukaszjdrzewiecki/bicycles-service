package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.brakes.BrakeHydraulic;
import p76.bicycles.db.entity.drivetrain.Cassette;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "brakeHydraulic", path = "brakeHydraulic")
public interface BrakeHydraulicRestRepository extends PagingAndSortingRepository<BrakeHydraulic, Long> {

    List<BrakeHydraulic> findByName(@Param("name") String name);
}
