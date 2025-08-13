package com.primerapirest.primerapirest.services;

import com.primerapirest.primerapirest.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

  List<Product> findAll();
  Optional<Product> finfById(Integer id);

  Product save(Product product);
  Optional<Product> delete(Product product);
}
