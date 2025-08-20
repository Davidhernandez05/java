package com.gestor_productos.gestor_productos.repositories;

import com.gestor_productos.gestor_productos.entities.Product;
import com.gestor_productos.gestor_productos.services.ProductServiceImpl;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
