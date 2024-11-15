package dev.hstr0100.dio.iss.service.impl;

import dev.hstr0100.dio.iss.dto.ISSLocationDTO;
import dev.hstr0100.dio.iss.model.City;
import dev.hstr0100.dio.iss.model.ISSDistanceResponse;
import dev.hstr0100.dio.iss.service.ISSClient;
import dev.hstr0100.dio.iss.util.CityNotFoundException;
import dev.hstr0100.dio.iss.util.Haversine;
import dev.hstr0100.dio.iss.util.ISSServiceUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@Service
public class ISSLocationService {

    @Autowired
    private CityRetrieveService cityRetrieveServiceImpl;

    @Autowired
    private ISSClient issLocationService;

    public ISSLocationDTO getCurrentISSLocation() {
        ISSLocationDTO issLocation = issLocationService.getCurrentLocation();
        if (issLocation == null) {
            throw new ISSServiceUnavailableException("ISS Location service is unavailable at the moment");
        }

        return issLocation;
    }

    public ISSDistanceResponse retrieveCurrentISSDistance(String cityName) {
        City city = cityRetrieveServiceImpl.retrieveCityByName(cityName);
        if (city == null) {
            throw new CityNotFoundException("City " + cityName + " does not exist");
        }

        ISSLocationDTO issLocation = getCurrentISSLocation();

        // Retrieve the ISS current location
        double issLat = issLocation.getIssPosition().getLatitude();
        double issLon = issLocation.getIssPosition().getLongitude();

        // Calculate the closest distance from ISS to city using its bounding box
        double distanceToClosestVector = calculateClosestDistanceFromIssToCity(issLat, issLon, city);

        // Return the calculated distance
        return new ISSDistanceResponse("Success", 200, city, distanceToClosestVector);
    }

    private double calculateClosestDistanceFromIssToCity(double issLat, double issLon, City city) {
        double latMin = city.getBbLatitude1();
        double latMax = city.getBbLatitude2();
        double lonMin = city.getBbLongitude1();
        double lonMax = city.getBbLongitude2();

        // Find the closest latitude and longitude
        double closestLat = Math.max(latMin, Math.min(issLat, latMax));
        double closestLon = Math.max(lonMin, Math.min(issLon, lonMax));

        // Use the Haversine formula to calculate the distance
        return calculateISSDistanceToCity(issLat, issLon, closestLat, closestLon);
    }

    private double calculateISSDistanceToCity(double issLat, double issLon, double cityLat, double cityLon) {
        return Haversine.calculateDistanceInKM(issLat, issLon, cityLat, cityLon);
    }
}
