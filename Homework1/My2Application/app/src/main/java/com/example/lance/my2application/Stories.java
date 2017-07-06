package com.example.lance.my2application;

import java.util.UUID;

/**
 * Created by lance on 7/2/2017.
 */

public class Stories {
    private UUID mID;
    private String name;
    private int text_id;
    private String text_desc;
    private String text_inner;

    public Stories(String name,int text_id,String desc,String inner){
        mID = UUID.randomUUID();
        this.setName(name);
        this.setText_id(text_id);
        this.setDesc(desc);
        this.setInner(inner);





    }

    public UUID getID() {return mID;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInner() {return text_inner;}

    public void setInner(String inner) {
        this.text_inner = inner;
    }

    public void setDesc(String desc){this.text_desc = desc;}

    public String getDesc(){return text_desc;}

    public int getText_id() {
        return text_id;
    }

    public void setText_id(int text_id) {
        this.text_id = text_id;
    }
}
