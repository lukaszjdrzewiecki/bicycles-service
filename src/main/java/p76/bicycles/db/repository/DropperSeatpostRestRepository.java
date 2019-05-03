package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.drivetrain.Chain;
import p76.bicycles.db.entity.seatpost.DropperSeatpost;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "dropperSeatpost", path = "dropperSeatpost")
public interface DropperSeatpostRestRepository extends PagingAndSortingRepository<DropperSeatpost, Long> {

    List<DropperSeatpost> findByName(@Param("name") String name);
}
