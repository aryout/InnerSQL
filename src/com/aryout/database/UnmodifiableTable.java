package com.aryout.database;


import java.io.IOException;
import java.util.Collection;

/**
 * Created by 97390 on 11/14/2017.
 */
public class UnmodifiableTable implements Table{
    private Table wrapped;

    public  UnmodifiableTable(Table wrapped){
        this.wrapped = wrapped;
    }
    public Object clone() throws CloneNotSupportedException{
        UnmodifiableTable copy = (UnmodifiableTable) super.clone();
        copy.wrapped = (Table)(wrapped.clone());
        return copy;
    };

    public String name(){
        return wrapped.name();
    };

    public void rename(String newName){
        wrapped.rename(newName);
    };

    public boolean isDirty(){
        return wrapped.isDirty();
    };

    public final void illegal(){
        throw new UnsupportedOperationException();
    }

    public int insert(String[] columnNames, Object[] values){
        illegal();
        return 0;
    };

    public int insert(Collection columnNames, Collection values){
        illegal();
        return 0;
    };

    public int insert(Object[] values){
        illegal();
        return 0;
    }

    public int insert(Collection values){
        illegal();
        return 0;
    };

    public int update(Selector where){
        illegal();
        return 0;
    };

    public int delete(Selector where){
        illegal();
        return 0;
    };

    public void begin(){
        illegal();
    };

    public void commit(boolean all) throws IllegalStateException{
        illegal();
    };

    public void rollback(boolean all) throws IllegalStateException{
        illegal();
    };

    public static final boolean ALL = true;

    public Table select(Selector where, String[] requestedColumns, Table[] other){
        return wrapped.select(where, requestedColumns, other);
    };
    public Table select(Selector where, String[] requestedColumns){
        return wrapped.select(where, requestedColumns);
    };
    public Table select(Selector where){
        return  wrapped.select(where);
    };
    public Table select(Selector where, Collection requestedColumns, Collection other){
        return wrapped.select(where, requestedColumns, other);
    };
    public Table select(Selector where, Collection requestedColumns){
        return wrapped.select(where, requestedColumns);
    };

    public Cursor rows(){
        return wrapped.rows();
    };

    public void export(Table.Exporter exporter) throws IOException{
        wrapped.export(exporter);
    };

    public Table extract(){
        return wrapped;
    }
}
