package dev.hstr0100.dio.iss.service;

import dev.hstr0100.dio.iss.dto.CityDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@FeignClient(name = "openstreetmap-api", url = "https://nominatim.openstreetmap.org")
public interface CityRetrieveClient {

    @GetMapping("/search")
    List<CityDTO> searchCityByName(
        @RequestParam("city") String cityName,
        @RequestParam(defaultValue = "json") String format,
        @RequestParam(defaultValue = "1") int limit);
}
