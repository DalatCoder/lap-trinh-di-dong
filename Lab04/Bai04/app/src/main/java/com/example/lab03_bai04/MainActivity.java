package com.example.lab03_bai04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView lblVietnam;
    private TextView lblEnglish;
    private TextView lblFrance;

    private TextView lblWelcome;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView txtDoNotHaveAccount;

    private void setText() {
        lblWelcome.setText(R.string.welcome);
        txtEmail.setHint(R.string.email);
        txtPassword.setHint(R.string.password);
        btnLogin.setText(R.string.login);
        txtDoNotHaveAccount.setText(R.string.do_not_have_account);
    }

    private void init() {
        lblVietnam = (TextView) findViewById(R.id.lblVietnam);
        lblEnglish = (TextView) findViewById(R.id.lblEnglish);
        lblFrance = (TextView) findViewById(R.id.lblFrance);
        lblWelcome = (TextView) findViewById(R.id.lblWelcome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtDoNotHaveAccount = (TextView) findViewById(R.id.lblDoNotHaveAccount);

        lblVietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.setLocale(MainActivity.this, "vi");
                setText();
            }
        });

        lblEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.setLocale(MainActivity.this, "en");
                setText();
            }
        });

        lblFrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.setLocale(MainActivity.this, "fr");
                setText();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        LocaleHelper.setLocale(this, "vi");
    }
}