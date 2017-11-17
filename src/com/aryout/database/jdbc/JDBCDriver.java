package com.aryout.database.jdbc;

import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by 97390 on 11/14/2017.
 */
public class JDBCDriver implements Driver {
    private JDBCConnection connection;
    static {
        try {
            java.sql.DriverManager.registerDriver(new JDBCDriver());
        }catch (SQLException e){
            System.err.println(e);
        }
    }

    public boolean acceptsURL(String url) throws SQLException{
        return url.startsWith("file:/");
    }

    public JDBCConnection connect(String uri, Properties info) throws SQLException{ // public Connection
        try {
            return connection = new JDBCConnection(uri);
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
    }

    public int getMajorVersion(){
        return 1;
    }
    public int getMinorVersion(){
        return 0;
    }
    public boolean jdbcCompliant(){
        return false;
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException{
        return new DriverPropertyInfo[0];
    }

    public  Logger getParentLogger() throws SQLFeatureNotSupportedException{ // houlai jia de
        return null;
    }
}
