package dev.hstr0100.dio.iss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ISSLocationDto {

    @JsonProperty("iss_position")
    private ISSPosition issPosition;

    private long timestamp;

    private String message;

    public ISSPosition getIssPosition() {
        return issPosition;
    }

    public void setIssPosition(ISSPosition issPosition) {
        this.issPosition = issPosition;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ISSLocation{"
            + "issPosition=" + issPosition
            + ", timestamp=" + timestamp
            + ", message='" + message + '\''
            + '}';
    }

    // Inner class to represent the position object
    public static class ISSPosition {

        private double longitude;

        private double latitude;

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        @Override
        public String toString() {
            return "ISSPosition{"
                + "longitude='" + longitude + '\''
                + ", latitude='" + latitude + '\''
                + '}';
        }
    }
}
