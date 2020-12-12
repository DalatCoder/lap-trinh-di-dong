package com.example.bai02_todolist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Truy vấn dữ liệu không trả kết quả: CREATE, INSERT, UPDATE, DELETE...
    public void QueryData(String query) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(query);
    }

    // Truy vấn dữ liệu trả kết quả: SELECT
    // Dùng con trỏ: cursor để duyệt trong CSDL, duyệt từng dòng
    public Cursor GetData(String query) {
        SQLiteDatabase database = this.getReadableDatabase();
        return database.rawQuery(query, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
