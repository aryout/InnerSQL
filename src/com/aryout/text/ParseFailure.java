package com.aryout.text;

/**
 * Created by 97390 on 11/14/2017.
 */
public class ParseFailure extends Exception {
    private final String inputLine;
    private final int inputPosition;
    private final int inputLineNumber;

    public ParseFailure(String message, String inputLine, int inputPosition, int inputLineNumber){
        super(message);
        this.inputLine = inputLine;
        this.inputLineNumber = inputLineNumber;
        this.inputPosition = inputPosition;
    }

    public String getErrorReport(){
        StringBuffer b = new StringBuffer();
        b.append("Line ");
        b.append(inputLineNumber + ":\n");
        b.append(inputLine);
        b.append("\n");
        for (int i = 0; i < inputPosition; i++) {
            b.append("_");
        }
        b.append("^\n");
        return b.toString();
    }
}
