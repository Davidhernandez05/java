package com.gestor_productos.gestor_productos.services;

import com.gestor_productos.gestor_productos.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

  List<Product> findAll();
  ResponseEntity<?> findById(Integer id);

  ResponseEntity<?> save(Product product, Integer id); // Traemos el JSON que envía el usuario y el ID de la categoria para su creación o agregación a esta categoria.
  ResponseEntity<?> update(Product product, Integer id);
  ResponseEntity<?> dalete(Integer id);


}
