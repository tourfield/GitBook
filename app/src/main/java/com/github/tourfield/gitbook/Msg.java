package com.github.tourfield.gitbook;

/**
 * Created by Geary on 2017/6/1.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;
    private String context;
    private int type;
    public Msg(String context,int type){
        this.context=context;
        this.type=type;
    }
    public String getContext(){
        return context;
    }
    public int getType(){
        return type;
    }
}
