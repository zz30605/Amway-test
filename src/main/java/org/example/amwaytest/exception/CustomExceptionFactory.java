package org.example.amwaytest.exception;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Component
public class CustomExceptionFactory {
    @Value("${spring.application.name}")
    private String theServiceName;

    private static String serviceName;

    public CustomExceptionFactory() {}

    public static AbstractCustomException create(
            Class<? extends AbstractCustomException> classType, String message, int errorCode, HttpStatus httpStatus) {
        try {
            Constructor<?> ctor = classType.getConstructor(String.class, String.class, Integer.TYPE, HttpStatus.class);
            return (AbstractCustomException) ctor.newInstance(serviceName, message, errorCode, httpStatus);
        } catch (InvocationTargetException
                | IllegalAccessException
                | InstantiationException
                | NoSuchMethodException var5) {
            return create(var5);
        }
    }

    public static AbstractCustomException create(
            Class<? extends AbstractCustomException> classType, String message, int errorCode) {
        try {
            Constructor<?> ctor = classType.getConstructor(String.class, String.class, Integer.TYPE);
            return (AbstractCustomException) ctor.newInstance(serviceName, message, errorCode);
        } catch (InvocationTargetException
                | IllegalAccessException
                | InstantiationException
                | NoSuchMethodException var4) {
            return create(var4);
        }
    }

    private static CustomExceptionFactoryException create(Exception ex) {
        return new CustomExceptionFactoryException(serviceName, ex.getMessage(), 9999);
    }

    @PostConstruct
    private void initServiceName() {
        serviceName = this.theServiceName;
    }
}
