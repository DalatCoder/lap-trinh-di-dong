package com.example.connect_3_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    // 0: yellow, 1: red, 2: empty
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    int activePlayer = 0;

    boolean gameActive = true;

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        // The position is not empty
        if (gameState[tappedCounter] != 2 || !gameActive) {
            return;
        }

        gameState[tappedCounter] = activePlayer;

        counter.setTranslationY(-1500);

        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;
        } else {
            counter.setImageResource(R.drawable.red);
            activePlayer = 0;
        }

        counter.animate().translationYBy(1500).setDuration(500);

        for (int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                gameActive = false;

                String winner = "";

                if (activePlayer == 0) winner = "Red";
                else winner = "Yellow";

                Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                playAgainButton.setVisibility(View.VISIBLE);

                winnerTextView.setText(winner + " has won!");
                winnerTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void playAgain(View view) {
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        GridLayout mainGridLayout = (GridLayout) findViewById(R.id.gridViewMainPlayer);

        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);

        // Clear UI
        for (AtomicInteger i = new AtomicInteger(); i.get() < mainGridLayout.getChildCount(); i.getAndIncrement()) {
            ImageView counter = (ImageView) mainGridLayout.getChildAt(i.get());
            counter.setImageDrawable(null);
        }

        // Clear state
        Arrays.fill(gameState, 2);
        gameActive = true;
        activePlayer = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}