package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.Pedals;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "pedals", path = "pedals")
public interface PedalsRestRepository extends PagingAndSortingRepository<Pedals, Long> {

    List<Pedals> findByName(@Param("name") String name);
}
