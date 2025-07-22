package com.di_app.di_app.Repositories;

import com.di_app.di_app.Models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Primary //Hace que sea el repositorio por defecto o como el principal que va a tomar el app.
public class ProductRepositoryFoo implements IProductRepository{

  @Override
  public List<Product> findAll() {
    return Collections.singletonList(new Product(1L, "monitor asus", 600L));
  }

  @Override
  public Product findId(Long id) {
    return new Product(id, "monitor asus", 600L);
  }
}
