package com.workshop.db.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.workshop.db.entity.Fork;

import java.util.Optional;


@Repository
public interface ForkRepository extends PagingAndSortingRepository<Fork, Long>, JpaSpecificationExecutor<Fork> {

    boolean existsByProductId (String productId);

    Optional<Fork> findByProductId (String productId);

}
