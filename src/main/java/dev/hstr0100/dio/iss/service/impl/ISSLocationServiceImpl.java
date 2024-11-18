package dev.hstr0100.dio.iss.service.impl;

import dev.hstr0100.dio.iss.client.ISSClient;
import dev.hstr0100.dio.iss.dto.ISSLocationDto;
import dev.hstr0100.dio.iss.exception.CityNotFoundException;
import dev.hstr0100.dio.iss.exception.ISSServiceUnavailableException;
import dev.hstr0100.dio.iss.entity.City;
import dev.hstr0100.dio.iss.response.DTOResponse;
import dev.hstr0100.dio.iss.response.ISSDistanceResponse;
import dev.hstr0100.dio.iss.service.ISSLocationService;
import dev.hstr0100.dio.iss.util.Haversine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@Service
public class ISSLocationServiceImpl implements ISSLocationService {

    @Autowired
    private CityRetrieveServiceImpl cityRetrieveServiceImpl;

    @Autowired
    private ISSClient issLocationService;

    @Override
    public DTOResponse<ISSLocationDto> getCurrentISSLocationResponse() {
        ISSLocationDto issLocation = issLocationService.getCurrentLocation();
        if (issLocation == null) {
            throw new ISSServiceUnavailableException("ISS Location service is unavailable at the moment");
        }

        return new DTOResponse<>(200, "Successs", issLocation);
    }

    @Override
    public ISSDistanceResponse retrieveCurrentISSDistance(String cityName) {
        City city = cityRetrieveServiceImpl.retrieveCityByName(cityName);
        if (city == null) {
            throw new CityNotFoundException("City " + cityName + " does not exist");
        }

        ISSLocationDto issLocation = issLocationService.getCurrentLocation();

        // Retrieve the ISS current location
        double issLat = issLocation.getIssPosition().getLatitude();
        double issLon = issLocation.getIssPosition().getLongitude();

        // Calculate the closest distance from ISS to city using its bounding box
        double distanceToClosestVector = calculateClosestDistanceFromIssToCity(issLat, issLon, city);

        // Return the calculated distance
        return new ISSDistanceResponse(200, "Success", city, distanceToClosestVector);
    }

    private double calculateClosestDistanceFromIssToCity(double issLat, double issLon, City city) {
        double latMin = city.getMinLatitude();
        double latMax = city.getMaxLatitude();
        double lonMin = city.getMinLongitude();
        double lonMax = city.getMaxLongitude();

        // Find the closest latitude and longitude
        double closestLat = Math.max(latMin, Math.min(issLat, latMax));
        double closestLon = Math.max(lonMin, Math.min(issLon, lonMax));

        // Use the Haversine formula to calculate the distance
        return Haversine.calculateDistanceKM(issLat, issLon, closestLat, closestLon);
    }
}
