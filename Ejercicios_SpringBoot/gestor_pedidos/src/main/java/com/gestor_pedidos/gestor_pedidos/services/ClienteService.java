package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

  List<Cliente> findAll();
  ResponseEntity<?> findByClient(Integer id);

  ResponseEntity<?> save(Cliente cliente);
  ResponseEntity<?> update(Integer id, Cliente cliente);
  ResponseEntity<?> delete(Integer id);
}
