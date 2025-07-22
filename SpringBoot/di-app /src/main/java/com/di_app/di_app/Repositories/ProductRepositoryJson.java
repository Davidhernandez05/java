package com.di_app.di_app.Repositories;

import com.di_app.di_app.Models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements IProductRepository{

  private List<Product> list;

  public ProductRepositoryJson(Resource resource) {
    //Resource resource = new ClassPathResource("json/product.json"); // Nos permite leer un archivo JSON.
    readValueJson(resource);
  }

  public ProductRepositoryJson() {
    Resource resource = new ClassPathResource("json/product.json"); // Nos permite leer un archivo JSON.
    readValueJson(resource);
  }

  private void readValueJson(Resource resource) {
    ObjectMapper objectMapper = new ObjectMapper(); //Lo lee como un recurso.
    try {
      list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class)); // Convertimos el archivo a un list.
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public List<Product> findAll() {
    return list;
  }

  @Override
  public Product findId(Long id) {
    return list.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
  }
}
