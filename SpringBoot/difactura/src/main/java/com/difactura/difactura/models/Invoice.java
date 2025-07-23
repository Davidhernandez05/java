package com.difactura.difactura.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoice {
  @Autowired
  private Client client;

  @Value("${invoice.description}")
  private String description;

  @Autowired
  private List<Item> items;

  //Getters:
  public Client getClient() { return client;  }
  public List<Item> getItems() {  return items; }
  public String getDescription() {  return description; }

  //Setters:
  public void setClient(Client client) {  this.client = client; }
  public void setDescription(String description) {  this.description = description; }
  public void setItems(List<Item> items) {  this.items = items; }

  public Integer getTotalInvoice() {
    //Integer totalInvoice = 0;
    //for (Item item : items) {
    //  totalInvoice += item.getTotal();
    //}

    return items.stream()
        .map(Item::getTotal)
        .reduce(0, Integer::sum);
  }
}
