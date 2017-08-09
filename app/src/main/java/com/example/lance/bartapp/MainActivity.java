package com.example.lance.bartapp;

import android.content.Intent;
import android.os.Handler;

import android.util.Log;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
//import com.example.lance.bartapp.FragmentAp;
import com.example.lance.bartapp.Model.Plan;
import com.example.lance.bartapp.Model.Trip;


import java.util.ArrayList;
import java.util.List;

import static com.example.lance.bartapp.R.id.parent;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    AutoCompleteTextView textView=null;
    private ArrayAdapter<String> adapter;

    String[] Text_names = { "PITT", "DUBL", "RICH", "SFIA", "WARM"};
    String[] Text_stuff={"PITT","WCRK","CONC","PHIL","MCAR" };
    String[] Text_description = {"“We’ve noticed with the kangaroo being in mid-flight ... when it’s in the air it actually looks like it’s further away, then it lands and it looks closer”", "“I wanted to bring my grandmother to prom because I wanted to do something special for her”" , "“To get an animal with the strongest bite on the planet to let go of you is a miracle”" , "“I am very divided by it, but the way I see it, I have a responsibility to more people“"};
    String[] Text_inner = {"Volvo has confessed that the springy marsupials are throwing off the “Large Animal Detection” systems being developed for self-driving cars, the Australian Broadcasting Corp. reports. Those systems are meant to make sure the cars avoid animals along the road, such as deer or cattle.", "Earlier this year, Jarman was diagnosed with pancreatic cancer and doctors said she may only have a few more months to live, according to her daughter-in-law Pam Virgil. In the meantime, her grandson has set out to make the days ahead as special as possible for his grandma, who calls him “my boy.” Taking her to prom seemed like a no brainer.", "A 10-year-old girl managed to free herself from the jaws of a nearly 9-foot-long alligator over the weekend by prying open its mouth with her bare hands!", "Mars One, a group that plans to send humans on a one-way trip to Mars, has announced its final 100 candidates. They have been selected from 200,000 applicants and will go on to further testing later this year, which they expect to include team-building exercises and later, isolation."};
    String [] products={"Daily City","Walnut Creek","Concord","Pleasant Hill","MacArthur"};
    String[][] arrays = new String[][]{Text_names,Text_description,Text_inner};

    Toolbar toolbar;
    ArrayList<SectionDataModel> sample;
    ArrayList<Stories> singleItem;
    RecyclerView recyclerView;
    RecycleAdapt recycleAdapt;
    RecyclerView.LayoutManager layoutManager;
    SectionDataModel dm;
    String nm = "";
    String vm = "";
    String origin = "";
    String jb= "";
    int count = 0;
    int numbers = 5;
    //ArrayList<Stories> arrayList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setTitle("BART Map");
        setSupportActionBar(toolbar);
       //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, products);
        textView.setThreshold(1);
        textView.setAdapter(adapter);
        textView.setOnItemSelectedListener(this);
        textView.setOnItemClickListener(this);
        sample = new ArrayList<SectionDataModel>();
        //setSupportActionBar(toolbar);



        //cmd=depart&orig=ASHB&dest=CIVC&date=now
        //cmd=depart&orig=dbrk&dest=pitt&date=today

        //final Handler handler = new Handler();
        //Runnable runnable = new Runnable() {
        //@Override

       // handler.post(runnable);

        //Toast.makeText(getBaseContext(), nm,
               // Toast.LENGTH_LONG).show();




       //for(int b = 1; b<4; b++){
       // createDummyData(b);
       //}
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


         recycleAdapt = new RecycleAdapt(this, sample);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recycleAdapt);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_bart_map){
            startActivity(new Intent(this, Map.class));

        }
        return true;

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
        //Toast.makeText(getBaseContext(), "Position:"+arg2+" Month:"+arg0.getItemAtPosition(arg2),
        // Toast.LENGTH_LONG).show();

        String selection = (String) arg0.getItemAtPosition(arg2);
        int pos = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].equals(selection)) {
                pos = i;

            }
        }


           // recycleAdapt.arrayList.clear();

            jb = Text_stuff[pos];



        if(jb == "PITT" ){
            Text_names = new String[]{"DUBL", "RICH", "SFIA","WARM"};
             count = 1;

        }
        if(jb == "RICH"){
            Text_names = new String[]{"DUBL", "PITT", "SFIA","WARM"};
            count = 1;
        }
        if (jb == "DUBL"){
            Text_names = new String[]{"RICH", "PITT", "SFIA","WARM"};
            count = 1;
        }
        if (jb == "SFIA"){
            Text_names = new String[]{"RICH", "PITT", "DUBL","WARM"};
            count = 1;
        }


        origin = jb;


            //recycleAdapt.arrayList.clear();
            //int i;
            // products[arg2] = Text_stuff[arg2];


            //  String jb;
            // jb = Text_stuff[pos];
            //products[pos] = Text_stuff[pos];






            // Toast.makeText(getBaseContext(),"Position " + pos ,
            // Toast.LENGTH_LONG).show();
            //"Position " + pos
            // origin = "DALY";
        if(count == 1){
            numbers = 4;
            count = 0;
        }else {
            numbers = 5;
            Text_names = new String[]{ "PITT", "DUBL", "RICH", "SFIA", "WARM"};
        }



            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());




            for (int k = 0; k < numbers; k++) {

                //Text_names[k]
                String url = "http://api.bart.gov/api/sched.aspx?" + "cmd=depart&orig=" + origin + "&dest=" + Text_names[k] + "&date=now&key=MW9S-E7SL-26DU-VV8V&b=0&a=4";


                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Plan plan = BartApi.parseSchedule(response);
                                List<Trip> trips = plan.getTrips();
                                dm = new SectionDataModel();
                                //ArrayList<Stories> singleItem = new ArrayList<Stories>();
                                singleItem = new ArrayList<Stories>();
                                for (int i = 0; i < trips.size(); i++) {
                                    int count = 0;
                                    Trip trip = trips.get(i);
                                    nm = trip.getOrigTimeMin();
                                    vm = trip.getDestination();
                                    singleItem.add(new Stories(vm, nm, nm));


                                }
                                dm.setAllItemsInSection(singleItem);

                                sample.add(dm);


                            }

                        }, new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getBaseContext(), "Position: Month:",
                                Toast.LENGTH_LONG).show();

                    }
                });
                queue.add(stringRequest);

            }





    }

}




