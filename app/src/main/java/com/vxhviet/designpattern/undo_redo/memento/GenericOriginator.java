package com.vxhviet.designpattern.undo_redo.memento;

/**
 * Created by Viet on 24/08/2017.
 *
 * not use, we will use real object in MainActivity
 */

public class GenericOriginator<T> implements Originator<T> {
    private T state;

    public GenericOriginator(T state) {
        super();
        this.state = state;
    }

    public void setState(T state) {
        this.state = state;
    }

    @Override
    public Memento<T> saveToMemento() {
        return new GenericMemento<T>(state);
    }

    @Override
    public void restoreFromMemento(Memento<T> memento) {
        state = memento.getState();
    }

    @Override
    public T getState() {
        return state;
    }
}