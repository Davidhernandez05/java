package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.Pedido;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidosService {

  List<Pedido> findAll();
  ResponseEntity<?> findByPedido(Integer id);

  ResponseEntity<?> save(Pedido pedido);
  ResponseEntity<?> update(Integer id, Pedido pedido);
  ResponseEntity<?> delete(Integer id);
}
