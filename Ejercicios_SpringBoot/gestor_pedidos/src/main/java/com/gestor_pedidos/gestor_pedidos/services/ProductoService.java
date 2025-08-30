package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.Producto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductoService {

  List<Producto> findAll();
  ResponseEntity<?> findByProduct(Integer id);

  ResponseEntity<?> save(Producto producto);
  ResponseEntity<?> update(Integer id, Producto producto);
  ResponseEntity<?> delete(Integer id);
}
