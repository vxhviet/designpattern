package com.vxhviet.designpattern.undo_redo.command;

import android.util.Log;

/**
 * Created by Viet on 23/08/2017.
 */

public class DefaultCommandTarget {
    private int state;

    public DefaultCommandTarget(int state) {
        super();
        this.state = state;
    }

    public void doForward() {
        state++;
        Log.d("TEST_COMMAND", "State transition to " + state);
    }

    public void doBackward() {
        state--;
        Log.d("TEST_COMMAND", "Rolled back state to " + state);
    }
}