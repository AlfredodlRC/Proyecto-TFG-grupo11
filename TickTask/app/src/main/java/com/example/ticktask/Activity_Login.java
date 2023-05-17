package com.example.ticktask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Login extends AppCompatActivity {

    Button bottomLogin;
    TextView buttonpassword;

    TextView buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bottomLogin  = findViewById(R.id.bottomLogin);
        bottomLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Activity_Login.this, MainActivity.class);
                startActivity(intent);

            }
        });

        buttonpassword=findViewById(R.id.forgotPass);
        buttonpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nos lleva a la ventana opara poder recuperar contraseña.
                Intent intent = new Intent(Activity_Login.this, Activity_forgot_password.class);
                startActivity(intent);
            }
        });

        buttonSignUp = findViewById(R.id.textSignUp);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pagina donde nos lleva a la opcion de registrarnos y darnos de alta
                Intent intent= new Intent(Activity_Login.this,Activity_Sign_Up.class);
                startActivity(intent);
            }
        });
    }
}