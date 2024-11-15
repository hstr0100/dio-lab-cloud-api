package dev.hstr0100.dio.iss.model;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class ErrorResponse extends AbstractResponse {

    private String error;

    public ErrorResponse(int statusCode, String message, String error) {
        super(statusCode, message);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" + "error=" + error + '}';
    }
}
