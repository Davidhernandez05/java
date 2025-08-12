package com.relationship.jpa_relationship.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String teacherName;
  private String courseName;
  private Boolean availability;

  @ManyToMany(mappedBy = "courses")
  private Set<Student> students;

  public Course() {
    this.students = new HashSet<>();
  }

  public Course(String courseName, String teacherName, Boolean availability){
    this();
    this.setTeacherName(teacherName);
    this.setCourseName(courseName);
    this.setAvailability(availability);
  }

  public Integer getId() {  return id;  }
  public String getTeacherName() {  return teacherName; }
  public String getCourseName() { return courseName;  }
  public Boolean getAvailability() {  return availability;  }
  public Set<Student> getStudents() { return students;  }

  public void setTeacherName(String teacherName) {  this.teacherName = teacherName; }
  public void setCourseName(String courseName) {  this.courseName = courseName;  }
  public void setAvailability(Boolean availability) { this.availability = availability; }
  public void setStudents(Set<Student> students) {  this.students = students; };

  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", teacherName:'" + teacherName + '\'' +
        ", courseName:'" + courseName + '\'' +
        ", availability:" + availability +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return Objects.equals(id, course.id) && Objects.equals(teacherName, course.teacherName) && Objects.equals(courseName, course.courseName) && Objects.equals(availability, course.availability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, teacherName, courseName, availability);
  }
}
