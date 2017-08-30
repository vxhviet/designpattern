package com.vxhviet.designpattern.undo_redo.memento;

/**
 * Created by Viet on 24/08/2017.
 *
 * In real application we should put the memento as private inner clas of the object that we want to save
 * to prevent unwanted modification.
 */

public class GenericMemento<T> implements Memento<T> {
    private final T state;

    public GenericMemento(T state) {
        super();
        this.state = state;
    }

    @Override
    public T getState() {
        return state;
    }
}