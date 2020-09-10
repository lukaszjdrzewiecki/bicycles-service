package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.wheels.Tyre;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "tyre", path = "tyre")
public interface TyreRepository extends PagingAndSortingRepository<Tyre, Long> {

    boolean existsByProductId (String productId);

    Optional<Tyre> findByProductId (String productId);

}

