package org.example.amwaytest.command;

import lombok.Getter;
import lombok.Setter;
import org.example.amwaytest.constants.ErrorEnum;
import org.example.amwaytest.util.ExceptionUtil;

import java.util.Stack;

public class Calculator {
    @Getter
    @Setter
    private double current = 0;

    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        } else {
            throw ExceptionUtil.createAbstractCustomException(ErrorEnum.COMMAND_NOT_ALLOWED, "Nothing to undo");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        } else {
            throw ExceptionUtil.createAbstractCustomException(ErrorEnum.COMMAND_NOT_ALLOWED, "Nothing to redo");
        }
    }
}