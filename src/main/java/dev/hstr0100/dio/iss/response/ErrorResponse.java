package dev.hstr0100.dio.iss.response;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ErrorResponse extends AbstractResponse {

    public ErrorResponse(int statusCode, String message) {
        super(statusCode, message);
    }
}