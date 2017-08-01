package com.example.lance.bartapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {
    ImageView imageView;
    TextView x_name,x_desc,x_inner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_layout);
        imageView = (ImageView)findViewById(R.id.contact_image);
        x_name = (TextView)findViewById(R.id.contact_name);
        x_desc = (TextView)findViewById(R.id.contact_description);
        x_inner = (TextView)findViewById(R.id.contact_mobile);
        imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        x_name.setText("" +getIntent().getStringExtra("name"));
        x_desc.setText("desc :" +getIntent().getStringExtra("desc"));
        x_inner.setText("" +getIntent().getStringExtra("inner"));
    }
}
