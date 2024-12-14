package br.com.likwi.toogle.strategy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public interface VehicleHandlerStrategy {
    void handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
