package com.primerapirest.primerapirest.controllers;


import com.primerapirest.primerapirest.ProductValidation;
import com.primerapirest.primerapirest.entities.Product;
import com.primerapirest.primerapirest.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService service;

  // Esta es una forma:
  //@Autowired
  //private ProductValidation validation;

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
  public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result) {
    //validation.validate(product, result);
    // Validamos si ocurrió algún error.
    if (result.hasFieldErrors()) {
      return validation(result);
    }
    //RequestBody -> para leer datos de un Json e insertarlos en product
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product)); // Crea el nuevo producto con los datos en json.
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@Valid @RequestBody Product product, BindingResult result,  @PathVariable Integer id) {
    //validation.validate(product, result);
    if (result.hasFieldErrors()) {
      return validation(result);
    }

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

  // Nos retorna un mensaje para el usuario en caso de que se genere algún error al momento de ingresar los datos.
  private ResponseEntity<?> validation(BindingResult result) {
    Map<String, String> errors = new HashMap<>();

    result.getFieldErrors().forEach(error -> {
      errors.put(error.getField(), "El campo: " + error.getField() + " " + error.getDefaultMessage());

      // error.getField() -> Nos da el nombre del campo.
      // error.getDefaultMessage() -> Nos da el mensaje de error.
    });

    return ResponseEntity.badRequest().body(errors);
  }
}
