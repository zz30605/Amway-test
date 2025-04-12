package org.example.amwaytest.command;

import org.example.amwaytest.constants.ErrorEnum;
import org.example.amwaytest.util.ExceptionUtil;

public class DivideCommand extends BinaryOperation {
    public DivideCommand(Calculator calculator, double right) {
        super(calculator, right);
    }

    @Override
    public void execute() {
        if (right == 0) {
            throw ExceptionUtil.createAbstractCustomException(ErrorEnum.COMMAND_NOT_ALLOWED, "Cannot divide by zero");
        }
        calculator.setCurrent(left / right);
    }
}