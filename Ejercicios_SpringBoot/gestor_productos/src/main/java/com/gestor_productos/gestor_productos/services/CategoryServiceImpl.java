package com.gestor_productos.gestor_productos.services;

import com.gestor_productos.gestor_productos.entities.Category;
import com.gestor_productos.gestor_productos.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> findAll() {
    return (List<Category>) categoryRepository.findAll();
  }

  @Override
  public ResponseEntity<?> findById(Integer id) {
    return null;
  }

  @Override
  public ResponseEntity<?> save(Category category) {
    Optional<Category> optionalCategory = Optional.of(categoryRepository.save(category));

    if (optionalCategory.isPresent()) {
      return ResponseEntity.status(HttpStatus.CREATED).body(optionalCategory);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No fue posible guardar la categoria."));
  }

  @Override
  public ResponseEntity<?> update(Integer id, Category category) {
    return null;
  }

  @Override
  public ResponseEntity<?> delete(Integer id) {
    Optional<Category> optionalCategory = categoryRepository.findById(id);

    if (optionalCategory.isPresent()){

      Category category = optionalCategory.get();
      categoryRepository.delete(category);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("Mensaje: ", "Se elimino correctamente el id: " + id));

    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ninguna categoria con el id: " + id));
  }
}
