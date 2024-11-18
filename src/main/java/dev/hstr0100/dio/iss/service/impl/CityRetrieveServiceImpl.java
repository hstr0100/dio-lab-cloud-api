package dev.hstr0100.dio.iss.service.impl;

import dev.hstr0100.dio.iss.client.CityRetrieveClient;
import dev.hstr0100.dio.iss.dto.CityDto;
import dev.hstr0100.dio.iss.entity.City;
import dev.hstr0100.dio.iss.exception.CityNotFoundException;
import dev.hstr0100.dio.iss.repository.CityRepository;
import dev.hstr0100.dio.iss.response.DTOResponse;
import dev.hstr0100.dio.iss.service.CityRetrieveService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@Service
public class CityRetrieveServiceImpl implements CityRetrieveService {

    private static final Logger log = LoggerFactory.getLogger(CityRetrieveServiceImpl.class.getName());

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityRetrieveClient cityRetrievalService;

    @Override
    public DTOResponse<City> retrieveCityResponseByName(String cityName) {
        City city = retrieveCityByName(cityName);

        return new DTOResponse<>(200, "Success", city);
    }

    @Override
    public City retrieveCityByName(String cityName) {
        // Try to find the city in the database
        City city = cityRepository.findFirstByName(cityName);
        log.debug("City in DB: {}", city);

        if (city == null) {
            // If city is not found in DB, call OpenStreetMap API
            List<CityDto> citySearchResponse = cityRetrievalService.searchCityByName(cityName, "json", 1);
            log.debug("API Response: {}", citySearchResponse);

            if (!citySearchResponse.isEmpty()) {
                CityDto retrieved = citySearchResponse.get(0);
                // Get the first result from the response (which will be the best match)
                // TODO: clone the bean
                city = new City();
                city.setName(retrieved.getName());
                city.setDisplayName(retrieved.getDisplayName());
                city.setLatitude(Double.parseDouble(retrieved.getLat()));
                city.setLongitude(Double.parseDouble(retrieved.getLon()));

                // This is a demo application, hence why this is not handling any edge cases
                List<String> boundingBox = retrieved.getBoundingBox();
                city.setMinLatitude(Math.min(
                    Double.parseDouble(boundingBox.get(0)),
                    Double.parseDouble(boundingBox.get(1))));
                city.setMaxLatitude(Math.max(
                    Double.parseDouble(boundingBox.get(0)),
                    Double.parseDouble(boundingBox.get(1))));
                city.setMinLongitude(Math.min(
                    Double.parseDouble(boundingBox.get(2)),
                    Double.parseDouble(boundingBox.get(3))));
                city.setMaxLongitude(Math.max(
                    Double.parseDouble(boundingBox.get(2)),
                    Double.parseDouble(boundingBox.get(3))));

                log.debug("New City Obj: {}", city);
                // Save the city to the database
                cityRepository.save(city);
            }
        }

        if (city == null) {
            throw new CityNotFoundException("City " + cityName + " does not exist");
        }

        return city;
    }
}
