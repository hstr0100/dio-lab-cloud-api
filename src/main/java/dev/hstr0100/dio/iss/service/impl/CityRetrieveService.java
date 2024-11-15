package dev.hstr0100.dio.iss.service.impl;

import dev.hstr0100.dio.iss.dto.CityDTO;
import dev.hstr0100.dio.iss.model.City;
import dev.hstr0100.dio.iss.repository.CityRepository;
import dev.hstr0100.dio.iss.service.CityRetrieveClient;
import dev.hstr0100.dio.iss.util.CityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@Service
public class CityRetrieveService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityRetrieveClient cityRetrievalService;

    public City retrieveCityByName(String cityName) {
        // Try to find the city in the database
        City city = cityRepository.findByName(cityName);
        System.out.println("City in DB: " + city);

        if (city == null) {
            // If city is not found in DB, call OpenStreetMap API
            List<CityDTO> citySearchResponse = cityRetrievalService.searchCityByName(cityName, "json", 1);
            System.out.println("API Response: " + citySearchResponse);

            if (!citySearchResponse.isEmpty()) {
                CityDTO retrieved = citySearchResponse.get(0);
                // Get the first result from the response (which will be the best match)
                // TODO: clone the bean
                city = new City();
                city.setName(retrieved.getName());
                city.setDisplayName(retrieved.getDisplayName());
                city.setLatitude(Double.parseDouble(retrieved.getLat()));
                city.setLongitude(Double.parseDouble(retrieved.getLon()));

                // This is a demo application, hence why this is not handling any edge cases
                city.setBbLatitude1(Double.parseDouble(retrieved.getBoundingBox().get(0)));
                city.setBbLatitude2(Double.parseDouble(retrieved.getBoundingBox().get(1)));
                city.setBbLongitude1(Double.parseDouble(retrieved.getBoundingBox().get(2)));
                city.setBbLongitude2(Double.parseDouble(retrieved.getBoundingBox().get(3)));

                System.out.println("New City Obj: " + city);

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
