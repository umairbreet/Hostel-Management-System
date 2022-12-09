package com.example.hostelmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentPanel extends AppCompatActivity implements View.OnClickListener {
ImageView qrC , av;
TextView qrCode, attendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_panel);
        qrC =findViewById(R.id.imgQR);
        qrCode = findViewById(R.id.txtQR);
        qrC.setOnClickListener(this);
        qrCode.setOnClickListener(this::onClick);

        av = findViewById(R.id.attendence_img);
        attendance = findViewById(R.id.attendence_text);

        av.setOnClickListener(this::onClickAttendance);
        attendance.setOnClickListener(this::onClickAttendance);
    }

    private void onClickAttendance(View view) {
        Intent z = new Intent(StudentPanel.this, Attendance.class);
        startActivity(z);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(StudentPanel.this,QR_Scanner.class);
        startActivity(i);
    }
}