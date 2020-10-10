package com.example.a01_firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void login(View view) {

        EditText userName = (EditText) findViewById(R.id.txtUserName);

        EditText password = (EditText) findViewById(R.id.txtPassword);

        Log.i("info", "Button pressed!");

        Log.i("Username", userName.getText().toString());

        Log.i("Password", password.getText().toString());

        String msg = "Username: " + userName.getText().toString() + ", Password: " + password.getText().toString();

        Toast.makeText(this, msg,    Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}