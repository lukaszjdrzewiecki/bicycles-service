package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.RearDerailleur;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rearDerailleur", path = "rearDerailleur")
public interface RearDerailleurRestRepository extends PagingAndSortingRepository<RearDerailleur, Long> {

    List<RearDerailleur> findByCage(@Param("cage") String cage);
}
