package org.example.amwaytest.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.springframework.http.HttpStatus;

public abstract class AbstractCustomException extends RuntimeException {
    private static final Gson gson =
            (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();

    @Expose
    private final String service;

    @Expose
    private ApplicationError error;

    public AbstractCustomException(String service, String message, int code, HttpStatus status) {
        this.error = new ApplicationError();
        this.service = service;
        this.getError().setMessage(message);
        this.getError().setCode(code);
        this.getError().setHttpStatus(status);
    }

    public AbstractCustomException(String service, String message, int code) {
        this.error = new ApplicationError();
        this.service = service;
        this.getError().setMessage(message);
        this.getError().setCode(code);
    }

    public ApplicationError getError() {
        return this.error;
    }

    public void setError(ApplicationError error) {
        this.error = error;
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public String getMessage() {
        return gson.toJson(this);
    }
}
