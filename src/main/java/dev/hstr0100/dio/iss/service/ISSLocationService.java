package dev.hstr0100.dio.iss.service;

import dev.hstr0100.dio.iss.dto.ISSLocationDto;
import dev.hstr0100.dio.iss.response.DTOResponse;
import dev.hstr0100.dio.iss.response.ISSDistanceResponse;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public interface ISSLocationService {

    DTOResponse<ISSLocationDto> getCurrentISSLocationResponse();

    ISSDistanceResponse retrieveCurrentISSDistance(String cityName);

}
