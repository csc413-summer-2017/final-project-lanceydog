package com.example.lance.bartapp;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import java.util.ArrayList;
import java.util.UUID;
/**
 * Created by lance on 7/3/2017.
 */

public class Single{
    private static final String EXTRA_Text_ID =
            "com.example.lance.my2application.stories_id";



    public static Intent newIntent(Context story, UUID textId ){
        Intent intent = new Intent(story, Description.class);
        intent.putExtra(EXTRA_Text_ID, textId);
        return intent;
    }





}
