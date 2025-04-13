package org.example.amwaytest.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.amwaytest.exception.AbstractCustomException;
import org.example.amwaytest.exception.CommandException;
import org.example.amwaytest.exception.LuckyDrawException;

import java.util.Arrays;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorEnum {
    COMMAND_NOT_ALLOWED(8101, "command not allowed", CommandException.class),
    DRAW_LIMIT_EXCEEDED(8102, "draw limit exceeded", LuckyDrawException.class);

    private Integer code;
    private String msg;
    private Class<? extends AbstractCustomException> exceptionClass;

    public static ErrorEnum ofException(AbstractCustomException ex) {
        return Arrays.stream(values()).filter(errorEnum -> errorEnum.getExceptionClass().isInstance(ex)).findFirst().get();
    }
}
