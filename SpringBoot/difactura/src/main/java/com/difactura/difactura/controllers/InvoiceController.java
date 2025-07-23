package com.difactura.difactura.controllers;

import com.difactura.difactura.models.Client;
import com.difactura.difactura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {


  @Autowired
  private Invoice invoice;

  @GetMapping("/show")
  public Invoice show() {
    Invoice i = new Invoice();
    Client c = new Client();

    //Con esto ya no tenemos que hacer el @JsonIgnoreProperties porque nos quita directamente el proxy de usuario.
    c.setLastname(invoice.getClient().getLastname());
    c.setName(invoice.getClient().getName());

    i.setClient(c);
    i.setDescription(invoice.getDescription());
    i.setItems(invoice.getItems());

    return i;
  }
}
