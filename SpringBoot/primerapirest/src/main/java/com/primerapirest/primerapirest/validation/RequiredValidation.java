package com.primerapirest.primerapirest.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class RequiredValidation implements ConstraintValidator<IsRequired, String> {
  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    //return (s != null && !s.isBlank());
    return StringUtils.hasText(s); // Esto hace lo mismo que el de arriba una validación de si tiene texto o no.
  }
}
