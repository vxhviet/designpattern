package com.vxhviet.designpattern.undo_redo.command;

import android.util.Log;
import android.widget.TextView;

/**
 * Created by Viet on 23/08/2017.
 */

public class UndoableSampleCommand implements Command {
    //private final DefaultCommandTarget target;

    //we use real target here
    private TextView target;

    public UndoableSampleCommand(TextView target) {
        this.target = target;
    }

    @Override
    public void doIt() {
        //target.doForward();

        //For each doIt() command, there's a counter undoIt() command that do exactly the opposite.
        //For example, increase by 1
        int current = Integer.valueOf((String) target.getText());
        current++;
        target.setText("" + current);
        Log.d("TEST_COMMAND", "State transition to " + current);
    }

    @Override
    public String whoAmI() {
        return "I'm a sample undoable command. Can you guess what I do?";
    }

    @Override
    public void undoIt() {
        //target.doBackward();

        //For each doIt() command, there's a counter undoIt() command that do exactly the opposite.
        //For example, decrease by 1
        int current = Integer.valueOf((String) target.getText());
        current--;
        target.setText("" + current);
        Log.d("TEST_COMMAND", "Rolled back state to " + current);
    }

}
