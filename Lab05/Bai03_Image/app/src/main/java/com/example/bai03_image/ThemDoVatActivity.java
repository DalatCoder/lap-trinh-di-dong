package com.example.bai03_image;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ThemDoVatActivity extends AppCompatActivity {

    Button btnAdd, btnCancel;
    EditText edtTen, edtMoTa;
    ImageButton ibtnCamera, ibtnFolder;
    ImageView imgHinh;

    int REQUEST_CODE_CAMERA = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_do_vat);

        AnhXa();

        ibtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void AnhXa() {
        btnAdd = (Button) findViewById(R.id.buttonThem);
        btnCancel = (Button) findViewById(R.id.buttonHuy);
        edtTen = (EditText) findViewById(R.id.editTextNhapTenDoVat);
        edtMoTa = (EditText) findViewById(R.id.editTextMoTa);
        ibtnCamera = (ImageButton) findViewById(R.id.imageButtonCamera);
        ibtnFolder = (ImageButton) findViewById(R.id.imageButtonFolder);
        imgHinh = (ImageView) findViewById(R.id.imageView);
    }
}