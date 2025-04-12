package org.example.amwaytest.command;

public abstract class BinaryOperation implements Command {
    protected double left;
    protected double right;
    protected Calculator calculator;

    public BinaryOperation(Calculator calculator, double right) {
        this.left = calculator.getCurrent();
        this.right = right;
        this.calculator = calculator;
    }

    @Override
    public void undo() {
        calculator.setCurrent(left);
    }
}
