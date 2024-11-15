package dev.hstr0100.dio.iss.controller;

import dev.hstr0100.dio.iss.model.CityResponse;
import dev.hstr0100.dio.iss.service.CityRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRetrieveService cityRetrieveServiceImpl;

    @GetMapping({"/", ""})
    public CityResponse getDefaultCity() {
        // Placeholder. No purpose defined for default route
        return getCityByName("Curitiba");
    }

    @GetMapping("/{cityName}")
    public CityResponse getCityByName(@PathVariable String cityName) {
        return cityRetrieveServiceImpl.retrieveCityResponseByName(cityName);
    }
}
