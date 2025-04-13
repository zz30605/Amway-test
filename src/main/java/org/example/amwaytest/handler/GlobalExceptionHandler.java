package org.example.amwaytest.handler;

import org.example.amwaytest.constants.ErrorEnum;
import org.example.amwaytest.exception.AbstractCustomException;
import org.example.amwaytest.exception.CustomExceptionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ServerErrorException;

@RestControllerAdvice(basePackages = "org.example.amwaytest")
public class GlobalExceptionHandler {
    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<String> handle(ServerErrorException ex) {
        return new ResponseEntity<>(
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handle(HttpClientErrorException ex) {
        return new ResponseEntity<>(
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<String> handle(HttpServerErrorException ex) {
        return new ResponseEntity<>(
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AbstractCustomException.class)
    public ResponseEntity<String> handle(AbstractCustomException ex) {
        ErrorEnum err = ErrorEnum.ofException(ex);
        AbstractCustomException cex =
                CustomExceptionFactory.create(err.getExceptionClass(), err.getMsg() + ex.getMessage(), err.getCode());
        return new ResponseEntity<>(cex.getMessage(), HttpStatus.BAD_REQUEST);
    }
//
//    @ExceptionHandler(LuckyDrawException.class)
//    public ResponseEntity<String> handle(LuckyDrawException ex) {
//        ErrorEnum err = ErrorEnum.DRAW_LIMIT_EXCEEDED;
//        AbstractCustomException cex =
//                CustomExceptionFactory.create(err.getExceptionClass(), err.getMsg() + ex.getMessage(), err.getCode());
//        return new ResponseEntity<>(cex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
}
