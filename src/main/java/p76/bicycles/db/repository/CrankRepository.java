package p76.bicycles.db.repository;

import org.springframework.data.repository.CrudRepository;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.drivetrain.Crank;

import java.util.List;


public interface CrankRepository extends CrudRepository<Crank, Long> {

    public List<Crank> findByName(String name);
}