package com.vxhviet.designpattern.undo_redo.memento;

import android.util.Log;

import com.vxhviet.designpattern.undo_redo.UndoRedoActivity;

/**
 * Created by Viet on 28/08/2017.
 * <p>
 * Note Caretaker should not modify the memento or need to know its structure.
 */

public class Caretaker {
    private AutoShrinkList mList = new AutoShrinkList(7);

    public void save(UndoRedoActivity act) {
        Memento m = act.saveToMemento();
        mList.add(m);
        Log.d("DEBUG_MEMENTO", "save: mList size: " + mList.size() + " memento: " + m.getState());
    }

    public void restoreToState(UndoRedoActivity act, int index) {
        act.restoreFromMemento((Memento) mList.get(index));
    }

    public AutoShrinkList getList() {
        return mList;
    }
}
