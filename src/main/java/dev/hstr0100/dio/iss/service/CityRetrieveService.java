package dev.hstr0100.dio.iss.service;

import dev.hstr0100.dio.iss.entity.City;
import dev.hstr0100.dio.iss.response.DTOResponse;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public interface CityRetrieveService {

    DTOResponse<City> retrieveCityResponseByName(String cityName);

    City retrieveCityByName(String cityName);
}
