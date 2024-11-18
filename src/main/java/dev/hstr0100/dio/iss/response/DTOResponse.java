package dev.hstr0100.dio.iss.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
public class DTOResponse<T> extends AbstractResponse {

    @JsonProperty("data")
    private T data;

    public DTOResponse(int statusCode, String message, T data) {
        super(statusCode, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DTOResponse{" + "data=" + data + '}';
    }
}
