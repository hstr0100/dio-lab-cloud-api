package dev.hstr0100.dio.iss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ISSDistanceResponse extends AbstractResponse {

    @JsonProperty("city_data")
    private City cityData;

    @JsonProperty("iss_distance")
    private ISSDistance issDistance;

    public ISSDistanceResponse(int statusCode, String message, City cityData, double currentDistanceKm) {
        super(statusCode, message);
        this.cityData = cityData;
        this.issDistance = new ISSDistance(currentDistanceKm);
    }

    public City getCityData() {
        return cityData;
    }

    public void setCityData(City cityData) {
        this.cityData = cityData;
    }

    public ISSDistance getIssDistance() {
        return issDistance;
    }

    public void setIssDistance(ISSDistance issDistance) {
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
