package org.example.amwaytest.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.amwaytest.exception.AbstractCustomException;
import org.example.amwaytest.exception.CommandException;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorEnum {
    COMMAND_NOT_ALLOWED(8101, "command", CommandException.class);

    private Integer code;
    private String msg;
    private Class<? extends AbstractCustomException> exceptionClass;
}
