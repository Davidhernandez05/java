package com.interceptor.interceptor_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  @Autowired()
  @Qualifier("loadingTimeInterceptor")
  private HandlerInterceptor timesInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // Para que se aplique a todas las rutas:
    //registry.addInterceptor(timesInterceptor);

    //.addPathPatterns -> Para decirle que se aplique a ciertas rutas únicamente:
    //registry.addInterceptor(timesInterceptor).addPathPatterns("/app/baz", "/app/bar");

    //Para que excluya ciertas rutas: Se áplique a todas menos a la rita indicada.
    registry.addInterceptor(timesInterceptor).excludePathPatterns("/app/foo");


  }
}
