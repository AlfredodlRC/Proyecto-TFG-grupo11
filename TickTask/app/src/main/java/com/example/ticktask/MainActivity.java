package com.example.ticktask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Btn_perfil;
    Button Btn_crear_ticket;
    Button Btn_ticket_creados;
    Button Btn_ticket_asignados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_perfil = findViewById(R.id.Btn_perfil);
        Btn_perfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

        Btn_crear_ticket = findViewById(R.id.Btn_Crear_ticket);
        Btn_crear_ticket.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Crear_ticket_Activity.class);
                startActivity(intent);
            }
        });

        Btn_ticket_asignados = findViewById(R.id.Btn_Ticket_asignados);
        Btn_ticket_asignados.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Listado_tickets_Activity.class);
                startActivity(intent);
            }
        });

        Btn_ticket_creados = findViewById(R.id.Btn_ticket_creados);
        Btn_ticket_creados.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Listado_tickets_Activity.class);
                startActivity(intent);
            }
        });



    } // Fin oncreate
} // fin clase