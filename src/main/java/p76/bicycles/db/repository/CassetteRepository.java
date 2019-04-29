package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.Cassette;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cassette", path = "cassette")
public interface CassetteRepository extends PagingAndSortingRepository<Cassette, Long> {

    List<Cassette> findByFreewheelBody(@Param("freewheelBody") String freewheelBody);
}