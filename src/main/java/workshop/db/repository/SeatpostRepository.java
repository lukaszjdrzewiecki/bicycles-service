package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.seatpost.Seatpost;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "seatpost", path = "seatpost")
public interface SeatpostRepository extends PagingAndSortingRepository<Seatpost, Long> {

    List<Seatpost> findByName(@Param("name") String name);

    public Seatpost findOneByName(String name);

    boolean existsByProductId (String productId);

    Optional<Seatpost> findByProductId (String productId);

}