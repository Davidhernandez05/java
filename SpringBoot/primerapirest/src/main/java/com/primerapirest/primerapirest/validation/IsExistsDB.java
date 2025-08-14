package com.primerapirest.primerapirest.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsExistsBDValidation.class)
public @interface IsExistsDB {
  // Nos permite validar su un campo ya existe en la BD.
  String message() default "Ya existe en la Base de Datos!.";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
