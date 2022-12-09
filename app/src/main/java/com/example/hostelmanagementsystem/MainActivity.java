package com.example.hostelmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Created By Mr Robot ( Umair Breet)
    ImageView imageAdmin,imageStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageAdmin = findViewById(R.id.img);
        imageStudent = findViewById(R.id.img2);

        imageAdmin.setOnClickListener(this);
        imageStudent.setOnClickListener(this);
        getSupportActionBar().hide();

    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.img:
                Intent a = new Intent(MainActivity.this, AdminLogin.class);
                startActivity(a);
                break;
            case R.id.img2:
                Intent s = new Intent(MainActivity.this, StudentLogin.class);
                startActivity(s);
                break;
            default:
                break;
        }
    }
}