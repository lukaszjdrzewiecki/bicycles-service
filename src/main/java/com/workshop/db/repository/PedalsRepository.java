package com.workshop.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.workshop.db.entity.Pedals;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "pedals", path = "pedals")
public interface PedalsRepository extends PagingAndSortingRepository<Pedals, Long> {

    boolean existsByProductId (String productId);

    Optional <Pedals> findByProductId (String productId);
}
