package com.primerapirest.primerapirest.repositories;

import com.primerapirest.primerapirest.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

  boolean existsBySku(String sku);
}
