package br.com.likwi.toogle.config;

import br.com.likwi.toogle.service.FeatureToggleService;
import br.com.likwi.toogle.service.VehicleHandlerService;
import br.com.likwi.toogle.strategy.VehicleHandlerStrategy;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class VehicleTypeInterceptor implements HandlerInterceptor {

    private final FeatureToggleService featureToggleService;
    private final VehicleHandlerService vehicleHandlerService;

    public VehicleTypeInterceptor(FeatureToggleService featureToggleService,
                                  VehicleHandlerService vehicleHandlerService) {
        this.featureToggleService = featureToggleService;
        this.vehicleHandlerService = vehicleHandlerService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (request.getAttribute("vehicleTypeChecked") != null) {
            return true;
        }
        String vehicleType = featureToggleService.getVehicleType();
        VehicleHandlerStrategy strategy = vehicleHandlerService.getStrategy(vehicleType);
        if (strategy != null) {
            strategy.handle(request,response);
        }else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Vehicle type not found");
        }

        return false;
    }
}
