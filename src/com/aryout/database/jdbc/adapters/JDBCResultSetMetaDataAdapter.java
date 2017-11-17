package com.aryout.database.jdbc.adapters;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by 97390 on 11/15/2017.
 */
public class JDBCResultSetMetaDataAdapter implements ResultSetMetaData {

    @Override
    public int getColumnCount() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public int isNullable(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isSigned(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public int getScale(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public String getTableName(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        return 0;
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {
        return null;
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new SQLException("Unsupported");
    }
}
