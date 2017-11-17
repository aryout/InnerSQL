package com.aryout.database;

import com.aryout.tools.ArrayIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/**
 * Created by 97390 on 11/14/2017.
 */
public class CSVImporter implements Table.Importer{
    private BufferedReader in;
    private String[] columnNames;
    private String tableName;

    public CSVImporter(Reader in){
        this.in = in instanceof BufferedReader ? (BufferedReader)in : new BufferedReader(in);
    }

    public void startTable() throws IOException{
        tableName = in.readLine().trim();
        columnNames = in.readLine().split("\\s*,\\s*");
    }

    public String loadTableName() throws IOException{
        return tableName;
    }
    public int loadWidth(){

        return columnNames.length;
    }
    public Iterator loadColumnNames() throws IOException{
        return new ArrayIterator(columnNames);
    }
    public Iterator loadRow() throws IOException{
        Iterator row = null;
        if (in != null){
            String line = in.readLine();
            if (line == null){
                in = null;
            }else {
                row = new ArrayIterator(line.split("\\s*,\\s*"));
            }
        }
        return row;
    }
    public void endTable() throws IOException{}
}
