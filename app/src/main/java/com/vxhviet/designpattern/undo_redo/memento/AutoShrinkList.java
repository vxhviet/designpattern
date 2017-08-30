package com.vxhviet.designpattern.undo_redo.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viet on 28/08/2017.
 *
 * List that will:
 * - Auto discard elements in a FIFO fashion if it grows over its max size.
 * - Auto discard elements that are above the current pointer.
 */

public class AutoShrinkList {
    private int mMaxSize;
    private List<Object> mList = new ArrayList<>();
    private int mListPointer = 0;

    public AutoShrinkList(int maxSize) {
        mMaxSize = maxSize;
    }

    public void add(Object m){
        if (mList.size() > mListPointer) {
            removeElementsAboveCurrentListPointer();
        }

        mList.add(m);
        mListPointer++;

        fitListToMaxSize();
    }

    public Object get(int i){
        mListPointer = i;
        return mList.get(i);
    }

    public int size(){
        return mList.size();
    }

    private void removeElementsAboveCurrentListPointer(){
        while(mList.size() > mListPointer + 1){
            mList.remove(mList.size() - 1);
        }
    }

    private void fitListToMaxSize() {
        if(mList.size() > mMaxSize) {
            mList.remove(0);
            mListPointer--;
        }
    }
}
