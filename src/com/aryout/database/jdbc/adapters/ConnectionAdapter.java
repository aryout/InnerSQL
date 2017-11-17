package com.aryout.database.jdbc.adapters;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Created by 97390 on 11/14/2017.
 */
public class ConnectionAdapter implements Connection{
    public ConnectionAdapter() throws SQLException{}

    public ConnectionAdapter(Driver driver, String url, Properties info) throws SQLException{
        throw new SQLException("Unsupported");
    }

    @Override
    public Statement createStatement() throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {

    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void commit() throws SQLException {

    }

    @Override
    public void rollback() throws SQLException {

    }

    @Override
    public void close() throws SQLException {

    }

    @Override
    public boolean isClosed() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public String getCatalog() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void clearWarnings() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public int getHoldability() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Clob createClob() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Blob createBlob() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public NClob createNClob() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public String getSchema() throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        throw new SQLException("Unsupported");
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
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