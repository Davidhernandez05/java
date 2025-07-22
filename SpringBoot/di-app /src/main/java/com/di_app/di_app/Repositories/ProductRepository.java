package com.di_app.di_app.Repositories;

import com.di_app.di_app.Models.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

// Se utiliza cuando trabajamos con los datos, ejemplo Bases de datos SQL y no SQL, etc.
//@RequestScope -> Funciona para que no funcione como singleton, lo que hace que por usuario se genere el código, y no se guarde en memoria.
 //@SessionScope -> Nos crea una sesión por navegador donde se pueden ir guardando los cambios, pero cuando la sesión se cierra se eliminan dichos cambios.
@Repository //Para cambiar el nombre lógico del repo lo hacemos de la siguiente forma: @Repository("nombre") debe empezar por minúscula.
public class ProductRepository implements IProductRepository {
  // En el repository es donde obtenemos los datos leemos los datos o guardamos los datos, los persistimos.

  private List<Product> data;

  public ProductRepository() {
    this.data = Arrays.asList(
        new Product(1L, "Memoria", 300L),
        new Product(2L, "CPU", 850L),
        new Product(3L, "Teclado Razer Mini", 180L),
        new Product(4L, "PC Gaming", 1000L)
    );
  }

  //Regresamos todos los productos que se encuentran en nuestra lista.
  @Override
  public List<Product> findAll() {
    return data;
  }

  //Buscamos un producto por el ID.
  @Override
  public Product findId(Long id) {
    return data.stream()
        .filter(product -> product.getId().equals(id))
        .findFirst().orElse(null); // Le decimos que si no lo encuentra retorne un null.
  }
}
