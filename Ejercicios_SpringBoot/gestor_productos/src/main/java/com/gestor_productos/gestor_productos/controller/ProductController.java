package com.gestor_productos.gestor_productos.controller;

import com.gestor_productos.gestor_productos.entities.Product;
import com.gestor_productos.gestor_productos.repositories.ProductRepository;
import com.gestor_productos.gestor_productos.services.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  private ProductServiceImpl productService;

  @Autowired
  private ProductRepository productRepository;


  @GetMapping
  public List<Product> listProducts() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> productById(@PathVariable Integer id){

    Product product = productRepository.getProductFindById(id);
    return productService.convertToDto(product, id);
  }

  @PostMapping("/{id}")
  public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product, BindingResult result, @PathVariable Integer id){
    //BindingResult result -> Tiene que ir después del valor que se va a validar.
    if (result.hasFieldErrors()) {
      return validation(result);
    }
    return ResponseEntity.ok().body(productService.save(product, id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product, @PathVariable Integer id) {
    return productService.update(product, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
    return productService.dalete(id);
  }

  // Ajustamos el mensaje de error para que lo imprimamos como deseamos al usuario.
  private ResponseEntity<?> validation(BindingResult result) {
    Map<String, String> errors = new HashMap<>();

    result.getFieldErrors().forEach(error -> {
      errors.put(error.getField(), error.getDefaultMessage()); // Mensaje que se va a enviar.
    });

    return ResponseEntity.badRequest().body(errors);
  }
}
