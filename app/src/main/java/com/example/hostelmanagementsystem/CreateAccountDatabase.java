package com.example.hostelmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class CreateAccountDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABSE_NAME = "createAccount.db";
    private static final String TABLE_NAME = "student_signup";

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static final String CREATE_TABLE = "create table "+TABLE_NAME+"("+USERNAME+" TEXT primary key," + PASSWORD
            + " TEXT NOT NULL);";

    private SQLiteDatabase sqLiteDatabase;

    public CreateAccountDatabase(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
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

    public Boolean addAccount(String username, String password)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME,username);
        contentValues.put(PASSWORD,password);
        sqLiteDatabase = this.getWritableDatabase();
        long res = sqLiteDatabase.insert(CreateAccountDatabase.TABLE_NAME,null,contentValues);
        if(res == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Boolean username(String username){
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+" where  "+
                                        USERNAME +"=?",new String[]{username});
        if(cursor.getCount()>0) {
            return true;
        }
        else
        {
            return false;
        }
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
