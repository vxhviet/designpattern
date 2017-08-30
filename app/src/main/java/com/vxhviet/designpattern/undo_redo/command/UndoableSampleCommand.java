package com.vxhviet.designpattern.undo_redo.command;

/**
 * Created by Viet on 23/08/2017.
 */

public class UndoableSampleCommand implements Command {
    private final DefaultCommandTarget target;

    public UndoableSampleCommand(DefaultCommandTarget target) {
        this.target = target;
    }

    @Override
    public void doIt() {
        target.doForward();
    }

    @Override
    public String whoAmI() {
        return "I'm a sample undoable command. Can you guess what I do?";
    }

    @Override
    public void undoIt() {
        target.doBackward();
    }

}
