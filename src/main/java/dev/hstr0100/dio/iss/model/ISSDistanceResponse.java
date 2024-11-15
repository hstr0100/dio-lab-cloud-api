package dev.hstr0100.dio.iss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ISSDistanceResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("current_iss_distance_km")
    private double currentDistanceKm;

    @JsonProperty("current_iss_distance_mi")
    private double currentDistanceMi;

    @JsonProperty("current_iss_distance_nm")
    private double currentDistanceNm;

    @JsonProperty("status_code")
    private int statusCode;

    public ISSDistanceResponse(String message, String cityName, double currentDistanceKm, int statusCode) {
        this.message = message;
        this.cityName = cityName;
        this.currentDistanceKm = currentDistanceKm;
        // TODO: helper methods
        this.currentDistanceMi = currentDistanceKm * 0.621371; // km to miles
        this.currentDistanceNm = currentDistanceKm * 0.539957; // km to nautical miles
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ISSDistanceResponse{"
            + "message='" + message + '\''
            + ", cityName='" + cityName + '\''
            + ", currentDistanceKm=" + currentDistanceKm
            + ", currentDistanceMi=" + currentDistanceMi
            + ", currentDistanceNm=" + currentDistanceNm
            + ", statusCode=" + statusCode
            + '}';
    }
}
