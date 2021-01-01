package workshop.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import workshop.db.entity.Frame;

import java.util.List;
import java.util.Optional;


@Repository
public interface FrameRepository extends JpaRepository<Frame, Long>, JpaSpecificationExecutor<Frame> {

    boolean existsByProductId (String productId);

    Optional<Frame> findByProductId (String productId);

    // For test only
    List<Frame> findAllByIsOfficialTrue();

}
