package dev.hstr0100.dio.iss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class CityResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("status_code")
    private int statusCode;

    @JsonProperty("city_data")
    private City cityData;

    public CityResponse(String message, int statusCode, City cityData) {
        this.message = message;
        this.statusCode = statusCode;
        this.cityData = cityData;
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

    @Override
    public String toString() {
        return "CityResponse{"
            + "message='" + message + '\''
            + ", statusCode=" + statusCode
            + ", cityData=" + cityData
            + '}';
    }
}
