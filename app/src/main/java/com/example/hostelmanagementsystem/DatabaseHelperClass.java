package com.example.hostelmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_NAME = "database.db";
    private static final String TABLE_NAME = "ROOMS";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String CONTACT = "contact";
    private static final String ROOMNO = "roomNo";

    private SQLiteDatabase sqLiteDatabase;

    private static final String CREATE_Table = "create table " + TABLE_NAME + "(" + ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+ NAME + " TEXT NOT NULL," + EMAIL +" TEXT NOT NULL,"
            + CONTACT + " TEXT NOT NULL," + ROOMNO + " TEXT NOT NULL);";

    public DatabaseHelperClass(Context context)
    {
        super (context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void addRoom(RoomModelClass roomModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME,roomModelClass.getName());
        contentValues.put(DatabaseHelperClass.EMAIL,roomModelClass.getEmail());
        contentValues.put(DatabaseHelperClass.CONTACT,roomModelClass.getContact());
        contentValues.put(DatabaseHelperClass.ROOMNO,roomModelClass.getRoomNo());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME,null,contentValues);
    }

    public List<RoomModelClass> getRoomList(){
        String sql= "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<RoomModelClass> storeRoom = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null,null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String contact = cursor.getString(3);
                String roomNo = cursor.getString(4);
                storeRoom.add(new RoomModelClass(id,name,email,contact,roomNo));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return storeRoom;
    }


    public void updateRoom(RoomModelClass roomModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME,roomModelClass.getName());
        contentValues.put(DatabaseHelperClass.EMAIL,roomModelClass.getEmail());
        contentValues.put(DatabaseHelperClass.CONTACT,roomModelClass.getContact());
        contentValues.put(DatabaseHelperClass.ROOMNO,roomModelClass.getRoomNo());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(DatabaseHelperClass.TABLE_NAME,contentValues,ID+" = ?", new String[]
                {String.valueOf(roomModelClass.getId())});
    }
    public void deleteRoom(Integer id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(DatabaseHelperClass.TABLE_NAME,ID+" =?" ,new String[]
                {String.valueOf(id)});
    }

}
