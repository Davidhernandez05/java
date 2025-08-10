package com.relationship.jpa_relationship.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private String lastname;

  // Creamos la tabla intermedia con sus respectivas columnas.
  // @JoinTable(
  //     name = "tbl_clientes_to_direcciones", // -> Le ponemos nombre a la tabla intermedia.
  //     joinColumns = @JoinColumn(name = "id_clientes"), // -> Nombremos la columna de nuestra primera tabla. -> Él, Id se puede repetir.
  //     inverseJoinColumns = @JoinColumn(name = "id_direcciones"), // -> Nombramos la columna de nuestra segunda tabla. -> Él, Id no se puede repetir
  //     uniqueConstraints = @UniqueConstraint(columnNames = {"id_direcciones"}) // -> Le decimos que los IDs de la segunda tabla deben de ser unicos.
  // )
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemoval = true -> Hace que se eliminen las direcciones huérfanas.
  private Set<Address> addresses;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client") // Así se estructura una relación inversa.
  protected Set<Invoice> invoices;

  public Client() {
    addresses = new HashSet<>();
    invoices = new HashSet<>();
  }

  public Client(String name, String lastname) {
    this(); // Esto llama al constructor vacío.
    this.setName(name);
    this.setLastname(lastname);
  }

  public Integer getId() {  return id;  }
  public String getName() { return name;  }
  public String getLastname() { return lastname;  }
  public Set<Address> getAddresses() { return addresses; }
  public Set<Invoice> getInvoices() {  return invoices;  }

  public void setName(String name) {  this.name = name; }
  public void setLastname(String lastname) {  this.lastname = lastname; }
  public void setAddresses(Set<Address> addresses) { this.addresses = addresses; }
  public void setInvoices(Set<Invoice> invoices) { this.invoices = invoices; }


  public void addInvoice(Invoice invoice) {
    invoices.add(invoice);
    invoice.setClient(this);
  }

  public void removeInvoice(Invoice invoice) {
    this.getInvoices().remove(invoice);
    invoice.setClient(null);
  }

  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", name:'" + name + '\'' +
        ", lastname:'" + lastname + '\'' +
        ", addresses:'" + addresses + '\'' +
        ", facturas:'" + invoices + '\'' +
        '}';
  }
}
