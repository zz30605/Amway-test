package org.example.amwaytest.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.springframework.http.HttpStatus;

public class ApplicationError {
    private static final Gson gson =
            (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();

    @Expose
    private String message = "An unknown error occurred.";

    @Expose
    private int code;

    @JsonIgnore
    private HttpStatus httpStatus;

    public ApplicationError() {}

    public ApplicationError(String message) {
        this.message = message;
    }

    public ApplicationError(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public ApplicationError(String message, int code, HttpStatus httpStatus) {
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String toJson() {
        return gson.toJson(this);
    }
}
