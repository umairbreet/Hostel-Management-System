package com.example.hostelmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DateTimeDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;

    private static final String DATABASE_NAME = "datetime.db";
    private static final String TABLE_NAME = "DATETIME";

    private static final String ID = "id";
    private static final String DATE = "date";

    private SQLiteDatabase sqLiteDatabase;
    private static final String CREATE_Table = "create table " + TABLE_NAME + "(" + ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+ DATE +" TEXT NOT NULL);";

    public DateTimeDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void addDate(TimeModel timeModel)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DateTimeDatabase.DATE, timeModel.getDate());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public List<TimeModel> getDate() {
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<TimeModel> storeTime = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String date = cursor.getString(1);
                storeTime.add(new TimeModel(id, date));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return storeTime;
    }
}
