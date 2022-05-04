package com.exercise.dealersolution.repository;

import com.exercise.dealersolution.model.ProductEntity;
import com.exercise.dealersolution.model.ProductSaida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductSaida> findByStatus(Long s);

    List<ProductSaida> findAllByOrderByDeadlineAsc();

    List<ProductSaida> findAllByOrderByQuantityAsc();

    List<ProductSaida> findAllByOrderByPriceAsc();
}
