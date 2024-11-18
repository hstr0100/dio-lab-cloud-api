package dev.hstr0100.dio.iss.exception;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String message) {
        super(message);
    }

    public CityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
