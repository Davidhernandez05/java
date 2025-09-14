package com.gestor_pedidos.gestor_pedidos.controllers;

import com.gestor_pedidos.gestor_pedidos.entities.Producto;
import com.gestor_pedidos.gestor_pedidos.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class productController {

  @Autowired
  private ProductoServiceImpl productoService;

  @GetMapping()
  public List<Producto> productos() {
    return productoService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findProduct(@PathVariable Integer id) {
    return productoService.findByProduct(id);
  }

  @PostMapping
  public ResponseEntity<?> createProduct(@RequestBody Producto producto) {
    return productoService.save(producto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
    return productoService.delete(id);
  }


  @PutMapping("/{id}")
  public ResponseEntity<?> updateProduct(@RequestBody Producto producto, @PathVariable Integer id) {
    return productoService.update(id, producto);
  }
}
