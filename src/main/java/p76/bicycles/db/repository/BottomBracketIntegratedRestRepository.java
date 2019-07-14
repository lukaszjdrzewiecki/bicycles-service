package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.BottomBracket;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "bottomBracket", path = "bottomBracket")
public interface BottomBracketIntegratedRestRepository extends PagingAndSortingRepository<BottomBracket, Long> {

    List<BottomBracket> findByName(@Param("name") String name);
}

