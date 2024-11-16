package dev.hstr0100.dio.iss.controller;

import dev.hstr0100.dio.iss.dto.ISSLocationDTO;
import dev.hstr0100.dio.iss.model.DTOResponse;
import dev.hstr0100.dio.iss.model.ISSDistanceResponse;
import dev.hstr0100.dio.iss.service.ISSLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@RestController
@RequestMapping("/iss")
public class ISSLocationController {

    @Autowired
    private ISSLocationService issLocationService;

    @GetMapping({"/", ""})
    public DTOResponse<ISSLocationDTO> getISSLocation() {
        return issLocationService.getCurrentISSLocationResponse();
    }

    @GetMapping("/{cityName}")
    public ISSDistanceResponse getISSDistanceCityByName(@PathVariable String cityName) {
        return issLocationService.retrieveCurrentISSDistance(cityName);
    }
}
