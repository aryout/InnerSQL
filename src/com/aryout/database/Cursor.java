package com.aryout.database;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by 97390 on 11/14/2017.
 */
public interface Cursor {
    String tableName();

    boolean advance() throws NoSuchElementException;

    Object column(String columnName);

    Iterator columns();

    boolean isTraversing(Table t);

    Object update(String columnName, Object newValue);

    void delete();
}
