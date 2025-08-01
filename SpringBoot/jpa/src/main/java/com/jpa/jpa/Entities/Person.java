package com.jpa.jpa.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity // Siempre tiene que ir.
@Table(name = "persons") //Le damos nombre a la tabla -> Si no se lo damos tomará el nombre de la clase.
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Incremental.
  private Long id;

  private String name;
  private String lastname;

  @Column(name = "programing_language") //Le damos un nombre a una columna -> Solamente si se le va a cambiar el nombre o si es una palabra compuesta.
  private String programingLanguage;

  @Embedded // Nos permite reutilizar el código que viene del: Embeddable
  private Audit audit = new Audit();

  //Constructors:

  public Person() {
    //Siempre tiene que llevar un constructor vacío.
    //Si se crea un constructor con parámetros.
  }

  public Person(Long id, String name, String lastname, String programingLanguage) {
    this.setId(id);
    this.setName(name);
    this.setLastname(lastname);
    this.setProgramingLanguage(programingLanguage);
  }

  public Person (String name, String lastname) {
    this.setName(name);
    this.setLastname(lastname);
  }

  //Getters:
  public Long getId() { return id;  }
  public String getName() { return name;  }
  public String getLastname() { return lastname;  }
  public String getProgramingLanguage() { return programingLanguage;  }


  //Setters:
  public void setId(Long id) {  this.id = id; }
  public void setName(String name) {  this.name = name; }
  public void setLastname(String lastname) {  this.lastname = lastname; }
  public void setProgramingLanguage(String programingLanguage) {  this.programingLanguage = programingLanguage; }


  @Override
  public String toString() {
    return "[id= " + id + ", name= " + name + ", lastname= " + lastname +
        ", Lenguajes de programación= " + programingLanguage + " CreateAt= " +
        audit.getCreateAt() + " UpdateAt=" + audit.getUpdateAt() + " ]";
  }
}
