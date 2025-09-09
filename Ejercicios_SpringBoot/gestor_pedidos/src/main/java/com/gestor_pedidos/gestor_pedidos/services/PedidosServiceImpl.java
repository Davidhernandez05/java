package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.gestor_pedidos.repositories.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PedidosServiceImpl implements PedidosService{

  private PedidoRepository pedidoRepository;

  @Transactional(readOnly = true)
  @Override
  public List<Pedido> findAll() {
    return (List<Pedido>) pedidoRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public ResponseEntity<?> findByPedido(Integer id) {

    Optional<Pedido> optionalPedido = pedidoRepository.findById(id);

    if (optionalPedido.isPresent()) {
      Pedido pedido = optionalPedido.get();

      return ResponseEntity.ok().body(pedido);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontro ningun pedido con el id: " + id));
  }

  @Override
  public ResponseEntity<?> save(Pedido pedido) {
    return ResponseEntity.ok().body(pedidoRepository.save(pedido));
  }

  @Override
  public ResponseEntity<?> update(Integer id, Pedido pedido) {
    return null;
  }

  @Override
  public ResponseEntity<?> delete(Integer id) {
    Optional<Pedido> optionalPedido = pedidoRepository.findById(id);

    if (optionalPedido.isPresent()) {
      Pedido pedido = optionalPedido.get();
      pedidoRepository.delete(pedido);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("Mensaje: ", "Se elimino correctamente el pedido con id: " + id));
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún pedido con el id: " + id));
  }
}
