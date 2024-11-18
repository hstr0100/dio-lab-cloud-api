package dev.hstr0100.dio.iss.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@Entity
@Table(name = "tb_cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    @JsonIgnore
    private Long id;

    private String name;

    @Column(name = "display_name")
    @JsonProperty("display_name")
    private String displayName;

    private double latitude;

    private double longitude;

    @Column(name = "min_latitude")
    @JsonProperty("min_latitude")
    private double minLatitude;

    @Column(name = "max_latitude")
    @JsonProperty("max_latitude")
    private double maxLatitude;

    @Column(name = "min_longitude")
    @JsonProperty("min_longitude")
    private double minLongitude;

    @Column(name = "max_longitude")
    @JsonProperty("max_longitude")
    private double maxLongitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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

    public double getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public double getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public double getMinLongitude() {
        return minLongitude;
    }

    public void setMinLongitude(double minLongitude) {
        this.minLongitude = minLongitude;
    }

    public double getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(double maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    @Override
    public String toString() {
        return "City{"
            + "id=" + id
            + ", latitude=" + latitude
            + ", longitude=" + longitude
            + ", name='" + name + '\''
            + ", displayName='" + displayName + '\''
            + ", minLatitude=" + minLatitude
            + ", maxLatitude=" + maxLatitude
            + ", minLongitude=" + minLongitude
            + ", maxLongitude=" + maxLongitude
            + '}';
    }

}
