package com.aryout.text;

/**
 * Created by 97390 on 11/14/2017.
 */
public interface Token {
    boolean match (String input, int offset);

    String lexeme();
}
