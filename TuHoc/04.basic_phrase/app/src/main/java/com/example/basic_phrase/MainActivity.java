package com.example.basic_phrase;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void playPhrase(View view) {
        Button button = (Button) view;
        String phrase = button.getTag().toString();
        String file = phrase + ".m4a";

        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(phrase, "raw", getPackageName()));

        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}