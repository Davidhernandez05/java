package com.gestor_pedidos.gestor_pedidos.repositories;

import com.gestor_pedidos.gestor_pedidos.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
