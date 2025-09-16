package com.gestor_pedidos.gestor_pedidos.controllers;

import com.gestor_pedidos.gestor_pedidos.entities.Producto;
import com.gestor_pedidos.gestor_pedidos.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class productController {

  @Autowired
  private ProductoServiceImpl productoService;

  @GetMapping()
  public ResponseEntity<?> productos() {

    List<Producto> productoList = productoService.findAll();
    if (productoList.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No hay ningún producto en la Base de datos actualmente."));
    }

    return ResponseEntity.ok().body(productoList);
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
