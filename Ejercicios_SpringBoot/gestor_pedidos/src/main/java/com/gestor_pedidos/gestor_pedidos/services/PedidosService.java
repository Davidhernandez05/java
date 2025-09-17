package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.Pedido;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidosService {

  ResponseEntity<?> findAll();
  ResponseEntity<?> findByPedido(Integer id);

  ResponseEntity<?> save(Pedido pedido, Integer id);
  ResponseEntity<?> update(Integer id, Pedido pedido);
  ResponseEntity<?> delete(Integer id);
}
