package com.example.hostelmanagementsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AdminPanel extends AppCompatActivity implements View.OnClickListener {
    ImageView stmngmnt, bedroom, att;
    TextView st_mngmnt, broom, attendance;
    CardView st, room, attendanceCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        stmngmnt = findViewById(R.id.img_st_management);
        st_mngmnt = findViewById(R.id.st_management);
        st = findViewById(R.id.stCard);
        stmngmnt.setOnClickListener(this);
        st_mngmnt.setOnClickListener(this::onClick);
        st.setOnClickListener(this::onClick);
        getSupportActionBar().hide();

        bedroom = findViewById(R.id.room_door);
        broom = findViewById(R.id.room);
        room = findViewById(R.id.roomcard);
        bedroom.setOnClickListener(this::onClickRoom);
        broom.setOnClickListener(this::onClickRoom);
        room.setOnClickListener(this::onClickRoom);

        att = findViewById(R.id.img_attendence);
        attendance = findViewById(R.id.text_attendence);
        attendanceCard = findViewById(R.id.attendenceCard);

        att.setOnClickListener(this::onClickAttendance);
        attendance.setOnClickListener(this::onClickAttendance);
        attendanceCard.setOnClickListener(this::onClickAttendance);
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AdminPanel.this);
        builder.setMessage("Do you want to Go ?");
        builder.setTitle("Developers are Working!");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            Intent i = new Intent(AdminPanel.this, StudentManagment.class);
            startActivity(i);
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void onClickRoom(View view) {
        Intent r = new Intent(AdminPanel.this,Bedrooms.class);
        startActivity(r);

    }

    public void onClickAttendance(View view) {
        Intent r = new Intent(AdminPanel.this,Attendance.class);
        startActivity(r);

    }


}