package com.aop.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2) //Nos da un orden de ejecución.
@Component
@Aspect
public class GreetingAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  //Se selecciona la parte(Punto de corte) donde se va a interrumpir para ejecutar este código.
  @Before("GreetingServicePointcuts.greetingLoggerPointcut()") // Before -> Antes de llamar el método. // * -> Cualquier tipo de retorno.
  public void loggerBefore(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName(); // Nos dice como se llama el método.
    String args = Arrays.toString(joinPoint.getArgs()); // Nos toma los argumentos que se le enviaron ha dicho método, retorna un String porque ese método retorna uno.

    logger.info("2. Before: {} con los argumentos: {}", method, args); // Nos imprime el mensaje por terminal.
  }

  @After("GreetingServicePointcuts.greetingLoggerPointcut()") // After -> Después de llamar el método. // * -> Cualquier tipo de retorno.
  // com.aop.aop.services.GreetingService.*(..) -> * -> Se va a llamar al after en todos los métodos que están en el GreetingService
  // (..) -> Para seleccionar los parámetros que se encuentran en el método

  public void loggerAfter(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName(); // Nos dice como se llama el método.
    String args = Arrays.toString(joinPoint.getArgs()); // Nos toma los argumentos que se le enviaron ha dicho método, retorna un String porque ese método retorna uno.

    logger.info("After: {} con los argumentos: {}", method, args); // Nos imprime el mensaje por terminal.
  }

  @AfterReturning("execution(* com.aop.aop.services.GreetingService.*(..))") // Solo se ejecuta cuando no hay ningún error en la llamada.
  public void loggerAfterReturning(JoinPoint joinPoint) {
    String m = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("After Returning: {} con los argumentos: {}", m, args);
  }

  @AfterThrowing("execution(* com.aop.aop.services.GreetingService.*(..))")
  public void loggerAfterT(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs()); //Convierte un arreglo a string.

    logger.info("After Throwing: {} con los argumentos:{}", method, args);
  }

  @Around("execution(* com.aop.aop.services.*.*(..))")
  public Object loggerAround(ProceedingJoinPoint proceedingJoinPoint) {
    String method = proceedingJoinPoint.getSignature().getName();
    String args = Arrays.toString(proceedingJoinPoint.getArgs());

    Object result = null;
    try {

      logger.info("El método: {} con los parámetros: {}", method, args);
      result = proceedingJoinPoint.proceed();
      logger.info("El método: {} retorna el resultado: {}", method, result);

      return result;
    } catch (Throwable e) {
      logger.error("Error: {} en la llamada del método: {}().", e.getMessage(), method);
    }

    return result;
  }
}
