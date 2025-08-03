package com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "biblioteca")
public class BasicLibrary {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "autor_name")
  private String autorName;
  
  @Column(name = "book_name")
  private String bookName;

  private String gender;

  public BasicLibrary() {
  }

  public BasicLibrary(Integer id, String bookName, String autorName, String gender) {
    this.setId(id);
    this.setBookName(bookName);
    this.setAutorName(autorName);
    this.setGender(gender);

  }

  public Integer getId() {  return id;  }
  public String getBookName() { return bookName;  }
  public String getAutorName() {  return autorName; }
  public String getGender() { return gender; }


  public void setId(Integer id) { this.id = id; }
  public void setBookName(String bookName) {  this.bookName = bookName; }
  public void setAutorName(String autorName) {  this.autorName = autorName; }
  public void setGender(String gender) {  this.gender = gender; }

  @Override
  public String toString() {
    return  "id: " + id + ", Nombre del libro: " + bookName +
        ", Nombre del autor: " + autorName + ", Genero del libro: " + gender;
  }
}
