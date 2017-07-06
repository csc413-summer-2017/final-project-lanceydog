package com.example.lance.my2application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by lance on 7/2/2017.
 */



public class RecycleAdapt extends RecyclerView.Adapter<RecycleAdapt.MyViewHolder> {
    ArrayList<Stories> arrayList = new ArrayList<>();
    Context story;
    RecycleAdapt(ArrayList<Stories> arrayList,Context story){
        this.arrayList = arrayList;
        this.story=story;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,story,arrayList);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.Text_ID.setImageResource(arrayList.get(position).getText_id());
        holder.Text_Name.setText(arrayList.get(position).getName());
        holder.Text_Desc.setText(arrayList.get(position).getDesc());
        holder.Text_inner.setText(arrayList.get(position).getInner());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView Text_ID;
        TextView Text_Name;
        TextView Text_Desc;
        TextView Text_inner;
        ArrayList<Stories> contacts = new ArrayList<Stories>();
        Context Story;

        public MyViewHolder(View itemView,Context story,ArrayList<Stories>arrayList) {
            super(itemView);
            this.contacts = arrayList;
            this.Story=story;
            itemView.setOnClickListener(this);
            Text_ID = (ImageView) itemView.findViewById(R.id.flag);
            Text_Name = (TextView) itemView.findViewById(R.id.name);
            Text_Desc = (TextView) itemView.findViewById(R.id.desc);
            Text_inner =(TextView) itemView.findViewById(R.id.mob);
        }

        @Override
        public void onClick(View v) {
        int position = getAdapterPosition();
            Stories arraylist = this.contacts.get(position);
            Intent intent = Single.newIntent(Story, arraylist.getID());
            intent.putExtra("img_id",arraylist.getText_id());
            intent.putExtra("name",arraylist.getName());
            intent.putExtra("desc",arraylist.getDesc());
            intent.putExtra("inner",arraylist.getInner());
            this.Story.startActivity(intent);

        }
    }
    public void Filter(ArrayList<Stories> newList){

        arrayList = new ArrayList<>();
        arrayList.addAll(newList );
        notifyDataSetChanged();
    }
}
