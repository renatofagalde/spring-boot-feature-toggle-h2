package br.com.likwi.toogle.service;

import br.com.likwi.toogle.strategy.VehicleHandlerStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VehicleHandlerService {

    private final Map<String,VehicleHandlerStrategy> strategies;

    public VehicleHandlerService(Map<String, VehicleHandlerStrategy> strategies) {
        this.strategies = strategies;
    }

    public VehicleHandlerStrategy getStrategy(String vehicleType) {
        return this.strategies.get(vehicleType);
    }
}
