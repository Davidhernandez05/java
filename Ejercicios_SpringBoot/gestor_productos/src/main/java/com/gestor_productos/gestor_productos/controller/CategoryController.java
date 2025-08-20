package com.gestor_productos.gestor_productos.controller;

import com.gestor_productos.gestor_productos.entities.Category;
import com.gestor_productos.gestor_productos.services.CategoryService;
import com.gestor_productos.gestor_productos.services.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

  @Autowired
  private CategoryServiceImpl categoryService;

  @GetMapping()
  public List<Category> list() {
    return categoryService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Integer id) {
    return categoryService.findById(id);
  }

  @PostMapping()
  public ResponseEntity<?> saveCategory(@Valid @RequestBody Category category) {
    return categoryService.save(category);
  }


  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
    return categoryService.delete(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateCategory(@Valid @RequestBody Category category, @PathVariable Integer id) {
    return categoryService.update(id, category);
  }

}
