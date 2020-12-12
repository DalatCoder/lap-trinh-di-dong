package com.example.bai02_todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Tạo database với tên GhiChu
        databaseHelper = new DatabaseHelper(this, "ghichu.sqlite", null, 1);

        // Tạo bảng CongViec
        databaseHelper.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");

        // Insert data
        // databaseHelper.QueryData("INSERT INTO CongViec(TenCV) VALUES ('Làm bài tập android')");

        // Select data
        Cursor dataCongViec = databaseHelper.GetData("SELECT * FROM CongViec");
        while (true) {
            boolean isRowRemain = dataCongViec.moveToNext();
            if (!isRowRemain)
                break;

            // Id: 0, TenCV: 1
            String ten = dataCongViec.getString(1);
            Toast.makeText(this, ten, Toast.LENGTH_LONG).show();
        }
    }
}