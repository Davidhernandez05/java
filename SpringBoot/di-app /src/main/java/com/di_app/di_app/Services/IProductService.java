package com.di_app.di_app.Services;

import com.di_app.di_app.Models.Product;

import java.util.List;
import java.util.stream.Collectors;

public interface IProductService {

  List<Product> findAll();
  Product findId(Long id);
}
