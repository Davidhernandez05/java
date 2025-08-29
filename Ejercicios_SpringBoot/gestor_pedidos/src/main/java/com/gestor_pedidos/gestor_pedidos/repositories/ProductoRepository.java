package com.gestor_pedidos.gestor_pedidos.repositories;

import com.gestor_pedidos.gestor_pedidos.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
}
