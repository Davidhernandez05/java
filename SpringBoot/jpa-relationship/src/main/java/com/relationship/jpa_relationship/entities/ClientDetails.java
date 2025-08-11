package com.relationship.jpa_relationship.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "client_details")
public class ClientDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Boolean premium;
  private Integer points;

  @OneToOne
  @JoinColumn(name = "id_client") // Clase hija pero dueña de la relación.
  private Client client;


  public ClientDetails() {

  }

  public ClientDetails(Boolean premium, Integer points) {
    this.setPremium(premium);
    this.setPoints(points);
  }

  public Integer getId() {  return id;  }
  public Integer getPoints() {  return points;  }
  public Boolean getPremium() { return premium; }
  public Client getClient() { return client;  }

  public void setPremium(Boolean premium) { this.premium = premium; }
  public void setPoints(Integer points) { this.points = points; }
  public void setClient(Client client) {  this.client = client; }

  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", premium:" + premium +
        ", points:" + points +
        '}';
  }
}
