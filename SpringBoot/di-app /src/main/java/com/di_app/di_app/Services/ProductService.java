package com.di_app.di_app.Services;

import com.di_app.di_app.Models.Product;
import com.di_app.di_app.Repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProductService {

  // El service es donde trabajamos con los datos.

  private ProductRepository repository = new ProductRepository();

  @Override
  public List<Product> findAll() {
    // Aquí estamos modificando el precio de nuestros productos.
    return repository.findAll().stream().map(p -> {
      Double priceTax = p.getPrice() * 1.25d;
      //Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());  //Esto hace que cumplamos con el principio de inmutabilidad.
      Product newProd = (Product) p.clone();
      newProd.setPrice(priceTax.longValue());
      return  newProd;
    }).collect(Collectors.toList());
  }

  public Product findId(Long id) {
    return repository.findId(id);
  }
}
