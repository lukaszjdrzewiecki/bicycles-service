package p76.bicycles.repository;


import org.springframework.data.repository.CrudRepository;
import p76.bicycles.entity.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
