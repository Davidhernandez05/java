package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.DetallesPedido;
import org.springframework.http.ResponseEntity;

public interface DetallesService {

  ResponseEntity<?> findAll();
  ResponseEntity<?> findByDetalles(Integer id);

  ResponseEntity<?> saveDetails(DetallesPedido detallesPedido, Integer idPedido);
  ResponseEntity<?> deleteDetails(Integer id);
  ResponseEntity<?> updateDetails(DetallesPedido detallesPedido, Integer id);

}
