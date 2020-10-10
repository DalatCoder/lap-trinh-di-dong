package com.example.a01_firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class CatCat extends AppCompatActivity {

    public void switchCat(View view) {
        Log.i("Info", "Button pressed!");

        ImageView imageView = (ImageView) findViewById(R.id.catImageView);
        imageView.setImageResource(R.drawable.cat2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_cat);
    }
}