package com.example.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bai01.bean.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private static final int MENU_ITEM_VIEW = 111;
    private static final int MENU_ITEN_EDIT = 222;
    private static final int MENU_ITEM_CREATE = 333;
    private static final int MENU_ITEM_DELETE = 444;

    private static final int MY_REQUEST_CODE = 1000;

    private final List<Note> noteList = new ArrayList<Note>();
    private ArrayAdapter<Note> listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView)findViewById(R.id.listView);

        MySQLiteHelper db = new MySQLiteHelper(MainActivity.this);
        db.createDefaultNotesIfNeed();

        List<Note> list = db.getAllNotes();
        this.noteList.addAll(list);

        this.listViewAdapter = new ArrayAdapter<Note>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, this.noteList);

        this.listView.setAdapter(listViewAdapter);

        registerForContextMenu(this.listView);
    }
}