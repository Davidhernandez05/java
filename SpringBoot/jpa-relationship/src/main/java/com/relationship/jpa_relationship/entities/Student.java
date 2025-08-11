package com.relationship.jpa_relationship.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private String lastname;
  private Boolean asset;

  @ManyToMany(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  private Set<Course> courses;

  public Student() {
    this.courses = new HashSet<>();
  }

  public Student(String name, String lastname, Boolean asset) {
    this();
    this.setName(name);
    this.setLastname(lastname);
    this.setAsset(asset);
  }

  public Integer getId() {  return id;  }
  public String getName() { return name;  }
  public String getLastname() { return lastname;  }
  public Boolean getAsset() { return asset; }
  public Set<Course> getCourses() { return courses; }

  public void setName(String name) {  this.name = name; }
  public void setLastname(String lastname) {  this.lastname = lastname; }
  public void setCourses(Set<Course> courses) { this.courses = courses; }
  public void setAsset(Boolean asset) { this.asset = asset; }

  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", name:'" + name + '\'' +
        ", lastname:'" + lastname + '\'' +
        ", asset:" + asset +
        ", courses:" + courses +
        '}';
  }
}
