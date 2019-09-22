package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.Frame;
import p76.bicycles.db.entity.Pedals;
import p76.bicycles.db.entity.drivetrain.Chain;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "frame", path = "frame")
public interface FrameRepository extends PagingAndSortingRepository<Frame, Long> {

    List<Frame> findByName(@Param("name") String name);

    boolean existsByProductId (String productId);

    Optional<Frame> findByProductId (String productId);

}
