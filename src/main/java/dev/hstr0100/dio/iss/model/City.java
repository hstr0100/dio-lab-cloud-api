package dev.hstr0100.dio.iss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    @JsonProperty("city_id")
    private Long id;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    @JsonProperty("display_name")
    private String displayName;

    @Column(name = "bb_latitude_1")
    @JsonProperty("bb_latitude_1")
    private double bbLatitude1;

    @Column(name = "bb_latitude_2")
    @JsonProperty("bb_latitude_2")
    private double bbLatitude2;

    @Column(name = "bb_longitude_1")
    @JsonProperty("bb_longitude_1")
    private double bbLongitude1;

    @Column(name = "bb_longitude_2")
    @JsonProperty("bb_longitude_2")
    private double bbLongitude2;

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

    public double getBbLatitude1() {
        return bbLatitude1;
    }

    public void setBbLatitude1(double bbLatitude1) {
        this.bbLatitude1 = bbLatitude1;
    }

    public double getBbLatitude2() {
        return bbLatitude2;
    }

    public void setBbLatitude2(double bbLatitude2) {
        this.bbLatitude2 = bbLatitude2;
    }

    public double getBbLongitude1() {
        return bbLongitude1;
    }

    public void setBbLongitude1(double bbLongitude1) {
        this.bbLongitude1 = bbLongitude1;
    }

    public double getBbLongitude2() {
        return bbLongitude2;
    }

    public void setBbLongitude2(double bbLongitude2) {
        this.bbLongitude2 = bbLongitude2;
    }

    @Override
    public String toString() {
        return "City{"
            + "id=" + id
            + ", latitude=" + latitude
            + ", longitude=" + longitude
            + ", name='" + name + '\''
            + ", displayName='" + displayName + '\''
            + ", bbLatitude1=" + bbLatitude1
            + ", bbLatitude2=" + bbLatitude2
            + ", bbLongitude1=" + bbLongitude1
            + ", bbLongitude2=" + bbLongitude2
            + '}';
    }

}
