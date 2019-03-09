package p76.bicycles.repository;

import org.springframework.data.repository.CrudRepository;
import p76.bicycles.dto.Bicycle;
import p76.bicycles.entity.Customer;

import java.util.List;

public interface  BicycleRepository extends CrudRepository<Bicycle, Long> {

    public List<Bicycle> findByName(String name);
}
