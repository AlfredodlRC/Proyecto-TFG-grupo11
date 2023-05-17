package com.example.ticktask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

public class Crear_ticket_Activity extends AppCompatActivity {

    Button Btn_aceptar;
    Button Btn_cancelar;
    Spinner Spn_departamento;
    Spinner Spn_parsona_asignada;
    TextInputEditText TI_nombre;
    TextInputEditText TI_descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_ticket);

        Btn_aceptar = findViewById(R.id.Btn_aceptar);
        Btn_aceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Crear_ticket_Activity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        Btn_cancelar = findViewById(R.id.Btn_cancelar);
        Btn_cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Crear_ticket_Activity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        Spn_departamento = findViewById(R.id.SPN_departamento);
        Spn_departamento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    } // Fin de onCreate
} // Fin clase