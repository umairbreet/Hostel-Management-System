package com.example.hostelmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivitySplash extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_splash);
        img = findViewById(R.id.image);
        getSupportActionBar().hide();

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        img.startAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(FullscreenActivitySplash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },4000);
    }
}