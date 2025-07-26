package com.aop.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingServicePointcuts {

  //Clase de puntos de corte.
  @Pointcut("execution(* com.aop.aop.services.GreetingService.sayHello(..))") //Nos permite reutilizar el punto de corte.
  public void greetingLoggerPointcut() {}

  @Pointcut("execution(* com.aop.aop.services.*.*(..))")
  public void greetingLoggerFooPointcut() {}
}
