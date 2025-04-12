package org.example.amwaytest.command;

public class MultiplyCommand extends BinaryOperation {
    public MultiplyCommand(Calculator calculator, double right) {
        super(calculator, right);
    }

    @Override
    public void execute() {
        calculator.setCurrent(left * right);
    }
}