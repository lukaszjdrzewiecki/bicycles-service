package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.bottomBracket.BottomBracketIntegrated;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterRight;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "bottomBracketIntegrated", path = "bottomBracketIntegrated")
public interface BottomBracketIntegratedRestRepository extends PagingAndSortingRepository<BottomBracketIntegrated, Long> {

    List<BottomBracketIntegrated> findByName(@Param("name") String name);
}

