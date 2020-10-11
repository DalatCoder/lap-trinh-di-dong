package com.example.lab01_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtFirstNumber;
    private EditText txtSecondNumber;
    private Button btnAdd;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;
    private TextView txtResult;

    double firstNumber;
    double secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }

    private void getNumbers() {
        try {
            this.firstNumber = Double.parseDouble(txtFirstNumber.getText().toString());
            this.secondNumber = Double.parseDouble(txtSecondNumber.getText().toString());
        } catch (Exception ex) {
            this.firstNumber = 0;
            this.secondNumber = 0;
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void initControl() {
        txtFirstNumber = (EditText) findViewById(R.id.txtFirstNumber);
        txtSecondNumber = (EditText) findViewById(R.id.txtSecondNumber);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                txtResult.setText(String.valueOf(firstNumber + secondNumber));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                txtResult.setText(String.valueOf(firstNumber - secondNumber));
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                txtResult.setText(String.valueOf(firstNumber * secondNumber));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                if (secondNumber == 0) {
                    Toast.makeText(getApplicationContext(), "Divide by 0 error!", Toast.LENGTH_SHORT).show();
                    return;
                }

                txtResult.setText(String.valueOf(firstNumber / secondNumber));
            }
        });
    }
}