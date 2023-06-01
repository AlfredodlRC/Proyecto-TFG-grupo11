package com.example.ticktask.adapters;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticktask.R;
import com.example.ticktask.Ticket;
import com.example.ticktask.retrofit.MyApiService;
import com.example.ticktask.retrofit.POJOS.Incidencia;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {
    private List<Ticket> tickets;  // Los datos de los tickets
    private Context context;
    MyApiService myApiService;
    private Ticket ticket;
    private long startTime;

    public TicketAdapter(List<Ticket> tickets, Context context, MyApiService myApiService) {
        this.tickets = tickets;
        this.context = context;
        this.myApiService = myApiService;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ticket, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        Ticket ticket = tickets.get(position);
        holder.tvTitulo.setText(context.getString(R.string.nombre_ticket, ticket.getTitulo()));
        holder.tvPrioridad.setText(context.getString(R.string.tipo_solicitud, ticket.getPrioridad()));
        holder.tvTipo.setText(context.getString(R.string.Prioridad, ticket.getTipoIncidencia()));
        holder.tvFechaCreacion.setText(context.getString(R.string.date, ticket.getFechaCreacion()));
        //   holder.tvPersonaCreadora.setText(context.getString(R.string.departamento,ticket.getPersonaCreadora()));
        holder.tvDepartamento.setText(context.getString(R.string.departamento, ticket.getDepartamento()));
        holder.tvPersonaAsignada.setText(context.getString(R.string.Usuario_Asignado, ticket.getPersonaAsignada()));
        holder.tvDescripcion.setText(context.getString(R.string.descriptionText, ticket.getDescripcion()));
    }

    @Override
    public int getItemCount() {
        Log.d("TicketAdapter", "Número total de tickets: " + tickets.size());
        return tickets.size();
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvPrioridad, tvTipo, tvFechaCreacion, tvPersonaCreadora,
                tvDepartamento, tvPersonaAsignada, tvDescripcion;

        //Referencia al boton aceptar.
        Button acceptButton, pendienteButton, resueltoButton, rechazadoButton;
        Chronometer chronometer;
        long pauseOffset;
        boolean running;

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            chronometer = itemView.findViewById(R.id.chronometer);
            tvTitulo = itemView.findViewById(R.id.TVtitulo);
            tvPrioridad = itemView.findViewById(R.id.TVprioridad);
            tvTipo = itemView.findViewById(R.id.TVtipo);
            tvFechaCreacion = itemView.findViewById(R.id.TVfecha_creacion);
            tvPersonaCreadora = itemView.findViewById(R.id.TVpersona_creadora);
            tvDepartamento = itemView.findViewById(R.id.TVdepartamento);
            tvPersonaAsignada = itemView.findViewById(R.id.TVpersona_asignada);
            tvDescripcion = itemView.findViewById(R.id.TVdescripcion);


            //Encontramos el boton y lo ponemos a la escucha
            acceptButton = itemView.findViewById(R.id.acceptButton);
            pendienteButton = itemView.findViewById(R.id.buttoPend);
            resueltoButton = itemView.findViewById(R.id.buttonResult);
            rechazadoButton = itemView.findViewById(R.id.buttonRech);

            acceptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Iniciamos el contador
                    startTime = System.currentTimeMillis();
                    // Una vez que el botón "Aceptar" se pulsa, mostramos los otros botones
                    pendienteButton.setVisibility(View.VISIBLE);
                    resueltoButton.setVisibility(View.VISIBLE);
                    rechazadoButton.setVisibility(View.VISIBLE);

                    //ocultamos el button acceptar
                    acceptButton.setVisibility(View.GONE);
                    if (!running) {
                        chronometer.setVisibility(View.VISIBLE);
                        chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                        chronometer.start();
                        running = true;
                    }

                }
            });

            pendienteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (running) {
                        chronometer.stop();
                        pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                        running = false;
                    }
                    //marcamos a la api para  cambiar a el estado pendinete
                    Ticket currentTicket = tickets.get(getAdapterPosition());
                    //Marcas a la API para cambiar  a el estado pendiente

                    Incidencia incidencia = new Incidencia();
                    incidencia.setEstado("Pendiente");
                    Call<Boolean> call = myApiService.put_actualizar_incidencia(currentTicket.getId(), incidencia);
                    call.enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if (response.isSuccessful()) {
                                //El estado de la incidencia se actualizó con éxito
                                pendienteButton.setVisibility(View.GONE);
                                resueltoButton.setVisibility(View.GONE);
                                rechazadoButton.setVisibility(View.GONE);
                            } else {
                                //Error al actualizarse, mostramos un mensje
                            }
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            //Error al actualizar  el estado de la incidencia

                        }
                    });
                }
            });

            resueltoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //marcamos a la api para  cambiar a el estado resuelto
                    if (running) {
                        chronometer.stop();
                        pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                        running = false;
                    }
                    //marcamos a la api para  cambiar a el estado resuelto
                    Ticket currentTicket = tickets.get(getAdapterPosition());
                    //Marcas a la API para cambiar  a el estado pendiente
                    Incidencia incidencia = new Incidencia();
                    incidencia.setEstado("Resuelto");
                    Call<Boolean> call = myApiService.put_actualizar_incidencia(currentTicket.getId(), incidencia);
                    call.enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if (response.isSuccessful()) {

                                //El estado de la incidencia se actualizó con éxito
                                pendienteButton.setVisibility(View.GONE);
                                resueltoButton.setVisibility(View.GONE);
                                rechazadoButton.setVisibility(View.GONE);
                                rechazadoButton.setVisibility(View.GONE);
                            } else {
                                //error al actualizarse
                            }
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            //Error al actualizar el estado del la incidencia
                        }
                    });
                }
            });

            rechazadoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (running) {
                        chronometer.stop();
                        pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                        running = false;
                    }
                    //marcazmos la api  para cambiar de esr¡tadi rechazado
                    Ticket currentTicket = tickets.get(getAdapterPosition());
                    Incidencia incidencia = new Incidencia();
                    incidencia.setEstado("Rechazado");
                    Call<Boolean> call = myApiService.put_actualizar_incidencia(currentTicket.getId(), incidencia);
                    call.enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if (response.isSuccessful()) {
                                pendienteButton.setVisibility(View.GONE);
                                resueltoButton.setVisibility(View.GONE);
                                rechazadoButton.setVisibility(View.GONE);
                            }
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Log.e("API_CALL", "Error during API call", t);
                        }
                    });
                }
            });
        }
    }
}