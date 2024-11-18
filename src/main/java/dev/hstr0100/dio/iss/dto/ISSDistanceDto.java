package dev.hstr0100.dio.iss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ISSDistanceDto {

    private double kilometers;
    private double miles;
    @JsonProperty("nautical_miles")
    private double nauticalMiles;

    public ISSDistanceDto(double kilometers) {
        this.kilometers = kilometers;
        this.miles = kilometers * 0.621371;  // km to miles
        this.nauticalMiles = kilometers * 0.539957;  // km to nautical miles
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
        // Recalculate miles and nautical miles when km changes
        this.miles = kilometers * 0.621371;
        this.nauticalMiles = kilometers * 0.539957;
    }

    public double getMiles() {
        return miles;
    }

    public double getNauticalMiles() {
        return nauticalMiles;
    }

    @Override
    public String toString() {
        return "Distance{"
            + "kilometers=" + kilometers
            + ", miles=" + miles
            + ", nauticalMiles=" + nauticalMiles
            + '}';
    }
}
