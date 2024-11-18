package dev.hstr0100.dio.iss.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.hstr0100.dio.iss.entity.City;
import dev.hstr0100.dio.iss.dto.ISSDistanceDto;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ISSDistanceResponse extends AbstractResponse {

    @JsonProperty("city_data")
    private City cityData;

    @JsonProperty("iss_distance")
    private ISSDistanceDto issDistance;

    public ISSDistanceResponse(int statusCode, String message, City cityData, double currentDistanceKm) {
        super(statusCode, message);
        this.cityData = cityData;
        this.issDistance = new ISSDistanceDto(currentDistanceKm);
    }

    public City getCityData() {
        return cityData;
    }

    public void setCityData(City cityData) {
        this.cityData = cityData;
    }

    public ISSDistanceDto getIssDistance() {
        return issDistance;
    }

    public void setIssDistance(ISSDistanceDto issDistance) {
        this.issDistance = issDistance;
    }

    @Override
    public String toString() {
        return "ISSDistanceResponse{"
            + "cityData=" + cityData
            + ", issDistance=" + issDistance
            + '}';
    }
}
