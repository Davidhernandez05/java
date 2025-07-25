package com.interceptor.interceptor_app.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component("loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HandlerMethod controller = ((HandlerMethod) handler);
    logger.info("LoadingTimeInterceptor: preHandle() Ingresando..." + controller.getMethod().getName());

    long start = System.currentTimeMillis();
    request.setAttribute("start", start);

    Random random = new Random(); //Nos da un número aleatorio entre 0 y 500;
    int delay = random.nextInt(500);

    Thread.sleep(delay); // Esto hace que haga una pausa para que se vea en el ejemplo.

    //Personalizar mensaje en caso de que sea false:
    Map<String, String> result = new HashMap<>();
    result.put("Message", "No tiene acceso a este recurso");
    result.put("Date", new Date().toString());

    //Convertir el Map a una estructura String manualmente:
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = mapper.writeValueAsString(result);

    response.setContentType("application/json");
    response.setStatus(403);
    response.getWriter().write(jsonString);

    return false; // No regresa nada, no contínua con la ejecución del controlador o interceptor que se está enviando.
    //return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    long end = System.currentTimeMillis();
    long start = (long) request.getAttribute("start");
    long result = end - start;

    logger.info("Tiempo transcurrido: " + result + " Milisegundos.");
    logger.info("LoadingTimeInterceptor: postHandle() Finalizando..." + ((HandlerMethod) handler).getMethod().getName());
  }

}
