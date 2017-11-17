package com.aryout.database.jdbc;

import com.aryout.database.Cursor;
import com.aryout.database.jdbc.adapters.ResultSetAdapter;


import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by 97390 on 11/14/2017.
 */
public class JDBCResultSet extends ResultSetAdapter {
private final Cursor cursor;
    private static final NumberFormat format = NumberFormat.getInstance();

    public JDBCResultSet(Cursor cursor){
        this.cursor = cursor;
    }

    public boolean next(){
        return cursor.advance();
    }

    public String getString(String columnName) throws SQLException{
        try {
            Object contents = cursor.column(columnName);
            return (contents == null) ? null : contents.toString();
        }catch (IndexOutOfBoundsException e){
            throw new SQLException("column " + columnName + " doesn't exist");
        }
    }

    public double getDouble(String columnName) throws SQLException{
        try {
            String contens = getString(columnName);
            return (contens == null) ? 0.0 : (format).parse(contens).doubleValue();
        }catch (ParseException e){
            throw new SQLException("field doesn't contain a number");
        }
    }

    public int  getInt(String columnName) throws SQLException{
        try {
            String contens = getString(columnName);
            return (contens == null) ? 0 : (format).parse(contens).intValue();
        }catch (ParseException e){
            throw new SQLException("field doesn't contain a number");
        }
    }

    public long getLong(String columnName) throws SQLException{
        try {
            String contens = getString(columnName);
            return (contens == null) ? 0L : (format).parse(contens).longValue();
        }catch (ParseException e){
            throw new SQLException("field doesn't contain a number");
        }
    }

    public void updateNull(String columnName){
        cursor.update(columnName, null);
    }

    public void updateDouble(String columnName, double value){
        cursor.update(columnName, format.format(value));
    }

    public void updateInt(String columnName, long value){
        cursor.update(columnName, format.format(value));
    }

    public ResultSetMetaData getMetaData() throws SQLException{
        return new JDBCResultSetMetaData(cursor);
    }
}
