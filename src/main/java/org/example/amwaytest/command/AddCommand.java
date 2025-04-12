package org.example.amwaytest.command;

public class AddCommand extends BinaryOperation {
    public AddCommand(Calculator calculator, double right) {
        super(calculator, right);
    }

    @Override
    public void execute() {
        double result = left + right;
        calculator.setCurrent(result);
    }
}