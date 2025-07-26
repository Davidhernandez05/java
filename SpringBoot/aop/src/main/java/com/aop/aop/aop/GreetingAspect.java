package com.aop.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class GreetingAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  //Se selecciona la parte(Punto de corte) donde se va a interrumpir para ejecutar este código.
  @Before("execution(* com.aop.aop.services.GreetingService.sayHello(..))") // Before -> Antes de llamar el método. // * -> Cualquier tipo de retorno.
  public void loggerBefore(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName(); // Nos dice como se llama el método.
    String args = Arrays.toString(joinPoint.getArgs()); // Nos toma los argumentos que se le enviaron ha dicho método, retorna un String porque ese método retorna uno.

    logger.info("Before: {} con los argumentos: {}", method, args); // Nos imprime el mensaje por terminal.
  }

  @After("execution(* com.aop.aop.services.GreetingService.*(..))") // After -> Después de llamar el método. // * -> Cualquier tipo de retorno.
  // com.aop.aop.services.GreetingService.*(..) -> * -> Se va a llamar al after en todos los métodos que están en el GreetingService
  // (..) -> Para seleccionar los parámetros que se encuentran en el método

  public void loggerAfter(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName(); // Nos dice como se llama el método.
    String args = Arrays.toString(joinPoint.getArgs()); // Nos toma los argumentos que se le enviaron ha dicho método, retorna un String porque ese método retorna uno.

    logger.info("After: {} con los argumentos: {}", method, args); // Nos imprime el mensaje por terminal.
  }
}
