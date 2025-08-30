package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.DetallesPedido;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DetallesService {

  List<DetallesPedido> findAll();
  ResponseEntity<?> findByDetalles(Integer id);


}
