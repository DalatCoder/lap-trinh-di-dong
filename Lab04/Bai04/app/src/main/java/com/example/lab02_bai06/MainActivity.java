package com.example.lab02_bai06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    Button btnPlay;
    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2,sb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300)
        {
            @Override
            public void onTick(long l)
            {
                int number=6;
                Random random= new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                sb1.setProgress(sb1.getProgress()+one);
                sb2.setProgress(sb2.getProgress()+two);
                sb3.setProgress(sb3.getProgress()+three);
            }

            @Override
            public void onFinish()
            {

            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });
    }

    private void init()
    {
        btnPlay =(Button) findViewById(R.id.buttonPlay);
        cb1     =(CheckBox) findViewById(R.id.checkboxOne);
        cb2     =(CheckBox) findViewById(R.id.checkboxTwo);
        cb3     =(CheckBox) findViewById(R.id.checkboxThree);
        sb1     =(SeekBar) findViewById(R.id.seekbarOne);
        sb2     =(SeekBar) findViewById(R.id.seekbarTwo);
        sb3     =(SeekBar) findViewById(R.id.seekbarThree);
    }
}