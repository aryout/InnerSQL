package com.aryout.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 97390 on 11/14/2017.
 */
public class TokenSet {
    private Collection members = new ArrayList();

    public Iterator iterator(){
        return members.iterator();
    }
    public Token create(String spec){
        Token token;
        int start  = 1;
        if (!spec.startsWith("'")){
            if (containsRegexMetacharacters(spec)){
                token = new RegexToken(spec);
                members.add(token);
                return token;
            }
            --start;
        }
        int end = spec.length();

        if (start == 1 && spec.endsWith("'")){
            --end;
        }
        token = Character.isJavaIdentifierPart(spec.charAt(end-1)) ? (Token) new WordToken(spec.substring(start,end)) : (Token) new SimpleToken(spec.substring(start,end));
        members.add(token);
        return token;
    }

    public static final boolean containsRegexMetacharacters(String s){
        Matcher m  =metacharacters.matcher(s);
        return m.find();
    }

    private static final Pattern metacharacters = Pattern.compile("[\\\\\\[\\]$\\^*+?|()]");
}
