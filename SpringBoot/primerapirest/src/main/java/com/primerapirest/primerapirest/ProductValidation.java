package com.primerapirest.primerapirest;

import com.primerapirest.primerapirest.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    return Product.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

    // Las tres formas se pueden utilizar.
    Product product = (Product) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null,  "Es requerido." );
    //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.product.description" );
    if (product.getDescription() == null || product.getDescription().isBlank()) {
      errors.rejectValue("description", null, "Es requerido, por favor.");
    }

    if (product.getPrice() == null) {
      errors.rejectValue("price", null, "no puede ser un valor nulo validar por favor.");
    }else if (product.getPrice() < 50) {
      errors.rejectValue("price", null, "el precio debe ser mayor a 50.");
    }

  }
}
