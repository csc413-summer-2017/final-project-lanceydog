package com.example.lance.bartapp;

import android.app.ActionBar;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    AutoCompleteTextView textView=null;
    private ArrayAdapter<String> adapter;

    String[] Text_names = { "Self-Driving Car Technology Foiled By Kangaroos", "Grandson Takes Grandma To Prom After Finding Out She’s Terminally Ill", "Badass 10-Year-Old Pries Open Gator’s Jaws To Free Her Leg", "Finalists chosen for chance to start colony on Mars, die there"};
    String[] Text_description = {"“We’ve noticed with the kangaroo being in mid-flight ... when it’s in the air it actually looks like it’s further away, then it lands and it looks closer”", "“I wanted to bring my grandmother to prom because I wanted to do something special for her”" , "“To get an animal with the strongest bite on the planet to let go of you is a miracle”" , "“I am very divided by it, but the way I see it, I have a responsibility to more people“"};
    String[] Text_inner = {"Volvo has confessed that the springy marsupials are throwing off the “Large Animal Detection” systems being developed for self-driving cars, the Australian Broadcasting Corp. reports. Those systems are meant to make sure the cars avoid animals along the road, such as deer or cattle.", "Earlier this year, Jarman was diagnosed with pancreatic cancer and doctors said she may only have a few more months to live, according to her daughter-in-law Pam Virgil. In the meantime, her grandson has set out to make the days ahead as special as possible for his grandma, who calls him “my boy.” Taking her to prom seemed like a no brainer.", "A 10-year-old girl managed to free herself from the jaws of a nearly 9-foot-long alligator over the weekend by prying open its mouth with her bare hands!", "Mars One, a group that plans to send humans on a one-way trip to Mars, has announced its final 100 candidates. They have been selected from 200,000 applicants and will go on to further testing later this year, which they expect to include team-building exercises and later, isolation."};
    String [] products={"Daily City","Walnut Creek","Concord","Pleasant Hill","MacArthur"};
    String[][] arrays = new String[][]{Text_names,Text_description,Text_inner};

   Toolbar toolbar;
    ArrayList<SectionDataModel> sample;
    RecyclerView recyclerView;
    RecycleAdapt recycleAdapt;
    RecyclerView.LayoutManager layoutManager;
    //ArrayList<Stories> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, products);
        textView.setThreshold(1);
        textView.setAdapter(adapter);
        textView.setOnItemSelectedListener(this);
        textView.setOnItemClickListener(this);
        sample = new ArrayList<SectionDataModel>();
        setSupportActionBar(toolbar);
        for(int b = 1; b<4; b++){
            createDummyData(b);
        }
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


         recycleAdapt = new RecycleAdapt(this, sample);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recycleAdapt);
    }


    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
                               long arg3) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }




    public void createDummyData(int b) {
        for (int i = 1; i <= 1; i++) {

            SectionDataModel dm = new SectionDataModel();

            //dm.setHeaderTitle("Section " + i);
            int count = 0;
            int layline = b;
            ArrayList<Stories> singleItem = new ArrayList<Stories>();
            switch (layline){
                case 1:
                    for (String Name : Text_names) {
                        singleItem.add(new Stories(Text_description[count], Name, Text_inner[count]));
                        count++;

                    }
                    break;
                case 2:
                    for (String Name : Text_names) {
                        singleItem.add(new Stories(Name, Text_description[count], Text_inner[count]));
                        count++;

                    }
                    break;

                case 3:
                    for (String Name : Text_names) {
                        singleItem.add(new Stories(Text_inner[count], Text_description[count],Name));
                        count++;

                    }
                    break;



                default: break;

            }

            dm.setAllItemsInSection(singleItem);

            sample.add(dm);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Toast.makeText(getBaseContext(), "Position:"+arg2+" Month:"+arg0.getItemAtPosition(arg2),
                Toast.LENGTH_LONG).show();

        Log.d("AutocompleteContacts", "Position:"+arg2+" Month:"+arg0.getItemAtPosition(arg2));
    }
}




