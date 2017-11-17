package com.aryout.text;

/**
 * Created by 97390 on 11/14/2017.
 */
public class WordToken implements Token{
    private final String pattren;

    public WordToken(String pattren){
        this.pattren = pattren;
    }

    public boolean match(String input, int offset){
        if ((input.length() - offset) < pattren.length()){
            return false;
        }

        String candidate = input.substring(offset, offset+pattren.length());
        if (!candidate.equalsIgnoreCase(pattren)){
            return false;
        }

        return ((input.length() - offset) == pattren.length()) || (!Character.isLetterOrDigit(input.charAt(offset+pattren.length())));
    }

    public String lexeme(){
        return pattren;
    }

    public String toString(){
        return pattren;
    }
}
