package com.difactura.difactura;

import com.difactura.difactura.models.Item;
import com.difactura.difactura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value = "classpath:text.properties", encoding = "UTF-8")

public class AppConfig {

  @Bean
  List<Item> itemsInvoice() {
    Product p1 = new Product("Camara Sony", 700);
    Product p2 = new Product("Playera Nike", 100);
    Product p3 = new Product("Juego de Mancuernas", 1000);

    return Arrays.asList(new Item(p1, 2), new Item(p2, 20), new Item(p3, 1));
  }
}
