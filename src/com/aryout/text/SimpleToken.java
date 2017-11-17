package com.aryout.text;

/**
 * Created by 97390 on 11/14/2017.
 */
public class SimpleToken implements Token{
    private final String pattern;

    public SimpleToken(String pattern){
        this.pattern = pattern.toLowerCase();
    }

    public boolean match(String input, int offset){
        return input.toLowerCase().startsWith(pattern, offset);
    }

    public String lexeme(){
        return pattern;
    }

    public String toString(){
        return pattern;
    }
}
