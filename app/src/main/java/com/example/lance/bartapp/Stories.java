package com.example.lance.bartapp;

import com.example.lance.bartapp.Model.Last;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by lance on 7/2/2017.
 */

public class Stories {
    private String name;
    private String text_desc;
    private String text_inner;
    private ArrayList<Stories> allItems;



    public Stories(String name, String desc, String inner){
        this.setName(name);
        this.setDesc(desc);
        this.setInner(inner);






    }


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





}
