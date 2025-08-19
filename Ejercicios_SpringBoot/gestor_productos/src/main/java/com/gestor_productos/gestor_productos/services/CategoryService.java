package com.gestor_productos.gestor_productos.services;

import com.gestor_productos.gestor_productos.entities.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

  List<Category> findAll();
  ResponseEntity<?> findById(Integer id);

  ResponseEntity<?> save(Category category); // Se trae el JSON que envía el usuario.
  ResponseEntity<?> update(Integer id, Category category);
  ResponseEntity<?> delete(Integer id);
}
