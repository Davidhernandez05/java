package com.gestor_productos.gestor_productos.repositories;

import com.gestor_productos.gestor_productos.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

  //@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Category c Where c.name = :category")
  //Boolean existsByCategory(@Param("category") String category);

  @Query("SELECT c FROM Category c Where c.id = :id")
  Category getCategoryFindById(@Param("id") Integer id);
}
