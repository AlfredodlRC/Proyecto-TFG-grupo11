package com.example.ticktask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticktask.retrofit.MyApiAdapter;
import com.example.ticktask.retrofit.MyApiService;
import com.example.ticktask.retrofit.POJOS.Departamento;
import com.example.ticktask.retrofit.POJOS.Estado;
import com.example.ticktask.retrofit.POJOS.Incidencia;
import com.example.ticktask.retrofit.POJOS.Respuesta_usuario_login;
import com.example.ticktask.retrofit.POJOS.Tipo_incidencia;
import com.example.ticktask.retrofit.POJOS.Usuario_login_email;
import com.example.ticktask.retrofit.POJOS.Usuario_simple;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Crear_ticket_Activity extends AppCompatActivity {

    Button Btn_aceptar;
    Button Btn_cancelar;

    private List<Tipo_incidencia> lista_tipos;

    private List<Departamento> lista_departamentos;

    private List<Usuario_simple> lista_empleados_departamento;

    private String nombre_usuario;
    private String id_usuario;

    EditText ET_descripcion;
    EditText ET_titulo;

    Spinner spiner_tipo;
    Spinner spiner_departamento;
    Spinner spiner_persona;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_ticket);

        ET_descripcion = findViewById(R.id.textedit_descripcion);
        ET_titulo = findViewById(R.id.textedit_titulo);

        // cogemos las listas para los spinner y se los asignamos

        // desplegable tipo
        spiner_tipo = findViewById(R.id.spinner_tipo);
        lista_tipos = coger_lista_tipos();


        // desplegable departamento
        spiner_departamento = findViewById(R.id.spinner_departamento);
        lista_departamentos = coger_lista_departamentos();

        // desplegable personas
        spiner_persona = findViewById(R.id.spinner_persona);
        lista_empleados_departamento = coger_lista_empleados_departamento(1);


        // recogemos el nombre y el id del usuario
        this.nombre_usuario = getIntent().getStringExtra("nombre");
        this.id_usuario = getIntent().getStringExtra("id");

        spiner_departamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int indice = 1;
                String departamento_destino = spiner_departamento.getSelectedItem().toString();
                for (Departamento departamento: lista_departamentos) {
                    if (departamento.getNombre().contains(departamento_destino) == true){
                        indice = Integer.parseInt(departamento.getPk());
                    }
                }
                lista_empleados_departamento = coger_lista_empleados_departamento(indice);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No seleccionaron nada
            }
        });
        Btn_aceptar = findViewById(R.id.Btn_aceptar);
        Btn_aceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyApiService servicio = MyApiAdapter.getApiService();


                // Obtener los valores ingresados por el usuario
                String titulo = ET_titulo.getText().toString();
                String descripcion = ET_descripcion.getText().toString();

                float fk_tipo_incidencia = 0;
                float fk_departamento_destino = 0;
                float fk_persona_destino = 0;

                //obtenemos la fecha actual
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
                String fechaCreacion = sdf.format(new Date());
                //String ahora = sdf.format(new Date());

                // Obtener la persona y el departamento asignados desde los spinners
                String personaAsignada = spiner_persona.getSelectedItem().toString();
                String departamentoAsignado = spiner_departamento.getSelectedItem().toString();

              //  EditText ET_descripcion = findViewById(R.id.textedit_descripcion);
                //EditText ET_titulo = findViewById(R.id.textedit_titulo);

                Spinner spiner_tipo = findViewById(R.id.spinner_tipo);
                String tipo_incidencia = spiner_tipo.getSelectedItem().toString();

                Spinner spiner_departamento = findViewById(R.id.spinner_departamento);
                String departamento_destino = spiner_departamento.getSelectedItem().toString();

                Spinner spiner_persona = findViewById(R.id.spinner_persona);
                String persona_destino = spiner_persona.getSelectedItem().toString();

                // se crea la incidencia ue se quiere enviar a la REST API
                Incidencia incidencia = new Incidencia();

                incidencia.setNombre(titulo);
                incidencia.setDescripcion(descripcion);
                incidencia.setFecha_creacion(fechaCreacion);
                incidencia.setFecha_finalizacion("");
                incidencia.setTiempo_resolucion(-1);
                incidencia.setPersona_origen(nombre_usuario);
                incidencia.setDepartamento_destino(departamento_destino);
                incidencia.setPersona_destino(persona_destino);
                incidencia.setTipo_incidencia(tipo_incidencia);
                incidencia.setEstado("pendiente");
                incidencia.setPrioridad("media");

                // Se envía la incidencia a la REST API y se vuelve a la pantalla principal
                 try {
                     Call<Boolean> llamada = servicio.put_crear_incidencia(incidencia);
                     llamada.enqueue(new Callback<Boolean>() {
                         @Override
                         public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                             Boolean respuesta =response.body();
                             Log.println(Log.ASSERT,"", String.valueOf(respuesta));

                             Intent intent = new Intent(Crear_ticket_Activity.this, Listado_tickets_Activity.class);

                             // Agregar los datos como extras al Intent

                             intent.putExtra("titulo", titulo);
                             intent.putExtra("descripcion", descripcion);
                             intent.putExtra("fechaCreacion", fechaCreacion);
                             intent.putExtra("personaAsignada", personaAsignada);
                             intent.putExtra("departamentoAsignado", departamentoAsignado);
                             startActivity(intent);
                         }
                         @Override
                         public void onFailure(Call<Boolean> call, Throwable t) {
                         }
                     });
                 } catch (Exception e) {
                     throw new RuntimeException(e);
                 }



            }
        });

        Btn_cancelar = findViewById(R.id.Btn_cancelar);
        Btn_cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Crear_ticket_Activity.this, MainActivity.class);
                intent.putExtra("nombre", nombre_usuario);
                intent.putExtra("id",id_usuario);
                startActivity(intent);

            }
        });
    } // Fin de onCreate


    private List<Tipo_incidencia> coger_lista_tipos() {
        List<Tipo_incidencia> resultado = new ArrayList<Tipo_incidencia>();
        MyApiService servicio = MyApiAdapter.getApiService();
        try {
            Call<List<Tipo_incidencia>> llamada = servicio.get_tipo_incidencias();
            llamada.enqueue(new Callback<List<Tipo_incidencia>>() {
                @Override
                public void onResponse(Call<List<Tipo_incidencia>> call, Response<List<Tipo_incidencia>> response) {
                    List<Tipo_incidencia> respuesta = response.body();
                    String[] tipos = new String[respuesta.size()];
                    int i = 0;
                    for (Tipo_incidencia tipo: respuesta) {
                        resultado.add(tipo);
                        tipos[i] = tipo.getNombre();
                        i++;
                    }
                    spiner_tipo.setAdapter(new ArrayAdapter<String>(
                            Crear_ticket_Activity.this,
                            android.R.layout.simple_spinner_dropdown_item, tipos));
                }
                @Override
                public void onFailure(Call<List<Tipo_incidencia>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"No se pudo conectar al servidor",Toast.LENGTH_LONG);
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        return resultado;
    }

    private List<Departamento> coger_lista_departamentos() {
        List<Departamento> resultado = new ArrayList<Departamento>();
        MyApiService servicio = MyApiAdapter.getApiService();
        try {
            Call<List<Departamento>> llamada = servicio.get_departamentos();
            llamada.enqueue(new Callback<List<Departamento>>() {
                @Override
                public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                    List<Departamento> respuesta = response.body();
                    String[] departamentos = new String[respuesta.size()];
                    int i = 0;
                    for (Departamento departamento: respuesta) {
                        resultado.add(departamento);
                        departamentos[i] = departamento.getNombre();
                        i++;
                    }
                    spiner_departamento.setAdapter(new ArrayAdapter<String>(
                            Crear_ticket_Activity.this,
                            android.R.layout.simple_spinner_dropdown_item, departamentos));
                }
                @Override
                public void onFailure(Call<List<Departamento>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"No se pudo conectar al servidor",Toast.LENGTH_LONG);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    private List<Usuario_simple> coger_lista_empleados_departamento(int id) {
        List<Usuario_simple> resultado = new ArrayList<Usuario_simple>();
        MyApiService servicio = MyApiAdapter.getApiService();
        try {
            Call<List<Usuario_simple>> llamada = servicio.get_usuarios_de_departamento(id);
            llamada.enqueue(new Callback<List<Usuario_simple>>() {
                @Override
                public void onResponse(Call<List<Usuario_simple>> call, Response<List<Usuario_simple>> response) {
                    List<Usuario_simple> respuesta = response.body();
                    String[] departamentos = new String[respuesta.size()];
                    int i = 0;
                    for (Usuario_simple usuario_simple: respuesta) {
                        resultado.add(usuario_simple);
                        departamentos[i] = usuario_simple.getNombre();
                        i++;
                    }
                    spiner_persona.setAdapter(new ArrayAdapter<String>(
                            Crear_ticket_Activity.this,
                            android.R.layout.simple_spinner_dropdown_item, departamentos));
                }
                @Override
                public void onFailure(Call<List<Usuario_simple>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"No se pudo conectar al servidor",Toast.LENGTH_LONG);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }        return resultado;
    }
} // Fin clase