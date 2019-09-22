package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.Pedals;
import p76.bicycles.db.entity.seatpost.Seatpost;
import p76.bicycles.db.entity.seatpost.SeatpostClamp;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "seatpostClamp", path = "seatpostClamp")
public interface SeatpostClampRepository extends PagingAndSortingRepository<SeatpostClamp, Long> {

    List<SeatpostClamp> findByName(@Param("name") String name);

    boolean existsByProductId (String productId);

    Optional<SeatpostClamp> findByProductId (String productId);

}
