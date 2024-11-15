package dev.hstr0100.dio.iss.handler.exception;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ISSServiceUnavailableException extends RuntimeException {

    public ISSServiceUnavailableException(String message) {
        super(message);
    }

    public ISSServiceUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
