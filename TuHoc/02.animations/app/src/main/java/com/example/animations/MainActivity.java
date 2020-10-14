package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isCat1Showing = true;

    public void fade(View view) {
        ImageView imageViewCat1 = (ImageView) findViewById(R.id.imageViewCat1);
        ImageView imageViewCat2 = (ImageView) findViewById(R.id.imageViewCat2);

        if (isCat1Showing) {
            isCat1Showing = false;
            imageViewCat1.animate().alpha(0).setDuration(2000);
            imageViewCat2.animate().alpha(1).setDuration(2000);
        }
        else {
            isCat1Showing = true;
            imageViewCat1.animate().alpha(1).setDuration(2000);
            imageViewCat2.animate().alpha(0).setDuration(2000);
        }
    }

    public void init() {
        ImageView imageViewCat1 = (ImageView) findViewById(R.id.imageViewCat1);

        imageViewCat1.animate().rotation(3600).scaleX(1).scaleY(1).alpha(1).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}