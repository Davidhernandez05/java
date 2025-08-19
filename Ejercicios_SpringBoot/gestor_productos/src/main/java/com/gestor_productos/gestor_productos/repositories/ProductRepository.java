package com.gestor_productos.gestor_productos.repositories;

import com.gestor_productos.gestor_productos.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
