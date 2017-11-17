package com.aryout.test;

import com.aryout.database.Database;
import com.aryout.database.Table;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by 97390 on 11/16/2017.
 */
public class DatabaseTest {
    @org.junit.Test
    public void execute() throws Exception {
        Database d = new Database();
        BufferedReader sqlScript = new BufferedReader(new FileReader("C:\\Users\\97390\\IdeaProjects\\InnerSQL\\src\\com\\aryout\\test\\Database.Test.sql"));
        String test;
        while ((test = sqlScript.readLine()) != null){
            test = test.trim();
            if (test.length() == 0){
                continue;
            }

            System.out.println("Parsing: " + test);

            Table result;
            String test_to_lower;
            if (( test_to_lower = test.toLowerCase()).contains("select")){
                String tableName = test.substring(test.indexOf("from") + 4).trim().split(" ")[0];
                (result = d.execute(test)).rename("query" + String.valueOf(tableName.charAt(0)).toUpperCase() + tableName.substring(1).toLowerCase()); // 查询的表直接重命名

                if (result != null){
                    System.out.println(result.toString());
                    System.out.println(result.name());
                }

            }else {
                d.execute(test); // 非查询操作
            }
        }
    }
}