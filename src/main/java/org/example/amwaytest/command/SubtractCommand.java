package org.example.amwaytest.command;

public class SubtractCommand extends BinaryOperation {
    public SubtractCommand(Calculator calculator, double right) {
        super(calculator, right);
    }

    @Override
    public void execute() {
        calculator.setCurrent(left - right);
    }
}