package com.aryout.tools;

/**
 * Created by 97390 on 11/15/2017.
 */
public class ThrowableContainer extends RuntimeException{
    private final Throwable contents;
    public ThrowableContainer(Throwable contents){
        this.contents = contents;
    }

    public Throwable contents(){
        return contents;
    }
}
