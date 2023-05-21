package com.example.ticktask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ticktask.retrofit.MyApiAdapter;
import com.example.ticktask.retrofit.MyApiService;
import com.example.ticktask.retrofit.POJOS.Departamento;
import com.example.ticktask.retrofit.POJOS.Usuario_login;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Login extends AppCompatActivity {

    Button bottomLogin;
    TextView buttonpassword;

    TextView buttonSignUp;

    Usuario_login usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bottomLogin  = findViewById(R.id.bottomLogin);
        bottomLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyApiService servicio = MyApiAdapter.getApiService();
                /**
                try {
                    String email = "Alfredo";
                    String contrasenya ="1234";
                    Call<Usuario_login> llamada = servicio.getLogin_email(email,contrasenya);
                    llamada.enqueue(new Callback<Usuario_login>() {
                        @Override
                        public void onResponse(Call<Usuario_login> call, Response<Usuario_login> response) {
                              usuario = response.body();
                        }
                        @Override
                        public void onFailure(Call<Usuario_login> call, Throwable t) {
                        }
                    });

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                Log.println(Log.ASSERT,"",usuario.getNombre());
                     */
                Intent intent = new Intent(Activity_Login.this, MainActivity.class);
                intent.putExtra("nombre", usuario.getNombre());
                intent.putExtra("id",usuario.getId());
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