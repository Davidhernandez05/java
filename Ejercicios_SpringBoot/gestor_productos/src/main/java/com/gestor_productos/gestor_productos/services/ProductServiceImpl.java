package com.gestor_productos.gestor_productos.services;

import com.gestor_productos.gestor_productos.entities.Category;
import com.gestor_productos.gestor_productos.entities.Product;
import com.gestor_productos.gestor_productos.repositories.CategoryRepository;
import com.gestor_productos.gestor_productos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public List<Product> findAll() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  public ResponseEntity<?> findById(Integer id) {
    return null;
  }

  @Override
  public ResponseEntity<?> save(Product product, Integer id) {
    Optional<Category> optionalCategory = categoryRepository.findById(id);

    if (optionalCategory.isPresent()) {

      Category category = optionalCategory.get();
      category.getProduct().add(product);

      product.setCategory(category);
      Category categoryDb = categoryRepository.save(category);
      return ResponseEntity.status(HttpStatus.CREATED).body(categoryDb);

    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje:", "No se encontró ninguna categoria con el ID: " + id + "Por favor crearla para agregar el producto."));
  }

  @Override
  public ResponseEntity<?> update(Product product, Integer id) {
    return null;
  }

  @Override
  public ResponseEntity<?> dalete(Integer id) {
    return null;
  }
}
