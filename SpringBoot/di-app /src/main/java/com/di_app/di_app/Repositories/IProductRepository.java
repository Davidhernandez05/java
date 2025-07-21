package com.di_app.di_app.Repositories;

import com.di_app.di_app.Models.Product;

import java.util.List;

public interface IProductRepository {
  List<Product> findAll();
  Product findId(Long id);
}
