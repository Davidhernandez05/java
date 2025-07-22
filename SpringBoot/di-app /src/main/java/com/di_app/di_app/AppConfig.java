package com.di_app.di_app;

import com.di_app.di_app.Repositories.IProductRepository;
import com.di_app.di_app.Repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

  @Value("classpath:json/product.json")
  private Resource resource;

  @Bean("productJson")
  IProductRepository productRepositoryJson() {
    return new ProductRepositoryJson(resource);
  }
}
