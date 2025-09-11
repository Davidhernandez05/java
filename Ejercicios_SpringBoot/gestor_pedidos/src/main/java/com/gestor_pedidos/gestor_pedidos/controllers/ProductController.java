package com.gestor_pedidos.gestor_pedidos.controllers;

import com.gestor_pedidos.gestor_pedidos.entities.Producto; 
import com.gestor_pedidos.gestor_pedidos.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  private ProductoServiceImpl productoService;

  @GetMapping()
  public List<Producto> productos() {
    return productoService.findAll();
  }
}
