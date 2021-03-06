package com.workshop.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.workshop.config.security.entity.User;
import com.workshop.db.entity.Bicycle;

import java.util.List;
import java.util.Optional;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Long> {

    List<Bicycle> findAllByUser(User user);

    Optional<Bicycle> findByNameAndUser (String name, User user);

    boolean existsByNameAndUser(String name, User user);

}
