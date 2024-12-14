package br.com.likwi.toogle.strategy.impl;

import br.com.likwi.toogle.strategy.VehicleHandlerStrategy;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("moto")
public class MotoHandlerStrategy implements VehicleHandlerStrategy {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setAttribute("vehicleTypeChecked", true);
        request.getRequestDispatcher("/moto").forward(request, response);
    }
}