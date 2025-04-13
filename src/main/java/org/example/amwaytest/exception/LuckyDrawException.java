package org.example.amwaytest.exception;

import org.springframework.http.HttpStatus;

public class LuckyDrawException extends AbstractCustomException {
    public LuckyDrawException(String service, String message, int code) {
        super(service, message, code);
    }

    public LuckyDrawException(String service, String message, int code, HttpStatus httpStatus) {
        super(service, message, code, httpStatus);
    }
}
