package com.jpa.jpa.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Embeddable // Esto nos permite reutilizar código.
public class Audit {

  @Column(name = "create_at")
  private LocalDateTime createAt;

  @Column(name = "updated_at")
  private LocalDateTime updateAt;

  // Pre y post:
  @PrePersist
  public void prePersist() { // Se ejecuta antes de crear el dato en la BD por lo cual utiliza la hora y hora en la que se crea.
    // También se pueden utilizar POST para después de realizar alguna acción.
    System.out.println("Evento del ciclo de vida del entity pre-Persist.");
    this.createAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() { // Se ejecuta antes de actualizar en dato en la BD por lo cual la fecha y hora es la de ese evento.
    System.out.println("Evento del ciclo de vida del entity pre-Update.");
    this.updateAt = LocalDateTime.now();
  }

  public LocalDateTime getCreateAt() {  return createAt;  }
  public LocalDateTime getUpdateAt() {  return updateAt;  }

  public void setCreateAt(LocalDateTime createAt) { this.createAt = createAt; }
  public void setUpdateAt(LocalDateTime updateAt) { this.updateAt = updateAt; }
}
