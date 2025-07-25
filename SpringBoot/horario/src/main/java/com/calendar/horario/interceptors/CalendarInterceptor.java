package com.calendar.horario.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("calendarInterceptor")
public class CalendarInterceptor implements HandlerInterceptor {

  @Value("${config.calendar.open}")
  private Integer open;

  @Value("${config.calendar.close}")
  private Integer close;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //Sacar la hora.
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    System.out.println("Son las: " + hour);

    if (hour >= open && hour <= close){
      String message = "Bienvenido al horario de atención a clientes!." + ", atendemos desde las: " +
          open +
          " hrs, hasta las: " +
          close +
          " hrs. " +
          "Gracias por su visita";

      request.setAttribute("message", message); //enviamos el message por request.
      return true;
    }

    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> json = new HashMap<>();
    json.put("message", "Horario de ingreso no valido.");
    StringBuilder message = new StringBuilder("Cerrado, nuestro horario de atención es desde las: "
        + open
        + " hrs, hasta las: "
        + close
        + " hrs. Gracias!.");

    json.put("message", message);
    json.put("date", new Date().toString());

    //Convertir en json:
    response.setContentType("application/json");
    response.setStatus(401);
    response.getWriter().write(mapper.writeValueAsString(json));
    return false;
  }


  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }
}
