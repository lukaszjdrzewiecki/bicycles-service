package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.cockpit.Stem;
import p76.bicycles.db.entity.seatpost.Seatpost;

import java.util.List;


    @RepositoryRestResource(collectionResourceRel = "stem", path = "stem")
    public interface StemRestRepository extends PagingAndSortingRepository<Stem, Long> {

        List<Stem> findByName(@Param("name") String name);
    }
