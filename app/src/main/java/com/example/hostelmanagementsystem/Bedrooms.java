package com.example.hostelmanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Bedrooms extends AppCompatActivity {

    EditText Name , Email , contact, roomNo;
    Button Add,View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedrooms);
        getSupportActionBar().hide();

        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        contact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().startsWith("(+92)-")){
                    contact.setText("(+92)-");
                    Selection.setSelection(contact.getText(),contact.getText().length());
                }
            }
        });
        roomNo = findViewById(R.id.roomNo);

        Add = findViewById(R.id.add_btn);
        View = findViewById(R.id.view_btn);

            Add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = Name.getText().toString();
                    String email = Email.getText().toString();
                    String Contact = contact.getText().toString();
                    String RoomNo = roomNo.getText().toString();

                    if((!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
                        if (name.length() <= 0 || email.length() <= 0 || Contact.length() <= 0 || RoomNo.length() <= 0) {
                            Toast.makeText(Bedrooms.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                        } else {
                            DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Bedrooms.this);
                            RoomModelClass roomModelClass = new RoomModelClass(name, email, Contact, RoomNo);
                            databaseHelperClass.addRoom(roomModelClass);
                            Toast.makeText(Bedrooms.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                            finish();

                            startActivity(getIntent());
                        }
                    }
                    else{
                        Email.setError("Enter correct Email");
                    }
                }
            });


        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(Bedrooms.this,ViewRoomClass.class);
                startActivity(z);

            }
        });
    }

    private boolean ValidateEmail()
    {
        String emailInput =  Email.getText().toString();
        if(emailInput.isEmpty())
        {
            Email.setError("Field can't be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            Email.setError("Please Enter Valid Email");
            return false;
        }
        else
        {
            return true;
        }
    }
}