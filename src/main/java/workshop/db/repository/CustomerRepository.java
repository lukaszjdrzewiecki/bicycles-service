package workshop.db.repository;


import org.springframework.data.repository.CrudRepository;
import workshop.db.entity.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
