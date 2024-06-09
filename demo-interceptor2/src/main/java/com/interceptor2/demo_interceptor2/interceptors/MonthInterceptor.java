package com.interceptor2.demo_interceptor2.interceptors;

import com.interceptor2.demo_interceptor2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Component
public class MonthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handles) throws Exception {
        List<Month> months = new ArrayList<>(Arrays.asList(
                new Month (6,"June", "Giugno", "Juni"),
                new Month (7, "July", "Luglio", "Juli"),
                new Month (8, "August", "Agosto", "August"),
                new Month (9, "September", "Settembre", "September"),
                new Month (10, "October", "Ottobre", "Oktober"),
                new Month (11, "November", "Novembre", "November"),
                new Month (12, "December", "Dicembre", "Dezember")));
        String monthNumber = request.getHeader("monthNumber");
        if(monthNumber == null || monthNumber.isEmpty()){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }
        int MonthNumberInt = Integer.parseInt(monthNumber);
        Optional<Month> optionalMonth = months.stream().filter(month -> month.getMonthNumber() == MonthNumberInt).findFirst();
        if(optionalMonth.isPresent()){
            request.setAttribute("month", optionalMonth.get());
        }else{
            request.setAttribute("month", new Month(1, "nope", "nope", "nope"));
        }
        response.setStatus(HttpServletResponse.SC_OK);
        return true;
    }
    }

