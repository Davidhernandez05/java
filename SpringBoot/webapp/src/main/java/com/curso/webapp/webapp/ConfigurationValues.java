package com.curso.webapp.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:values.properties", encoding = "UTF-8")//Aquí configuramos nuestro nuevo archivo properties, pero de igual forma se podrían crear más.
                                                                          //También configuramos los acentos en el archivo.
public class ConfigurationValues {
  //Este es un archivo de configuración de propiedades para no ensuciar nuestro main.
}
