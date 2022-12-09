package com.example.hostelmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminDBHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "Admin_LogIn";

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static final String CREATE_TABLE = "create table "+TABLE_NAME+"("+USERNAME+" TEXT primary key," + PASSWORD
            + " TEXT NOT NULL);";

    private SQLiteDatabase sqLiteDatabase;

    public AdminDBHelper(Context context) {
        super(context, "adminDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void rootAdmin()
    {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME,"root");
        contentValues.put(PASSWORD,"12345678");
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public Boolean usernamePassword(String username, String password) {
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME + " where  " + USERNAME + "=? and "
                +PASSWORD+" =?", new String[]{username,password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


}
