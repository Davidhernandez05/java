package com.primerapirest.primerapirest.services;

import com.primerapirest.primerapirest.entities.Product;
import com.primerapirest.primerapirest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
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
  public Optional<Product> update(Integer id, Product product) {
    // Buscamos el ID del producto.
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isPresent()){ // Cuando queremos retornar algo lo mejor es utilizar el if.
      // Guardamos ese producto en nuestra variable en caso de que no exista se maneja el error.
      Product productBD = optionalProduct.orElseThrow();

      // Agregamos los nuevos valores:
      productBD.setName(product.getName());
      productBD.setDescription(product.getDescription());
      productBD.setPrice(product.getPrice());

      System.out.println("Se actualizo correctamente el producto.");

      // Guardamos los nuevos valores en nuestra BD.
      return Optional.of(productRepository.save(productBD));
    }
    return optionalProduct;
  }

  @Transactional
  @Override
  public Optional<Product> delete(Integer id) {
    // Sacamos él, id del producto que enviamos como parameter.
    Optional<Product> optionalProduct = productRepository.findById(id);
    optionalProduct.ifPresentOrElse(product -> {
      productRepository.delete(product);
      System.out.println("Se eliminó correctamente el producto.");
      }, () -> System.out.println("No se encontró el producto."));

    return optionalProduct;
  }

}
