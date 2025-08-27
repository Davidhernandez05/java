package com.primerapirest.primerapirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique = true)
  private String name;

  @ManyToMany(mappedBy = "roles")
  @EqualsAndHashCode.Exclude
  @JsonIgnoreProperties({"roles", "handler", "hibernateLazyInitializer"})
  private List<User> users;

  public Role() {
    this.users = new ArrayList<>();
  }
}
