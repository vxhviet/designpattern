package com.vxhviet.designpattern.undo_redo.command;

import android.util.Log;

/**
 * Created by Viet on 23/08/2017.
 */

public class CommandExecutor {
    private final CommandStack commandStack;

    public CommandExecutor(int undoBufferSize) {
        super();
        commandStack = new CommandStack(undoBufferSize);
    }

    public void executeCommand(Command cmd) {
        Log.d("TEST_COMMAND", "executeCommand: ");
        commandStack.push(cmd);
        cmd.doIt();
    }

    public void undoLastCommand() {
        Log.d("TEST_COMMAND", "undoLastCommand: ");
        Command cmd = commandStack.getLastCommand();
        if(cmd != null) {
            cmd.undoIt();
        }
    }

    public void redoLastUndoedCommand() {
        Log.d("TEST_COMMAND", "redoLastUndoedCommand: ");
        Command cmd = commandStack.recoverLastGettedCommand();
        if (cmd != null) {
            cmd.doIt();
        }
    }
}