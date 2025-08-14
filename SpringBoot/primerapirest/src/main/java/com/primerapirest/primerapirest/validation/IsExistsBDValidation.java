package com.primerapirest.primerapirest.validation;

import com.primerapirest.primerapirest.services.ProductService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsExistsBDValidation implements ConstraintValidator<IsExistsDB, String> {

  @Autowired
  private ProductService service;

  // Nos permite validar su un campo ya existe en la BD:
  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return !service.existsBySku(s);
  }
}
