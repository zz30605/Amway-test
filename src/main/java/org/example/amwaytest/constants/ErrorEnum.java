package org.example.amwaytest.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.amwaytest.exception.AbstractCustomException;
import org.example.amwaytest.exception.CommandException;
import org.example.amwaytest.exception.LuckyDrawException;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorEnum {
    COMMAND_NOT_ALLOWED(8101, "command not allowed", CommandException.class),
    DRAW_LIMIT_EXCEEDED(8102, "draw limit exceeded", LuckyDrawException.class);

    private Integer code;
    private String msg;
    private Class<? extends AbstractCustomException> exceptionClass;
}
