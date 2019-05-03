package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.Chain;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "chain", path = "chain")
public interface ChainRestRepository extends PagingAndSortingRepository<Chain, Long> {

    List<Chain> findByName(@Param("name") String name);
}
