package com.example.lance.bartapp;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by lance on 7/2/2017.
 */



public class RecycleAdapt extends RecyclerView.Adapter<RecycleAdapt.MyViewHolder> {
    ArrayList<SectionDataModel> arrayList = new ArrayList<>();
    Context story;
    private final static int FADE_DURATION = 1000;
    RecycleAdapt(Context story, ArrayList<SectionDataModel> arrayList){
        this.arrayList = arrayList;
        this.story=story;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    //holder.Text_ID.setImageResource(arrayList.get(position).getText_id());

        ArrayList singleSectionItems = arrayList.get(position).getAllItemsInSection();

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(story, singleSectionItems);
        holder.recycler_view_list.setHasFixedSize(true);
        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(story, LinearLayoutManager.HORIZONTAL, false));
        holder.recycler_view_list.setAdapter(itemListDataAdapter);
        setFadeAnimation(holder.itemView);


    }
    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount(){
        return (null != arrayList ? arrayList.size() : 0);

    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Text_Name;
        RecyclerView recycler_view_list;
        TextView Text_Desc;
        TextView Text_inner;
        ArrayList<Stories> contacts = new ArrayList<Stories>();
        Context Story;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.recycler_view_list =(RecyclerView) itemView.findViewById(R.id.recycler_view_list);
            Text_Name = (TextView) itemView.findViewById(R.id.name);
            Text_Desc = (TextView) itemView.findViewById(R.id.desc);
            Text_inner =(TextView) itemView.findViewById(R.id.mob);
        }

    }

}
