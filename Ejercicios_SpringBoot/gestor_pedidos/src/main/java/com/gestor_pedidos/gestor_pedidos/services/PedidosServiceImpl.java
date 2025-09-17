package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.Cliente;
import com.gestor_pedidos.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.gestor_pedidos.repositories.ClienteRepository;
import com.gestor_pedidos.gestor_pedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PedidosServiceImpl implements PedidosService{

  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Transactional(readOnly = true)
  @Override
  public ResponseEntity<?> findAll() {
    List<Pedido> pedidoList = (List<Pedido>) pedidoRepository.findAll();

    if (pedidoList.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No hay ningún pedido en la Base de Datos."));
    }

    return ResponseEntity.ok().body(pedidoList);
  }

  @Transactional(readOnly = true)
  @Override
  public ResponseEntity<?> findByPedido(Integer id) {

    Optional<Pedido> optionalPedido = pedidoRepository.findById(id);

    if (optionalPedido.isPresent()) {
      Pedido pedido = optionalPedido.get();

      return ResponseEntity.ok().body(pedido);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún pedido con el id: " + id));
  }

  @Override
  public ResponseEntity<?> save(Pedido pedido, @PathVariable Integer id) {
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);

    if (optionalCliente.isPresent()) {
      return ResponseEntity.ok().body(pedidoRepository.save(pedido));
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontro ningun cliente con el id: " + id));
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
