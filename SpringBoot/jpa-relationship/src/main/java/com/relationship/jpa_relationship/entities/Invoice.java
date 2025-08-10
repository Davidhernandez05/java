package com.relationship.jpa_relationship.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "invoice")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String description;
  private Integer total;

  @ManyToOne
  @JoinColumn(name = "client_id") // Nombre de la llave foránea. -> Es la dueña de la relación.
  //@JoinColumn(name = "cliente_id") -> Nos permite personalizar el nombre de la llave foránea en caso de que no exista la tabla.
  private Client client; // De forma automática va a tomar el nombre de client_id

  public Invoice() {
  }

  public Invoice(String description, Integer total){
    this.setDescription(description);
    this.setTotal(total);
  }


  public Integer getId() {  return id;  }
  public String getDescription() {  return description; }
  public Integer getTotal() { return total; }
  public Client getClient() { return client;  }

  public void setDescription(String description) {  this.description = description; }
  public void setTotal(Integer total) { this.total = total; }
  public void setClient(Client client) {  this.client = client; }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Invoice invoice = (Invoice) o;
    return Objects.equals(id, invoice.id) && Objects.equals(description, invoice.description) && Objects.equals(total, invoice.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, total);
  }

  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", description:'" + description + '\'' +
        ", total:" + total +
        '}';
  }
}
