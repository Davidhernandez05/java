package com.di_app.di_app.Services;

import com.di_app.di_app.Models.Product;
import com.di_app.di_app.Repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

  // El service es donde trabajamos con los datos.

  private ProductRepository repository = new ProductRepository();

  public List<Product> findAll() {
    // Aquí estamos modificando el precio de nuestros productos.
    return repository.findAll().stream().map(p -> {
      Double priceImp = p.getPrice() * 1.25d;
      return new Product(p.getId(), p.getName(), priceImp.longValue()); //Esto hace que cumplamos con el principio de inmutabilidad.
    }).collect(Collectors.toList());
  }

  public Product findId(Long id) {
    return repository.findId(id);
  }
}
