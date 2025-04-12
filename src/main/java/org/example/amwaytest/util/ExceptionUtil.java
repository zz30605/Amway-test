package org.example.amwaytest.util;

import org.example.amwaytest.constants.ErrorEnum;
import org.example.amwaytest.exception.AbstractCustomException;
import org.example.amwaytest.exception.CustomExceptionFactory;

public final class ExceptionUtil {
    public static AbstractCustomException createAbstractCustomException(final ErrorEnum err, final String detail) {
        return createAbstractCustomException(err.getExceptionClass(), err.getMsg() + ": " + detail, err.getCode());
    }

    private static AbstractCustomException createAbstractCustomException(
            final Class<? extends AbstractCustomException> clazz, final String message, final int code) {
        return CustomExceptionFactory.create(clazz, message, code);
    }
}
