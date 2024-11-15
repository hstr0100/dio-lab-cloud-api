package dev.hstr0100.dio.iss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ISSDistanceResponse extends AbstractResponse {

    @JsonProperty("city_data")
    private City cityData;

    @JsonProperty("iss_distance_kilometers")
    private double currentDistanceKm;

    @JsonProperty("iss_distance_miles")
    private double currentDistanceMi;

    @JsonProperty("iss_distance_nautical_miles")
    private double currentDistanceNm;

    public ISSDistanceResponse(int statusCode, String message, City cityData, double currentDistanceKm) {
        super(statusCode, message);
        this.cityData = cityData;
        this.currentDistanceKm = currentDistanceKm;
        // TODO: helper methods
        this.currentDistanceMi = currentDistanceKm * 0.621371; // km to miles
        this.currentDistanceNm = currentDistanceKm * 0.539957; // km to nautical miles
    }

    public City getCityData() {
        return cityData;
    }

    public void setCityData(City cityData) {
        this.cityData = cityData;
    }

    public double getCurrentDistanceKm() {
        return currentDistanceKm;
    }

    public void setCurrentDistanceKm(double currentDistance) {
        this.currentDistanceKm = currentDistance;
    }

    public double getCurrentDistanceMi() {
        return currentDistanceMi;
    }

    public void setCurrentDistanceMi(double currentDistanceMi) {
        this.currentDistanceMi = currentDistanceMi;
    }

    public double getCurrentDistanceNm() {
        return currentDistanceNm;
    }

    public void setCurrentDistanceNm(double currentDistanceNm) {
        this.currentDistanceNm = currentDistanceNm;
    }

    @Override
    public String toString() {
        return "ISSDistanceResponse{"
            + ", cityData=" + cityData
            + ", currentDistanceKm=" + currentDistanceKm
            + ", currentDistanceMi=" + currentDistanceMi
            + ", currentDistanceNm=" + currentDistanceNm
            + '}';
    }
}
