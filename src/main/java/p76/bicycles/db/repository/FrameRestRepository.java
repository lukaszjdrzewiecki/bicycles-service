package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.Frame;
import p76.bicycles.db.entity.drivetrain.Chain;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "frame", path = "frame")
public interface FrameRestRepository extends PagingAndSortingRepository<Frame, Long> {

    List<Frame> findByName(@Param("name") String name);
}
