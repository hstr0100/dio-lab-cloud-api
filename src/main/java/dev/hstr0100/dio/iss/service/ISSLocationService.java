package dev.hstr0100.dio.iss.service;

import dev.hstr0100.dio.iss.dto.ISSLocationDTO;
import dev.hstr0100.dio.iss.model.DTOResponse;
import dev.hstr0100.dio.iss.model.ISSDistanceResponse;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public interface ISSLocationService {

    DTOResponse<ISSLocationDTO> getCurrentISSLocationResponse();

    ISSDistanceResponse retrieveCurrentISSDistance(String cityName);

}
