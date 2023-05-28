package com.example.ticktask;

import android.content.Intent;
import android.os.Bundle;

import com.example.ticktask.retrofit.POJOS.Incidencia;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ticktask.databinding.ActivityDatosTicketBinding;

public class Datos_ticket_Activity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityDatosTicketBinding binding;
    private String nombre_usuario;
    private String id_usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_ticket);

        nombre_usuario = getIntent().getStringExtra("nombre_usuario");
        id_usuario = getIntent().getStringExtra("id_usuario");

        String titulo = getIntent().getStringExtra("titulo");
        String tipo = getIntent().getStringExtra("tipo");
        String departamento = getIntent().getStringExtra("departamento");
        String persona_creadora = getIntent().getStringExtra("persona_creadora");
        String persona_asignada = getIntent().getStringExtra("persona_asignada");
        String descripcion = getIntent().getStringExtra("descripcion");
        String prioridad = getIntent().getStringExtra("prioridad");
        String fecha_creacion = getIntent().getStringExtra("fecha_creación");


        TextView TVtitulo = findViewById(R.id.TVtitulo);
        TextView TVtipo = findViewById(R.id.TVtipo);
        TextView TVdepartamento = findViewById(R.id.TVdepartamento);
        TextView TVpersona_creadora = findViewById(R.id.TVpersona_creadora);
        TextView TVpersona_asignada = findViewById(R.id.TVpersona_asignada);
        TextView TVdescripcion = findViewById(R.id.TVdescripcion);
        TextView TVprioridad = findViewById(R.id.TVprioridad);
        TextView TVfecha_creacion = findViewById(R.id.TVfecha_creacion);

        Button Btn_volver= findViewById(R.id.Btn_volver_datos);

        TVtitulo.setText(titulo);
        TVtipo.setText(tipo);
        TVdepartamento.setText(departamento);
        TVpersona_creadora.setText(persona_creadora);
        TVpersona_asignada.setText(persona_asignada);
        TVdescripcion.setText(descripcion);
        TVprioridad.setText(prioridad);
        TVfecha_creacion.setText(fecha_creacion);

        Btn_volver = findViewById(R.id.Btn_volver_datos);
        Btn_volver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Datos_ticket_Activity.this, MainActivity.class);
                intent.putExtra("nombre", nombre_usuario);
                intent.putExtra("id",id_usuario);
                startActivity(intent);
            }
        });


    }
}
