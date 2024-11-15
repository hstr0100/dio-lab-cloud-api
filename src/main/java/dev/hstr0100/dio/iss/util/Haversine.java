package dev.hstr0100.dio.iss.util;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public final class Haversine {

    private Haversine() {

    }

    public static double calculateDistanceKM(double lat1, double lng1, double lat2, double lng2) {
        int r = 6371; // Average radius of the earth in km

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return r * c;// Distance in km
    }
}
