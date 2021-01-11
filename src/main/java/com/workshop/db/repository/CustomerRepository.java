package com.workshop.db.repository;


import org.springframework.data.repository.CrudRepository;
import com.workshop.db.entity.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
