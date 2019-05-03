package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.seatpost.Seatpost;
import p76.bicycles.db.entity.suspension.SuspensionFork;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "suspensionFork", path = "suspensionFork")
public interface SuspensionForkRestRepository extends PagingAndSortingRepository<SuspensionFork, Long> {

    List<SuspensionFork> findByName(@Param("name") String name);
}
