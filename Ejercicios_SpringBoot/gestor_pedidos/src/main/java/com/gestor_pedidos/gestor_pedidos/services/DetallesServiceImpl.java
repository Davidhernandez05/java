package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.DetallesPedido;
import com.gestor_pedidos.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.gestor_pedidos.repositories.DetalleRepository;
import com.gestor_pedidos.gestor_pedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DetallesServiceImpl implements DetallesService{

  @Autowired
  private DetalleRepository detalleRepository;

  @Autowired
  private PedidoRepository pedidoRepository;

  @Override
  public ResponseEntity<?> findAll() {
    List<DetallesPedido> detallesPedidoList = (List<DetallesPedido>) detalleRepository.findAll();

    if (detallesPedidoList.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún detalle en la Base de Datos."));
    }

    return ResponseEntity.ok().body(detallesPedidoList);
  }

  @Override
  public ResponseEntity<?> findByDetalles(Integer id) {
    return null;
  }

  @Override
  public ResponseEntity<?> saveDetails(DetallesPedido detallesPedido, Integer idPedido) {
    Optional<Pedido> optionalPedido = pedidoRepository.findById(idPedido);

    if (optionalPedido.isPresent()) {
      return ResponseEntity.ok().body(detalleRepository.save(detallesPedido));
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún pedido con el id: " + idPedido));
  }

  @Override
  public ResponseEntity<?> deleteDetails(Integer id) {
    return null;
  }

  @Override
  public ResponseEntity<?> updateDetails(DetallesPedido detallesPedido, Integer id) {
    return null;
  }
}
