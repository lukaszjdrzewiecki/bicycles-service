package p76.bicycles.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import p76.bicycles.db.entity.cockpit.Grips;
import p76.bicycles.db.entity.cockpit.Handlebar;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "handlebar", path = "handlebar")
public interface HandlebarRepository extends JpaRepository<Handlebar, Long> {

}
