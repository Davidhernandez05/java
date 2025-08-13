package com.primerapirest.primerapirest.services;

import com.primerapirest.primerapirest.entities.Product;
import com.primerapirest.primerapirest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // Componente Spring que se encarga de la logic.
public class ProducServiceImp implements ProductService{

  @Autowired
  private ProductRepository productRepository;

  @Transactional(readOnly = true)
  @Override
  public List<Product> findAll() {
    return (List<Product>) productRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<Product> finfById(Integer id) {
    return productRepository.findById(id);
  }

  @Transactional
  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Transactional
  @Override
  public Optional<Product> delete(Product product) {
    // Sacamos él, id del producto que enviamos como parameter.
    Optional<Product> optionalProduct = productRepository.findById(product.getId());
    optionalProduct.ifPresentOrElse(product1 -> {

      productRepository.delete(product);
      System.out.println("Se eliminó correctamente el producto.");
      }, () -> System.out.println("No se encontró el producto."));

    return optionalProduct;
  }

}
