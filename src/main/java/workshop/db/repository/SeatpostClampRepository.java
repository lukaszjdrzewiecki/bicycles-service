package workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workshop.db.entity.seatpost.SeatpostClamp;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "seatpostClamp", path = "seatpostClamp")
public interface SeatpostClampRepository extends PagingAndSortingRepository<SeatpostClamp, Long> {

    boolean existsByProductId (String productId);

    Optional<SeatpostClamp> findByProductId (String productId);

}
