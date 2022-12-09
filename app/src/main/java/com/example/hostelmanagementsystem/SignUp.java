package com.example.hostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {


    Button create_account;
    EditText username,password,repass;
    CreateAccountDatabase createAccountDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        create_account = findViewById(R.id.create_account);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        repass = findViewById(R.id.etRepPassword);

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = username.getText().toString();
                String Pass = password.getText().toString();
                String RePass = repass.getText().toString();

                 if (Pass.equals(RePass) && !Pass.equals("") && !Name.equals("")) {
                        createAccountDatabase = new CreateAccountDatabase(SignUp.this);
                        Boolean checkUser = createAccountDatabase.username(Name);
                        if (!checkUser) {
                            Boolean checkAdd = createAccountDatabase.addAccount(Name, Pass);
                            if (checkAdd) {
                                Toast.makeText(SignUp.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(SignUp.this, StudentLogin.class));
                            } else {
                                Toast.makeText(SignUp.this, "Failed to Create Account", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUp.this, "Username already exist", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        repass.setError("Please Enter Same Password");
                        Toast.makeText(SignUp.this, "Please Enter Same Password", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}