package com.gestor_productos.gestor_productos.services;

import com.gestor_productos.gestor_productos.dto.ProductDto;
import com.gestor_productos.gestor_productos.entities.Category;
import com.gestor_productos.gestor_productos.entities.Product;
import com.gestor_productos.gestor_productos.repositories.CategoryRepository;
import com.gestor_productos.gestor_productos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  CategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  @Override
  public List<Product> findAll() {
    return (List<Product>) productRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public ResponseEntity<?> findById(Integer id) {
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isPresent()) {

      Product product = optionalProduct.get();
      return ResponseEntity.ok().body(product);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún producto con el ID: " + id));
  }

  @Transactional
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

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje:", "No se encontró ninguna categoria con el ID: " + id + ", Por favor crearla para agregar el producto."));
  }

  @Transactional
  @Override
  public ResponseEntity<?> update(Product product, Integer id) {
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isPresent()) {
      Product productDb = optionalProduct.get();

      productDb.setName(product.getName());
      productDb.setPrice(product.getPrice());
      productDb.setStock(product.getStock());

      productRepository.save(productDb);
      return ResponseEntity.ok().body(productDb);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún producto con el ID: " + id));
  }

  @Transactional
  @Override
  public ResponseEntity<?> dalete(Integer id) {
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isPresent()) {
      Product product = optionalProduct.get();
      productRepository.delete(product);

      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("Mensaje: ", "Se elimino correctamente el ID: " + id));
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún producto con el ID: " + id));
  }

  @Transactional(readOnly = true)
  public ResponseEntity<?> convertToDto(Product product, Integer id) {

    if (product == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún producto con el ID: " + id));
    }

    ProductDto dto = new ProductDto();
    dto.setId(product.getId());
    dto.setName(product.getName());
    dto.setPrice(product.getPrice());

    return ResponseEntity.ok(dto);
  }
}
