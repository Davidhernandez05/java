package com.difactura.difactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Component //Los usuarios comparten los cambios.
@RequestScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {
  @Autowired
  private Client client;

  @Value("${invoice.description.Office}")
  private String description;

  //@Qualifier("default")
  @Autowired
  private List<Item> items;

  //Ciclo de vida:
  @PostConstruct
  public void init() {
    // Nos permite hacer modificaciones antes de que se cree la beans.
    System.out.println("Creando el componente de la factura.");
    client.setName(client.getName().concat(" Pepe"));
    description = description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLastname());
  }

  @PreDestroy
  public void destroy() {
    //Nos permite hacer una acción después de que se cierre o destruya en beans.
    System.out.println("Destruyendo el componente o bean invoice");
  }

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
