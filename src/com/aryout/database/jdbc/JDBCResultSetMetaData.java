package com.aryout.database.jdbc;

import com.aryout.database.Cursor;
import com.aryout.database.jdbc.adapters.JDBCResultSetMetaDataAdapter;

import java.sql.SQLException;

import static java.sql.Types.VARCHAR;

/**
 * Created by 97390 on 11/14/2017.
 */
public class JDBCResultSetMetaData extends JDBCResultSetMetaDataAdapter {
    private final Cursor cursor;

    public JDBCResultSetMetaData(Cursor cursor){
        this.cursor = cursor;;
    }

    public int getColumnType(int column) throws SQLException{
        return VARCHAR;
    }

    public String getColumnTypeName(int column) throws SQLException{
        return "VARCHAR";
    }
}
