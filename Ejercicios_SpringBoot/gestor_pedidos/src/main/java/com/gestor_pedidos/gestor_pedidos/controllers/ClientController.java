package com.gestor_pedidos.gestor_pedidos.controllers;

import com.gestor_pedidos.gestor_pedidos.entities.Cliente;
import com.gestor_pedidos.gestor_pedidos.services.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
public class ClientController {

  private ClienteServiceImpl clienteService;

  @GetMapping
  public ResponseEntity<?> allClient() {

    List<Cliente> clienteList = clienteService.findAll();

    if (clienteList.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No hay ningún cliente en la base de datos."));
    }

    return ResponseEntity.ok().body(clienteList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findClientId(@PathVariable Integer id) {
    return clienteService.findByClient(id);
  }
}
