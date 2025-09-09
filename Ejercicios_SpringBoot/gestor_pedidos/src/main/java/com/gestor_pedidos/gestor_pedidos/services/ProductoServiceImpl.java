package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.Producto;
import com.gestor_pedidos.gestor_pedidos.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{

  @Autowired
  private ProductoRepository productoRepository;

  @Transactional(readOnly = true)
  @Override
  public List<Producto> findAll() {
    return (List<Producto>) productoRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public ResponseEntity<?> findByProduct(Integer id) {
    Optional<Producto> optionalProducto = productoRepository.findById(id);

    if (optionalProducto.isPresent()) {
      Producto producto = optionalProducto.get();
      return ResponseEntity.ok().body(producto);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mesanje: ", "No se encontró ningún producto con el id: " + id));
  }

  @Transactional
  @Override
  public ResponseEntity<?> save(Producto producto) {
    return ResponseEntity.ok().body(productoRepository.save(producto));
  }

  @Transactional
  @Override
  public ResponseEntity<?> update(Integer id, Producto producto) {
    Optional<Producto> optionalProducto = productoRepository.findById(id);

    if (optionalProducto.isPresent()) {
      Producto productoDB = optionalProducto.get();

      productoDB.setName(producto.getName());
      productoDB.setPrice(producto.getPrice());
      productoDB.setStock(producto.getStock());

      return ResponseEntity.ok().body(productoRepository.save(productoDB));
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontro ningun producto con el id: " + id));
  }

  @Transactional
  @Override
  public ResponseEntity<?> delete(Integer id) {
    Optional<Producto> optionalProducto = productoRepository.findById(id);

    if (optionalProducto.isPresent()) {
      Producto producto = optionalProducto.get();
      productoRepository.delete(producto);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("Mensaje: ", "Se elimino correctamente el producto con el id: " + id));
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún producto con el id: " + id));
  }
}
