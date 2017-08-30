package com.vxhviet.designpattern.undo_redo.memento;

/**
 * Created by Viet on 24/08/2017.
 */

public interface Originator<T> {
    Memento<T> saveToMemento();

    void restoreFromMemento(Memento<T> memento);

    T getState();
}