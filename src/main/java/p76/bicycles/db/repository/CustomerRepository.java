package p76.bicycles.db.repository;


import org.springframework.data.repository.CrudRepository;
import p76.bicycles.db.entity.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
