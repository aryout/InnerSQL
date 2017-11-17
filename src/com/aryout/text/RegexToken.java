package com.aryout.text;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 97390 on 11/14/2017.
 */
public class RegexToken implements Token {
    private Matcher matcher;
    private final Pattern pattern;
    private final String id;

    public RegexToken(String description){
        id = description;
        pattern = Pattern.compile(description, Pattern.CASE_INSENSITIVE);
    }

    public boolean match(String input, int offset){
        matcher =  pattern.matcher(input.substring(offset));
        return matcher.lookingAt();
    }

    public String lexeme(){
        return matcher.group();
    }

    public String toString(){
        return id;
    }
}
