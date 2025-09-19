package com.gestor_pedidos.gestor_pedidos.controllers;


import com.gestor_pedidos.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.gestor_pedidos.services.PedidosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido")
public class OrderController {

  @Autowired
  private PedidosServiceImpl pedidosService;

  @GetMapping()
  public ResponseEntity<?> allOrders() {
    return pedidosService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findOrderById(@PathVariable Integer id) {
    return pedidosService.findByPedido(id);
  }

  @PostMapping("/{id}")
  public ResponseEntity<?> saveOrder(@RequestBody Pedido pedido, @PathVariable Integer id) {
    return pedidosService.save(pedido, id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateOrder(@RequestBody Pedido pedido, @PathVariable Integer id) {
    return pedidosService.update(id, pedido);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
    return pedidosService.delete(id);
  }
}
