package p76.bicycles.db.repository;

import org.springframework.data.repository.CrudRepository;
import p76.bicycles.db.entity.Bicycle;

import java.util.List;

public interface  BicycleRepository extends CrudRepository<Bicycle, Long> {

    List<Bicycle> findByName(String name);
}
