package com.example.times_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar timesTablesSeekBar;
    ListView timesTablesListView;
    TextView timesTablesTitle;

    public void initControl() {
        timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTablesListView = findViewById(R.id.timesTablesListView);
        timesTablesTitle = findViewById(R.id.timesTablesTitle);

        int max = 20;
        int startingPosition = 10;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPosition);

        renderTimesTableTitle(startingPosition);
        renderTimesTableListView(startingPosition);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (progress < min) {
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }

                renderTimesTableTitle(timesTableNumber);
                renderTimesTableListView(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void renderTimesTableListView(int times) {

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            String msg = Integer.toString(times) + " x " + Integer.toString(i) + " = " + Integer.toString(i * times);
            timesTableContent.add(msg);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    public void renderTimesTableTitle(int times) {
        String title = "Times table for " + Integer.toString(times);
        timesTablesTitle.setText(title);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }
}