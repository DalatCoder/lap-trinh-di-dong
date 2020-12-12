package com.example.bai01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.bai01.bean.Note;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Note_Manager";

    // Table name: Note.
    private static final String TABLE_NOTE = "Note";

    private static final String COLUMN_NOTE_ID ="Note_Id";
    private static final String COLUMN_NOTE_TITLE ="Note_Title";
    private static final String COLUMN_NOTE_CONTENT = "Note_Content";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NOTE + " ( "
                + COLUMN_NOTE_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_NOTE_TITLE + " TEXT,"
                + COLUMN_NOTE_CONTENT + " TEXT )";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);

        onCreate(db);
    }

    public void createDefaultNotesIfNeed()  {
        if (this.getNotesCount() == 0) {
            Note note1 = new Note("Note đầu tiên",
                    "Hello SQLite");
            Note note2 = new Note("Note thứ hai",
                    "Đây là note thứ hai");
            this.addNote(note1);
            this.addNote(note2);
        }
    }

    public void addNote(Note note) {
        Log.i(TAG, "addNote: ..." + note.getNoteTitle());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
        values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());

        db.insert(TABLE_NOTE, null, values);

        db.close();
    }

    public Note getNote(int noteID) {
        Log.i(TAG, "getNote: ..." + noteID);

        SQLiteDatabase db = this.getWritableDatabase();

        String[] columns = new String[] { COLUMN_NOTE_ID, COLUMN_NOTE_TITLE, COLUMN_NOTE_CONTENT };
        String[] param = new String[] { String.valueOf(noteID) };
        String query = COLUMN_NOTE_ID + " =?";

        Cursor cursor = db.query(TABLE_NOTE, columns, query, param, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Note note = new Note(noteID, cursor.getString(1), cursor.getString(2));

        return note;
    }

    public List<Note> getAllNotes() {
        Log.i(TAG, "MyDatabaseHelper.getAllNotes ... " );

        List<Note> noteList = new ArrayList<Note>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NOTE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNoteId(Integer.parseInt(cursor.getString(0)));
                note.setNoteTitle(cursor.getString(1));
                note.setNoteContent(cursor.getString(2));
                // Adding note to list
                noteList.add(note);
            } while (cursor.moveToNext());
        }

        // return note list
        return noteList;
    }

    public int getNotesCount() {
        Log.i(TAG, "getNotesCount: ...");

        String query = "SELECT * FROM " + TABLE_NOTE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int count = cursor.getCount();

        cursor.close();

        return count;
    }

    public int updateNote(Note note) {
        Log.i(TAG, "updateNote: ... " + note.getNoteTitle());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
        values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());

        return db.update(TABLE_NOTE, values, COLUMN_NOTE_ID + " =?", new String[] { String.valueOf(note.getNoteId()) });
    }

    public void deleteNote(Note note) {
        Log.i(TAG, "deleteNote: ... " + note.getNoteTitle() );

        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NOTE, COLUMN_NOTE_ID + " =?", new String[]{ String.valueOf(note.getNoteId()) });
        db.close();
    }
}
