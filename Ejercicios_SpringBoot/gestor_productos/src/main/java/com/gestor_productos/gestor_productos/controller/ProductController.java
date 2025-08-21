package com.gestor_productos.gestor_productos.controller;

import com.gestor_productos.gestor_productos.entities.Product;
import com.gestor_productos.gestor_productos.services.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  private ProductServiceImpl productService;


  @GetMapping
  public List<Product> listProducts() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> productById(@PathVariable Integer id){
    return productService.findById(id);
  }

  @PostMapping("/{id}")
  public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product, @PathVariable Integer id){
    return productService.save(product, id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product, @PathVariable Integer id) {
    return productService.update(product, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
    return productService.dalete(id);
  }
}
