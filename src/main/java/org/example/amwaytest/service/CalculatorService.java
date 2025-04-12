package org.example.amwaytest.service;

import org.example.amwaytest.command.AddCommand;
import org.example.amwaytest.command.Calculator;
import org.example.amwaytest.command.DivideCommand;
import org.example.amwaytest.command.MultiplyCommand;
import org.example.amwaytest.command.SubtractCommand;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private final Calculator calculator = new Calculator();

    public double add(double val) {
        calculator.executeCommand(new AddCommand(calculator, val));
        return calculator.getCurrent();
    }

    public double subtract(double val) {
        calculator.executeCommand(new SubtractCommand(calculator, val));
        return calculator.getCurrent();
    }

    public double multiply(double val) {
        calculator.executeCommand(new MultiplyCommand(calculator, val));
        return calculator.getCurrent();
    }

    public double divide(double val) {
        calculator.executeCommand(new DivideCommand(calculator, val));
        return calculator.getCurrent();
    }

    public double undo() {
        calculator.undo();
        return calculator.getCurrent();
    }

    public double redo() {
        calculator.redo();
        return calculator.getCurrent();
    }
}
