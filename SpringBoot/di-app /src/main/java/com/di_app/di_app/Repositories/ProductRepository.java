package com.di_app.di_app.Repositories;

import com.di_app.di_app.Models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements IProductRepository {
  // En el repository es donde obtenemos los datos leemos los datos o guardamos los datos, los persistimos.

  private List<Product> data;

  public ProductRepository() {
    this.data = Arrays.asList(
        new Product(1L, "Memoria", 300L),
        new Product(2L, "CPU", 850L),
        new Product(3L, "Teclado Razer Mini", 180L),
        new Product(4L, "PC Gaming", 1000L)
    );
  }

  //Regresamos todos los productos que se encuentran en nuestra lista.
  @Override
  public List<Product> findAll() {
    return data;
  }

  //Buscamos un producto por el ID.
  @Override
  public Product findId(Long id) {
    return data.stream()
        .filter(product -> product.getId().equals(id))
        .findFirst().orElse(null); // Le decimos que si no lo encuentra retorne un null.
  }
}
