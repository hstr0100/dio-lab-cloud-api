package dev.hstr0100.dio.iss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class CityDto {

    private String lat;
    private String lon;
    private String name;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("boundingbox")
    private List<String> boundingBox;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(List<String> boundingBox) {
        this.boundingBox = boundingBox;
    }

    @Override
    public String toString() {
        return "CityDTO{"
            + "lat=" + lat
            + ", lon=" + lon
            + ", name=" + name
            + ", displayName=" + displayName
            + ", boundingBox=" + boundingBox
            + '}';
    }

}
