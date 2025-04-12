package org.example.amwaytest.exception;

import org.springframework.http.HttpStatus;

public class CommandException extends AbstractCustomException {
    public CommandException(String service, String message, int code) {
        super(service, message, code);
    }

    public CommandException(String service, String message, int code, HttpStatus httpStatus) {
        super(service, message, code, httpStatus);
    }
}
