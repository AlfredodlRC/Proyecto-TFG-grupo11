package com.example.ticktask;

import android.content.Intent;
import android.os.Bundle;

import com.example.ticktask.adapters.TicketAdapter;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Listado_tickets_Activity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private TicketAdapter ticketAdapter;
    private RecyclerView recyclerView;
    private List<Ticket> tickets;
    private MyApiService myApiService;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_listado_tickets);//nombre del layout
        Intent intent = getIntent();
        tickets = Crear_ticket_Activity.tickets;

        //creamos el servicio
        myApiService = MyApiAdapter.getApiService();
        if (tickets == null || tickets.isEmpty()) {
            // No hay tickets para mostrar
            // Puedes mostrar un mensaje o hacer algo aquí
        } else {
            // Configuramos el RecyclerView
            recyclerView = findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Creamos e instalamos el adaptador
            ticketAdapter = new TicketAdapter(tickets, this, myApiService);
            recyclerView.setAdapter(ticketAdapter);

        }
    }
}