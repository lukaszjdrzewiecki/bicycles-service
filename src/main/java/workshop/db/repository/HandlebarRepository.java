package workshop.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.cockpit.Handlebar;

import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "handlebar", path = "handlebar")
public interface HandlebarRepository extends JpaRepository<Handlebar, Long> {

    boolean existsByProductId (String productId);

    Optional<Handlebar> findByProductId (String productId);

}
