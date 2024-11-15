package dev.hstr0100.dio.iss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ISSDistanceResponse {

    @JsonProperty("message")
    private String message;
    
    @JsonProperty("status_code")
    private int statusCode;

    @JsonProperty("city_data")
    private City cityData;

    @JsonProperty("current_iss_distance_km")
    private double currentDistanceKm;

    @JsonProperty("current_iss_distance_mi")
    private double currentDistanceMi;

    @JsonProperty("current_iss_distance_nm")
    private double currentDistanceNm;


    public ISSDistanceResponse(String message, int statusCode, City cityData, double currentDistanceKm) {
        this.message = message;
        this.statusCode = statusCode;
        this.cityData = cityData;
        this.currentDistanceKm = currentDistanceKm;
        // TODO: helper methods
        this.currentDistanceMi = currentDistanceKm * 0.621371; // km to miles
        this.currentDistanceNm = currentDistanceKm * 0.539957; // km to nautical miles
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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
            + "message='" + message + '\''
            + ", statusCode=" + statusCode
            + ", cityData=" + cityData
            + ", currentDistanceKm=" + currentDistanceKm
            + ", currentDistanceMi=" + currentDistanceMi
            + ", currentDistanceNm=" + currentDistanceNm
            + '}';
    }
}
