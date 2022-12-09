package com.example.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class Attendance extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        recyclerView = findViewById(R.id.recycle2);
        recyclerView.setLayoutManager(new LinearLayoutManager(Attendance.this));
        recyclerView.setHasFixedSize(true);

        DateTimeDatabase dateTimeDatabase = new DateTimeDatabase(Attendance.this);
        List<TimeModel> timeModels = dateTimeDatabase.getDate();

        TimeAdapter timeAdapter = new TimeAdapter(timeModels,Attendance.this);
        recyclerView.setAdapter(timeAdapter);
    }
}