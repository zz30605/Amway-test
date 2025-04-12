package org.example.amwaytest.exception;

import org.springframework.http.HttpStatus;

public class CustomExceptionFactoryException extends AbstractCustomException {
    public CustomExceptionFactoryException(String service, String message, int code) {
        super(service, message, code);
    }

    public CustomExceptionFactoryException(String service, String message, int code, HttpStatus httpStatus) {
        super(service, message, code, httpStatus);
    }
}
