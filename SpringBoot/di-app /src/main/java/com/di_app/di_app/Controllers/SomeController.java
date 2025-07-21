package com.di_app.di_app.Controllers;

import com.di_app.di_app.Models.Product;
import com.di_app.di_app.Repositories.ProductRepository;
import com.di_app.di_app.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

  private final ProductService service = new ProductService();

  @GetMapping
  public List<Product> list() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Product show(@PathVariable Long id) {
    return service.findId(id);
  }

}
