package com.example.bai02_todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    ListView lvCongViec;
    ArrayList<CongViec> arrayCongViec;
    CongViecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvCongViec = (ListView) findViewById(R.id.listviewCongViec);
        arrayCongViec = new ArrayList<CongViec>();

        adapter = new CongViecAdapter(this, R.layout.dong_cong_viec, arrayCongViec);
        lvCongViec.setAdapter(adapter);

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
            int id = dataCongViec.getInt(0);
            String ten = dataCongViec.getString(1);
            arrayCongViec.add(new CongViec(id, ten));
        }

        adapter.notifyDataSetChanged();
    }
}