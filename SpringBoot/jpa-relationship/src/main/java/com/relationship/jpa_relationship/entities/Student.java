package com.relationship.jpa_relationship.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
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

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "students_courses",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "courses_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "courses_id"})
  )
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

  public void addCourses(Course course) {
    this.courses.add(course);
    course.getStudents().add(this);
  }

  public void removeCourses(Course course) {
    this.courses.remove(course);
    course.getStudents().remove(this);
  }

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

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(lastname, student.lastname) && Objects.equals(asset, student.asset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname, asset);
  }
}
