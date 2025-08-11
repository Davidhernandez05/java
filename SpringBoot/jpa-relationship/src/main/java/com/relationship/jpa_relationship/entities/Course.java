package com.relationship.jpa_relationship.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String teacherName;
  private String courseName;
  private Boolean availability;

  public Course() {

  }

  public Course(String courseName, String teacherName, Boolean availability){
    this.setTeacherName(teacherName);
    this.setCourseName(courseName);
    this.setAvailability(availability);
  }

  public Integer getId() {  return id;  }
  public String getTeacherName() {  return teacherName; }
  public String getCourseName() { return courseName;  }
  public Boolean getAvailability() {  return availability;  }

  public void setTeacherName(String teacherName) {  this.teacherName = teacherName; }
  public void setCourseName(String courseName) {  this.courseName = courseName;  }
  public void setAvailability(Boolean availability) { this.availability = availability; }

  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", teacherName:'" + teacherName + '\'' +
        ", courseName:'" + courseName + '\'' +
        ", availability:" + availability +
        '}';
  }
}
