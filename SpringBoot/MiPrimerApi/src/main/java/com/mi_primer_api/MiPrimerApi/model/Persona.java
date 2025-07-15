package com.mi_primer_api.MiPrimerApi.model;


import lombok.Data;

import java.beans.ConstructorProperties;

@Data //Nos crea los getters y setter automáticamente.
public class Persona {
  private String name; //Con este mismo nombre se tendrían que enviar los datos JSON.
}
