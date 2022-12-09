package com.example.hostelmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentManagment extends AppCompatActivity {

TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_managment);
        getSupportActionBar().hide();
        tx = findViewById(R.id.txa);
        Animation anime = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.myanimation);
        tx.startAnimation(anime);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },1000);
    }
}