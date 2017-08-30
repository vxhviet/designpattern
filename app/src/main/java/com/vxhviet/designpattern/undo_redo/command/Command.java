package com.vxhviet.designpattern.undo_redo.command;

/**
 * Created by Viet on 23/08/2017.
 */

public interface Command {
    void doIt();

    void undoIt();

    String whoAmI();
}
