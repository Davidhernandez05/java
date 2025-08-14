package com.primerapirest.primerapirest.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RequiredValidation.class) // Nos une con la clase que se va a validar.
@Retention(RetentionPolicy.RUNTIME) // Se ejecuta en tiempo de ejecución.
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IsRequired {

  String message() default "Es requerido usando anotaciones.";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
