package com.example.brain_trainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonGo;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button buttonPlayAgain;
    TextView textViewSum;
    TextView textViewResult;
    TextView textViewScore;
    TextView textViewTimer;
    ConstraintLayout gameLayout;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    boolean gameActive;

    public void start(View view) {
        buttonGo.setVisibility(View.INVISIBLE);
        buttonPlayAgain.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        gameActive = true;

        playAgain(findViewById(R.id.buttonPlayAgain));
    }

    public void chooseAnswer(View view) {
        if (!gameActive) return;

        numberOfQuestions += 1;

        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            score += 1;
            textViewResult.setText("Correct!");
        } else {
            textViewResult.setText("Wrong :(");
        }

        textViewScore.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();
    }

    public void newQuestion() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        textViewSum.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
                continue;
            }
            int wrongAnswer = rand.nextInt(41);
            while (wrongAnswer == a+b) wrongAnswer = rand.nextInt(41);
            answers.add(wrongAnswer);
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void playAgain(View view) {
        buttonPlayAgain.setVisibility(View.INVISIBLE);
        score = 0;
        numberOfQuestions = 0;
        textViewTimer.setText("30s");
        textViewScore.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        textViewResult.setText("");
        gameActive = true;

        newQuestion();

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                textViewResult.setText("Done!");
                buttonPlayAgain.setVisibility(View.VISIBLE);
                gameActive = false;
            }
        }.start();
    }

    public void initControl() {
        buttonGo = findViewById(R.id.buttonGo);
        textViewSum = findViewById(R.id.textViewSum);
        textViewResult = findViewById(R.id.textViewResult);
        textViewScore = findViewById(R.id.textViewScore);
        textViewTimer = findViewById(R.id.textViewTimer);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        gameLayout = findViewById(R.id.gameLayout);
        gameActive = true;

        buttonGo.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControl();
    }
}