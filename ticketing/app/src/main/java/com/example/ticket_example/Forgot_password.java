package com.example.ticket_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forgot_password extends AppCompatActivity {
    Button bottomLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        setContentView(R.layout.activity_forgot_password);
        bottomLogin  = findViewById(R.id.sendbutton);
        bottomLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Forgot_password.this, Activity_Login.class);
                startActivity(intent);

            }
        });
    }
}