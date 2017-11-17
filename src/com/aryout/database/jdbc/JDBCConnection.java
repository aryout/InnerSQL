package com.aryout.database.jdbc;

import com.aryout.database.Database;
import com.aryout.database.jdbc.adapters.ConnectionAdapter;
import com.aryout.text.ParseFailure;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by 97390 on 11/14/2017.
 */
public class JDBCConnection extends ConnectionAdapter {
    private Database database;

    public JDBCConnection(String uri) throws SQLException, URISyntaxException, IOException{
        this(new URI(uri));
    }

    public JDBCConnection(URI uri) throws SQLException, IOException{
        database = new Database(uri);
    }

    public void close() throws SQLException{
        try {
            autoCommitState.close();
            database.dump();
            database = null;
        }catch (IOException e){
            throw new SQLException(e.getMessage());
        }
    }

    public Statement createStatement() throws SQLException{
        return new JDBCStatement(database);
    }

    public void commit() throws SQLException{
        autoCommitState.commit();
    }

    public void rollback() throws SQLException{
        autoCommitState.rollback();
    }

    public void setAutoCommit(boolean enable) throws SQLException{
        autoCommitState.setAutoCommit(enable);
    }

    public boolean getAutoCommit() throws SQLException{
        return autoCommitState == enabled;
    }

    private interface AutoCommitBehavior{
        void close() throws SQLException;
        void commit() throws SQLException;
        void rollback() throws SQLException;
        void setAutoCommit(boolean enable) throws SQLException;
    }

    private AutoCommitBehavior enabled = new AutoCommitBehavior() {
        @Override
        public void close() throws SQLException {

        }

        @Override
        public void commit() throws SQLException {

        }

        @Override
        public void rollback() throws SQLException {

        }

        @Override
        public void setAutoCommit(boolean enable) throws SQLException {
            if (!enable){
                database.begin();
                autoCommitState = disable;
            }
        }
    };

    private AutoCommitBehavior disable = new AutoCommitBehavior() {
        @Override
        public void close() throws SQLException {
            try {
                database.commit();
            }catch (ParseFailure e){
                throw new SQLException(e.getMessage());
            }
        }

        @Override
        public void commit() throws SQLException {
            try {
                database.commit();
                database.begin();
            }catch (ParseFailure e){
                throw new SQLException(e.getMessage());
            }
        }

        @Override
        public void rollback() throws SQLException {
            try {
                database.rollback();
                database.begin();
            }catch (ParseFailure e){
                throw new SQLException(e.getMessage());
            }
        }

        @Override
        public void setAutoCommit(boolean enable) throws SQLException {
            try {
                if (enable){
                    database.commit();
                    autoCommitState = enabled;
                }
            }catch (ParseFailure e){
                throw new SQLException(e.getMessage());
            }
        }
    };

    private AutoCommitBehavior autoCommitState = enabled;
}
