package com.example.lab02_bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView grid;

    String[] titles = {
            "Maboo",
            "SameOldShawn",
            "Magnitude901",
            "Brandon",
            "Clement_RGF",
            "Nebja",
            "BBDS",
            "PleaseDe-ModMe",
            "DLizzle",
            "palacelight",
            "TheDarkKnight",
            "hellrel"
    };

    Integer[] contributors = {
            283297,
            252433,
            164935,
            100466,
            93932,
            84187,
            81762,
            79243,
            76331,
            75497,
            69138,
            86903
    };

    Integer[] imgIds = {
            R.drawable.drink_01,
            R.drawable.spider_02,
            R.drawable.witch_03,
            R.drawable.owl_04,
            R.drawable.skull_05,
            R.drawable.apple_06,
            R.drawable.werewolf_07,
            R.drawable.pizza_08,
            R.drawable.guacamole_09,
            R.drawable.punch_10,
            R.drawable.ghost_11,
            R.drawable.headband_12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridView) findViewById(R.id.gridView);

        CustomGridView customGridView = new CustomGridView(MainActivity.this, titles, contributors, imgIds);

        grid.setAdapter(customGridView);
    }
}