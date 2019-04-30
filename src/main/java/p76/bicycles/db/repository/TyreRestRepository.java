package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;
import p76.bicycles.db.entity.wheels.Tyre;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "tyre", path = "tyre")
public interface TyreRestRepository extends PagingAndSortingRepository<Tyre, Long> {

    List<Tyre> findByName(@Param("width") int width);
}

