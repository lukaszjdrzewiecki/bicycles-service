package workshop.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.Frame;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "frame", path = "frame")
public interface FrameRepository extends JpaRepository<Frame, Long> {

    boolean existsByProductId (String productId);

    Optional<Frame> findByProductId (String productId);

    List<Frame> findAllByIsOfficialTrue();
}
