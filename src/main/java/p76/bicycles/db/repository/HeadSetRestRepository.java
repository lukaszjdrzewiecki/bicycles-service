package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.cockpit.Handlebar;
import p76.bicycles.db.entity.cockpit.HeadSet;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "headSet", path = "headSet")
public interface HeadSetRestRepository extends PagingAndSortingRepository<HeadSet, Long> {

    List<HeadSet> findByName(@Param("name") String name);
}
