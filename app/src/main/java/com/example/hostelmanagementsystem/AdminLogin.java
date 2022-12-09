package com.example.hostelmanagementsystem;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLogin extends AppCompatActivity implements View.OnClickListener {

    Button login;
    EditText name,password;
    AdminDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getSupportActionBar().hide();
        name = findViewById(R.id.usernameEdit);
        password = findViewById(R.id.passwordEdit);


        db = new AdminDBHelper(this);
        db.rootAdmin();


        login = findViewById(R.id.login_btn);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username = name.getText().toString();
        String Password = password.getText().toString();

        if(username.isEmpty() && Password.isEmpty()) {
            name.setError("Enter Username");
            password.setError("Enter Password");
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean check = db.usernamePassword(username,Password);
            if(check == true) {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                finish();
                Intent i = new Intent(AdminLogin.this, AdminPanel.class);
                startActivity(i);

            }
            else
            {
                name.setError("Enter Correct Username");
                password.setError("Enter Correct Password");
                Toast.makeText(this, "Enter Correct Username / Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}