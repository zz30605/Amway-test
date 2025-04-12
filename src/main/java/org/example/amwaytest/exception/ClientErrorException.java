package org.example.amwaytest.exception;

import org.springframework.http.HttpStatus;

public class ClientErrorException extends AbstractCustomException {
    public ClientErrorException(String service, String message, int code) {
        super(service, message, code);
    }

    public ClientErrorException(String service, String message, int code, HttpStatus httpStatus) {
        super(service, message, code, httpStatus);
    }
}
