package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.Chainring;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "chainring", path = "chainring")
public interface ChainringRestRepository extends PagingAndSortingRepository<Chainring, Long> {

    List<Chainring> findByName(@Param("type") String type);
}

