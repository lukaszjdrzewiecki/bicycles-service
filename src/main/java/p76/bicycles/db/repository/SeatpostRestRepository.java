package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.seatpost.Saddle;
import p76.bicycles.db.entity.seatpost.Seatpost;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "seatpost", path = "seatpost")
public interface SeatpostRestRepository extends PagingAndSortingRepository<Seatpost, Long> {

    List<Seatpost> findByName(@Param("name") String name);
    public Seatpost findOneByName(String name);
}