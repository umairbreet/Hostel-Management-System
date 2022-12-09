package com.example.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener {
Button login,signup;
EditText user,pass;
CreateAccountDatabase createAccountDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        getSupportActionBar().hide();

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        user = findViewById(R.id.etUser);
        pass = findViewById(R.id.etPass);
        createAccountDatabase = new CreateAccountDatabase(StudentLogin.this);
        signup.setOnClickListener(this);
        login.setOnClickListener(this::onClickLogin);
    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
        finish();
    }

    public void onClickLogin(View view) {
        String name = user.getText().toString();
        String Pass = pass.getText().toString();
        if(name.equals("") && Pass.equals(""))
        {
            Toast.makeText(this, "Please Enter Username / Password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Boolean checkUsername = createAccountDatabase.usernamePassword(name,Pass);
            if(checkUsername == true)
            {
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(StudentLogin.this, StudentPanel.class));
            }
            else
            {
                Toast.makeText(this, "Enter Correct Username/Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}