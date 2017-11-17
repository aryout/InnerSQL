package com.aryout.database.jdbc;

import com.aryout.database.Database;
import com.aryout.database.Table;
import com.aryout.database.jdbc.adapters.StatementAdapter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 97390 on 11/14/2017.
 */
public class JDBCStatement extends StatementAdapter {
    Database database;

    public JDBCStatement(Database database){
        this.database = database;
    }

    public int executeUpdate(String sqlString) throws SQLException{
        try {
            database.execute(sqlString);
            return database.affectedRows();
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
    }

    public ResultSet executeQuery(String sqlString) throws SQLException{
        try {
            Table result = database.execute(sqlString);
            return new JDBCResultSet(result.rows());
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
    }
}
