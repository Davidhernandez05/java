package com.gestor_pedidos.gestor_pedidos.controllers;


import com.gestor_pedidos.gestor_pedidos.entities.DetallesPedido;
import com.gestor_pedidos.gestor_pedidos.services.DetallesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/details")
public class DetailsController {

  @Autowired
  private DetallesServiceImpl detallesService;

  @GetMapping()
  public ResponseEntity<?> viewAllDetails() {
    return detallesService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findDetailsById(@PathVariable Integer id) {
    return detallesService.findByDetalles(id);
  }

  @PostMapping("/{id}")
  public ResponseEntity<?> savedetail(@RequestBody DetallesPedido detail, @PathVariable Integer id) {
    return detallesService.saveDetails(detail, id);
  }

  
}
