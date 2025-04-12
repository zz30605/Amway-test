package org.example.amwaytest.handler;

import jakarta.validation.ConstraintViolationException;
import org.example.amwaytest.constants.ErrorEnum;
import org.example.amwaytest.exception.AbstractCustomException;
import org.example.amwaytest.exception.CommandException;
import org.example.amwaytest.exception.CustomExceptionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ServerErrorException;

@RestControllerAdvice(basePackages = "org.example.amwaytest")
public class GlobalExceptionHandler extends AbstractGlobalExceptionHandler {
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

    @ExceptionHandler(CommandException.class)
    public ResponseEntity<String> handle(CommandException ex) {
        ErrorEnum err = ErrorEnum.COMMAND_NOT_ALLOWED;
        AbstractCustomException cex =
                CustomExceptionFactory.create(err.getExceptionClass(), err.getMsg() + ex.getMessage(), err.getCode());
        return new ResponseEntity<>(cex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
