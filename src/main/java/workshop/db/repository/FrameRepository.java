package workshop.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.Frame;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "frame", path = "frame")
public interface FrameRepository extends JpaRepository<Frame, Long>, JpaSpecificationExecutor<Frame> {

    boolean existsByProductId (String productId);

    Optional<Frame> findByProductId (String productId);

    List<Frame> findAllByIsOfficialTrue();

    @Query("select x from Frame x where (:brand is null or x.brand = :brand) and isOfficial = true")
    List<Frame> findAllFrames(@Param("brand") String brand);
}
