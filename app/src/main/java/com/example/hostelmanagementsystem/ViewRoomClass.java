package com.example.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewRoomClass extends AppCompatActivity {
    RecyclerView Rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_class);

        Rec = findViewById(R.id.re);
        Rec.setLayoutManager( new LinearLayoutManager(ViewRoomClass.this));

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<RoomModelClass> roomModelClasses = databaseHelperClass.getRoomList();
        if(roomModelClasses.size()>0)
        {
            RoomAdapterClass roomAdapterClass = new RoomAdapterClass(roomModelClasses,ViewRoomClass.this);
            Rec.setAdapter(roomAdapterClass);

        }
        else
        {
            Toast.makeText(this, "There is no Data", Toast.LENGTH_SHORT).show();
        }

    }
}
