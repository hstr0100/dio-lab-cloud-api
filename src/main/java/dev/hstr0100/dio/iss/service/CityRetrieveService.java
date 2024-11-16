package dev.hstr0100.dio.iss.service;

import dev.hstr0100.dio.iss.model.City;
import dev.hstr0100.dio.iss.model.DTOResponse;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public interface CityRetrieveService {

    DTOResponse<City> retrieveCityResponseByName(String cityName);

    City retrieveCityByName(String cityName);
}
