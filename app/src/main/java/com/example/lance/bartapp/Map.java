package com.example.lance.bartapp;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by lance on 8/8/2017.
 */

public class Map extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.removeAllViews();


        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) findViewById(R.id.bart_map);
        imageView.setImage(ImageSource.resource(R.drawable.bart_map_med_res).dimensions(1150, 1047),
                ImageSource.resource(R.drawable.bart_map_low_res).dimensions(750, 683));
    }
}
