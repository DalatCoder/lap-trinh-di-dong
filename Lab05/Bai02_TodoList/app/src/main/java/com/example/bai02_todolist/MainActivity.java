package com.example.bai02_todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
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

        GetDataCongViec();
    }

    private void GetDataCongViec() {
        arrayCongViec.clear();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            DialogThem();
        }

        return super.onOptionsItemSelected(item);
    }

    private void DialogThem() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them_cong_viec);

        EditText edtTen = (EditText) dialog.findViewById(R.id.edittextTenCV);
        Button btnThem = (Button) dialog.findViewById(R.id.buttonThemCV);
        Button btnThoat = (Button) dialog.findViewById(R.id.buttonThoat);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenCV = edtTen.getText().toString();

                if (tenCV.length() == 0) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc", Toast.LENGTH_SHORT).show();
                    return;
                }

                databaseHelper.QueryData("INSERT INTO CongViec(TenCV) VALUES ('" + tenCV + "')");
                Toast.makeText(MainActivity.this, "Thêm công việc thành công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                GetDataCongViec();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}