package org.example.amwaytest.handler;

import com.google.gson.JsonObject;
import org.example.amwaytest.exception.AbstractCustomException;
import org.example.amwaytest.exception.ClientErrorException;
import org.example.amwaytest.util.GsonUtil;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractGlobalExceptionHandler {
    @Value("${spring.application.name}")
    private String serviceName;

    public AbstractGlobalExceptionHandler() {}

    @ExceptionHandler({
        HttpRequestMethodNotSupportedException.class,
        HttpMediaTypeNotSupportedException.class,
        HttpMediaTypeNotAcceptableException.class,
        MissingPathVariableException.class,
        MissingServletRequestParameterException.class,
        ServletRequestBindingException.class,
        ConversionNotSupportedException.class,
        TypeMismatchException.class,
        HttpMessageNotReadableException.class,
        HttpMessageNotWritableException.class,
        MethodArgumentNotValidException.class,
        MissingServletRequestPartException.class,
        BindException.class,
        NoHandlerFoundException.class,
        AsyncRequestTimeoutException.class,
        AbstractCustomException.class,
        Exception.class
    })
    @Nullable
    public final ResponseEntity<Object> handleException(Exception ex, WebRequest request) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus status;
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            status = HttpStatus.METHOD_NOT_ALLOWED;
            return this.handleHttpRequestMethodNotSupported(
                    (HttpRequestMethodNotSupportedException) ex, headers, status, request);
        } else if (ex instanceof HttpMediaTypeNotSupportedException) {
            status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
            return this.handleHttpMediaTypeNotSupported(
                    (HttpMediaTypeNotSupportedException) ex, headers, status, request);
        } else if (ex instanceof HttpMediaTypeNotAcceptableException) {
            status = HttpStatus.NOT_ACCEPTABLE;
            return this.handleHttpMediaTypeNotAcceptable(
                    (HttpMediaTypeNotAcceptableException) ex, headers, status, request);
        } else if (ex instanceof MissingPathVariableException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return this.handleMissingPathVariable((MissingPathVariableException) ex, headers, status, request);
        } else if (ex instanceof MissingServletRequestParameterException) {
            status = HttpStatus.BAD_REQUEST;
            return this.handleMissingServletRequestParameter(
                    (MissingServletRequestParameterException) ex, headers, status, request);
        } else if (ex instanceof ServletRequestBindingException) {
            status = HttpStatus.BAD_REQUEST;
            return this.handleServletRequestBindingException(
                    (ServletRequestBindingException) ex, headers, status, request);
        } else if (ex instanceof ConversionNotSupportedException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return this.handleConversionNotSupported((ConversionNotSupportedException) ex, headers, status, request);
        } else if (ex instanceof TypeMismatchException) {
            status = HttpStatus.BAD_REQUEST;
            return this.handleTypeMismatch((TypeMismatchException) ex, headers, status, request);
        } else if (ex instanceof HttpMessageNotReadableException) {
            status = HttpStatus.BAD_REQUEST;
            return this.handleHttpMessageNotReadable((HttpMessageNotReadableException) ex, headers, status, request);
        } else if (ex instanceof HttpMessageNotWritableException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return this.handleHttpMessageNotWritable((HttpMessageNotWritableException) ex, headers, status, request);
        } else if (ex instanceof MethodArgumentNotValidException) {
            status = HttpStatus.BAD_REQUEST;
            return this.handleMethodArgumentNotValid((MethodArgumentNotValidException) ex, headers, status, request);
        } else if (ex instanceof MissingServletRequestPartException) {
            status = HttpStatus.BAD_REQUEST;
            return this.handleMissingServletRequestPart(
                    (MissingServletRequestPartException) ex, headers, status, request);
        } else if (ex instanceof BindException) {
            status = HttpStatus.BAD_REQUEST;
            return this.handleBindException((BindException) ex, headers, status, request);
        } else if (ex instanceof NoHandlerFoundException) {
            status = HttpStatus.NOT_FOUND;
            return this.handleNoHandlerFoundException((NoHandlerFoundException) ex, headers, status, request);
        } else if (ex instanceof AsyncRequestTimeoutException) {
            status = HttpStatus.SERVICE_UNAVAILABLE;
            return this.handleAsyncRequestTimeoutException((AsyncRequestTimeoutException) ex, headers, status, request);
        } else if (ex instanceof AbstractCustomException) {
            return this.handleAbstractCustomException((AbstractCustomException) ex, headers, request);
        } else {
            throw ex;
        }
    }

    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
            HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleMissingPathVariable(
            MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleServletRequestBindingException(
            ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleConversionNotSupported(
            ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleTypeMismatch(
            TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleHttpMessageNotWritable(
            HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getBindingResult(), 9998, status);
    }

    protected ResponseEntity<Object> handleMissingServletRequestPart(
            MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleBindException(
            BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getBindingResult(), 9998, status);
    }

    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(
            AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.getObjectResponseEntity(ex.getMessage(), 9999, status);
    }

    private ResponseEntity<Object> handleAbstractCustomException(
            AbstractCustomException ex, HttpHeaders headers, WebRequest request) {
        return new ResponseEntity(ex.getMessage(), headers, ex.getError().getHttpStatus());
    }

    private ResponseEntity<Object> getObjectResponseEntity(String message, int code, HttpStatus status) {
        return this.createResponseEntity(message, code, status);
    }

    private ResponseEntity<Object> getObjectResponseEntity(BindingResult bindingResult, int code, HttpStatus status) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<JsonObject> fields = new ArrayList();
        Iterator var6 = fieldErrors.iterator();

        while (var6.hasNext()) {
            FieldError fieldError = (FieldError) var6.next();
            JsonObject field = new JsonObject();
            field.addProperty("field", fieldError.getField());
            field.addProperty("message", fieldError.getDefaultMessage());
            fields.add(field);
        }

        String message = GsonUtil.toJson(fields);
        return this.createResponseEntity(message, code, status);
    }

    private ResponseEntity<Object> createResponseEntity(String message, int code, HttpStatus status) {
        ClientErrorException clientErrorException = new ClientErrorException(serviceName, message, code);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(clientErrorException.toJson(), headers, status);
    }
}
