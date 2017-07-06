package com.example.lance.my2application;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    String[] Text_names = { "Self-Driving Car Technology Foiled By Kangaroos", "Grandson Takes Grandma To Prom After Finding Out She’s Terminally Ill", "Badass 10-Year-Old Pries Open Gator’s Jaws To Free Her Leg", "Finalists chosen for chance to start colony on Mars, die there"};
    String[] Text_description = {"“We’ve noticed with the kangaroo being in mid-flight ... when it’s in the air it actually looks like it’s further away, then it lands and it looks closer”", "“I wanted to bring my grandmother to prom because I wanted to do something special for her”" , "“To get an animal with the strongest bite on the planet to let go of you is a miracle”" , "“I am very divided by it, but the way I see it, I have a responsibility to more people“"};
    String[] Text_inner = {"Volvo has confessed that the springy marsupials are throwing off the “Large Animal Detection” systems being developed for self-driving cars, the Australian Broadcasting Corp. reports. Those systems are meant to make sure the cars avoid animals along the road, such as deer or cattle.", "Earlier this year, Jarman was diagnosed with pancreatic cancer and doctors said she may only have a few more months to live, according to her daughter-in-law Pam Virgil. In the meantime, her grandson has set out to make the days ahead as special as possible for his grandma, who calls him “my boy.” Taking her to prom seemed like a no brainer.", "A 10-year-old girl managed to free herself from the jaws of a nearly 9-foot-long alligator over the weekend by prying open its mouth with her bare hands!", "Mars One, a group that plans to send humans on a one-way trip to Mars, has announced its final 100 candidates. They have been selected from 200,000 applicants and will go on to further testing later this year, which they expect to include team-building exercises and later, isolation."};
    int[] Text_id = {R.drawable.kangaroo, R.drawable.prom, R.drawable.alligator, R.drawable.mars};


    Toolbar toolbar;
    RecyclerView recyclerView;
    RecycleAdapt recycleAdapt;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Stories> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count = 0;

        for(String Name : Text_names){
           arrayList.add(new Stories(Name,Text_id[count],Text_description[count],Text_inner[count]));

            count++;
        }
         recycleAdapt = new RecycleAdapt(arrayList,this);
        recyclerView.setAdapter(recycleAdapt);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<Stories> newList = new ArrayList<>();
        for(Stories stories : arrayList ){
            String name = stories.getName().toLowerCase();
            String des = stories.getDesc().toLowerCase();
            if(name.contains(newText)|| des.contains(newText))
                newList.add(stories);
        }

        recycleAdapt.Filter(newList);
        return true;
    }
}
