package com.example.ticktask;

import android.content.Intent;
import android.os.Bundle;

import com.example.ticktask.retrofit.MyApiAdapter;
import com.example.ticktask.retrofit.MyApiService;
import com.example.ticktask.retrofit.POJOS.Incidencia;
import com.example.ticktask.retrofit.POJOS.Respuesta_usuario_login;
import com.example.ticktask.retrofit.POJOS.Usuario_login_email;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ticktask.databinding.ActivityListadoTicketsBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Listado_tickets_Activity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityListadoTicketsBinding binding;

    private String nombre_usuario;
    private String id_usuario;
    private Boolean asignados;
    private Boolean creados;
    private List<Incidencia> incidencias_creadas;
    private List<Incidencia> incidencias_asignadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_tickets);

        // recogemos el nombre y el id del usuario
        String titulo = getIntent().getStringExtra("titulo");
        String descripcion = getIntent().getStringExtra("descripcion");
        String fechaCreacion = getIntent().getStringExtra("fechaCreacion");
        String personaAsignada = getIntent().getStringExtra("personaAsignada");
        String departamentoAsignado = getIntent().getStringExtra("departamentoAsignado");

        // Mostrar los datos en los elementos correspondientes
            TextView textViewTitulo = findViewById(R.id.textedit_titulo);
             TextView textViewDescripcion = findViewById(R.id.TVdescripcion);
        TextView textViewFechaCreacion = findViewById(R.id.TVfecha_creacion);
        TextView textViewPersonaAsignada = findViewById(R.id.TVpersona_asignada);
        TextView textViewDepartamentoAsignado = findViewById(R.id.TVdepartamento);

        textViewTitulo.setText(titulo);
        textViewDescripcion.setText(descripcion);
        textViewFechaCreacion.setText(fechaCreacion);
        textViewPersonaAsignada.setText(personaAsignada);
        textViewDepartamentoAsignado.setText(departamentoAsignado);


        this.nombre_usuario = getIntent().getStringExtra("nombre");
        this.id_usuario = getIntent().getStringExtra("id");
        this.asignados = getIntent().getBooleanExtra("asignados",false);
        this.creados = getIntent().getBooleanExtra("creados",false);
        this.incidencias_creadas = new ArrayList<Incidencia>();
        this.incidencias_asignadas = new ArrayList<Incidencia>();
        MyApiService servicio = MyApiAdapter.getApiService();
        if (this.creados == true) {

            try {
                Call<List<Incidencia>> llamada = servicio.get_incidencias_de_creador(Integer.parseInt(id_usuario));
                llamada.enqueue(new Callback<List<Incidencia>>() {
                    @Override
                    public void onResponse(Call<List<Incidencia>> call, Response<List<Incidencia>> response) {
                         incidencias_creadas = response.body();
                    }
                    @Override
                    public void onFailure(Call<List<Incidencia>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"No se pudo conectar al servidor",Toast.LENGTH_LONG);
                    }
                });

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (this.asignados == true) {
            try {
                Call<List<Incidencia>> llamada = servicio.get_incidencias_de_solucionador(Integer.parseInt(id_usuario));
                llamada.enqueue(new Callback<List<Incidencia>>() {
                    @Override
                    public void onResponse(Call<List<Incidencia>> call, Response<List<Incidencia>> response) {
                        incidencias_asignadas = response.body();
                    }
                    @Override
                    public void onFailure(Call<List<Incidencia>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"No se pudo conectar al servidor",Toast.LENGTH_LONG);
                    }
                });

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}