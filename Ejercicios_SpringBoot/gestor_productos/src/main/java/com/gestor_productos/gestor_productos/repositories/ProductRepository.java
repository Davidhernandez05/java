package com.gestor_productos.gestor_productos.repositories;

import com.gestor_productos.gestor_productos.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {

  @Query("SELECT p FROM Product p WHERE p.id = :id")
  Product getProductFindById(@Param("id")Integer id);

}
