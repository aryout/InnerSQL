package com.aryout.test;

import com.aryout.database.Database;

import java.io.IOException;
import java.sql.*;

/**
 * Created by 97390 on 11/15/2017.
 */
public class JDBCTest {
    static String[] data = {
            "(1, 'John', 'mon',1, 'JustJoe')",
            "(2, 'Js', 'mon', 1, 'Cappuccino')",
            "(3, 'Maria', 'mon', 1, 'CaffeMocha')",
    };
    public static void main(String[]args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        Class.forName("com.aryout.database.jdbc.JDBCDriver").newInstance();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(
                    "file:/c:/Dbase","harpo", "swordfish"
            );
            statement = connection.createStatement();

            statement.executeUpdate(
                    "create table test ( Entry INTEGER  NOT NULL"+
                            ", Customer VARCHAR (20) NOT NULL" +
                            ", DOW VARCHAR(3) NOT NULL"+
                            ", Cups INTEGER NOT NULL"+
                            ", Type VARCHAR (10) NOT NULL"+
                            ", PRIMARY KEY( Entry)"+
                            ")"
            );

           // StringBuffer sb = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
/*                String state = data[i];
                String[] stateSplits = state.split(",");
                for (int j = 0; j < stateSplits.length; j++) {
                    sb.append("(").append(stateSplits[j]).append(")").append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                state = sb.toString();
                sb.delete(0, sb.length());
                System.out.println(state);
                System.out.println("insert into test  values " + state);*/
                statement.executeUpdate(    "insert into test  values " + data[i]);
               // statement.executeUpdate(    "insert into test  values " + state);
            }

            connection.setAutoCommit(false); // 注释掉这句就不会出现两句Frield 了
            statement.executeUpdate("INSERT INTO test VALUES " + "(4, 'James', 'Thu', 1, 'Cappuccino')"  );
            connection.commit();
            statement.executeUpdate("INSERT INTO test (Customer) VALUES ('Frield')" );
            connection.rollback();
            connection.setAutoCommit(true);

            ResultSet result = statement.executeQuery("SELECT * from test");
            while (result.next()){ // 打印出每一行的各个列表元素
                System.out.println(
                        result.getInt("Entry") + ","+
                                result.getString("Customer") + ","+
                                result.getString("DOW") + "," +
                                result.getInt("Cups") + "," +
                                result.getString("Type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement != null){
                    statement.close();
                }
            }catch (Exception e){

            }

            try {
                if (connection != null){
                    connection.close();
                }
            }catch (Exception e){

            }
        }
    }
}
