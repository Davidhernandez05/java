package com.gestor_pedidos.gestor_pedidos.controllers;


import com.gestor_pedidos.gestor_pedidos.services.PedidosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
