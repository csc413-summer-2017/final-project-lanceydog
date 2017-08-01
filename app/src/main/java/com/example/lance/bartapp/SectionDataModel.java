package com.example.lance.bartapp;

/**
 * Created by lance on 7/29/2017.
 */
import java.util.ArrayList;

public class SectionDataModel {
    private String headerTitle;
    private ArrayList<Stories> allItems;


    public SectionDataModel(){

    }

    public SectionDataModel(String headerTitle, ArrayList<Stories> allItems){
        this.headerTitle = headerTitle;
        this.allItems = allItems;

    }

    public String getHeaderTitle(){
        return headerTitle;
    }
    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }
    public ArrayList<Stories> getAllItemsInSection() {
        return allItems;
    }

    public void setAllItemsInSection(ArrayList<Stories> allItemsInSection) {
        this.allItems = allItemsInSection;
    }


}
