package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.cockpit.HeadSet;
import p76.bicycles.db.entity.seatpost.Saddle;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "saddle", path = "saddle")
public interface SaddleRestRepository extends PagingAndSortingRepository<Saddle, Long> {

    List<Saddle> findByName(@Param("name") String name);
}
