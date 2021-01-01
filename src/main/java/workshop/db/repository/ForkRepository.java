package workshop.db.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import workshop.db.entity.Frame;
import workshop.db.entity.suspension.Fork;

import java.util.List;
import java.util.Optional;


@Repository
public interface ForkRepository extends PagingAndSortingRepository<Fork, Long>, JpaSpecificationExecutor<Fork> {

    boolean existsByProductId (String productId);

    Optional<Fork> findByProductId (String productId);

}
