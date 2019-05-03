package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.cockpit.Grips;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "grips", path = "grips")
public interface GripsRestRepository extends PagingAndSortingRepository<Grips, Long> {

    List<Grips> findByName(@Param("name") String name);
}
