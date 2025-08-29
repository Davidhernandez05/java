package com.gestor_pedidos.gestor_pedidos.repositories;

import com.gestor_pedidos.gestor_pedidos.entities.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
}
