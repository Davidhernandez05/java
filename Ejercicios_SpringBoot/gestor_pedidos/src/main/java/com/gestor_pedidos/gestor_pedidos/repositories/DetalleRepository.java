package com.gestor_pedidos.gestor_pedidos.repositories;

import com.gestor_pedidos.gestor_pedidos.entities.DetallesPedido;
import org.springframework.data.repository.CrudRepository;

public interface DetalleRepository extends CrudRepository<DetallesPedido, Integer> {
}
