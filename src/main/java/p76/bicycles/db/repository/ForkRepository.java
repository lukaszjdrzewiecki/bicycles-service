package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.Pedals;
import p76.bicycles.db.entity.suspension.Fork;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "suspensionFork", path = "suspensionFork")
public interface ForkRepository extends PagingAndSortingRepository<Fork, Long> {

    List<Fork> findByName(@Param("name") String name);

    boolean existsByProductId (String productId);

    Optional<Fork> findByProductId (String productId);

}
