package com.example.lance.bartapp;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by lance on 7/29/2017.
 */

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<Stories> itemlist;
    private Context story;

    public SectionListDataAdapter(Context story, ArrayList<Stories> itemlist){
        this.itemlist = itemlist;
        this.story = story;

    }
    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v,story,itemlist);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {
        Stories singleItem = itemlist.get(i);
        holder.Text_Name.setText(singleItem.getName());
        holder.Text_Desc.setText(singleItem.getDesc());


    }

    @Override
    public int getItemCount() {
        return (null != itemlist ? itemlist.size() : 0);
    }

    public static class SingleItemRowHolder extends RecyclerView.ViewHolder{

        TextView Text_Name;
        TextView Text_Desc;
        ArrayList<Stories> contacts = new ArrayList<Stories>();
        Context Story;



        public SingleItemRowHolder(View view,Context story,ArrayList<Stories>arrayList) {
            super(view);
            this.Text_Name = (TextView) view.findViewById(R.id.name);
            this.Text_Desc = (TextView) view.findViewById(R.id.desc);
            this.Story = story;
            this.contacts = arrayList;

            ;


        }

    }





}


//Toast.makeText(v.getContext(), Text_Name.getText(), Toast.LENGTH_SHORT).show();

