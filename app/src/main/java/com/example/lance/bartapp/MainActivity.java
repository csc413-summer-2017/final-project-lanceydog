package com.example.lance.bartapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;

import android.support.v7.widget.CardView;
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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
//import com.example.lance.bartapp.FragmentAp;
import com.example.lance.bartapp.Model.Last;
import com.example.lance.bartapp.Model.Plan;
import com.example.lance.bartapp.Model.Trip;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.lance.bartapp.R.id.parent;
import static com.example.lance.bartapp.R.id.recycler_view_list;
import static com.example.lance.bartapp.R.id.recyclerview;
import static com.example.lance.bartapp.R.id.up;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    AutoCompleteTextView textView=null;
    private ArrayAdapter<String> adapter;

    String[] Text_names = { "PITT", "DUBL", "RICH", "SFIA", "WARM"};
    String[] Text_stuff={"DALY","WCRK","CONC","PHIL","MCAR","12TH","16TH","PITT","19TH","24TH","ASHB","BALB","BAYF","CAST","CIVC","COLS","COLM","DBRK","DUBL","DELN","PLZA","EMBR","FRMT","FTVL","GLEN","HAYW","LAFY","LAKE","MLBR","MONT","NBRK","NCON","OAKL","ORIN","POWL","RICH","ROCK","SBRN","SFIA","SANL","SHAY","SSAN","UCTY","WDUB","WOAK","WARM"};
    String [] products={"Daly City","Walnut Creek","Concord","Pleasant Hill","MacArthur","12th St. Oakland City Center","16th St. Mission","Pittsburg/Bay Point","19th St. Oakland","24th St. Mission","Ashby","Balboa Park","Bay Fair","Castro Valley","Civic Center/UN Plaza","Coliseum","Colma","Downtown Berkeley","Dublin/Pleasanton","El Cerrito del Norte","El Cerrito Plaza","Embarcadero","Fremont","Fruitvale","Glen Park","Hayward","Lafayette","Lake Merritt","Millbrae","Montgomery St.","North Berkeley","North Concord/Martinez","Oakland International Airport","Orinda","Powell St.","Richmond","Rockridge","San Bruno","San Francisco International Airport","San Leandro","South Hayward","South San Francisco","Union City","West Dublin/Pleasanton","West Oakland","Warm Springs/South Fremont"};


    Toolbar toolbar;
    ArrayList<SectionDataModel> sample;
    ArrayList<Stories> singleItem;
    RecyclerView recyclerView;
    RecycleAdapt recycleAdapt;
    CardView cardView;
    RecyclerView.LayoutManager layoutManager;
    SectionDataModel dm;
    String nm = "";
    String vm = "";
    String origin = "";
    String jb= "";
    String ju = "";
    List<Last> jj;
    int update = 0;
    int count = 0;
    int numbers = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, products);
        textView.setThreshold(1);
        textView.setAdapter(adapter);
        textView.setOnItemSelectedListener(this);
        textView.setOnItemClickListener(this);
        sample = new ArrayList<SectionDataModel>();
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

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

      if(update != 0){
           sample.removeAll(sample);
          sample.clear();
          recyclerView.removeAllViews();
        }
        update++;
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
        if (jb == "WARM"){
            Text_names = new String[]{"RICH", "PITT", "DUBL","SFIA"};
            count = 1;
        }


        origin = jb;


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
                                singleItem = new ArrayList<Stories>();
                                for (int i = 0; i < trips.size(); i++) {
                                    int count = 0;
                                    Trip trip = trips.get(i);
                                    nm = trip.getOrigTimeMin();
                                    vm = trip.getDestination();
                                    jj = trip.getL();


                                    if(jj.size() < 3){
                                        singleItem.add(new Stories(vm, nm, nm));

                                    }else{
                                        break;
                                    }


                                }
                                if(singleItem.size() != 0){

                                    dm.setAllItemsInSection(singleItem);

                                    sample.add(dm);

                                }



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




