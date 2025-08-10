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


  public ClientDetails() {

  }

  public ClientDetails(Boolean premium, Integer points) {
    this.setPremium(premium);
    this.setPoints(points);
  }

  public Integer getId() {  return id;  }
  public Integer getPoints() {  return points;  }
  public Boolean getPremium() { return premium; }

  public void setPremium(Boolean premium) { this.premium = premium; }
  public void setPoints(Integer points) { this.points = points; }


  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", premium:" + premium +
        ", points:" + points +
        '}';
  }
}
