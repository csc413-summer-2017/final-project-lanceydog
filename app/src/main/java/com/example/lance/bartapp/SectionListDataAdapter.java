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

    }

    @Override
    public int getItemCount() {
        return (null != itemlist ? itemlist.size() : 0);
    }

    public static class SingleItemRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Text_Name;
        ArrayList<Stories> contacts = new ArrayList<Stories>();
        Context Story;



        public SingleItemRowHolder(View view,Context story,ArrayList<Stories>arrayList) {
            super(view);
            this.Text_Name = (TextView) view.findViewById(R.id.name);
            this.Story = story;
            this.contacts = arrayList;
            view.setOnClickListener(this);
            //view.setOnClickListener(new View.OnClickListener(this)

            ;


        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Stories arraylist = this.contacts.get(position);
            Intent intent = Single.newIntent(Story, arraylist.getID());
            // intent.putExtra("img_id",arraylist.getText_id());
            intent.putExtra("name",arraylist.getName());
            intent.putExtra("desc",arraylist.getDesc());
            intent.putExtra("inner",arraylist.getInner());
            this.Story.startActivity(intent);

        }
    }





}


//Toast.makeText(v.getContext(), Text_Name.getText(), Toast.LENGTH_SHORT).show();

