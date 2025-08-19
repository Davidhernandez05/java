package com.gestor_productos.gestor_productos.repositories;

import com.gestor_productos.gestor_productos.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
