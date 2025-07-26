package com.aop.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1) //Primero en entrar y último en salir.
@Component
@Aspect
public class GreetingFooAspect {
  private Logger logger = LoggerFactory.getLogger(getClass());


  @Before("GreetingServicePointcuts.greetingLoggerFooPointcut()") // Se llama el nombre de la clase y del método.
  // En caso de estar en otro package también se tendría que llamar al package
  public void loggerBefore(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("1. Antes: {}, invocado con los parámetros: {}.", method, args);

  }

  @After("GreetingServicePointcuts.greetingLoggerFooPointcut()")
  public void loggerAfter(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("1. After: {} con los parámetros: {}", method, args);
  }
}
