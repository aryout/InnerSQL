package com.aryout.tools;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by 97390 on 11/14/2017.
 */
public final class ArrayIterator implements Iterator{
    private int position = 0;
    private final Object[] items;

    public ArrayIterator(Object[] items){
        this.items = items;;
    }

    public boolean hasNext(){
        return (position < items.length);
    }

    public Object next(){
        if (position >= items.length){
            throw new NoSuchElementException();
        }
        return items[position++];
    }

    public void remove(){
        throw new UnsupportedOperationException("ArrayIterator.remove");
    }

    public Object[] toArray(){
        return (Object[]) items.clone();
    }
}
