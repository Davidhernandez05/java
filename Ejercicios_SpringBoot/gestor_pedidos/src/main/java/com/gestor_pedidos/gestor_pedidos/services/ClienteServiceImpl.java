package com.gestor_pedidos.gestor_pedidos.services;

import com.gestor_pedidos.gestor_pedidos.entities.Cliente;
import com.gestor_pedidos.gestor_pedidos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Cliente> findAll() {
    return (List<Cliente>) clienteRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public ResponseEntity<?> findByClient(Integer id) {
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);

    if (optionalCliente.isPresent()) {
      Cliente cliente = optionalCliente.get();
      return ResponseEntity.ok().body(cliente);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No existe ningún cliente con el id: " + id));
  }

  @Override
  @Transactional
  public ResponseEntity<?> save(Cliente cliente) {
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
  }

  @Override
  @Transactional
  public ResponseEntity<?> update(Integer id, Cliente cliente) {
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);

    if (optionalCliente.isPresent()) {
      Cliente clienteDB = optionalCliente.get();
      clienteDB.setName(cliente.getName());
      clienteDB.setEmail(cliente.getEmail());

      return ResponseEntity.ok().body(clienteRepository.save(clienteDB));
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún cliente con el id: " + id));
  }

  @Override
  @Transactional
  public ResponseEntity<?> delete(Integer id) {
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);

    if (optionalCliente.isPresent()) {
      Cliente cliente = optionalCliente.get();
      clienteRepository.delete(cliente);

      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("Mensaje: ", "Se elimino correctamente al cliente con id: " + id));
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ",
        String.format("No se encontró ningún cliente con el id: %d por lo cual no es posible eliminarlo.", id)));
  }
}
