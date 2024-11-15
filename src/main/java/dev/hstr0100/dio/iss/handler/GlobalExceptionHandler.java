package dev.hstr0100.dio.iss.handler;

import dev.hstr0100.dio.iss.model.ErrorResponse;
import dev.hstr0100.dio.iss.util.CityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCityNotFoundException(CityNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("City Not Found", ex.getMessage(), HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ex.printStackTrace();

        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", "An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
