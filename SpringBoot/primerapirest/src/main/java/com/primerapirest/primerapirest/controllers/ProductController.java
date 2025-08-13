package com.primerapirest.primerapirest.controllers;


import com.primerapirest.primerapirest.entities.Product;
import com.primerapirest.primerapirest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService service;

  @GetMapping
  public List<Product> list() {
    return service.findAll(); // Listamos todos los productos de la BD.
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> view(@PathVariable Integer id) {
    Optional<Product> optionalProduct = service.finfById(id); // Buscamos el producto por el ID.

    if (optionalProduct.isPresent()) {
      // Si el producto existe retornamos un status ok y el producto lo imprimimos.
      return ResponseEntity.ok(optionalProduct.orElseThrow());
    }
    // Si no existe el producto retorna un estatus norFound
    return ResponseEntity.notFound().build();
  }

  @PostMapping()
  public ResponseEntity<Product> create(@RequestBody Product product) {
    //RequestBody -> para leer datos de un Json e insertarlos en product
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product)); // Crea el nuevo producto con los datos en json.
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product) {

    Optional<Product> productOptional = service.update(id, product);
    if (productOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(productOptional.orElseThrow());
    }

    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    Product product = new Product();
    product.setId(id);

    Optional<Product> optionalProduct = service.delete(id);

    if (optionalProduct.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(optionalProduct.orElseThrow());
    }
    return ResponseEntity.notFound().build();

  }
}
