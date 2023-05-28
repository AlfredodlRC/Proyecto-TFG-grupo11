package com.example.ticktask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView Btn_perfil;
    private CardView Btn_crear_ticket;
    private CardView  Btn_ticket_creados;
    private CardView Btn_ticket_asignados;

    private String nombre_usuario;
    private String id_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recogemos el nombre y el id del usuario
        this.nombre_usuario = getIntent().getStringExtra("nombre");
        this.id_usuario = getIntent().getStringExtra("id");

        //llmamaos la variable de boton imagen
        Btn_perfil= findViewById(R.id.Btn_perfil);

        Btn_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    showPopupMenuProfile(Btn_perfil);

            }
        });

        Btn_perfil = findViewById(R.id.Btn_perfil);
        Btn_perfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Aquí se  muestra las opciones de perfil y cerrar sesión
                // mostrar un diálogo, abrir una actividad específica o realizar cualquier otra acción
                    showPopupMenuProfile(Btn_perfil);
                }

        });

        Btn_crear_ticket = findViewById(R.id.Btn_Crear_ticket);
        Btn_crear_ticket.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Crear_ticket_Activity.class);
                intent.putExtra("nombre", nombre_usuario);
                intent.putExtra("id",id_usuario);
                startActivity(intent);
            }
        });

         Btn_ticket_asignados= findViewById(R.id.Btn_Ticket_Asignados);
        Btn_ticket_asignados.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Listado_tickets_Activity.class);
                intent.putExtra("nombre", nombre_usuario);
                intent.putExtra("id",id_usuario);
                intent.putExtra("asignados",true);
                intent.putExtra("creados",false);
                startActivity(intent);
            }
        });

        Btn_ticket_creados = findViewById(R.id.Btn_ticket_creados);
        Btn_ticket_creados.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Listado_tickets_Activity.class);
                intent.putExtra("nombre", nombre_usuario);
                intent.putExtra("id",id_usuario);
                intent.putExtra("asignados",false);
                intent.putExtra("creados",true);
                startActivity(intent);
            }
        });



    } // Fin oncreate

    private void showPopupMenuProfile(View view){
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_profile,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_profile) {
                    // Acciones cuando se selecciona "Perfil"
                    Toast.makeText(MainActivity.this, "Perfil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                    intent.putExtra("nombre", nombre_usuario);
                    intent.putExtra("id",id_usuario);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.menu_logout) {
                    // Acciones cuando se selecciona "Cerrar sesión"
                    Toast.makeText(MainActivity.this, "Cerrar sesión", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Activity_Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Limpiar la pila de actividades
                    intent.putExtra("nombre", nombre_usuario);
                    intent.putExtra("id",id_usuario);
                    startActivity(intent);
                    finish(); // Finalizar la actividad actual
                    return true;
                }
                return false;
            }
        });

        popupMenu.show();
    }

} // fin clase